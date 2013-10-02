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
	
	private TileEntityLabBench labbench;
	
	public GuiLabbench(InventoryPlayer invPlayer, TileEntityLabBench labbench) {
		super(new ContainerLabbench(invPlayer, labbench));
		
		this.labbench = labbench;
		
		xSize = 256;
		ySize = 224;
	}

	private static final ResourceLocation texture = new ResourceLocation("strangecraft", "textures/gui/labbench.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(TextureMap.field_110575_b);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawString("test", 8, 6, 0x404040);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		buttonList.clear();
	}
	
	protected int getLeft() {
		return guiLeft;
	}
	
	protected int getTop() {
		return guiTop;
	}
}
