package com.SoundBoardy.soundboardy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class ChatEventHandler {

    @SubscribeEvent
    public void ChatEvent(ClientChatReceivedEvent event) {
        FMLClientHandler cli = FMLClientHandler.instance();
        EntityPlayer hto = cli.getClientPlayerEntity();
        String msg = event.message.getUnformattedText();

        Main.LOG.info(msg);
        Main.LOG.info(hto.getDisplayName());

        if (msg
            .split("> ").length != 0 || msg.split("] ").length != 0) {
            try {
                String msg1;
                msg = msg.split("> ")[msg.split("> ").length - 1];
                msg1 = msg.split("] ")[msg.split("] ").length - 1];
                // Main.LOG.info(msg);
                if (msg.split(" ").length != 1 && msg1.split(" ").length != 1) {
                    Main.LOG.info("neither fits");
                    return;
                }
                if (msg.split(" ").length == 1) {
                    Main.LOG.info("попытка запустить звук: " + Main.MODID + ":" + msg);
                    cli.getClient().getSoundHandler().playSound(new MovingSoundPlayer(hto, Main.MODID + ":" + msg));


                    return;
                }
                if (msg1.split(" ").length == 1) {
                    Main.LOG.info("попытка запустить звук: " + Main.MODID + ":" + msg1);
                    cli.getClient().getSoundHandler().playSound(new MovingSoundPlayer(hto, Main.MODID + ":" + msg1));
                }
            } catch (ArrayIndexOutOfBoundsException mogus) {
                Main.LOG.info(mogus);
            }

        }
    }
}


