import java.awt.Color;
import java.awt.Graphics;

public class Coin {
	private int x;
	private int y;
	private final int VELOCITY = 1;
	private final int RADIUS = 10;
	public final int WIDTH;
	private static final int KILL_LOCATION = 500;
	private static int WINDOW_WIDTH = 0;
	private boolean collected;

	public Coin(double percentage) {
		WIDTH = RADIUS + RADIUS;
		x = (int) (percentage * (WINDOW_WIDTH - WIDTH));
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

	public void success(){
		collected = true;
	}
	
	public void fail(){
		collected = false;
	}
	
	public boolean tick() {
		//System.out.println(distanceFall);
		y += VELOCITY;

		return y > KILL_LOCATION;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public boolean getSuccess() {
		return collected;
	}
}
