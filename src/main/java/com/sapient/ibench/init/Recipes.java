package com.sapient.ibench.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {
    public static void init() {

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.blueprints),
                "lll",
                "lbl",
                "lll",
                'l', new ItemStack(Items.dye, 1, 4), 'b', Items.book);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ibench),
                "ibi",
                "gwg",
                "ici",
                'i', Items.iron_ingot, 'g', Items.gold_ingot, 'w', Blocks.crafting_table, 'b', ModItems.blueprints, 'c', Blocks.chest);

    }
}
