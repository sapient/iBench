package com.sapient.ibench.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotRecipe extends Slot {

    public SlotRecipe(IInventory iInventory, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(iInventory, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    /**
     * Return whether this slot's stack can be taken from this slot.
     *
     * @param p_82869_1_
     */
    @Override
    public boolean canTakeStack(EntityPlayer p_82869_1_) {
        return false;
    }
}
