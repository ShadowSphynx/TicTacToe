package game;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Action {

	Game game = new Game();
	ImageIcon cross = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Cross.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
	ImageIcon zero = new ImageIcon(new ImageIcon("D:/Programming/TicTacToe/images/Zero.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
	
	public void action(ActionEvent e, JButton button, JFrame frame) {

		int move = game.setMove((e.getActionCommand().length()));
		if(move==1)
			button.setIcon(cross);
		else
			button.setIcon(zero);
		checkGame(frame);
		button.setEnabled(false);
	
	}
	
	void checkGame(JFrame frame) {
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
