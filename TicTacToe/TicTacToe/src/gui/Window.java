package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.Action;

public class Window extends JFrame {
	
	public Window() {
		setGame(); 
	}

	JFrame frame = new JFrame("TicTacToe");
	Action action = new Action();
	
	void setGame() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(3, 3));
	
		ImageIcon blank = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Blank.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		
		String name = "A";
		
		for(int i=0 ; i<9 ; i++){
		    JButton button = new JButton(name);
		    button.setPreferredSize(new Dimension(100, 100));
		    button.setIcon(blank);
		    button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					action.action(e, button, frame);
				}
			});
		    panel.add(button);
		    name+= "A";
		}
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
