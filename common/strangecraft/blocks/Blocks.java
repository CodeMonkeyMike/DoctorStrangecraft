package strangecraft.blocks;

import strangecraft.items.ItemLabBench;
import strangecraft.tileentites.TileEntityLabBench;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {

	public static Block labbench;

	public static void init() {
		labbench = new BlockLabBench(BlockInfo.LABBENCH_ID);
		GameRegistry.registerBlock(labbench, ItemLabBench.class, BlockInfo.LABBENCH_KEY);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(labbench, BlockInfo.LABBENCH_NAME);
	}
	
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityLabBench.class, BlockInfo.LABBENCH_TE_KEY);
	}
	
}
