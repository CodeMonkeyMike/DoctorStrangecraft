package strangecraft.blocks;

import strangecraft.Strangecraft;
import strangecraft.tileentites.TileEntityLabBench;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLabBench extends BlockContainer {

	protected BlockLabBench(int id) {
		super(id, Material.iron);
		
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.LABBENCH_UNLOCALIZED_NAME);
	}
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon botIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LABBENCH_TOP);
		botIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LABBENCH_BOT);
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LABBENCH_SIDE);			
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (side == 0) {
			return botIcon;
		}else if(side == 1) {
			return topIcon;
		}else{
			return sideIcon;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLabBench();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			// Parameter 3 is the option which will tell which case to use on get...GuiElement
			FMLNetworkHandler.openGui(player, Strangecraft.instance, 0, world, x, y, z);
		}
	
		return true;
	}
}
