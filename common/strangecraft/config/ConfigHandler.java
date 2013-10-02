package strangecraft.config;

import java.io.File;

import strangecraft.blocks.BlockInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.LABBENCH_ID = config.getBlock(BlockInfo.LABBENCH_KEY, BlockInfo.LABBENCH_DEFAULT).getInt();
		
		//ItemInfo.WAND_ID = config.getItem(ItemInfo.WAND_KEY, ItemInfo.WAND_DEFAULT).getInt() - 256;
		
		config.save();
		
	}
}
