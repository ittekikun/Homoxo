package com.ghthub.ittekikun.homoxo;
 
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
 
public class ItemBlockHomoxo extends ItemBlock 
{
 
	public ItemBlockHomoxo(int par1) 
	{
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
 
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
 
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		System.out.println(getUnlocalizedName() + "_" + par1ItemStack.getItemDamage());
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
 
}