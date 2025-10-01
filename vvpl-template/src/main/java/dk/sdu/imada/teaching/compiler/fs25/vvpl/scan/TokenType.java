package dk.sdu.imada.teaching.compiler.fs25.vvpl.scan;

/**
 * partial / start author: Sandra Greiner
 * further additions:
 * @author Sofie Løfberg & Sandra Johansen
 * @version CompilerConstruction FT 2025
 */

public enum TokenType 
{
    // Single-character tokens
    HASHTAG, //Comments
    RIGHT_PAREN,
    LEFT_PAREN,
    RIGHT_BRACE,
    LEFT_BRACE,
    SEMICOLON,


    //literals
    STRING, 
    NUMBER,  // specify negative number option
    BOOL,
    IDENTIFIER,

    //Operators
    SUBTRACT, // x minus y
    ADD,
    DIVIDE,
    MULTIPLY,
    
    // Keywords
    OR, //lowest precedence
    AND,
    NOT, //highest precedence, possibly char token
    NOT_EQUALS,
    EQUALS,
    GREATER,
    GREATER_EQUAL,
    LESS,
    LESS_EQUAL,
    TRUE,
    FALSE,
    HAS_TYPE,
    RETURN,
    VAR,
    IF,
    ELSE,
    PRINT,
    WHILE,
    CAST,
    
    ASSIGN,
    
    // End-of-file
    EOF
}
