package strangecraft.client.interfaces;

import strangecraft.tileentites.TileEntityLabBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLabbench extends Container {

	private TileEntityLabBench labbench;
	
	public ContainerLabbench(InventoryPlayer invPlayer, TileEntityLabBench Labbench) {
		this.labbench = Labbench;
		
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 48 + 18 * x, 200));
		}
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 48 + 18 * x, 142 + y * 18));
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return labbench.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

}