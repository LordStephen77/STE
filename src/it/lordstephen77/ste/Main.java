/*
 * STE (Script Text Editor)
 * Copyright (C) 2017 Stefano Peris
 * This file is distributed under the same license as the Script Text Editor package.
 */

package it.lordstephen77.ste;

import it.lordstephen77.ste.DefaultTextArea;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class Main extends JFrame {
	
public Main() {

      JPanel jpanel = new JPanel(new BorderLayout());
      
      RSyntaxTextArea textArea = new RSyntaxTextArea(40, 60); // set window resolution
      
      /*
       * select default language:
       * 
       * C, CPLUSPLUS, CSHARP, PYTHON, LUA, RUBY, DART, FORTRAN, HTML, CSS, JAVASCRIPT, PHP
       * MAKEFILE, UNIX_SHELL, WINDOWS_BATCH, ASSEMBLER_X86, BBCODE, CLOJURE, D, DELPHI, DOCKERFILE, DTD
       * GROOVY, HOSTS, HTACCESS, INI, JSON, XML, YAML, LATEX, LISP, LESS, MXML, NSIS, PROPERTIES_FILE
       * SCALA, SAS, SQL, TCL, TYPESCRIPT, VISUAL_BASIC, NONE.
       * 
       * Warning: NONE is equivalent to a simple text file (.txt) does not apply any color to the code.
       */
      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
      
      textArea.setFont(new Font("default", Font.BOLD, 14)); // set a default font for the TextArea
      textArea.setCodeFoldingEnabled(true); // set codefolding
      textArea.setBracketMatchingEnabled(true); // set bracket matching
      textArea.setAutoIndentEnabled(true); // set autoindent
      textArea.setAntiAliasingEnabled(isEnabled()); // set antialiasing
      textArea.addMouseWheelListener(null); // set mousewheel zoom
      textArea.convertTabsToSpaces(); // convert tabs to spaces
      textArea.setTabSize(3);
		textArea.setCaretPosition(0);
		textArea.requestFocusInWindow();
		textArea.setMarkOccurrences(true);
		textArea.setCodeFoldingEnabled(true);
		textArea.setClearWhitespaceLinesEnabled(false);
		//textArea.setWhitespaceVisible(true);
		//textArea.setPaintMatchedBracketPair(true);
      RTextScrollPane rscrollpane = new RTextScrollPane(textArea);
      jpanel.add(rscrollpane);
      
      // Displays the default text in the editor (DefaultTextArea class).
      textArea.setText(DefaultTextArea.text);
      
      setContentPane(jpanel);
      setTitle("Script Text Editor"); // set title window
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
   }

   public static void main(String[] args) {
	   
      // Start all Swing applications on the EDT.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Main().setVisible(true);
         }
      });
   }
}
	
      
