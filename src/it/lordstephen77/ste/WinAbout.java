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
	
	final String strURL = "https://github.com/LordStephen77/STE";
	
	final JEditorPane htmlPane = new JEditorPane();
	
	private static final long serialVersionUID = 1L;
		
		public WinAbout() {
			
			ImageIcon icon = new ImageIcon("res/ste_icon.png");
			
			JPanel panel = new JPanel();
	        panel.setBackground(new Color(102, 205, 170));
	        panel.setLayout(null);

	        panel.setBorder(BorderFactory.createTitledBorder(""));
	        
	        JLabel title = new JLabel("STE");
	        title.setBounds(0, 0, 265, 64);
	        title.setFont(new Font("Arial", Font.BOLD, 18));
	        title.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(title, "push, align center");
	        
	        JLabel subtitle = new JLabel("(Script Text Editor)");
	        subtitle.setBounds(0, 20, 265, 64);
	        subtitle.setFont(new Font("Arial", Font.BOLD, 12));
	        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(subtitle, "push, align center");
	        
	        JLabel copyright = new JLabel("By Stefano Peris (c) 2017");
	        copyright.setBounds(0, 40, 265, 64);
	        copyright.setFont(new Font("Arial", Font.BOLD, 11));
	        copyright.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(copyright, "push, align center");
	        
	        JLabel note1 = new JLabel("This software is opensource.");
	        note1.setBounds(0, 80, 265, 64);
	        note1.setFont(new Font("Arial", Font.BOLD, 11));
	        note1.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(note1);
	        
	        JLabel note2 = new JLabel("Licensed under GPL3.");
	        note2.setBounds(0, 100, 265, 64);
	        note2.setFont(new Font("Arial", Font.BOLD, 11));
	        note2.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(note2);
	        
	        JLabel github = new JLabel("♥ Github ♥");
	        github.setBounds(0, 140, 265, 64);
	        github.setFont(new Font("Arial", Font.BOLD, 14));
	        github.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(github);
	        
	        UIManager.put("OptionPane.minimumSize",new Dimension(600, 290));
	        JOptionPane.showMessageDialog(null, panel, "About", JOptionPane.PLAIN_MESSAGE, icon);
	}
	
}


