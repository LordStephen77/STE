/*
 * STE (Script Text Editor)
 * Copyright (C) 2017 Stefano Peris
 * This file is distributed under the same license as the Script Text Editor package.
 */

package it.lordstephen77.ste;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.java.swing.plaf.windows.resources.windows_es;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextAreaEditorKit.*;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.ErrorStrip;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextAreaEditorKit;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

/*
 * @author Stefano Peris © 2017
 */
	public class Main extends JFrame implements ActionListener {
		
		/*
		 * Returns whether closing markup tags should be automatically completed.
		 * This method only returns true if getLanguageIsMarkup() also returns true.
		 */
		public boolean getCompleteMarkupCloseTags() {
			return rootPaneCheckingEnabled;
		}
		
		/*
		 * Returns whether the current programming language uses curly braces ('{' and '}')
		 * to denote code blocks.
		 */
		public boolean getCurlyBracesDenoteCodeBlocks() {
			return rootPaneCheckingEnabled;
		}
		
		/*
		 * Returns whether the current language is a markup language, such as HTML, XML or PHP.
		 */
		public boolean getLanguageIsMarkup() {
			return rootPaneCheckingEnabled;
		}
		
		/*
		 * This method returns whether auto indentation should be done if Enter is pressed
		 * at the end of the specified line.
		 */
		public boolean getShouldIndentNextLine(int line) {
			return rootPaneCheckingEnabled;
		}
	    
	private static final long serialVersionUID = 1L;
	   
	   private RSyntaxTextArea DefaultTextArea;

	   // Default text in the editor (features, changelog)
	   private static final String text = "STE (Script Text Editor)\n"
	         + "Copyright (C) 2017 Stefano Peris\n\n"
	         + "This software is distributed under the GNU 3.0 license\n"
	         + "A copy of the license is included in the source code.\n"
	         + "\n\n"
	         + "Script Text Editoris include syntax highlighting, code folding text component for Java Swing.\n"
	         + "It is fast and efficient, and can be used in any work that needs to edit or view source code.\n"
	         + "It extends JTextComponent so it integrates completely with the standard javax.swing.text package.\n\n"
	         + "Include the following features:\n\n"
	         + "------------------------\n"
	         + "-- Main features --\n"
	         + "------------------------\n\n"
	         + "* Coloring the code.\n"
	         + "* Auto indentation of the code.\n"
	         + "* Highlight the braces: (), [], {}.\n"
	         + "* Opens and closes the code folders.\n"
	         + "* Find and Replace function (Find Next, Find Previous, Regex, Match Case).\n"
	         + "* Other features in development.\n\n"
	         + "-----------------------------------------------------------------------\n"
	         + "-- Supports color coding of the following languages --\n"
	         + "-----------------------------------------------------------------------\n\n"
	         + "* C\n"
	         + "* C++\n"
	         + "* Java\n"
	         + "* C#\n"
	         + "* Python\n"
	         + "* Ruby\n"
	         + "* Lua\n"
	         + "* Perl\n"
	         + "* Groovy\n"
	         + "* Jsp\n"
	         + "* Tcl\n"
	         + "* Fortran\n"
	         + "* ActionScript\n"
	         + "* Html5\n"
	         + "* Css3\n"
	         + "* Javascript\n"
	         + "* Php\n"
	         + "* Dart\n"
	         + "* Xml\n"
	         + "* Json\n"
	         + "* Yaml\n"
	         + "* Latex\n";

	   // Search and Field components
	   private JTextField searchField;
	   private JCheckBox regexCB;
	   private JCheckBox matchCaseCB;
	   
	   public Main() {

	      JPanel jpanel = new JPanel(new BorderLayout());

	      DefaultTextArea = new RSyntaxTextArea(35, 60); // set window resolution
	      
	      // Recognition of languages
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE); // Simple text file (.txt)
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_RUBY);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_LUA);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PERL);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GROOVY);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CLOJURE);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_DELPHI);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_DTD);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTACCESS);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_LISP);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_MAKEFILE);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SCALA);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SAS);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NSIS);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_BBCODE);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSP);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_TCL);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_FORTRAN);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_DART);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_YAML);
	      DefaultTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_LATEX);
	      
	      DefaultTextArea.setText(text); // Displays the default text in the editor.
	      
	      DefaultTextArea.setCodeFoldingEnabled(true);
	      DefaultTextArea.setFont(new Font("Mono", Font.BOLD, 14)); // set a default font for the TextArea
	      RTextScrollPane scrollpane = new RTextScrollPane(DefaultTextArea);
	      jpanel.add(scrollpane);
		  
	      /*
	       * South position
	       * Create a toolbar with searching options (toolbar draggable).
	       */
	      JToolBar toolBarSouth = new JToolBar();
	      searchField = new JTextField(20);
	      toolBarSouth.add(searchField);
	      final JButton nextButton = new JButton("Find Next");
	      nextButton.setActionCommand("FindNext");
	      nextButton.addActionListener(this);
	      toolBarSouth.add(nextButton);
	      searchField.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            nextButton.doClick(0);
	         }
	         
	      });
	      
	      JButton prevButton = new JButton("Find Previous");
	      prevButton.setActionCommand("FindPrev");
	      prevButton.addActionListener(this);
	      toolBarSouth.add(prevButton);
	      regexCB = new JCheckBox("Regex");
	      toolBarSouth.add(regexCB);
	      matchCaseCB = new JCheckBox("Match Case");
	      toolBarSouth.add(matchCaseCB);
	      jpanel.add(toolBarSouth, BorderLayout.SOUTH);

	      setContentPane(jpanel);
	      setTitle("Script Text Editor");
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	   }

	   public void actionPerformed(ActionEvent e) {

	      // "FindNext" => search forward, "FindPrev" => search backward
	      String command = e.getActionCommand();
	      boolean forward = "FindNext".equals(command);

	      // Create an object defining our search parameters.
	      SearchContext context = new SearchContext();
	      String text = searchField.getText();
	      if (text.length() == 0) {
	         return;
	      }
	      
	      context.setSearchFor(text);
	      context.setMatchCase(matchCaseCB.isSelected());
	      context.setRegularExpression(regexCB.isSelected());
	      context.setSearchForward(forward);
	      context.setWholeWord(false);

	      boolean found = SearchEngine.find(DefaultTextArea, context).wasFound();
	      if (!found) {
	         JOptionPane.showMessageDialog(this, "Text not found");
	      }

	   }
	   
	   private HashMap<Object, Action> createActionTable(JTextComponent textComponent) {
	        HashMap<Object, Action> actions = new HashMap<Object, Action>();
	        Action[] actionsArray = textComponent.getActions();
	        for (int i = 0; i < actionsArray.length; i++) {
	            Action a = actionsArray[i];
	            actions.put(a.getValue(Action.NAME), a);
	        }
	        return actions;
	    }
	   
	   public static void main(String[] args) {
		   
	      // Start all Swing applications on the EDT.
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               String laf = UIManager.getSystemLookAndFeelClassName();
	               UIManager.setLookAndFeel(laf);
	            } catch (Exception e) { /* never happens */ }
	            Main findreplace = new Main();
	            findreplace.setVisible(true);
	            findreplace.DefaultTextArea.requestFocusInWindow();
	         }
	         
	      });
	      
	   }
	   
	}
	
      
