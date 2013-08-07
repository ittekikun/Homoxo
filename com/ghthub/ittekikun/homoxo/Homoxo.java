package com.ghthub.ittekikun.Homoxo;
 
import java.util.Random;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.Configuration;

import com.ghthub.ittekikun.Homoxo.Block.BlockAxtu;
import com.ghthub.ittekikun.Homoxo.Block.BlockHomoxo;
import com.ghthub.ittekikun.Homoxo.Block.BlockHomoxoOre;
import com.ghthub.ittekikun.Homoxo.Entity.EntityHomoxo;
import com.ghthub.ittekikun.Homoxo.Item.ItemGoldenBall;
import com.ghthub.ittekikun.Homoxo.Item.ItemHomoxo;
import com.ghthub.ittekikun.Homoxo.Item.ItemHomoxoBook;
import com.ghthub.ittekikun.Homoxo.Item.ItemHomoxoSword;
import com.ghthub.ittekikun.ITKcore.PlayerLogin;
import com.ghthub.ittekikun.ITKcore.Uti.BouyomiChan4J;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.InstanceFactory;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid="Homoxo", name="Homoxo", version="1.0")
public class Homoxo implements IConnectionHandler 
{
	public static Block BlockHomoxo;
	public static Block BlockAxtu;
	public static Block BlockHomoxoOre;
	
	public static Item ItemHomoxo;
	public static Item ItemHomoxoBook;
	public static Item ItemGoldenBall;
	public static Item ItemHomoxoSword;
	
	public static int BlockHomoxoID = 4050;
	public static int BlockAxtuID = 4051;
	public static int BlockHomoxoOreID = 4052;
	
	public static int ItemHomoxoID = 5050;
	public static int ItemHomoxoBookID = 5051;
	public static int ItemGoldenBallID = 5052;
	public static int ItemHomoxoSwordID = 5053;
	
	//棒読みちゃん関係
	public static boolean Bouyomi = false;
	public static String HostIP = "localhost";
	public static int Port = 50001;
	public static int volume = -1;
	public static int speed = -1;
	public static int tone = -1;
	public static int voice = 0;
	
	public static BouyomiChan4J bouyomi = new BouyomiChan4J(HostIP,Port);
	
	//バージョンチェック
	public static boolean VerCheck = true;
	
	//tab
    public static final CreativeTabs HomoxoTab = new CreativeTabHomoxo("Homoxo");
	
	double NowVer = 1.0;
 
	@Instance("Homoxo")
    protected static Homoxo instance;
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//ブロックの登録
		BlockHomoxo = new BlockHomoxo(BlockHomoxoID, Material.rock).setCreativeTab(HomoxoTab);
		BlockAxtu = new BlockAxtu(BlockAxtuID, Material.rock).setCreativeTab(HomoxoTab);
		BlockHomoxoOre = new BlockHomoxoOre(BlockHomoxoOreID, Material.rock).setCreativeTab(HomoxoTab);
				
		GameRegistry.registerBlock(BlockHomoxo, "HomoxoBlock");
		GameRegistry.registerBlock(BlockAxtu, "AxtuBlock");
		GameRegistry.registerBlock(BlockHomoxoOre, "HomoxoOreBlock");
				
		//ブロック名の登録
		LanguageRegistry.addName(new ItemStack(BlockHomoxo, 1, 0), "HomoxoBlock");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxo, 1, 0), "ja_JP", "┌(┌ ＾o＾)┐ﾎﾓｫ...ブロック");
		LanguageRegistry.addName(new ItemStack(BlockAxtu, 1, 0), "AxtuBlock");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockAxtu, 1, 0), "ja_JP", "ｱｯｰ♂ブロック");
		LanguageRegistry.addName(new ItemStack(BlockHomoxoOre, 1, 0), "HomoxoOreBlock");
		LanguageRegistry.instance().addNameForObject(new ItemStack(BlockHomoxoOre, 1, 0), "ja_JP", "┌(┌ ＾o＾)┐ﾎﾓｫ...鉱石");
		
		//アイテム登録
		ItemHomoxo = new ItemHomoxo(ItemHomoxoID);
		ItemHomoxoBook = new ItemHomoxoBook(ItemHomoxoBookID);
		ItemGoldenBall = new ItemGoldenBall(ItemGoldenBallID);
		ItemHomoxoSword = new ItemHomoxoSword(ItemHomoxoSwordID);
		
		GameRegistry.registerItem(ItemHomoxo, "ItemHomoxo");
		GameRegistry.registerItem(ItemHomoxoBook, "ItemHomoxoBook");
		GameRegistry.registerItem(ItemGoldenBall, "ItemGoldenBall");
		GameRegistry.registerItem(ItemHomoxoSword, "ItemHomoxoSword");
		
		//アイテム名登録
		LanguageRegistry.addName(ItemHomoxo, "HomoxoItem");
		LanguageRegistry.instance().addNameForObject(ItemHomoxo, "ja_JP", "┌(┌ ＾o＾)┐ﾎﾓｫ...アイテム");
		LanguageRegistry.addName(ItemHomoxoBook, "HomoxoBook");
		LanguageRegistry.instance().addNameForObject(ItemHomoxoBook, "ja_JP", "(┌ ＾o＾)┐ﾎﾓｫ...ブック");
		LanguageRegistry.addName(ItemGoldenBall, "GoldenBall");
		LanguageRegistry.instance().addNameForObject(ItemGoldenBall, "ja_JP", "輝く金(の)玉");
		LanguageRegistry.addName(ItemHomoxoSword, "HomoxoSword");
		LanguageRegistry.instance().addNameForObject(ItemHomoxoSword, "ja_JP", "(┌ ＾o＾)┐ﾎﾓｫ...ソード");
		
		//名前
		LanguageRegistry.instance().addStringLocalization("Homoxo.CreativeTab", "TabHomoxo");
		LanguageRegistry.instance().addStringLocalization("Homoxo.CreativeTab", "ホモォMOD");
		
		//イベント登録
		NetworkRegistry.instance().registerConnectionHandler(instance);
		
		//レシピ
		GameRegistry.addRecipe(new ItemStack(BlockHomoxo, 1), 
	            new Object[]{"HHH","HSH","HHH", 'H', ItemHomoxo, 'S', Block.cloth});
		
		//エンティティ
		EntityRegistry.registerGlobalEntityID(EntityHomoxo.class, "Homoxo", ModLoader.getUniqueEntityId(), 0x290c05,  0xe3350c);
        EntityRegistry.addSpawn(EntityHomoxo.class, 8, 2, 3, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.plains, BiomeGenBase.icePlains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.mushroomIsland);
        LanguageRegistry.instance().addStringLocalization("entity.Homoxo.name", "Homoxo");
        LanguageRegistry.instance().addStringLocalization("entity.Homoxo.name", "ja_JP", "ホモォMOB");
		
	}
 
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
	     config.load();
		 BlockHomoxoID = config.getBlock("1_BlockHomoxoID", BlockHomoxoID).getInt();
		 BlockAxtuID = config.getBlock("2_BlockAxtuID", BlockAxtuID).getInt();
		 BlockHomoxoOreID = config.getBlock("3_BlockHomoxoOreID", BlockHomoxoOreID).getInt();
		 
		 ItemHomoxoID = config.getItem("1_ItemHomoxoID", ItemHomoxoID).getInt();
		 ItemHomoxoBookID = config.getItem("2_ItemHomoxoBookID", ItemHomoxoBookID).getInt();
		 ItemGoldenBallID = config.getItem("3_ItemGoldenBallID", ItemGoldenBallID).getInt();
		 ItemHomoxoSwordID = config.getItem("4_ItemHomoxoSwordID", ItemHomoxoSwordID).getInt();
		 
		 VerCheck = config.get("バージョンチェック", "チェック", VerCheck).getBoolean(true);
		 
		 Bouyomi = config.get("読み上げ機能", "1_棒読み", Bouyomi).getBoolean(false);
		 volume = config.get("読み上げ機能", "2_ボリューム", volume).getInt();
		 speed = config.get("読み上げ機能", "3_スピード", speed).getInt();
		 tone = config.get("読み上げ機能", "4_トーン", tone).getInt();
		 voice = config.get("読み上げ機能", "5_ボイス", voice).getInt();
		 HostIP = config.get("読み上げ機能", "6_ホストIP", HostIP).getString();
		 Port = config.get("読み上げ機能", "7_ポート番号", Port).getInt();
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "HomoxoMODConfigError");
		}
		finally
		{
			config.save();
		}
	}

	/*
	 * for(int i = 0; i < 5; i++)
	 *「i < 5」はレアリティを指定
	 * 石炭で20
	 * 
	 * int randomPosY = random.nextInt(20);
	 * Y軸の調整
	 * これではY20以下で生成
	 * 
	 * (new WorldGenMinable(blockID, 2)).generate(world, random, randomPosX, randomPosY, randomPosZ);
	 * 生成させる対象BlockIDを指定して固まってる数を指定
	 * これでは最大2
	 */
	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < 5; i++)
		{
			int randomPosX = chunkX + random.nextInt(16);
			int randomPosY = random.nextInt(20);
			int randomPosZ = chunkZ + random.nextInt(16);
			(new WorldGenMinable(BlockHomoxoOre.blockID, 5)).generate(world, random, randomPosX, randomPosY, randomPosZ);
		}
	}

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,INetworkManager manager) 
	{
		if(VerCheck)
		{
			EntityPlayer entityplayer = (EntityPlayer)player;
			String url = "Homoxo";
			Thread PlayerLogin = new Thread(new PlayerLogin(entityplayer,url,NowVer));
			PlayerLogin.start();
		}
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