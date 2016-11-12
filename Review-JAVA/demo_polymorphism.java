package reviewjava;

/*
 * 向上转型: 程序会自动完成
 * 		父类  父类对象 = 子类实例
 * 向下转型: 强制类型转换
 * 		子类  子类对象 = （子类）父类实例 
 */
class A {
	public void tell_1() {
		System.out.println("A----tell_1");
	}

	public void tell_2() {
		System.out.println("A----tell_2");
	}
}

class B extends A {
	public void tell_1() {
		System.out.println("B----tell_1");
	}

	public void tell_3() {
		System.out.println("B----tell_3");
	}
}

class C extends A {
	public void tell_4() {
		System.out.println("C----tell_4");
	}
}

public class demo_polymorphism {

	public static void main(String[] args) {

		// 向上转型
		A a = new B();
		a.tell_1();// tell_1被重写，则调用该方法
		a.tell_2();
		// B----tell_1
		// A----tell_2

		System.out.println("=========");

		// 向下转型
		A a1 = new B();
		B b = (B) a1;
		b.tell_1();
		b.tell_2();
		b.tell_3();
		// B----tell_1
		// A----tell_2
		// B----tell_3

		System.out.println("=========");

		say(new B());
		say(new C());
		// B----tell_1 这里是因为tell_1在子类中被重写了，所以执行了子类中的方法
		// A----tell_1
	}

	// 多态的简单应用，简化代码，所有的子类都向上转型，调用父类的方法
	public static void say(A a) {
		a.tell_1();
	}

}
