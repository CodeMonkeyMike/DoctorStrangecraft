package strangecraft.client.interfaces;

import strangecraft.network.PacketHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTabDistillationTower extends GuiTab {

	public GuiTabDistillationTower(int id) {
		super("Distillation Tower", id);
	}
	
	private static final GuiRectangle tower = new GuiRectangle(62, 46, 130, 97, -1);
	private static final GuiRectangle slider = new GuiRectangle(95, 49, 6, 9, -1);
	
	private int tempHeatSetting;
	private boolean isDragging;
	
	@Override
	public void drawBackground(GuiLabbench gui, int x, int y) {
		tower.draw(gui, 126, 20);
		updateSliderPosition(gui);
		slider.draw(gui, 246, 0);
	}

	@Override
	public void drawForeground(GuiLabbench gui, int x, int y) {
		gui.getFontRenderer().drawString("Height: +" + getCurrentHeat(gui), 60, 88, 0x404040);
	}
	@Override
	public void mouseClick(GuiLabbench gui, int x, int y, int button) {
		updateSliderPosition(gui);
		if (slider.inRect(gui, x, y)) {
			isDragging = true;
			tempHeatSetting = gui.labbench.heatSetting;
		}
	}
	
	@Override
	public void mouseMoveClick(GuiLabbench gui, int x, int y, int button, long timeSinceClicked) {
		if (isDragging) {
			tempHeatSetting = x - gui.getLeft() - 50;
			if (tempHeatSetting < 0) {
				tempHeatSetting = 0;
			}else if(tempHeatSetting > 85) {
				tempHeatSetting = 85;
			}
		}
	}
	
	@Override
	public void mouseReleased(GuiLabbench gui, int x, int y, int button) {
		if (isDragging) {
			PacketHandler.sendInterfacePacket((byte)0, (byte)tempHeatSetting);
			gui.labbench.heatSetting = tempHeatSetting;
			isDragging = false;
		}
	}
	
	private void updateSliderPosition(GuiLabbench gui) {
		slider.setX(50 + getCurrentHeat(gui));
	}
	
	private int getCurrentHeat(GuiLabbench gui) {
		return isDragging ? tempHeatSetting : gui.labbench.heatSetting;	
	}
}
