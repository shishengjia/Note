package reviewjava;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList��Vectorʹ����ûʲô����
 * ��������ArrayList�����첽�������ܸߵ����̰߳�ȫ��Vector����ͬ���������ܵ͵��̰߳�ȫ
 * @author shi
 */

public class demo_ArrayList_Vector {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
//		List<String> names = new Vector<String>();
		//add
		names.add("a");
		names.add("b");
		names.add("c");
		for(int i = 0;i<names.size();i++)
			System.out.println(names.get(i));
				
		System.out.println("IsEmpty:"+names.isEmpty());//false
		System.out.println("Position of b"+names.indexOf("b"));//1
	}

}
