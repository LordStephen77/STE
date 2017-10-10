/*
 * 
 * .----------------.  .----------------.  .----------------. 
 * | .--------------. || .--------------. || .--------------. |
 * | |    _______   | || |  _________   | || |  _________   | |
 * | |   /  ___  |  | || | |  _   _  |  | || | |_   ___  |  | |
 * | |  |  (__ \_|  | || | |_/ | | \_|  | || |   | |_  \_|  | |
 * | |   '.___`-.   | || |     | |      | || |   |  _|  _   | |
 * | |  |`\____) |  | || |    _| |_     | || |  _| |___/ |  | |
 * | |  |_______.'  | || |   |_____|    | || | |_________|  | |
 * | |              | || |              | || |              | |
 * | '--------------' || '--------------' || '--------------' |
 *  '----------------'  '----------------'  '----------------' 
 * 
 *            +-+-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+ +-+
 *            |S|c|r|i|p|t| |T|e|x|t| |E|d|i|t|o|r|
 *            +-+-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+ +-+
 * 
 * 
 * 
 * @name        STE
 * @copyright   Stefano Peris (c) 2017
 * @author      Stefano Peris
 * @email       lordstephen77@gmail.com
 * @github      https://github.com/LordStephen77/STE
 * @license     GPL-3.0 (https://www.gnu.org/licenses/gpl-3.0.en.html)
 * @create      dom 08 ott 2017 17:04:24 CEST
 * @update      lun 09 ott 2017 11:44:08 CEST
 * 
 */


package it.lordstephen77.ste;

import java.awt.*;

import javax.swing.*;

public class WinAbout extends JFrame {
	
	private static final long serialVersionUID = 1L;
		
		public WinAbout() {
			
			ImageIcon icon = new ImageIcon("res/ste_icon.png");
			
			JPanel panel = new JPanel();
			UIManager.put("OptionPane.minimumSize",new Dimension(600, 290));
	        panel.setBackground(new Color(227, 132, 170)); // RGB color
	        panel.setLayout(null);

	        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        JLabel title = new JLabel("STE");
	        title.setBounds(0, 0, 315, 64);
	        title.setFont(new Font("Arial", Font.BOLD, 18));
	        title.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(title, "push, align center");
	        
	        JLabel subtitle = new JLabel("Script Text Editor");
	        subtitle.setBounds(0, 20, 315, 64);
	        subtitle.setFont(new Font("Arial", Font.PLAIN, 12));
	        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(subtitle, "push, align center");
	        
	        JLabel copyright = new JLabel("By Stefano Peris (c) 2017");
	        copyright.setBounds(0, 40, 315, 64);
	        copyright.setFont(new Font("Arial", Font.PLAIN, 12));
	        copyright.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(copyright, "push, align center");
	        
	        JLabel note1 = new JLabel("This software is opensource.");
	        note1.setBounds(0, 80, 315, 64);
	        note1.setFont(new Font("Arial", Font.PLAIN, 11));
	        note1.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(note1);
	        
	        JLabel note2 = new JLabel("Licensed under GPL3.");
	        note2.setBounds(0, 100, 315, 64);
	        note2.setFont(new Font("Arial", Font.PLAIN, 11));
	        note2.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(note2);
	        
	        JLabel github = new JLabel("♥ Github ♥");
	        github.setBounds(0, 140, 315, 64);
	        github.setFont(new Font("Arial", Font.BOLD, 14));
	        github.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(github);
	        
	        JLabel link = new JLabel("https://github.com/LordStephen77/STE");
	        link.setBounds(0, 170, 315, 64);
	        link.setFont(new Font("Arial", Font.PLAIN, 11));
	        link.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(link);
	        
	        JOptionPane.showMessageDialog(null, panel, "About", JOptionPane.PLAIN_MESSAGE, icon);
	}
	
}


