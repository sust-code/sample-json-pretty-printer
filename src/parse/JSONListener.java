package src.parse;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSONParser}.
 */
public interface JSONListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSONParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(JSONParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(JSONParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullObject}
	 * labeled alternative in {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void enterFullObject(JSONParser.FullObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullObject}
	 * labeled alternative in {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void exitFullObject(JSONParser.FullObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyObject}
	 * labeled alternative in {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void enterEmptyObject(JSONParser.EmptyObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyObject}
	 * labeled alternative in {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void exitEmptyObject(JSONParser.EmptyObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JSONParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JSONParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullArray}
	 * labeled alternative in {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void enterFullArray(JSONParser.FullArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullArray}
	 * labeled alternative in {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void exitFullArray(JSONParser.FullArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyArray}
	 * labeled alternative in {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(JSONParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyArray}
	 * labeled alternative in {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(JSONParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plain}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterPlain(JSONParser.PlainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plain}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitPlain(JSONParser.PlainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueObject}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueObject(JSONParser.ValueObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueObject}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueObject(JSONParser.ValueObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueArray}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueArray(JSONParser.ValueArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueArray}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueArray(JSONParser.ValueArrayContext ctx);
}