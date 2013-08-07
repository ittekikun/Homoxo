package com.ghthub.ittekikun.Homoxo.Item;
 
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.ghthub.ittekikun.Homoxo.Homoxo;
 
public class ItemHomoxoBook extends Item
{
 
	public ItemHomoxoBook(int par1)
	{
		super(par1);
		this.setUnlocalizedName("ItemHomoxoBook");	//システム名の登録
		this.func_111206_d("Item_HomoxoBook");	//テクスチャの指定
		this.setMaxStackSize(64);	//スタックできる量
		this.setCreativeTab(Homoxo.HomoxoTab);
	}
 
	/*
	 * 以下おまけ
	 * 特に機能がなければ消してください
	 */
 
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ)
	{
		//アイテムをブロックに対して右クリックした時に呼ばれる
		return false;
	}
 
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		//アイテムを右クリック時に呼ばれる
		return item;
	}
}