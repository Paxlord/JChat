package clientSide.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Window{

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Chat box");
		JPanel mainPanel = new JPanel();
		JPanel chatBox = new JPanel();
		JPanel textEnter = new JPanel();
		BorderLayout bl = new BorderLayout();
		
		JTextArea chatArea = new JTextArea(20,50);
		JTextArea inputArea = new JTextArea(2,50);
		
		chatArea.setEditable(false);
		
		mainPanel.setLayout(bl);

		
		
		chatBox.add(chatArea);
		textEnter.add(inputArea);
		
		chatArea.setBorder(BorderFactory.createLineBorder(Color.black));
		inputArea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		mainPanel.add(chatBox, BorderLayout.NORTH);
		mainPanel.add(textEnter, BorderLayout.SOUTH);
		
		
		frame.setContentPane(mainPanel);
		frame.setSize(new Dimension(600,400));
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
