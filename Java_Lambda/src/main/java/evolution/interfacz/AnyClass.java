package evolution.interfacz;

public class AnyClass {
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
	}
}
