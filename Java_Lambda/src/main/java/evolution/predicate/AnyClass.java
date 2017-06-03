package evolution.predicate;

import org.junit.Test;

public class AnyClass {
	// You can apply the following methods when JDK 8 or above is unavailable.
	public interface MockPredicate<T> {
		public boolean test(T t);
	}
	
	// MockPredicate is allowed to have different implementations.
	public void runMockPredicate(int x, MockPredicate<Integer> mockPredicate) {
		if (mockPredicate.test(x)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
	
	@Test// An example of polymorphism in Java.
	public void testMockPredicate() {
		AnyClass AnyClass = new AnyClass();
		AnyClass.runMockPredicate(3, new MockPredicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		});
		// Define an anonymous class.
		MockPredicate<Integer> mockPredicate = new MockPredicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 3 == 0;
			}
		};
		AnyClass.runMockPredicate(3, mockPredicate);
	}
}
