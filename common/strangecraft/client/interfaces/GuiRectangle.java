package strangecraft.client.interfaces;

import java.util.Arrays;

public class GuiRectangle {

	private int x;
	private int y;
	private int w;
	private int h;
	private int id;
	
	public GuiRectangle(int x, int y, int w, int h, int id) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.id = id;
	}
	
	public boolean inRect(GuiLabbench gui, int mouseX, int mouseY) {
		mouseX -= gui.getLeft();
		mouseY -= gui.getTop();
		
		return x <= mouseX && mouseX <= x + w && y <= mouseY && mouseY <= y + h;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getId() {
		return id;
		
	}
	
	public void draw(GuiLabbench gui, int srcX, int srcY) {
		gui.drawTexturedModalRect(gui.getLeft() + x, gui.getTop() + y, srcX, srcY, w, h);
		if (id >= 0){
			gui.drawTexturedModalRect(gui.getLeft() + x + 2, gui.getTop() + y + 2, id * 16, srcY, 16, 16);
		}
	}
	
	public void drawString(GuiLabbench gui, int mouseX, int mouseY, String str) {
		if (inRect(gui, mouseX, mouseY)) {
			gui.drawHoverString(Arrays.asList(str.split("\n")), mouseX - gui.getLeft(), mouseY - gui.getTop());
		}
	}
}
