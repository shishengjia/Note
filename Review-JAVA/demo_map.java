package reviewjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ���ü�ֵ�Է�ʽ���д�� key->value
 * HashMap �����ţ�key�������ظ�
 * Hashtree	 �����ţ�key�������ظ�
 * @author shi
 */
public class demo_map {

	public static void main(String[] args) {
		Map<String,String> info = new HashMap<String,String>();
		info.put("Mike", "123");
		info.put("Steve", "433");
		info.put("David", "564");
		info.put("Tom", "233");
		//������м��ļ���
		Set<String> names = info.keySet();
//		Collection<String> number = info.values(); ��ȡ����ֵ�ļ���
		//ʹ�õ��������
		Iterator<String> iter = names.iterator();
		
		while(iter.hasNext()){
			//���ݼ��ҵ�ֵ�������
			System.out.println(info.get(iter.next()));
		}
	}

}
