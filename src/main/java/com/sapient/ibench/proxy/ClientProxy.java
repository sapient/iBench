package com.sapient.ibench.proxy;

import com.sapient.ibench.handlers.KeyInputEventHandler;

public class ClientProxy extends CommonProxy {
    public static KeyInputEventHandler keyInputEventHandler;

    public void init() {
        keyInputEventHandler = new KeyInputEventHandler();
        keyInputEventHandler.init();
    }
}
