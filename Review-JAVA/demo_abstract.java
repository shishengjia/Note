package reviewjava;

/*
 * 抽象类:包含一个抽象方法的类就是抽象类* 
 * 抽象方法:声明而未被实现的方法，抽象方法必须使用abstract关键字声明
 * 抽象类被子类继承，子类（如果不是抽象类）必须重写抽象类中的所有抽象方法
 * 抽象类不能直接实例化，要通过其子类进行实例化
 * 好处:把一类事物公有的部分提出来，作成抽象类，剩下每个事物各自的特点则有子类继承来实现
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
	// 子类（如果不是抽象类）必须重写抽象类中的所有抽象方法
	@Override
	public void say() {
		System.out.println("Name:" + getName());
	}

}

public class demo_abstract {

	public static void main(String[] args) {

		// Worker w = new Worker();
		// abstract class can not be directly instantiated
		WorkerA wa = new WorkerA();// 通过子类进行实例化
		wa.setName("SHI SHENGJIA");
		wa.say();
	}

}
