package com.sapient.ibench.handlers;

import com.sapient.ibench.iBench;
import com.sapient.ibench.reference.Keybindings;
import com.sapient.ibench.util.IBenchHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

@SideOnly(Side.CLIENT)
public class KeyInputEventHandler {

    public void init() {
        ClientRegistry.registerKeyBinding(Keybindings.openIBench);
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {
        if (Keybindings.openIBench.isPressed()) {
            EntityPlayer player = FMLClientHandler.instance().getClientPlayerEntity();

            if (IBenchHelper.getIBench(player) != null) {
                player.openGui(iBench.instance, 0, player.getEntityWorld(), (int)player.posX, (int)player.posY, (int)player.posZ);
            }
        }
    }
}
