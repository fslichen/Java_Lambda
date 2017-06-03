package evolution.consumer;

import java.util.function.Consumer;

import org.junit.Test;

public class AnyClass {
	// You don't need to define (Double x) because the type parameter Double 
	// is already defined in the parameterized type Consumer<Double>.
	// A consumer accepts a value, and it does not have a return type.
	Consumer<Double> consumer = x -> System.out.println(x.doubleValue());

	@Test
	public void testConsumer() {
		AnyClass anyClass = new AnyClass();
		anyClass.consumer.accept(3.0);
	}
	
	public void run(double x, Consumer<Double> consumer) {
		consumer.accept(x);
	}
	
	@Test
	public void testRunConsumer() {
		AnyClass anyClass = new AnyClass();
		anyClass.run(3, new Consumer<Double>() {// Traditional Way
			@Override
			public void accept(Double x) {
				System.out.println(x * x);
			}
		});
		anyClass.run(3, x -> System.out.println(x * x * x));
	}
}
