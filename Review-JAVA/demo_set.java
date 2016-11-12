package reviewjava;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口不能加入重复元素，但是可以排序
 * 常用子类:HashSet（不能排序,但不保证无序，可能有序） TreeSet（可排序）
 * @author shi
 *
 */
public class demo_set {

	public static void main(String[] args) {
		Set<String> names = new HashSet<String>();
		Set<String> names2 = new TreeSet<String>();
		
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		names.add("F");
		System.out.print(names);//[A, B, C, D, E, F],不保证无序
		
		names2.add("b");
		names2.add("c");
		names2.add("a");
		names2.add("d");
		System.out.print(names2);//[a, b, c, d]
	}

}
