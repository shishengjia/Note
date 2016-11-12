package reviewjava;

/*
 * 接口的实现必须通过子类，使用关键字implements，接口可以多实现
 * 一个子类可以同时继承抽象类和接口
 * 一个接口不能继承一个抽象类，但可以通过extends继承多个接口，实现接口的多继承
 */
public class demo_interface {

	interface A {
		public abstract void show_1();
	}

	interface B {
		public abstract void show_2();
	}

	abstract class C {
		public abstract void show_3();
	}

	// 一个子类同时继承抽象类和接口
	class D extends C implements A, B {

		@Override
		public void show_1() {
		}

		@Override
		public void show_2() {
		}

		@Override
		public void show_3() {
		}

	}

	// 接口多继承
	interface E extends A, B {

	}

	public static void main(String[] args) {

	}

}
