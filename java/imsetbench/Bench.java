//> using jvm 21
//> using jmh true
package imsetbench;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

/**
 * This piece of code is mainly copied from
 * http://minborgsjavapot.blogspot.com/2023/09/java-records-are-trusted-and.html
 * run it with scala --jmh .
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(value = 3)
public class Bench {
    private static final void foo(boolean x) {
	}

	private final static Set<Integer> hashSet = new HashSet<>();
	static {
		hashSet.add(2345);
		hashSet.add(123124134);
		hashSet.add(4012);
		hashSet.add(4823955);
		hashSet.add(4598423);
		hashSet.add(898349);
		hashSet.add(348904);
		hashSet.add(48659056);
		hashSet.add(384902384);
		hashSet.add(1978234342);
	}
	private final static Set<Integer> setOf = Set.of(2345, 123124134, 4012, 4823955, 4598423, 898349, 348904, 48659056,
			384902384, 1978234342);

	@Setup
	public void setup() {
	}

	@Benchmark
	public void hahset() {
        for (int i = 0; i < 10000; i++) {
			foo(hashSet.contains(i));
		}
	}

	@Benchmark
	public void setof() {
        for (int i = 0; i < 10000; i++) {
			foo(setOf.contains(i));
		}
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
