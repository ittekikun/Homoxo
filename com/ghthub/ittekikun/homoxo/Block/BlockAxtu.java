package com.ghthub.ittekikun.Homoxo.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.ghthub.ittekikun.Homoxo.Homoxo;

public class BlockAxtu extends Block
{
    public BlockAxtu(int par1, Material par2Material)
    {
        super(par1, par2Material);
        
		this.setUnlocalizedName("BlockAxtu");	//システム名の設定
		this.func_111022_d("Block_Axtu");	//ブロックのテクスチャの指定

        this.setStepSound(Block.soundClothFootstep);
        this.setLightValue(0.5F);
        this.setResistance(5.0F);
    }

    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        if (!var1.isRemote)
        {
            return true;
        }
        else if (!var5.canPlayerEdit(var2, var3, var4, var6, null))
        {
            return false;
        }
        else if (GuiScreen.isShiftKeyDown())
        {
            return false;
        }
        else
        {
            var5.addChatMessage("やらないか♂");
            if(Homoxo.Bouyomi)
            {
            	Homoxo.bouyomi.talk(Homoxo.volume, Homoxo.speed, Homoxo.tone, Homoxo.voice, "やらないか");
            }
            return true;
        }
    }
}
