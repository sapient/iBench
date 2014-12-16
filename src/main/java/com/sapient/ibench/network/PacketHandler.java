package com.sapient.ibench.network;

import com.sapient.ibench.network.message.iBenchMessage;
import com.sapient.ibench.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toUpperCase());

    public static void init() {
        INSTANCE.registerMessage(iBenchMessage.Handler.class, iBenchMessage.class, 0, Side.SERVER);
    }
}
