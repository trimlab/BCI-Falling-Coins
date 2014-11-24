import java.awt.Color;
import java.awt.Graphics;

public class Coin {
	private int x;
	private int y;
	private final int VELOCITY = 2;
	private final int RADIUS = 10;
	private final int WIDTH;
	private final int SCALE = 1;
	private static final int START_LOCATION = 0;
	private static final int KILL_LOCATION = 500;
	private static int WINDOW_WIDTH = 0;
	private static double distanceFall = 0;

	public Coin(double percentage) {
		WIDTH = RADIUS + RADIUS;
		x = (int) (percentage * (double) (WINDOW_WIDTH - WIDTH));
		y = 0 - WIDTH;
	}



	public static void setWindowWidth(int width) {
		WINDOW_WIDTH = width;
	}

	public void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval(x,  y, WIDTH, WIDTH);
		g.setColor(Color.black);
		g.drawOval(x,  y, WIDTH, WIDTH);
	}

	public boolean tick() {
		//System.out.println(distanceFall);
		y += VELOCITY;

		return (int) y > KILL_LOCATION;
	}
}
