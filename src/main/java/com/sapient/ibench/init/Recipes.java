package com.sapient.ibench.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes {
    public static void init() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ibench), " g ", "gcg", " g ", 'g', Items.gold_ingot, 'c', Blocks.crafting_table);
    }
}
