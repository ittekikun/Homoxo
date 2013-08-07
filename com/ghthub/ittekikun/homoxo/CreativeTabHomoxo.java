package com.ghthub.ittekikun.Homoxo;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
 
public class CreativeTabHomoxo extends CreativeTabs
{
	public CreativeTabHomoxo(String type)
	{
		super(type);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Homoxo.BlockHomoxoID;
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return StatCollector.translateToLocal("Homoxo.CreativeTab");
	}
}