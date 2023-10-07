package vsys;

public abstract class Stream<A> {

    private static Stream EMPTY = new Empty();

    public abstract void forEach(Effect<A> ef);

    public abstract A head();

    public abstract Stream<A> tail();

    public abstract Boolean isEmpty();


    private static class Empty<A> extends Stream<A> {

        @Override
        public void forEach(Effect<A> ef) {
            // Do nothing
        }

        @Override
        public A head() {
            throw new IllegalStateException("head called on empty");
        }

        @Override
        public Stream<A> tail() {
            throw new IllegalStateException("tail called on empty");
        }

        @Override
        public Boolean isEmpty() {
            return true;
        }
    }

    private static class Cons<A> extends Stream<A> {

        private final Supplier<A> head;
        private A h;
        private final Supplier<Stream<A>> tail;
        private Stream<A> t;

        private Cons(Supplier<A> h, Supplier<Stream<A>> t) {
            head = h;
            tail = t;
        }

        @Override
        public void forEach(Effect<A> ef) {
            forEach(this, ef).eval();
        }

        @Override
        public A head() {
            return head.get();
        }

        @Override
        public Stream<A> tail() {
            return tail.get();
        }

        @Override
        public Boolean isEmpty() {
            return false;
        }

        private static <A> TailCall<Stream<A>> forEach(Stream<A> stream, Effect<A> ef) {
            return stream.isEmpty()
                    ? TailCall.ret(stream)
                    : TailCall.sus(() -> {
                ef.apply(stream.head());
                return forEach(stream.tail(), ef);
            });
        }
    }

    public static <A, S> Stream<A> unfold(S z, Function<S, Result<Tuple<A, S>>> f) {
        return f.apply(z).map(x -> cons(() -> x.fst, () -> unfold(x.snd, f))).getOrElse(empty());
    }

    static <A> Stream<A> cons(Supplier<A> hd, Supplier<Stream<A>> tl) {
        return new Cons<>(hd, tl);
    }

    public static <A> Stream<A> empty() {
        return EMPTY;
    }
}
