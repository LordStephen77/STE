/*
 * STE (Script Text Editor)
 * Copyright (C) 2017 Stefano Peris
 * This file is distributed under the same license as the Script Text Editor package.
 */

package it.lordstephen77.ste;

import java.awt.*;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WinAbout extends JFrame {
	
	private static final long serialVersionUID = 1L;
		
		public WinAbout() {
			
			ImageIcon icon = new ImageIcon("res/ste_icon.png");
			
			JPanel panel = new JPanel();
	        panel.setBackground(new Color(102, 205, 170));
	        panel.setLayout(null);

	        JLabel title = new JLabel("STE (Script Text Editor)");
	        title.setBounds(0, 0, 200, 64);
	        title.setFont(new Font("Arial", Font.BOLD, 14));
	        title.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(title);
	        
	        JLabel copyright = new JLabel("By Stefano Peris (c) 2017");
	        copyright.setBounds(-10, 20, 200, 64);
	        copyright.setFont(new Font("Arial", Font.BOLD, 11));
	        copyright.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(copyright);

	        UIManager.put("OptionPane.minimumSize",new Dimension(600, 290));
	        JOptionPane.showMessageDialog(null, panel, "About", JOptionPane.PLAIN_MESSAGE, icon);
	}
	
}
