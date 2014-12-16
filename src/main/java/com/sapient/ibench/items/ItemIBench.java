package com.sapient.ibench.items;

import com.sapient.ibench.iBench;
import com.sapient.ibench.library.ItemCore;
import com.sapient.ibench.util.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemIBench extends ItemCore {

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
}
