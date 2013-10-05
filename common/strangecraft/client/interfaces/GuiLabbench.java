package strangecraft.client.interfaces;

import java.util.List;

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
	private final GuiTab[] tabs;
	private GuiTab activeTab;
	
	public GuiLabbench(InventoryPlayer invPlayer, TileEntityLabBench labbench) {
		super(new ContainerLabbench(invPlayer, labbench));
		
		xSize = 256;
		ySize = 224;
		
		tabs = new GuiTab[] {
				new GuiTabDistillationTower(0),
				new GuiTabSaw(1),
				new GuiTabCompressor(2),
				new GuiTabMixer(3),
				new GuiTabShaker(4),
				new GuiTabCentrifuge(5),
				new GuiTabElectrolizer(6),
				new GuiTabTumbler(7)
		};
		activeTab = tabs[0];
	}

	private static final ResourceLocation texture = new ResourceLocation("strangecraft", "textures/gui/labbench.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		
		for (GuiRectangle tab : tabs) {
			int srcY = 43;
			
			if (tab == activeTab) {
				srcY += 32;
			}else if(tab.inRect(this, x, y)) {
				srcY += 16;
			}
			
			tab.draw(this, xSize, srcY);
		}
		
		activeTab.drawBackground(this, x, y);
		
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}
	
	protected int getLeft() {
		return guiLeft;
	}
	
	protected int getTop() {
		return guiTop;
	}
	
	protected void drawHoverString(List lst, int x, int y) {
		drawHoveringText(lst, x, y, fontRenderer);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawString("Lab Bench", 80, 12, 0x404040);
		
		activeTab.drawForeground(this, x, y);
		
		for (GuiTab tab : tabs) {
			tab.drawString(this, x, y, tab.getName());
		}
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
		
		activeTab.mouseClick(this, x, y, button);
		
		for (GuiTab tab : tabs) {
			if (activeTab != tab) {
				if (tab.inRect(this, x, y)) {
					activeTab = tab;
					break;
				}
			}
		}
	}
}
