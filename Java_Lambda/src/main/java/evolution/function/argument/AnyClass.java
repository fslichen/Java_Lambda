package evolution.function.argument;

import org.junit.Test;

public class AnyClass {
	public interface Calculator<T> {
		public T calculate(T t0, T t1);
	}
	
	// A method or function is plugged in as a parameter, just like what you did in js.
	public Double run(double x, double y, Calculator<Double> calculator) {
		double result = calculator.calculate(x, y);
		System.out.println(result);
		return result;
	}
	
	@Test
	public void testRunCalculator() {
		// Use lambda expression when using JDK 8 or above.
		Calculator<Double> plus = (x, y) -> x + y;
		Calculator<Double> minus = (x, y) -> x - y;
		Calculator<Double> times = (x, y) -> x * y;
		Calculator<Double> divide = (x, y) -> x / y;
		// Use traditional anonymous class when using JDK 7 or eariler versions.
		Calculator<Double> verbosePlus = new Calculator<Double>() {
			@Override
			public Double calculate(Double t0, Double t1) {
				return t0 + t1;
			}
		};
		Calculator<Double> verboseMinus = new Calculator<Double>() {
			@Override
			public Double calculate(Double t0, Double t1) {
				return t0 - t1;
			}
		};
		Calculator<Double> verboseTimes = new Calculator<Double>() {
			@Override
			public Double calculate(Double t0, Double t1) {
				return t0 * t1;
			}
		};
		Calculator<Double> verboseDivide = new Calculator<Double>() {
			@Override
			public Double calculate(Double t0, Double t1) {
				return t0 / t1;
			}
		};
		AnyClass anyClass = new AnyClass();
		anyClass.run(3, 4, plus);
		anyClass.run(3, 4, minus);
		anyClass.run(3, 4, times);
		anyClass.run(3, 4, divide);
		anyClass.run(3, 4, verbosePlus);
		anyClass.run(3, 4, verboseMinus);
		anyClass.run(3, 4, verboseTimes);
		anyClass.run(3, 4, verboseDivide);
	}
}
