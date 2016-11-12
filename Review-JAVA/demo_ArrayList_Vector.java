package reviewjava;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList和Vector使用上没什么区别
 * 区别在于ArrayList采用异步处理性能高但非线程安全，Vector采用同步处理性能低但线程安全
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
