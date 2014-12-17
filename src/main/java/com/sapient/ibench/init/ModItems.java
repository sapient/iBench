package com.sapient.ibench.init;

import com.sapient.ibench.items.ItemBlueprints;
import com.sapient.ibench.items.ItemCraftingCore;
import com.sapient.ibench.items.ItemIBench;
import com.sapient.ibench.reference.Names;
import com.sapient.ibench.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static Item ibench = new ItemIBench();
    public static Item blueprints = new ItemBlueprints();
    public static Item craftingCore = new ItemCraftingCore();

    public static void init() {
        GameRegistry.registerItem(ibench, Names.Items.I_BENCH);
        GameRegistry.registerItem(blueprints, Names.Items.BLUEPRINTS);
        GameRegistry.registerItem(craftingCore, Names.Items.CRAFTING_CORE);
    }

}
