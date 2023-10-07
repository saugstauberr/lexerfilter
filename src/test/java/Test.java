import grammar.test.GraphicsLexer;
import grammar.test.GraphicsParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import vsys.Function;
import vsys.Result;

public class Test {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        CharStream inputStream = CharStreams.fromString(input.toString());
        GraphicsLexer lex = new GraphicsLexer(inputStream);

        // Create a buffer of tokens between lexer and parser
        TokenStream tokens = new TokenStream();
        // Create the parser, attaching it to the token buffer
        GraphicsParser p = new GraphicsParser(tokens);
        p.file(); // launch parser at rule file
    }
}
