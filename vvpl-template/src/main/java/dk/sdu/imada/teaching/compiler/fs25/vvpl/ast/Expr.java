package dk.sdu.imada.teaching.compiler.fs25.vvpl.ast;

import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.visitors.ExprVisitor;

/**
 * @author Sandra Greiner
 * @version CompilerConstruction FT 2025
 */
public abstract class Expr 
{
    public abstract <T> T accept(ExprVisitor<T> visitor);

    public static class Assignment extends Expr 
    {
        final Expr expr;
        
        Assignment(Expr expr) {
            this.expr = expr;
        }

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitAssignment(this);
        }
        
    }

    public static class LogicExpr extends Expr {
        //logicOr and logicAnd

        final Expr left;
        final Expr right;

        LogicExpr(Expr left, Expr right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitLogicExpr(this);
        }
        
    }

    public static class Binary extends Expr {
        //Equality, compr and term

        final Expr left;
        final Expr right;

        Binary(Expr left, Expr right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitBinary(this);
        }
        

    }

    public static class Unary extends Expr {

        final Expr expr;

        Unary(Expr expr) {
            this.expr = expr;
        }

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitUnary(this);
        }

    }

    public static class Literal extends Expr {

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitLiteral();
        }

    }

    public static class Identifier extends Expr {

        @Override
        public <T> T accept(ExprVisitor<T> visitor) {
            return visitor.visitIdentifier();
        }

    }
}
