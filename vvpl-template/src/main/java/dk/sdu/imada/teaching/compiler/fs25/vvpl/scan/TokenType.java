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
    MINUS,

    //literals
    STRING, 
    NUMBER,  // specify negative number option
    IDENTIFIER,

    //Types
    STRING_TYPE,
    NUMBER_TYPE,
    BOOL_TYPE,

    //Operators
    SUB, // x minus y
    PLUS,
    DIV,
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
    TYPE_DEF,
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
