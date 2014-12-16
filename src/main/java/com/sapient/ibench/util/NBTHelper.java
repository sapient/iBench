package com.sapient.ibench.util;

import com.sapient.ibench.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

public class NBTHelper {

    public static boolean hasUUID(ItemStack itemStack) {
        return has_tag(itemStack, Names.NBT.MOST_SIG_UUID) && has_tag(itemStack, Names.NBT.LEAST_SIG_UUID);
    }

    public static void setUUID(ItemStack itemStack) {
        initNBTCompound(itemStack);

        if (!hasUUID(itemStack)) {
            UUID itemUUID = UUID.randomUUID();

            setLong(itemStack, Names.NBT.MOST_SIG_UUID, itemUUID.getMostSignificantBits());
            setLong(itemStack, Names.NBT.LEAST_SIG_UUID, itemUUID.getLeastSignificantBits());
        }
    }

    public static void initNBTCompound(ItemStack itemStack) {
        if (itemStack.stackTagCompound == null) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static boolean has_tag(ItemStack itemStack, String tag) {
        return itemStack != null && itemStack.hasTagCompound() && itemStack.stackTagCompound.hasKey(tag);
    }

    public static void setLong(ItemStack itemStack, String tag, Long value) {
        initNBTCompound(itemStack);
        itemStack.stackTagCompound.setLong(tag, value);
    }
}
