package tokenreader;

import vsys.Result;
import vsys.Stream;
import vsys.Tuple;

public interface Input<A> extends AutoCloseable {
    Result<Tuple<A, Input<A>>> read();

    default Stream<A> stream() {
        return Stream.<A, Input<A>>unfold(this, Input::read);
    }
}
