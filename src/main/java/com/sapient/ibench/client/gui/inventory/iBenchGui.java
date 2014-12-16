package com.sapient.ibench.client.gui.inventory;

import com.sapient.ibench.client.gui.button.iBenchButton;
import com.sapient.ibench.inventory.iBenchContainer;
import com.sapient.ibench.network.PacketHandler;
import com.sapient.ibench.network.message.iBenchMessage;
import com.sapient.ibench.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class iBenchGui extends GuiContainer {

    private iBenchContainer container;
    private EntityPlayer player;

    private iBenchButton balanceButton;
    private iBenchButton spinButton;
    private iBenchButton clearButton;

    public iBenchGui(iBenchContainer container) {
        super(container);
        this.player = container.getPlayer();
        this.container = container;
        xSize = 176;
        ySize = 166;
    }

    @Override
    public void initGui() {
        super.initGui();

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;

        this.buttonList.add(this.balanceButton = new iBenchButton(1, xStart + 10, yStart + 16, 11, 16, iBenchButton.BALANCE));
        this.buttonList.add(this.spinButton = new iBenchButton(2, xStart + 10, yStart + 32, 11, 11, iBenchButton.SPIN));
        this.buttonList.add(this.clearButton = new iBenchButton(3, xStart + 10, yStart + 48, 11, 11, iBenchButton.EMPTY));
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString(StatCollector.translateToLocal("crafting.iBench"), 29, 6, 0x202020);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.Gui.IBENCH);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     *
     * @param p_73869_1_
     * @param p_73869_2_
     */
    @Override
    protected void keyTyped(char p_73869_1_, int p_73869_2_) {
        if (p_73869_2_ == this.mc.gameSettings.keyBindBack.getKeyCode()) {
            this.container.clearMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.CLEAR_MATRIX));
        }
        if (p_73869_2_ == this.mc.gameSettings.keyBindRight.getKeyCode()) {
            this.container.spinMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.SPIN_MATRIX));
        }
        if (p_73869_2_ == this.mc.gameSettings.keyBindLeft.getKeyCode()) {
            this.container.spinMatrix(true);
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.SPIN_MATRIX_LEFT));
        }

        if (p_73869_2_ == this.mc.gameSettings.keyBindForward.getKeyCode()) {
            this.container.balanceMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.BALANCE_MATRIX));
        }

        super.keyTyped(p_73869_1_, p_73869_2_);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button == balanceButton) {
            this.container.balanceMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.BALANCE_MATRIX));
        } else if (button == spinButton) {
            this.container.spinMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.SPIN_MATRIX));
        } else if (button == clearButton) {
            this.container.clearMatrix();
            PacketHandler.INSTANCE.sendToServer(new iBenchMessage(iBenchMessage.CLEAR_MATRIX));
        }
    }
}
