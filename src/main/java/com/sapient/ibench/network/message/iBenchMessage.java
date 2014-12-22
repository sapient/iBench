package com.sapient.ibench.network.message;

import com.sapient.ibench.iBench;
import com.sapient.ibench.inventory.iBenchContainer;
import com.sapient.ibench.reference.GUIs;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class iBenchMessage implements IMessage {

    int action;

    public static final int CLEAR_MATRIX = 1;
    public static final int SPIN_MATRIX = 2;
    public static final int BALANCE_MATRIX = 3;
    public static final int SPIN_MATRIX_LEFT = 4;
    public static final int OPEN_IBENCH = 5;

    // MUST ALWAYS HAVE DEFAULT CONSTUCTOR OR WE WILL CRASH, IDIOT!
    public iBenchMessage() { }

    public iBenchMessage(int action) {
        this.action = action;
    }

    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        action = ByteBufUtils.readVarShort(buf);
    }

    /**
     * Deconstruct your message into the supplied byte buffer
     *
     * @param buf
     */
    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarShort(buf, action);
    }


    public static class Handler implements IMessageHandler<iBenchMessage, IMessage> {
        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx
         * @return an optional return message
         */
        @Override
        public IMessage onMessage(iBenchMessage message, MessageContext ctx) {
            iBenchContainer container;
            switch (message.action) {
                case iBenchMessage.BALANCE_MATRIX:
                    container = (iBenchContainer)ctx.getServerHandler().playerEntity.openContainer;
                    container.balanceMatrix();
                    break;
                case iBenchMessage.SPIN_MATRIX:
                    container = (iBenchContainer)ctx.getServerHandler().playerEntity.openContainer;
                    container.spinMatrix();
                    break;
                case iBenchMessage.SPIN_MATRIX_LEFT:
                    container = (iBenchContainer)ctx.getServerHandler().playerEntity.openContainer;
                    container.spinMatrix(true);
                    break;
                case iBenchMessage.CLEAR_MATRIX:
                    container = (iBenchContainer)ctx.getServerHandler().playerEntity.openContainer;
                    container.clearMatrix();
                    break;
                case iBenchMessage.OPEN_IBENCH:
                    EntityPlayer player = ctx.getServerHandler().playerEntity;
                    player.openGui(iBench.instance, GUIs.IBENCH.ordinal(), player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
                    break;
            }

            return null;
        }
    }

}
