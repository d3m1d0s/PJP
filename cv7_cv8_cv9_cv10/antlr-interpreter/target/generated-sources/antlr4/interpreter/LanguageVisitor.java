// Generated from interpreter/Language.g4 by ANTLR 4.13.1
package interpreter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(LanguageParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(LanguageParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LanguageParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(LanguageParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LanguageParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(LanguageParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(LanguageParser.PrimitiveTypeContext ctx);
}