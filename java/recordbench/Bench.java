//> using jvm 21
//> using jmh true
package recordbench;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

/**
 * This piece of code is mainly copied from http://minborgsjavapot.blogspot.com/2023/09/java-records-are-trusted-and.html
 * run it with scala --jmh .
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(value = 3)
public class Bench {

	private static final RegularPoint REGULAR_ORIGIN = new RegularPoint(0, 0);
	private static final FinalPoint FINAL_ORIGIN = new FinalPoint(0, 0);
	private static final RecordPoint RECORD_ORIGIN = new RecordPoint(0, 0);
	private static final IntConsumer bh = i -> {
	};

	private List<RegularPoint> regularPoints;
	private List<FinalPoint> finalPoints;
	private List<RecordPoint> recordPoints;

	@Setup
	public void setup() {
		regularPoints = IntStream.range(0, 16).mapToObj(i -> new RegularPoint(i, i)).toList();
		recordPoints = IntStream.range(0, 16).mapToObj(i -> new RecordPoint(i, i)).toList();
		finalPoints = IntStream.range(0, 16).mapToObj(i -> new FinalPoint(i, i)).toList();
	}

	@Benchmark
	public void regular() {
		for (RegularPoint point : regularPoints) {
			if (point.x() == REGULAR_ORIGIN.x() && point.y() == REGULAR_ORIGIN.y()) {
				bh.accept(1);
			} else {
				bh.accept(0);
			}
		}
	}

	@Benchmark
	public void finalPoint() {
		for (FinalPoint point : finalPoints) {
			if (point.x() == FINAL_ORIGIN.x() && point.y() == FINAL_ORIGIN.y()) {
				bh.accept(1);
			} else {
				bh.accept(0);
			}
		}
	}

	@Benchmark
	public void record() {
		for (RecordPoint point : recordPoints) {
			if (point.x() == RECORD_ORIGIN.x() && point.y() == RECORD_ORIGIN.y()) {
				bh.accept(1);
			} else {
				bh.accept(0);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
