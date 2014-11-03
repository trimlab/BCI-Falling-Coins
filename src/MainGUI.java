import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 *
 * @author Matthew T. Vaught
 *
 */

public class MainGUI extends JFrame implements KeyListener {
	private final Bucket BUCKET;
	private final int PANEL_X = 640;
	private final int PANEL_Y = 640;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainGUI() {
		super("BCI Falling Coins");
		BUCKET = new Bucket();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(PANEL_X, PANEL_Y));
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);


	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setRenderingHints(rh);
		BUCKET.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}



}
