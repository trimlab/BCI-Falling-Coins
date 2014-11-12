import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Matthew T. Vaught
 *
 */

public class MainGUI extends JFrame implements KeyListener {
	private final Bucket BUCKET;
	private final int PANEL_X = 640;
	private final int PANEL_Y = 640;
	private int motion = 0;
	private boolean run = true;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainGUI() {
		super("BCI Falling Coins");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.setPreferredSize(new Dimension(PANEL_X + 10, PANEL_Y));
		// this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.addKeyListener(this);


		JPanel drawablePanel = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2D = (Graphics2D) g;
				RenderingHints rh = new RenderingHints(
						RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2D.setRenderingHints(rh);
				BUCKET.draw(g);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 540, PANEL_X, 2);
				g.drawRect(0, 0, PANEL_X - 1, PANEL_Y - 1);
			}
		};
		// drawablePanel.setOpaque(true);
		this.add(drawablePanel);
		drawablePanel.setPreferredSize(new Dimension(PANEL_X, PANEL_Y));
		drawablePanel.setBackground(Color.BLACK);
		this.pack();
		// drawablePanel.setSize(new Dimension(PANEL_X, PANEL_Y));
		BUCKET = new Bucket(PANEL_X);
		Timer timer = createTimer();
		timer.start();


	}


	@Override
	public void keyPressed(KeyEvent e) {
		char test = e.getKeyChar();
		// System.out.println(test);
		if (test == 'a') {
			motion = -1;
		} else if (test == 's') {
			motion = 0;
		} else if (test == 'd') {
			motion = 1;
		}

	}

	private Timer createTimer() {
		// Create the instructions that will execute every cycle
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// checks to see if program is supposed to be running
				if (run) {
					// Redraw the window
					// System.out.println(motion);
					switch (motion) {
					case -1:
						// System.out.println("left");
						BUCKET.moveLeft();
						break;
					case 0:
						break;
					case 1:
						BUCKET.moveRight();
						break;
					}
					repaint();
				}
			}
		};
		// Return the timer which ticks ~.005 s
		return new Timer(5, actionListener);
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
