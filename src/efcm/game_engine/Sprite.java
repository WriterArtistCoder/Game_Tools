package efcm.game_engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import efcm.task_engine.SlowTaskManager;

public abstract class Sprite {

	/** Actions the sprite can perform */
	protected Action[] actions;

	/** The SlowTaskManager */
	private SlowTaskManager manager;

	/** The source sprite sheet */
	protected Image image;

	/** The current sprite, an index starting with 0 */
	protected int frame;

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Sprite() {
		this.manager = new SlowTaskManager();
	}

	public void render(Graphics g, ImageObserver observer) {
		g.drawImage(image, x * Runner.SCENE_PXL_SCALE, y * Runner.SCENE_PXL_SCALE, (x + width) * Runner.SCENE_PXL_SCALE,
				(y + height) * Runner.SCENE_PXL_SCALE, width * frame, 0, width * (frame + 1), height, observer);
		manager.doTasks();
	}

	public abstract void actOn(Action action, Sprite reciever);

	public abstract void recieve(Action action, Sprite actor);

	public Action[] getActions() {
		return actions;
	}

	public void setActions(Action[] actions) {
		this.actions = actions;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getFrame() {
		return frame;
	}
	
	public void setFrame(int frame) {
		this.frame = frame;
	}
	
	public void setPosition(int x, int y, int mode) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
