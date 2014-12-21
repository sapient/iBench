package com.sapient.ibench.reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;


@SideOnly(Side.CLIENT)
public class Keybindings {
    public static KeyBinding openIBench = new KeyBinding("key.open_ibench.desc", Keyboard.KEY_C, "iBench");
}
