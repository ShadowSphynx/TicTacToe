package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.*;

public class Window extends JFrame {
	
	public Window() {
		setGame(); 
	}

	Game game = new Game();
	JFrame frame = new JFrame("TicTacToe");
	
	void setGame() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(3, 3));
		
		ImageIcon cross = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Cross.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		ImageIcon zero = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Zero.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		ImageIcon blank = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Blank.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		
		String name = "A";
		
		for(int i=0 ; i<9 ; i++){
		    JButton button = new JButton(name);
		    button.setPreferredSize(new Dimension(100, 100));
		    button.setIcon(blank);
		    button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int move = game.setMove((e.getActionCommand().length()));
					if(move==1)
						button.setIcon(cross);
					else
						button.setIcon(zero);
					checkGame();
					button.setEnabled(false);
				}
			});
		    panel.add(button);
		    name+= "A";
		}
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	void checkGame() {
		if(game.checkGame()) {
			if(game.count%2==0)
				JOptionPane.showMessageDialog(frame, "0 wins!");
			else if(game.count%2!=0)
				JOptionPane.showMessageDialog(frame, "x wins!");
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
			
		if(game.count==9) {
			JOptionPane.showMessageDialog(frame, "Game Draw.");
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}