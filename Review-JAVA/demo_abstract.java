package reviewjava;

/*
 * ������:����һ�����󷽷�������ǳ�����* 
 * ���󷽷�:������δ��ʵ�ֵķ��������󷽷�����ʹ��abstract�ؼ�������
 * �����౻����̳У����ࣨ������ǳ����ࣩ������д�������е����г��󷽷�
 * �����಻��ֱ��ʵ������Ҫͨ�����������ʵ����
 * �ô�:��һ�����﹫�еĲ�������������ɳ����࣬ʣ��ÿ��������Ե��ص���������̳���ʵ��
 */

abstract class Worker {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void say();

}

class WorkerA extends Worker {
	// ���ࣨ������ǳ����ࣩ������д�������е����г��󷽷�
	@Override
	public void say() {
		System.out.println("Name:" + getName());
	}

}

public class demo_abstract {

	public static void main(String[] args) {

		// Worker w = new Worker();
		// abstract class can not be directly instantiated
		WorkerA wa = new WorkerA();// ͨ���������ʵ����
		wa.setName("SHI SHENGJIA");
		wa.say();
	}

}
