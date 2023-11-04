package Task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as
	// coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T ele = iter.next();
			if (p.test(ele))
				iter.remove();
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T ele = iter.next();
			if (!p.test(ele)) iter.remove();
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> set = new HashSet<T>();
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T ele = iter.next();
			if (p.test(ele)) set.add(ele);
		}
		
		return set;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int cnt = 0 ;
		for (T ele: coll) {
			if (p.test(ele)) {
				return cnt;
			}
			++cnt;
		}
		return -1;
	}

	public static void run() {
		ArrayList<Integer> listInt = new ArrayList<>();
		ArrayList<Integer> listInt1 = new ArrayList<>();
		ArrayList<Integer> listInt2 = new ArrayList<>();
		ArrayList<Integer> listInt3 = new ArrayList<>();
		


		for (int i = 1; i <= 10; i++) {
			listInt.add(i);
			listInt1.add(i);
			listInt2.add(i);
			listInt3.add(i);
		}
		System.out.print("Remove những phần tử thỏa mãn Predicate: ");
		remove(listInt, new Even());
		System.out.println(listInt + "\n");
		
		System.out.print("In những phần tử thỏa mãn Predicate: ");
		retain(listInt2, new Even());
		System.out.println(listInt2 + "\n");
		
		System.out.print("In những phần tử duy nhất thỏa mãn Predicate: ");
		Set<Integer> set = collect(listInt3, new Even());
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
		
		System.out.println("\n");
		System.out.print("Index đầu tiên của phần tử thỏa mãn Predicate: ");
		System.out.println(find(listInt1, new Even()));
		System.out.println();

		
	}

	public static void main(String[] args) {
		run();
	}

}
