package strangecraft.client.interfaces;

import strangecraft.Strangecraft;
import strangecraft.tileentites.TileEntityLabBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(Strangecraft.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if (te != null && te instanceof TileEntityLabBench) {
					return new ContainerLabbench(player.inventory, (TileEntityLabBench)te);
				}
				break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if (te != null && te instanceof TileEntityLabBench) {
					return new GuiLabbench(player.inventory, (TileEntityLabBench)te);
				}
				break;
		}
		return null;
	}

}
