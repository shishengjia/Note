package reviewjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 采用键值对方式进行存放 key->value
 * HashMap 无序存放，key不允许重复
 * Hashtree	 无序存放，key不允许重复
 * @author shi
 */
public class demo_map {

	public static void main(String[] args) {
		Map<String,String> info = new HashMap<String,String>();
		info.put("Mike", "123");
		info.put("Steve", "433");
		info.put("David", "564");
		info.put("Tom", "233");
		//获得所有键的集合
		Set<String> names = info.keySet();
//		Collection<String> number = info.values(); 获取所有值的集合
		//使用迭代器输出
		Iterator<String> iter = names.iterator();
		
		while(iter.hasNext()){
			//根据键找到值进行输出
			System.out.println(info.get(iter.next()));
		}
	}

}
