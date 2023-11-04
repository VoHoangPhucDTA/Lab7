package Task2;

public class Even implements Predicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return (i % 2 == 0);
	}
	
}
