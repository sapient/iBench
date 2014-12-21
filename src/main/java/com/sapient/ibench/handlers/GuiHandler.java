package com.sapient.ibench.handlers;

import com.sapient.ibench.client.gui.inventory.iBenchGui;
import com.sapient.ibench.inventory.iBenchContainer;
import com.sapient.ibench.inventory.InventoryIBench;
import com.sapient.ibench.reference.GUIs;
import com.sapient.ibench.util.IBenchHelper;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.IBENCH.ordinal()) {
            return new iBenchContainer(player, new InventoryIBench(player, IBenchHelper.getIBench(player)));
        }
        return null;
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.IBENCH.ordinal()) {
            return new iBenchGui(new iBenchContainer(player, new InventoryIBench(player, IBenchHelper.getIBench(player))));
        }
        return null;
    }
}
