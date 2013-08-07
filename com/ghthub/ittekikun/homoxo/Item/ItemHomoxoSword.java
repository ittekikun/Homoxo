package com.ghthub.ittekikun.Homoxo.Item;
 
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;

import com.ghthub.ittekikun.Homoxo.Homoxo;
 
public class ItemHomoxoSword extends ItemSword
{
	public static EnumToolMaterial HomoxoSwordEnum;
	static
	{
		//剣に使う基本素材の設定
		HomoxoSwordEnum = EnumHelper.addToolMaterial("HomoxoSword", 0, 150, 4.0F, 2.0F, 22);
		HomoxoSwordEnum.customCraftingMaterial = Item.bone;
	}

	public ItemHomoxoSword(int par1)
	{
		super(par1, HomoxoSwordEnum);
		this.setUnlocalizedName("ItemHomoxoSword");	//システム名の登録
		this.func_111206_d("Item_HomoxoSword");	//テクスチャの指定
		this.setCreativeTab(Homoxo.HomoxoTab);
	}
}