package reviewjava;


/*
 * instanceof 关键字判断一个对象到底是不是一个类的实例
 */
class A1 {

}

class B1 extends A1 {

}

public class demo_instanceof {

	public static void main(String[] args) {
		A1 a1 = new A1();
		System.out.println(a1 instanceof A1);//true
		System.out.println(a1 instanceof B1);//false
		
		A1 a2 = new B1();//向上转型
		System.out.println(a2 instanceof A1);//true
		System.out.println(a2 instanceof B1);//true
	}

}
