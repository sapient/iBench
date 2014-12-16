package com.sapient.ibench.plugins.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.DefaultOverlayHandler;
import com.sapient.ibench.client.gui.inventory.iBenchGui;
import com.sapient.ibench.reference.Reference;

public class NEIiBenchConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        // Handles the recipe pattern overlay
        API.registerGuiOverlay(iBenchGui.class, "crafting", new iBenchStackPositioner());

        // Handles putting real items into the inventory
        API.registerGuiOverlayHandler(iBenchGui.class, new DefaultOverlayHandler(), "crafting");
    }

    @Override
    public String getName() {
        return Reference.MOD_ID;
    }

    @Override
    public String getVersion() {
        return Reference.VERSION;
    }
}
