package strangecraft;

import strangecraft.blocks.Blocks;
import strangecraft.client.interfaces.GuiHandler;
import strangecraft.config.ConfigHandler;
import strangecraft.items.Items;
import strangecraft.network.PacketHandler;
import strangecraft.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Strangecraft {


	@Instance(ModInformation.ID)
	public static Strangecraft instance;

	@SidedProxy(clientSide = "strangecraft.proxies.ClientProxy", serverSide = "strangecraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Items.addNames();
		Blocks.addNames();
		
		Items.registerRecipes();
		
		Blocks.registerTileEntities();
		
		new GuiHandler();
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
	
	}
}