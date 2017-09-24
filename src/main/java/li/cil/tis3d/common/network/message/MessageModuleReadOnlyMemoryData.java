package li.cil.tis3d.common.network.message;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public final class MessageModuleReadOnlyMemoryData implements IMessage {
    private byte[] data;

    public MessageModuleReadOnlyMemoryData(final byte[] data) {
        this.data = data;
    }

    @SuppressWarnings("unused") // For deserialization.
    public MessageModuleReadOnlyMemoryData() {
    }

    // --------------------------------------------------------------------- //

    public byte[] getData() {
        return data;
    }

    // --------------------------------------------------------------------- //
    // IMessage

    @Override
    public void fromBytes(final ByteBuf buf) {
        data = new byte[buf.readInt()];
        buf.readBytes(data);
    }

    @Override
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(data.length);
        buf.writeBytes(data);
    }
}
