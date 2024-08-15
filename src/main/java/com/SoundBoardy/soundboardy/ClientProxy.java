package com.SoundBoardy.soundboardy;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.
    @Override
    public void postInit(FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new ChatEventHandler());

    }

}
