package strangecraft.client.interfaces;

import strangecraft.tileentites.TileEntityLabBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerLabbench extends Container {
	
	private TileEntityLabBench labbench;
	
	public ContainerLabbench(InventoryPlayer invPlayer, TileEntityLabBench labbench) {
		this.labbench = labbench;
		
//		for (int x = 0; x < 9; x++) {
//			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 194));
//		}
//		
//		for (int y = 0; y < 3; y++) {
//			for (int x = 0; x < 9; x++) {
//				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 136 + y * 18));
//			}
//		}
//		
//		for (int x = 0; x < 3; x++) {
//			addSlotToContainer(new SlotAnvil(machine, x, 8 + 18 * x, 17));
//		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return labbench.isUseableByPlayer(entityplayer);
	}
	
	public TileEntityLabBench getLabbench() {
		return labbench;
	}
}
