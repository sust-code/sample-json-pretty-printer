package src.fmt;

import javax.swing.SwingUtilities;
import java.awt.Color;

import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleConstants;
import javax.swing.text.Document;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.BadLocationException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import src.parse.JSONLexer;

public class Highlighter{
    public DefaultStyledDocument doc;
    
    // available styles
    public Style mainStyle;
    public Style keywordStyle;
    public Style stringStyle; 
    public Style integerStyle; 
    public Style floatStyle; 
    public Style curlyBraceStyle; 
    public Style squareBracketStyle; 

    public Highlighter( ) {
        StyleContext context = new StyleContext();
        doc = new DefaultStyledDocument(context);
        
        // Create and add the main document style
        Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
        mainStyle = context.addStyle("MainStyle", defaultStyle);
        StyleConstants.setFontFamily(mainStyle, "Consolas");
        StyleConstants.setForeground(mainStyle, Color.WHITE);
        StyleConstants.setFontSize(mainStyle, 12);

        keywordStyle = context.addStyle("Keyword", mainStyle);
        StyleConstants.setForeground(keywordStyle, new Color(4, 97, 247));
        StyleConstants.setBold(keywordStyle, true);

        stringStyle = context.addStyle("String", mainStyle);
        StyleConstants.setForeground(stringStyle, new Color(206, 145, 120));

        integerStyle = context.addStyle("Integer", mainStyle);
        StyleConstants.setForeground(integerStyle, new Color(247, 4, 227));

        floatStyle = context.addStyle("Float", mainStyle);
        StyleConstants.setForeground(floatStyle, new Color(21, 178, 26));

        curlyBraceStyle = context.addStyle("Curly Braces", mainStyle);
        StyleConstants.setForeground(curlyBraceStyle, Color.orange);
        
        squareBracketStyle = context.addStyle("Square Brackets", mainStyle);
        StyleConstants.setForeground(squareBracketStyle, new Color(78, 201, 176));
    }

    public Document apply(String text){

        // Prepare the lexer
        JSONLexer lexer = new JSONLexer(new ANTLRInputStream(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Get all tokens from lexer until EOF
        tokens.fill();

        try {
            // Set the logical style
            doc.setLogicalStyle(0, mainStyle);

            doc.insertString(0, text, null);
            
            for (Token tok : tokens.getTokens()) {
                int start = tok.getStartIndex();
                int len = tok.getText().length();
                Style style = null;
                int type = tok.getType();

                switch(type){
                    // {, }
                    case 1:
                    case 3:
                        style = curlyBraceStyle;
                        break;
                    
                    // [, ]
                    case 5:
                    case 6:
                        style = squareBracketStyle;
                        break;

                    // Keywords: true, false, null
                    case 7:
                    case 8:
                    case 9:
                        style = keywordStyle;
                        break;

                    // String
                    case 10:
                        style = stringStyle;
                        break;

                    // Number
                    case 11:
                        if(isInteger(tok.getText())){
                            // check if it's integer
                            style = integerStyle;
                        }else{
                            // ok, it's float
                            style = floatStyle;
                        }
                        break;

                    default:
                        style = mainStyle;
                }
                
                // Set the style
                doc.setCharacterAttributes(start,len, style, false);
            }
            
        }catch(BadLocationException ex){
            System.out.println("BadLocationException");
        }
        return doc;
    }

    private Boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}