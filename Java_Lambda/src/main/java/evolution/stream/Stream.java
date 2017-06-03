package evolution.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Stream {
	public interface Consumer<T> {
		public void accept(T t);
	}
	
	public interface Function<T, V> {
		public V apply(T t);
	}
	
	public interface Predicate<T> {
		public boolean test(T t);
	}
	
	public <T> List<T> filter(List<T> ts, Predicate<T> predicate) {
		List<T> filteredTs = new LinkedList<>();
		for (T t : ts) {
			if (predicate.test(t)) {
				filteredTs.add(t);
			}
		}
		return filteredTs;
	}
	
	public <T, V> List<V> map(List<T> ts, Function<T, V> function) {
		List<V> mappedTs = new LinkedList<>();
		for (T t : ts) {
			mappedTs.add(function.apply(t));
		}
		return mappedTs;
	}
	
	public <T> void forEach(List<T> ts, Consumer<T> consumer) {
		for (T t : ts) {
			consumer.accept(t);
		}
	}
	
	@Test
	public void testFilter() {
		Stream stream = new Stream();
		List<Double> numbersGt4 = stream.filter(Arrays.asList(2.34, 3.14, 6.28, 10.27, 13.5), new Predicate<Double>() {
			@Override
			public boolean test(Double t) {
				return t > 4;
			}
		});
		List<Integer> intNumbers = stream.map(numbersGt4, new Function<Double, Integer>() {
			@Override
			public Integer apply(Double t) {
				return t.intValue();
			}
		});
		stream.forEach(intNumbers, new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
	}
}
