package com.sapient.ibench.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemCraftingCore extends Item {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemCraftingCore() {
        setMaxStackSize(64);
        setUnlocalizedName("ibench:crafting_core");
        setTextureName("ibench:crafting_core");
        setHasSubtypes(true);
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     *
     * @param itemStack
     */
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        switch (itemStack.getItemDamage()) {
            case 0:
                return "item.ibench:crafting_core";

            case 1:
                return "item.ibench:crafting_core_plus";

        }
        return "item.ibench:crafting_core";
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     *
     * @param item
     * @param creativeTabs
     * @param list
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    /**
     * Gets an icon index based on an item's damage value
     *
     * @param damage
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return icons[damage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[2];

        icons[0] = iconRegister.registerIcon("ibench:crafting_core");
        icons[1] = iconRegister.registerIcon("ibench:crafting_core_plus");
    }
}


