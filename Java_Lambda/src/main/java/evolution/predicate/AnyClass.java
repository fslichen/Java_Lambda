package evolution.predicate;

import java.util.function.Predicate;

public class AnyClass {
	Predicate<Integer> predicate = x -> x % 2 == 0;
	
	public Object run(int x, Predicate<Integer> predicate) {
		if (predicate.test(x)) {
			return x;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		boolean even = anyClass.predicate.test(2);
		System.out.println(even);
		Object result = anyClass.run(6, new Predicate<Integer>() {// Verbose way of using predicate.
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});
		System.out.println(result);
		result = anyClass.run(6, (Integer x) -> x % 2 == 0);// Concise way of using predicate. Note that predicate is a functional interaface with just one method, therefore the method name can be omitted.
		System.out.println(result);
		result = anyClass.run(6, x -> x % 2 == 0);// Type parameter Integer can be omitted becauase it is already defined in the parameterized type Predicate<Integer>.
		System.out.println(result);
	}
}
