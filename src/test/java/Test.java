import grammar.test.GraphicsLexer;
import grammar.test.GraphicsParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import vsys.Function;
import vsys.Result;

public class Test {
    public static void main(String[] args) throws Exception {
        CharStream input = null;
        // Pick an input stream (filename from commandline or stdin)
        if ( args.length>0 ) input = new ANTLRFileStream(args[0]);
        else input = new ANTLRInputStream(System.in);
        // Create the lexer
        GraphicsLexer lex = new GraphicsLexer(input);
        // Create a buffer of tokens between lexer and parser
        CommonTokenStream tokens = new CommonTokenStream(lex);
        // Create the parser, attaching it to the token buffer
        GraphicsParser p = new GraphicsParser(tokens);
        p.file(); // launch parser at rule file
    }
}
