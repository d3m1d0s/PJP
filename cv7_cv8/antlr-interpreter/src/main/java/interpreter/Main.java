package interpreter;

import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    private static final String EXTENSION = "lang";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String[] files = (args.length == 0) ? new String[]{"test." + EXTENSION} : args;
        System.out.println("Dirbase: " + DIRBASE);

        for (String file : files) {
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            LanguageLexer lexer = new LanguageLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new VerboseListener());

            LanguageParser.ProgramContext tree = parser.program();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Aborted due to syntax errors.");
                return;
            }

            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
            typeChecker.visit(tree);

            if (typeChecker.hasErrors()) {
                typeChecker.printErrors();
                System.err.println("Aborted due to type errors.");
                return;
            }

            // INTERPRETER (won't work without removed class):
            // LanguageCustomVisitor executor = new LanguageCustomVisitor();
            // executor.visit(tree);

            System.out.println("FINISH: " + file);
        }
    }
}
