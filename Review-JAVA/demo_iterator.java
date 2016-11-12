package reviewjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 迭代输出时不能使用集合去删除元素
 * @author shi
 *
 */
public class demo_iterator {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("a");
		names.add("b");
		names.add("c");
		names.add("d");
		
		Iterator<String> iter = names.iterator();  
		while(iter.hasNext()){
			String str = iter.next();
			if(str.equals("c"))
				iter.remove(); //names.remove(0)这是禁止的
			else
				System.out.print(str+" ");//a b d 
		}
	}

}
