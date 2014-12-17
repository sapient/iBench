package com.sapient.ibench.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {
    public static void init() {

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.craftingCore),
                "a",
                "w",
                "c",
                'a', Items.apple, 'w', Blocks.crafting_table, 'c', Blocks.chest);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.craftingCore, 1, 1),
                "a",
                "w",
                "c",
                'a', new ItemStack(Items.golden_apple, 1, 1), 'w', Blocks.crafting_table, 'c', Blocks.chest);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.blueprints),
                "lll",
                "lbl",
                "lll",
                'l', new ItemStack(Items.dye, 1, 4), 'b', Items.book);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ibench, 1, 0),
                "ibi",
                "gsg",
                "ici",
                'i', Items.iron_ingot, 'g', Items.gold_ingot, 'b', ModItems.blueprints, 'c', new ItemStack(ModItems.craftingCore, 1, 0), 's', Blocks.glass_pane);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ibench, 1, 1),
                "ibi",
                "gsg",
                "ici",
                'i', Items.iron_ingot, 'g', Items.gold_ingot, 'b', ModItems.blueprints, 'c', new ItemStack(ModItems.craftingCore, 1, 1), 's', Blocks.glass_pane);

    }
}
