package util;

/**
 * interface for function with three parameters and return void.
 *
 * @param <A> - First param.
 * @param <B> - Second param.
 * @param <C> - Third param.
 * @see java.util.function.Consumer
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {

    void accept(A a, B b, C c);

}