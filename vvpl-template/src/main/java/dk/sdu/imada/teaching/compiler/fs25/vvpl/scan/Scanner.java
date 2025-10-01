package dk.sdu.imada.teaching.compiler.fs25.vvpl.scan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * partial / start author: Sandra Greiner
 * additional content:
 * @author Sofie Løfberg & Sandra Johansen
 * @version CompilerConstruction FT 2025
 */

public class Scanner 
{
    List<Token> scannedTokens =  new LinkedList<>();
    private final String inputString;

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        //Add stuff
    }


    // Scanning state
    private int start = 0;
    private int current = 0;
    private int line = 1;

    
    public Scanner(String inputString) 
    {
        this.inputString = inputString;
    }


    public List<Token> scanTokens() 
    {
        while (!isAtEnd()) {
            start = current;
            char c = advance();
            switch(c) {
                case '(':
                    addToken(TokenType.LEFT_PAREN);
                    break;
                case ')':
                    addToken(TokenType.RIGHT_PAREN);
                    break;
                case '{':
                    addToken(TokenType.LEFT_BRACE);
                    break;
                case '}':
                    addToken(TokenType.RIGHT_BRACE);
                    break;

                case ' ':
                case '\r':
                case '\t':
                    break;
                case '\n':
                    line++;
                    break;
                
                case '"':
                    string();
                    break;
                
                default: 
                    if (isDigit(c)) {
                        number();
                    } else if (isAlpha(c)) {
                        identifier();
                    } else {
                        //error handling
                    }
                    break;
            }
        }
        
        return scannedTokens;
    }
    
    
    private boolean match( char expected )
    {
        if( isAtEnd() )
        {
            return false;
        }
        if( inputString.charAt(current) != expected )
        {
            return false;
        }
        
        current++;
        return true;
    }


    private void number()
    {
        while( isDigit(peek() ))
        {
            advance();
        }

        // look for fractional
        if( peek() == '.' && isDigit( peekNext() ))
        {
            advance();

            while( isDigit(peek() ))
            {
                advance();
            }
        }

        addToken(TokenType.NUMBER, Double.parseDouble(inputString.substring(start,current)));
    }

    
    void identifier() 
    {
        while (isAlphaNumeric(peek())) 
        {
            advance();
        }

        String text = inputString.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) 
        {
            type = TokenType.IDENTIFIER;
        }

        addToken(type);
    }

    //////////////////////////////////////////////////////////////////////
    // Helper methods
    //////////////////////////////////////////////////////////////////////
    private void addToken(TokenType type) 
    {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) 
    {
        String text = inputString.substring(start, current);
        scannedTokens.add(new Token(type, text, literal, line));
    }
    
    private char advance() 
    {
        return inputString.charAt(current++);
    }

    private char peek() 
    {
        if (isAtEnd())
        {
            return '\0';
        }
        return inputString.charAt(current);
    }

    private boolean isAtEnd() 
    {
        return current >= inputString.length();
    }

    boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') |
            (c >= 'A' && c <= 'Z') |
            c == '_';
    }

    boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }
    
    // works but ugly
    private boolean isDigit(char c)
    {
        boolean bool = false;
        if( c >= '0' && c <= '9' )
        {
            bool = true;
        }
        else if( c == '-' && peek() >= '0' && peek() <= '9' )
        {
            bool = true;
        }

        return bool;
    }

    private char peekNext()
    {
        if( current + 1 >= inputString.length())
        {
            return '\0';
        }
        return inputString.charAt(current + 1);
    }
}
