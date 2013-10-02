package strangecraft.items;

import net.minecraft.item.ItemBlock;

public class ItemLabBench extends ItemBlock {

	public ItemLabBench(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg) {
		return dmg;
	}
}
