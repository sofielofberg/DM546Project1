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
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt.WhileStmt;

/**
 * @author Sandra K. Johansen and Sofie Løfberg
 * @version CompilerConstruction FT 2025
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
    String string = "ExprStmt\n";
    indent++;
    string += space() + Stmt.expr.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitIfStmt(IfStmt Stmt) 
  {
    String string = "IfStmt\n";
    indent++;
    string += space() + Stmt.ifStmt.accept(this); //throw to correct handler
    string += space() + Stmt.elseStmt.accept(this);
    indent--;
    return string;
  }

  @Override
  public String visitWhileStmt(WhileStmt Stmt) 
  {
    String string = "WhileStmt\n";
    indent++;
    string += space() + Stmt.whileStmt.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitPrintStmt(PrintStmt Stmt) 
  {
    String string = "PrintStmt\n";
    indent++;
    string += space() + Stmt.expr.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitBlock(Block Stmt) 
  {
    String string = "BlockStmt\n";
    indent++;
    for (Stmt statement : Stmt.decls) // we wanna throw each decl to accept one at a time
    {
      string += space() + statement.accept(this); //throw to correct handler
    }
    indent--;
    return string;
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
    String string = "AssignExpr\n";
    indent++;
    string += space() + expr.expr.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitLogicExpr(LogicExpr expr) 
  {
    String string = "LogicalExpr\n";
    indent++;
    string += space() + expr.left.accept(this); //throw to correct handler
    string += space() + expr.operator.lexeme;
    string += space() + expr.right.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitBinary(Binary expr) 
  {
    String string = "BinaryExpr\n";
    indent++;
    string += space() + expr.left.accept(this); //throw to correct handler
    string += space() + expr.operator.lexeme;
    string += space() + expr.right.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitUnary(Unary expr) 
  {
    String string = "UnaryExpr\n";
    indent++;
    string += space() + expr.token.lexeme;
    string += space() + expr.expr.accept(this); //throw to correct handler
    indent--;
    return string;
  }

  @Override
  public String visitIdentifier(Identifier string) 
  {
    String strin = "VariableExpr\n";
    indent++;
    strin += space() + string.string;
    indent--;
    return strin;
  }

  @Override
  public String visitLiteral(Literal expr) 
  {
    String string = "LiteralExpr\n";
    indent++;
    string += space() + expr;
    indent--;
    return string;
  }
}
