package com.my.pract.chap1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintCompnentDemo {

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("PaintComponentDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new MyPanel());

		// frame.setSize(250, 250);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				createAndShowGUI();
			}
		});
	}
}

class MyPanel extends JPanel {

	RedSquare redSquare = new RedSquare();

	private final int CURR_X = redSquare.getXpos();
	private final int CURR_Y = redSquare.getYpos();
	private final int CURR_W = redSquare.getWidth();
	private final int CURR_H = redSquare.getHieght();

	public MyPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		/*
		 * addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mousePressed(MouseEvent e) {
		 * moveSquare(e.getX(), e.getY()); } });
		 */

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}

			public void mouseMoved(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});

	}

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if (CURR_X != x || CURR_Y != y) {
			repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);
			redSquare.setXpos(x);
			redSquare.setYpos(y);
			repaint(redSquare.getXpos(), redSquare.getYpos(),
					redSquare.getWidth() + OFFSET, redSquare.getHieght()
							+ OFFSET);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(250, 250);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw Text
		redSquare.paintSquare(g);
		/*
		 * g.drawString("This is my Custom Test Paint", 10, 20);
		 * g.setColor(Color.RED); g.fillRect(squareX, squareY, squareH,
		 * squareH); g.setColor(Color.BLACK); g.drawRect(squareX, squareY,
		 * squareW, squareH);
		 */

	}
}

class RedSquare {
	private int xpos = 50;
	private int ypos = 50;
	private int width = 20;
	private int hieght = 20;

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHieght() {
		return hieght;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public void paintSquare(Graphics g) {
		g.drawString("This is my Custom Test Paint", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(xpos, ypos, hieght, width);
		g.setColor(Color.BLACK);
		g.drawRect(xpos, ypos, hieght, width);
	}

}
