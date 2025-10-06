package dk.sdu.imada.teaching.compiler.fs25.vvpl.ast;

import java.util.List;

import dk.sdu.imada.teaching.compiler.fs25.vvpl.ast.visitors.StmtVisitor;

/**
 * @author Sandra Greiner
 * @version CompilerConstruction FT 2025
 */

public abstract class Stmt {
    public abstract <T> T accept(StmtVisitor<T> visitor);

    static class ExprStmt extends Stmt 
    {
        final Expr expr;

        ExprStmt(Expr expr) 
        {
            this.expr = expr;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }
    }

    static class IfStmt extends Stmt 
    {
        final Expr guard;
        final Stmt ifStmt;
        final Stmt elseStmt;
        

        IfStmt(Expr guard, Stmt ifStmt, Stmt elseStmt) 
        {
            this.guard = guard;
            this.ifStmt = ifStmt;
            this.elseStmt = elseStmt;
        }


        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }

    }

    static class WhileStmt extends Stmt 
    {
        final Expr guard;
        final Stmt whileStmt;

        WhileStmt(Expr guard, Stmt whileStmt)
        {
            this.guard = guard;
            this.whileStmt = whileStmt;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }

    }

    static class PrintStmt extends Stmt 
    {
        final Expr expr;

        PrintStmt(Expr expr) 
        {
            this.expr = expr;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }

    }

    static class ReturnStmt extends Stmt 
    {
        final Expr expr;

        ReturnStmt(Expr expr)
        {
            this.expr = expr;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }

    }

    static class Block extends Stmt 
    {
        final List<Stmt> decls;

        Block(List<Stmt> decls)
        {
            this.decls = decls;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }
    }

    static class VarDecl extends Stmt 
    {
        final Expr expr;
        
        VarDecl(Expr expr) 
        {
            this.expr = expr;
        }

        @Override
        public <T> T accept(StmtVisitor<T> visitor) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'accept'");
        }
    }
}