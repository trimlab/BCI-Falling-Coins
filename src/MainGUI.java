import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matthew T. Vaught
 *
 */

public class MainGUI extends JFrame{
	
	public MainGUI() {

	}

	public void init() {

	}

	private class MyJPanel extends JPanel implements KeyListener {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}