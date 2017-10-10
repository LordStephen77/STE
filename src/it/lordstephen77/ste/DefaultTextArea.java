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

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class DefaultTextArea {

	public RSyntaxTextArea DefaultTextArea;

	   /*
	    * Default text in the editor (features, changelog)
	    */
	   public static final String text = "/*\n" // open multiline comment
	   		 + "STE (Script Text Editor)\n\n"
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
	         + "* D\n"
	         + "* Assembler x86"
	         + "* Java\n"
	         + "* C#\n"
	         + "* Unix Shell\n"
	         + "* Windows Batch\n"
	         + "* INI\n"
	         + "* Properties File\n"
	         + "* Makefile\n"
	         + "* Python\n"
	         + "* Ruby\n"
	         + "* Lua\n"
	         + "* Perl\n"
	         + "* Groovy\n"
	         + "* Scala\n"
	         + "* Clojure\n"
	         + "* SQL\n"
	         + "* Jsp\n"
	         + "* Tcl\n"
	         + "* Fortran\n"
	         + "* ActionScript\n"
	         + "* Html5\n"
	         + "* Css3\n"
	         + "* Javascript\n"
	         + "* Typescript\n"
	         + "* Php\n"
	         + "* Dart\n"
	         + "* Xml\n"
	         + "* Json\n"
	         + "* Yaml\n"
	         + "* Latex\n"
	         + "*/"; // closing multiline comment
}


