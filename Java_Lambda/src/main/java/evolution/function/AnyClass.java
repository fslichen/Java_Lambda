package evolution.function;

import java.util.function.Function;

import org.junit.Test;

public class AnyClass {
	// Define a function that turns double into int.
	// A function accepts one argument and return one value.
	Function<Double, Integer> function = x -> x.intValue();
	
	@Test
	public void testFunction() {
		int result = this.function.apply(3.14);
		System.out.println(result);
	}

	public <T, V> void run(T t, Function<T, V> function) {
		V v = function.apply(t);
		System.out.println(v);
	}
	
	@Test
	public void testRunFunction() {
		// The type inference algorithm can tell that T is Double and V is Integer.
		// Therefore the method signature becomes run(Double t, Function<Double, Integer> function).
		// And once again you don't need to define (Double x) because 
		// the type argument Double is already defined in the parameterized type Function<Double, Integer>.
		run(3.0, x -> x.intValue());
		this.<Double, Integer>run(3.0, new Function<Double, Integer>() {// Traditional Way with explicit type inference.
			@Override
			public Integer apply(Double t) {
				return 2 * t.intValue();
			}
		});
		run(3.0, new Function<Double, Integer>() {// Traditional Way with implicit type inference.
			@Override
			public Integer apply(Double t) {
				return 2 * t.intValue();
			}
		});
	}
}
