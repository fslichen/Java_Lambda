package evolution.predicate;

import java.util.function.Predicate;

import org.junit.Test;

public class AnotherClass {
	// Apply the following methods when using JDK 8 or above.
	// You don't need to specify the type of x in lambda expression because
	// the type parameter is already defined in the parameterized type Predicate<Integer>.
	public Predicate<Integer> predicate = x -> x % 2 == 0;
	
	@Test
	public void testPredicate() {
		AnotherClass anotherClass = new AnotherClass();
		boolean even = anotherClass.predicate.test(2);
		System.out.println(even);
	}
	
	public void run(int x, Predicate<Integer> predicate) {
		if (predicate.test(x)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
	
	@Test
	public void testRunPredicate() {
		AnotherClass anotherClass = new AnotherClass();
		anotherClass.run(6, new Predicate<Integer>() {// Verbose way of using predicate.
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});
		anotherClass.run(6, (Integer x) -> x % 2 == 0);// Concise way of using predicate. Note that predicate is a functional interaface with just one method, therefore the method name can be omitted.
		anotherClass.run(6, x -> x % 2 == 0);// Type parameter Integer can be omitted becauase it is already defined in the parameterized type Predicate<Integer>.
	}
}
