package org.dmc.jmh;

import org.dmc.algos.NumberConverter;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 2, time = 10)
@Measurement(iterations = 5, time = 10)
@Fork(3)
public class NumberConverterBenchmark {

    @Benchmark
    public void defaultConverter() {
        NumberConverter.toWords(Integer.MAX_VALUE);
    }
}
