package strangecraft.client.interfaces;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTabDistillationTower extends GuiTab {

	public GuiTabDistillationTower(int id) {
		super("Distillation Tower", id);
		// TODO Auto-generated constructor stub
	}
	
	private static final GuiRectangle tower = new GuiRectangle(62, 46, 130, 97, -1);
	//private static final GuiRectangle heating = new GuiRectangle();
	
	@Override
	public void drawBackground(GuiLabbench gui, int x, int y) {
		tower.draw(gui, 126, 20);
	}

	@Override
	public void drawForeground(GuiLabbench gui, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
