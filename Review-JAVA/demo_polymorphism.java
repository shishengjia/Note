package reviewjava;

/*
 * ����ת��: ������Զ����
 * 		����  ������� = ����ʵ��
 * ����ת��: ǿ������ת��
 * 		����  ������� = �����ࣩ����ʵ�� 
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

		// ����ת��
		A a = new B();
		a.tell_1();// tell_1����д������ø÷���
		a.tell_2();
		// B----tell_1
		// A----tell_2

		System.out.println("=========");

		// ����ת��
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
		// B----tell_1 ��������Ϊtell_1�������б���д�ˣ�����ִ���������еķ���
		// A----tell_1
	}

	// ��̬�ļ�Ӧ�ã��򻯴��룬���е����඼����ת�ͣ����ø���ķ���
	public static void say(A a) {
		a.tell_1();
	}

}
