import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import tokenreader.Input;
import tokenreader.TokenReader;
import vsys.Result;
import grammar.Time;

import java.util.List;

public class FilterTime {

    public String GiveTime(String filePath) {
        String time = "TIMES HERE";

        Result<Input<Token>> rTokenReader;
        try {
            rTokenReader = TokenReader.
                    lexFile(filePath, Time::new);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        rTokenReader.forEach(rt -> rt.stream().forEach(t -> st.add("time", t)));
        return time;
    }
    public static void main(String[] args) {
        System.out.println("Main method working!");
    }
}
