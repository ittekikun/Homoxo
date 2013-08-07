package com.ghthub.ittekikun.Homoxo.Block;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.ghthub.ittekikun.Homoxo.Homoxo;
 
public class BlockHomoxo extends Block
{
 
	public BlockHomoxo(int par1, Material par2Material)
	{
		super(par1, par2Material);

		this.setUnlocalizedName("BlockHomoxo");	//システム名の設定
		this.func_111022_d("Block_Homoxo");	//ブロックのテクスチャの指定

		this.setHardness(0.5F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundClothFootstep);
        this.setLightValue(0.5F);
	}
 
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		//ブロックを壊した時にドロップするもの
		return this.blockID;
	}
 
	@Override
	public int quantityDropped(Random rand)
	{
		//ブロックを壊した時にドロップする量
		return 1;
	}
 
	@Override
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
            var5.addChatMessage("┌(┌ ＾o＾)┐ﾎﾓｫ...");
            
            if(Homoxo.Bouyomi)
            {
            	Homoxo.bouyomi.talk(Homoxo.volume, Homoxo.speed, Homoxo.tone, Homoxo.voice, "ﾎﾓｫ...");
            }
            return true;
        }
    }
 
}