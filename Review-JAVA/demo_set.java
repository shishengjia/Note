package reviewjava;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set�ӿڲ��ܼ����ظ�Ԫ�أ����ǿ�������
 * ��������:HashSet����������,������֤���򣬿������� TreeSet��������
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
		System.out.print(names);//[A, B, C, D, E, F],����֤����
		
		names2.add("b");
		names2.add("c");
		names2.add("a");
		names2.add("d");
		System.out.print(names2);//[a, b, c, d]
	}

}
