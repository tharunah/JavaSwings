package com.my.pract.chap1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class DemoSwing {

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("HelloWorldSwing Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello World Swing Label");

		frame.getContentPane().add(label);
		// Display the Window.
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
