package com.sapient.ibench;

import com.sapient.ibench.handlers.GuiHandler;
import com.sapient.ibench.init.ModBlocks;
import com.sapient.ibench.init.ModItems;
import com.sapient.ibench.init.ModTileEntities;
import com.sapient.ibench.init.Recipes;
import com.sapient.ibench.network.PacketHandler;
import com.sapient.ibench.proxy.IProxy;
import com.sapient.ibench.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS,
        dependencies = "after:NotEnoughItems")
public class iBench {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    public static final CreativeTabs creativeTab = new CreativeTabs(Reference.MOD_NAME) {
        @Override
        public Item getTabIconItem() {
            return Items.gold_ingot;
        }
    };

    @Mod.Instance(Reference.MOD_ID)
    public static iBench instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.init();
        proxy.init();
        ModItems.init();
        ModBlocks.init();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        ModTileEntities.init();

        Recipes.init();
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
