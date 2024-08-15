package com.SoundBoardy.soundboardy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChatEventHandler {

    @SubscribeEvent
    public void ChatEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText()
            .split("> ").length > 0) {
            String toname = event.message.getUnformattedText()
                .split("> ")[0];
            try {
                EntityPlayer hto = FMLClientHandler.instance()
                    .getClientPlayerEntity();
                String msg = event.message.getUnformattedText()
                    .split("> ")[1];
                Main.LOG.info(msg);
                if (msg.split(" ").length > 1) {
                    return;
                }
                Main.LOG.info("попытка запустить звук: " + "soundboardy:" + msg);
                FMLClientHandler.instance()
                    .getWorldClient()
                    .playSound(hto.posX, hto.posY, hto.posZ, "soundboardy:" + msg, 1, 1, false);
            } catch (ArrayIndexOutOfBoundsException mogus) {

            }

        }
    }
}
