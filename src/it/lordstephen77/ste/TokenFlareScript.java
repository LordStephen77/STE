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
 * @create      dom 12 ott 2017 00:18:24 CEST
 * @update      none
 * 
 */


package it.lordstephen77.ste;

import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

public class TokenFlareScript {

	public TokenMap getWordsToHighlight() {
		
		   TokenMap flareScript = new TokenMap();
		  
		   flareScript.put("#", Token.COMMENT_KEYWORD);
		   
		   flareScript.put("case",  Token.RESERVED_WORD);
		   flareScript.put("for",   Token.RESERVED_WORD);
		   flareScript.put("if",    Token.RESERVED_WORD);
		   flareScript.put("while", Token.RESERVED_WORD);
		  
		   flareScript.put("printf", Token.FUNCTION);
		   flareScript.put("scanf",  Token.FUNCTION);
		   flareScript.put("fopen",  Token.FUNCTION);
		   
		   flareScript.put("int", Token.VARIABLE);
		   flareScript.put("string",  Token.VARIABLE);
		   flareScript.put("float",  Token.VARIABLE);
		   flareScript.put("boolean",  Token.VARIABLE);
		   
		   // other...
		   
		   return flareScript;
		}
}


