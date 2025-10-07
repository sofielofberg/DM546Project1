package dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.visitors;
import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Stmt;

/**
 * @author Sandra Greiner
 * @version CompilerConstruction FT 2025
 */

public interface StmtVisitor<T> {
    T visitExprStmt(Stmt.ExprStmt Stmt);
    T visitIfStmt(Stmt.IfStmt Stmt);
    T visitWhileStmt(Stmt.WhileStmt Stmt);
    T visitPrintStmt(Stmt.PrintStmt Stmt);
    T visitReturnStmt(Stmt.ReturnStmt Stmt);
    T visitBlock(Stmt.Block Stmt);
    T visitVarDecl(Stmt.VarDecl Stmt);
}