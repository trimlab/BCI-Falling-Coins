import java.awt.Color;
import java.awt.Graphics;


public class Bucket {
	private int x = 50;
	private int y = 50;
	private final int VELOCITY = 10;
	private final int BASE_WIDTH = 60;
	private final int INNER_WIDTH = 30;
	private final int HEIGHT = 40;
	private final int DEPTH = 25;
	private final int TOP_WIDTH = 80;
	private final int TOP_BASE_WIDTH_OFFSET;
	private final int TOP_INNER_WIDTH_OFFSET;
	private final int SCALE = 1;

	public Bucket() {
		TOP_BASE_WIDTH_OFFSET = (TOP_WIDTH - BASE_WIDTH) / 2;
		TOP_INNER_WIDTH_OFFSET = (TOP_WIDTH - INNER_WIDTH) / 2;
	}

	public void draw(Graphics g) {

		g.setColor(Color.WHITE);

		int x = 50;
		int y = 50;

		int[] xCord = { x, x + TOP_BASE_WIDTH_OFFSET * SCALE,
				x + (TOP_WIDTH - TOP_BASE_WIDTH_OFFSET) * SCALE,
				x + TOP_WIDTH * SCALE,
				x + (TOP_WIDTH - TOP_INNER_WIDTH_OFFSET) * SCALE,
				x + TOP_INNER_WIDTH_OFFSET * SCALE };

		int[] yCord = { y, y + HEIGHT * SCALE, y + HEIGHT * SCALE, y,
				y + DEPTH * SCALE, y + DEPTH * SCALE };

		g.fillPolygon(xCord, yCord, 6);


	}

	public void moveLeft() {
		x -= VELOCITY;
	}

	public void moveRight() {
		x += VELOCITY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
