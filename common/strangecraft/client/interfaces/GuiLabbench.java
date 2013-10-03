package strangecraft.client.interfaces;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import strangecraft.tileentites.TileEntityLabBench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiLabbench extends GuiContainer {

	public GuiLabbench(InventoryPlayer invPlayer, TileEntityLabBench labbench) {
		super(new ContainerLabbench(invPlayer, labbench));
		
		xSize = 256;
		ySize = 224;
	}

	private static final ResourceLocation texture = new ResourceLocation("strangecraft", "textures/gui/labbench.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}

}
