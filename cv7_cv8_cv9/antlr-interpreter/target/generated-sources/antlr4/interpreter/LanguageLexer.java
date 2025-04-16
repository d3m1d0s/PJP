// Generated from interpreter/Language.g4 by ANTLR 4.13.1
package interpreter;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INT_KEYWORD=4, FLOAT_KEYWORD=5, SEMI=6, COMMA=7, 
		MUL=8, DIV=9, MOD=10, ADD=11, SUB=12, IDENTIFIER=13, FLOAT=14, INT=15, 
		WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "INT_KEYWORD", "FLOAT_KEYWORD", "SEMI", "COMMA", 
			"MUL", "DIV", "MOD", "ADD", "SUB", "IDENTIFIER", "FLOAT", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "'int'", "'float'", "';'", "','", "'*'", "'/'", 
			"'%'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INT_KEYWORD", "FLOAT_KEYWORD", "SEMI", "COMMA", 
			"MUL", "DIV", "MOD", "ADD", "SUB", "IDENTIFIER", "FLOAT", "INT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010[\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0004\fA\b\f\u000b\f\f\fB\u0001\r\u0004\rF\b\r\u000b\r\f\rG\u0001\r"+
		"\u0001\r\u0004\rL\b\r\u000b\r\f\rM\u0001\u000e\u0004\u000eQ\b\u000e\u000b"+
		"\u000e\f\u000eR\u0001\u000f\u0004\u000fV\b\u000f\u000b\u000f\f\u000fW"+
		"\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001"+
		"\u0000\u0003\u0002\u0000AZaz\u0001\u000009\u0003\u0000\t\n\r\r  _\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001"+
		"\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000"+
		"\u0000\u0007\'\u0001\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b"+
		"1\u0001\u0000\u0000\u0000\r3\u0001\u0000\u0000\u0000\u000f5\u0001\u0000"+
		"\u0000\u0000\u00117\u0001\u0000\u0000\u0000\u00139\u0001\u0000\u0000\u0000"+
		"\u0015;\u0001\u0000\u0000\u0000\u0017=\u0001\u0000\u0000\u0000\u0019@"+
		"\u0001\u0000\u0000\u0000\u001bE\u0001\u0000\u0000\u0000\u001dP\u0001\u0000"+
		"\u0000\u0000\u001fU\u0001\u0000\u0000\u0000!\"\u0005(\u0000\u0000\"\u0002"+
		"\u0001\u0000\u0000\u0000#$\u0005)\u0000\u0000$\u0004\u0001\u0000\u0000"+
		"\u0000%&\u0005=\u0000\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005i\u0000"+
		"\u0000()\u0005n\u0000\u0000)*\u0005t\u0000\u0000*\b\u0001\u0000\u0000"+
		"\u0000+,\u0005f\u0000\u0000,-\u0005l\u0000\u0000-.\u0005o\u0000\u0000"+
		"./\u0005a\u0000\u0000/0\u0005t\u0000\u00000\n\u0001\u0000\u0000\u0000"+
		"12\u0005;\u0000\u00002\f\u0001\u0000\u0000\u000034\u0005,\u0000\u0000"+
		"4\u000e\u0001\u0000\u0000\u000056\u0005*\u0000\u00006\u0010\u0001\u0000"+
		"\u0000\u000078\u0005/\u0000\u00008\u0012\u0001\u0000\u0000\u00009:\u0005"+
		"%\u0000\u0000:\u0014\u0001\u0000\u0000\u0000;<\u0005+\u0000\u0000<\u0016"+
		"\u0001\u0000\u0000\u0000=>\u0005-\u0000\u0000>\u0018\u0001\u0000\u0000"+
		"\u0000?A\u0007\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000C\u001a"+
		"\u0001\u0000\u0000\u0000DF\u0007\u0001\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0005.\u0000\u0000JL\u0007\u0001"+
		"\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u001c\u0001\u0000\u0000"+
		"\u0000OQ\u0007\u0001\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\u001e"+
		"\u0001\u0000\u0000\u0000TV\u0007\u0002\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006\u000f\u0000\u0000Z \u0001"+
		"\u0000\u0000\u0000\u0006\u0000BGMRW\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}