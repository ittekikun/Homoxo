package com.ghthub.ittekikun.homoxo;
 
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class BlockHomoxo extends Block
{
	public BlockHomoxo(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setStepSound(Block.soundGlassFootstep);	//ブロックの音
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) 
	{
		return super.getIcon(par1, par2);
	}
 
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		// メタデータでブロックを追加する
		// par3List.add(new ItemStack(par1, 1, <メタデータ>));
		for (int i = 0; i < 16; i++) 
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
 
}