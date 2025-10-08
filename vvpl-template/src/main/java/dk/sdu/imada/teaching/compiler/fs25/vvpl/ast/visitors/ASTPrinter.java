package dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.visitors;

import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.Assignment;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.Binary;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.Identifier;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.Literal;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.LogicExpr;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr.Unary;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.Block;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.ExprStmt;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.IfStmt;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.PrintStmt;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.VarDecl;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.WhileStmt;

/**
 * @author Sandra K. Johansen and Sofie Løfberg
 * @version CompilerConstruction FT 2025
 */


/**
 * AST printer
 * we wanna print statement. 
 * for each expression we have print function
 * 
 * 
 * 
 */
 


public class ASTPrinter implements ExprVisitor<String>, StmtVisitor<String> 
{

  private int indent = 0;

  private String space()
  {
    return "  ".repeat(indent);
  }

  public String print(Stmt stmt) 
  {
    return "";
  }

  @Override
  public String visitExprStmt(ExprStmt Stmt) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitExprStmt'");
  }

  @Override
  public String visitIfStmt(IfStmt Stmt) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitIfStmt'");
  }

  @Override
  public String visitWhileStmt(WhileStmt Stmt) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitWhileStmt'");
  }

  @Override
  public String visitPrintStmt(PrintStmt Stmt) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitPrintStmt'");
  }

  @Override
  public String visitBlock(Block Stmt) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitBlock'");
  }

  @Override
  public String visitVarDecl(Stmt.VarDecl Stmt) 
  {
    String string = "VarDecl\n";
    indent++;
    string += space() + Stmt.id + "\n";
    string += space() + Stmt.type + "\n";
    string += space() + Stmt.expr.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitAssignment(Assignment expr) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitAssignment'");
  }

  @Override
  public String visitLogicExpr(LogicExpr expr) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitLogicExpr'");
  }

  @Override
  public String visitBinary(Binary expr) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitBinary'");
  }

  @Override
  public String visitUnary(Unary expr) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitUnary'");
  }

  @Override
  public String visitIdentifier(Identifier string) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitIdentifier'");
  }

  @Override
  public String visitLiteral(Literal expr) 
  {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitLiteral'");
  }
}
