package strangecraft.client.interfaces;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GuiTab extends GuiRectangle {
	private String name;

	public GuiTab(String name, int id) {
		// Super sloppy ternary operators FTW
		super((id < 4)?28 : 208,(id < 4)?(id * 20)+7 : ((id - 4) * 20)+7, 20, 20);
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void drawBackground(GuiLabbench gui, int x, int y);
	public abstract void drawForeground(GuiLabbench gui, int x, int y);
	public void mouseClick(GuiLabbench gui, int x, int y, int button) {}
	public void mouseMoveClick(GuiLabbench gui, int x, int y, int button, long timeSinceClicked) {}
	public void mouseReleased(GuiLabbench gui, int x, int y, int button) {}
}
