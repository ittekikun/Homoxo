package com.ghthub.ittekikun.homoxo;
 
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;

import com.ghthub.ittekikun.ITKcore.PlayerLogin;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.InstanceFactory;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid="Homoxo", name="Homoxo", version="1.0")
public class Homoxo implements IConnectionHandler 
{
	public static Block BlockHomoxoMetadata;
	public static int BlockHomoxoMetadataID = 4087;
	
	double NowVer = 1.0;
 
	@Instance("Homoxo")
    protected static Homoxo instance;
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//ブロック名の登録
		//LanguageRegistry.addName(new ItemStack(blockSample, 1, <メタデータ>), "<名前>");
		//LanguageRegistry.instance().addNameForObject(new ItemStack(blockSample, 1, <メタデータ>), "<言語>", "<名前>");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 0), "Sample Block1");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 0), "ja_JP", "サンプル ブロック1");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 1), "Sample Block2");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 1), "ja_JP", "サンプル ブロック2");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 2), "Sample Block3");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 2), "ja_JP", "サンプル ブロック3");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 3), "Sample Block4");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 3), "ja_JP", "サンプル ブロック4");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 4), "Sample Block5");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 4), "ja_JP", "サンプル ブロック5");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 5), "Sample Block6");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 5), "ja_JP", "サンプル ブロック6");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 6), "Sample Block7");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 6), "ja_JP", "サンプル ブロック7");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 7), "Sample Block8");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 7), "ja_JP", "サンプル ブロック8");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 8), "Sample Block9");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 8), "ja_JP", "サンプル ブロック9");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 9), "Sample Block10");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 9), "ja_JP", "サンプル ブロック10");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 10), "Sample Block11");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 10), "ja_JP", "サンプル ブロック11");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 11), "Sample Block12");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 11), "ja_JP", "サンプル ブロック12");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 12), "Sample Block13");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 12), "ja_JP", "サンプル ブロック13");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 13), "Sample Block14");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 13), "ja_JP", "サンプル ブロック14");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 14), "Sample Block15");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 14), "ja_JP", "サンプル ブロック15");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoMetadata, 1, 15), "Sample Block16");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoMetadata, 1, 15), "ja_JP", "サンプル ブロック16");
		
		NetworkRegistry.instance().registerConnectionHandler(instance);
	}
 
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックの登録
		BlockHomoxoMetadata = new BlockHomoxo(BlockHomoxoMetadataID, Material.rock).setCreativeTab(CreativeTabs.tabBlock);
		//GameRegistry.registerBlock(blockSample, <ItemBlock>.class, "blockSample");
		GameRegistry.registerBlock(BlockHomoxoMetadata, ItemBlockHomoxo.class, "BlockHomoxo");
	}

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,INetworkManager manager) 
	{
		EntityPlayer entityplayer = (EntityPlayer)player;
		String url = "Homoxo";

		Thread PlayerLogin = new Thread(new PlayerLogin(entityplayer,url,NowVer));
		PlayerLogin.start();
		
	}
	
	@InstanceFactory
    public static Homoxo instance() 
    {
    	return new Homoxo();
    }

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler,
			INetworkManager manager, Packet1Login login) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
 
}