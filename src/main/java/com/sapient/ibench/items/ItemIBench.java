package com.sapient.ibench.items;

import com.sapient.ibench.iBench;
import com.sapient.ibench.library.ItemCore;
import com.sapient.ibench.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemIBench extends ItemCore {

    private static String fwd = GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode());
    private static String back = GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode());
    private static String left = GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode());
    private static String right = GameSettings.getKeyDisplayString(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode());

    public ItemIBench() {
        setMaxStackSize(1);
        setUnlocalizedName("ibench:ibench");
        setCreativeTab(iBench.creativeTab);
        setTextureName("ibench:ibench");

    }


    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    @Override
    public boolean getShareTag() {
        return true;
    }


    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     *
     * @param itemStack
     * @param world
     * @param player
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            NBTHelper.setUUID(itemStack);

            player.openGui(iBench.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return itemStack;
    }

    

    /**
     * allows items to add custom lines of information to the mouseover description
     *
     * @param itemStack
     * @param player
     * @param list
     * @param par4
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        EnumChatFormatting hl = EnumChatFormatting.WHITE;
        EnumChatFormatting rst = EnumChatFormatting.GRAY;
        
        list.add(hl + fwd + rst + " key to balance stacks");
        list.add(hl + back + rst + " key to clear the grid");
        list.add(hl + left + rst + " and " + hl + right + rst + " keys to spin");
    }
}
