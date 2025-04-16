// Generated from interpreter/Language.g4 by ANTLR 4.13.1
package interpreter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaration}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaration}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(LanguageParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(LanguageParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(LanguageParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(LanguageParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(LanguageParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(LanguageParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LanguageParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LanguageParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(LanguageParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(LanguageParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(LanguageParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(LanguageParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(LanguageParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(LanguageParser.PrimitiveTypeContext ctx);
}