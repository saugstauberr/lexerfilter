package tokenreader;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import vsys.Function;
import vsys.Result;
import vsys.Tuple;

public class TokenReader implements Input<Token> {
    private final Lexer lexer;

    private TokenReader(Lexer lexer) {
        this.lexer = lexer;
    }

    public static Input<Token> tokenReader(Lexer lexer) {
        return new TokenReader(lexer);
    }

    public static Result<Input<Token>> lexFile(String filename, Function<CharStream, Lexer> lexer) {
        return  Result.of(() ->tokenReader(lexer.apply(CharStreams.fromFileName(filename))));
    }

    @Override
    public Result<Tuple<Token, Input<Token>>> read() {
        Token t = lexer.nextToken();
        return t.getType() == Token.EOF
                ? Result.
                empty()
                : Result.
                success(new Tuple<>(t, this));
    }

    @Override
    public void close() throws Exception {

    }
}