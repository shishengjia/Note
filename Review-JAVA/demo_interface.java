package reviewjava;

/*
 * �ӿڵ�ʵ�ֱ���ͨ�����࣬ʹ�ùؼ���implements���ӿڿ��Զ�ʵ��
 * һ���������ͬʱ�̳г�����ͽӿ�
 * һ���ӿڲ��ܼ̳�һ�������࣬������ͨ��extends�̳ж���ӿڣ�ʵ�ֽӿڵĶ�̳�
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

	// һ������ͬʱ�̳г�����ͽӿ�
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

	// �ӿڶ�̳�
	interface E extends A, B {

	}

	public static void main(String[] args) {

	}

}
