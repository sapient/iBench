package com.sapient.ibench.plugins.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.GuiRecipe;
import com.sapient.ibench.client.gui.inventory.iBenchGui;
import com.sapient.ibench.util.LogHelper;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;

public class iBenchStackPositioner implements IStackPositioner {

    @Override
    public ArrayList<PositionedStack> positionStacks(ArrayList<PositionedStack> stacks) {

        if (Minecraft.getMinecraft().currentScreen instanceof GuiRecipe)
        {
            GuiRecipe recipeGui = (GuiRecipe) Minecraft.getMinecraft().currentScreen;

            if (!(recipeGui.firstGui instanceof iBenchGui)) {
                LogHelper.warn("No iBenchGui found!");
                return stacks;
            }

            for (PositionedStack stack : stacks) {
                stack.relx += 17;
                stack.rely += 11;
            }
        }

        return stacks;
    }
}
