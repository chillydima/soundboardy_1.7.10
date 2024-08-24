package com.SoundBoardy.soundboardy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class MovingSoundPlayer extends MovingSound
{
    private final EntityPlayer player;

    public MovingSoundPlayer(EntityPlayer plr, String SoundResource)
    {
        super(new ResourceLocation(SoundResource));
        this.player = plr;
        this.repeat = false;
        this.field_147665_h = 0;
    }

    public void update()
    {
        if (this.player.isDead)
        {
            this.donePlaying = true;
        }
        else
        {
            this.xPosF = (float)this.player.posX;
            this.yPosF = (float)this.player.posY+2.2F;
            this.zPosF = (float)this.player.posZ;

        }
    }
}
