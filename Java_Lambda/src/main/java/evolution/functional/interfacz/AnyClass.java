package evolution.functional.interfacz;

public class AnyClass {
	// This is a functional interface.
	// A functional interface has only one method.
	// Therefore the method name could be omitted using lambda.
	public interface AnyInterface<T> {
		public T anyMethod(T t0, T t1);
	}
	
	public Object run(double x0, double x1, AnyInterface<Double> anyInterface) {
		return anyInterface.anyMethod(x0, x1);// anyMethod(..) has different behaviors.
	}
	
	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		Object result = anyClass.run(3.14, 6.28, new AnyInterface<Double>() {
			public Double anyMethod(Double t0, Double t1) {// Define plus behavior for anyMethod(..).
				return t0 + t1;
			}
		});
		System.out.println(result);
		result = anyClass.run(3.14, 6.28, new AnyInterface<Double>() {
			public Double anyMethod(Double t0, Double t1) {// Define times behavior for anyMethod(..).
				return t0 * t1;
			}
		});
		System.out.println(result);
		result = anyClass.run(3.14, 6.28, (Double x0, Double x1) -> x0 / x1);// The method name is omitted using lambda because there is only one method in the functional interface.
		System.out.println(result);
		result = anyClass.run(3.14, 6.28, (x0, x1) -> x0 / x1);// The type can also be omitted thanks to type parameter Double.
		System.out.println(result);
	}
}
