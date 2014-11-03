import java.awt.Color;
import java.awt.Dimension;
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
