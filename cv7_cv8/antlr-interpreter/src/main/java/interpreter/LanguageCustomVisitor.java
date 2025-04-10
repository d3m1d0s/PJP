package interpreter;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Integer> {

    @Override
    public Integer visitInt(LanguageParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText(), 10);
    }

    @Override
    public Integer visitOct(LanguageParser.OctContext ctx) {
        return Integer.parseInt(ctx.OCT().getText(), 8);
    }

    @Override
    public Integer visitHexa(LanguageParser.HexaContext ctx) {
        // remove "0x"
        return Integer.parseInt(ctx.HEXA().getText().substring(2), 16);
    }

    @Override
    public Integer visitPar(LanguageParser.ParContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitAdd(LanguageParser.AddContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getText().equals("+") ? left + right : left - right;
    }

    @Override
    public Integer visitMul(LanguageParser.MulContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getText().equals("*") ? left * right : left / right;
    }

    @Override
    public Integer visitProg(LanguageParser.ProgContext ctx) {
        for (LanguageParser.ExprContext expr : ctx.expr()) {
            System.out.println(visit(expr));
        }
        return 0;
    }
}
