package lab13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private int numClick;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		numClick=0;
		
		//create buttons
		JButton changeButton = new JButton("Change");
		JButton resetButton = new JButton("Reset");
		JButton closeButton = new JButton("Close");
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(changeButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(closeButton);
		
		//add panel to frame
		add(buttonPanel);
		buttonPanel.setBackground(Color.BLACK);
		
		//create button actions
		ColorAction blackAction = new ColorAction(Color.BLACK);
		ColorAction greenAction = new ColorAction(Color.GREEN);
		ColorAction orangeAction = new ColorAction(Color.ORANGE);
		ColorAction pinkAction = new ColorAction(Color.PINK);
		
		//associate actions with buttons
		if(numClick%4==0)
			changeButton.addActionListener(blackAction);
		else if(numClick%4==1)
			changeButton.addActionListener(greenAction);
		else if(numClick%4==2)
			changeButton.addActionListener(orangeAction);
		else
			changeButton.addActionListener(pinkAction);
		resetButton.addActionListener(blackAction);
		closeButton.addActionListener(blackAction);
		System.exit(0);
		
	}
	
	/* An action listener that sets the panel's background color */
	private class ColorAction implements ActionListener
	{
		private Color backgroundColor;
		
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundColor);
		}
	}
}