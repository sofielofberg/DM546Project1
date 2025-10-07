package dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.visitors;

import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.Expr;

/**
 * @author Sandra Greiner
 * @version CompilerConstruction FT 2025
 */

public interface ExprVisitor<T> {
    T visitAssignment(Expr.Assignment expr);
    T visitLogicExpr(Expr.LogicExpr expr);
    T visitBinary(Expr.Binary expr);
 
}