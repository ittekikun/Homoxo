package com.ghthub.ittekikun.Homoxo.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.ghthub.ittekikun.Homoxo.Homoxo;


public class BlockHomoxoOre extends Block
{
    public BlockHomoxoOre(int par1, Material par2Material)
    {
        super(par1, par2Material);

		this.setUnlocalizedName("BlockHomoxoOre");	//システム名の設定
		this.func_111022_d("Block_HomoxoOre");	//ブロックのテクスチャの指定

        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public int idDropped(int var1, Random var2, int var3)
    {
        return Homoxo.ItemHomoxoID;
    }

    public int quantityDropped(Random var1)
    {
    	int ran = var1.nextInt(1) + 1;
        return ran;
    }
}
