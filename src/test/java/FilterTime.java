import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import tokenreader.Input;
import tokenreader.TokenReader;
import vsys.Function;
import vsys.Result;
import grammar.Time;
import vsys.Stream;

import java.io.IOException;
import java.util.List;


public class FilterTime {

    public String GiveTime(String filePath) throws IOException {
        String time = "TIMES HERE";

        Time lexer = new Time(CharStreams.fromFileName(filePath));

        return lexer.getAllTokens().;
    }

    public static  tokenReader() {

    }

    public static void main(String[] args) {
        System.out.println("Main method working!");
    }
}
