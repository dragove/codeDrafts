package site.dragove;

import java.util.function.Function;

public class YCombinator {
    @FunctionalInterface
    public interface Func<T> extends Function<T, T> {
    }

    @FunctionalInterface
    private interface FuncToTFunc<T> extends Function<FuncToTFunc<T>, Func<T>> {
    }

    public static <T> Func<T> Y(final Func<Func<T>> f) {
        FuncToTFunc<T> g = t -> f.apply(x -> t.apply(t).apply(x));
        return g.apply(g);
    }

    public static void main(String[] args) {
        // 阶乘函数
        Func<Integer> factorial = Y(f -> n -> {
            if (n == 0)
                return 1;
            else
                return n * f.apply(n - 1);
        });
        // 计算斐波那契数列的第n项
        Func<Integer> fib = Y(f -> n -> {
            if (n < 2)
                return n;
            else
                return f.apply(n - 1) + f.apply(n - 2);
        });

        System.out.println(factorial.apply(10));
        System.out.println(fib.apply(9));
    }
}

