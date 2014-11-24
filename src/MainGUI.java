import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Matthew T. Vaught
 *
 */

public class MainGUI extends JFrame implements KeyListener {
	private final int TICK = 5;
	private final Bucket BUCKET;
	private final int PANEL_X = 640;
	private final int PANEL_Y = 640;
	private int motion = 0;
	private boolean run = false;
	private LinkedList<Coin> coins = new LinkedList<Coin>();
	private final long START_TIME;
	private final long DURATION;
	private final String TEST_ID;
	private final String OUTPUT_FILE;
	private int left = 0;
	private int right = 0;
	private int zero = 0;
	private Timer timer;
	private Random random;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainGUI(int testDuration, String outputFile, String testID) {
		super("BCI Falling Coins");
		OUTPUT_FILE = outputFile;
		TEST_ID = testID;
		random = new Random(System.nanoTime());
		DURATION = (long) (testDuration * Math.pow(10, 9));
		Coin.setWindowWidth(PANEL_X);

		coins.addLast(new Coin(random.nextDouble()));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.setPreferredSize(new Dimension(PANEL_X + 10, PANEL_Y));
		// this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.addKeyListener(this);

		JPanel drawablePanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				// Graphics2D g2D = (Graphics2D) g;
				RenderingHints rh = new RenderingHints(
						RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				((Graphics2D) g).setRenderingHints(rh);

				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 540, PANEL_X, 2);
				g.drawRect(0, 0, PANEL_X - 1, PANEL_Y - 1);
				if (run)
					coins.getLast().draw(g);
				BUCKET.draw(g);
			}
		};
		// drawablePanel.setOpaque(true);
		this.add(drawablePanel);
		drawablePanel.setPreferredSize(new Dimension(PANEL_X, PANEL_Y));
		drawablePanel.setBackground(Color.BLACK);
		this.pack();
		// drawablePanel.setSize(new Dimension(PANEL_X, PANEL_Y));
		BUCKET = new Bucket(PANEL_X);
		timer = createTimer();
		timer.start();
		run = true;
		START_TIME = System.nanoTime();

	}

	private void exit() {
		run = false;
		long stop = System.nanoTime();
		timer.stop();
		// System.out.println((stop - START_TIME));
		int collected = 0;
		int failed = 0;
		for (Coin coin : coins) {
			if (coin.getSuccess()) {
				collected++;
			} else {
				failed++;
			}
		}
		String header = "ID,COLLECTED,UNCOLLECTED,TOTAL,LEFT,ZERO,RIGHT,DURATION (s),";
		String content = TEST_ID + "," + collected + "," + failed + ","
				+ (collected + failed) + "," + left + "," + zero + "," + right
				+ "," + (stop - START_TIME) / Math.pow(10, 9) + ",";
		System.out.println(header);
		System.out.println(content);

		File f;
		if (OUTPUT_FILE.length() > 4 && OUTPUT_FILE.endsWith(".csv")) {
			f = new File(OUTPUT_FILE);
		} else {
			f = new File(OUTPUT_FILE + ".csv");
		}

		boolean addheader = !f.exists();

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(f, true)));
			if (addheader) {
				out.println(header);
			}
			out.println(content);
			out.close();
		} catch (IOException fnf) {
			System.out.println("ERROR");
		}
		System.exit(0);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char test = e.getKeyChar();
		// System.out.println(test);
		int motionOld = motion;
		if (test == 'a') {
			motion = -1;
		} else if (test == 's') {
			motion = 0;
		} else if (test == 'd') {
			motion = 1;
		}
		if (motionOld != motion) {
			switch (motion) {
			case -1:
				left++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				right++;
				break;
			}
		}

	}

	private Timer createTimer() {
		// Create the instructions that will execute every cycle
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// checks to see if program is supposed to be running
				if ((System.nanoTime() - START_TIME) > DURATION) {
					exit();
				}

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

					boolean next = coins.getLast().tick();
					if (next) {
						Coin coin = coins.getLast();
						if (BUCKET.getX() < coin.getX()
								&& BUCKET.getX() + BUCKET.WIDTH > coin.getX()
										+ coin.WIDTH) {
							coin.success();
						} else {
							coin.fail();
						}
						coins.addLast(new Coin(random.nextDouble()));
					}
					repaint();
				}
			}
		};
		// Return the timer which ticks ~.005 s
		return new Timer(TICK, actionListener);
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
