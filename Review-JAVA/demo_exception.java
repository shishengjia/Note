package reviewjava;

/**
 * ArrayIndexOutOfBoundsException
 * NumberFormatException
 * ArithmeticException
 * NullPointException
 * ...
 */

/**
 * 自定义异常类
 * @author shi
 */
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}

public class demo_exception {

	public static void calculate(int i, int j) throws ArithmeticException {
		int temp = 0;
		temp = i / j;
		System.out.println(temp);

	}

	public static void main(String[] args) {
		try {
			calculate(10, 0);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally { // 不管有没有异常，都会执行这一块
			System.out.println("exit");
		}
		
		
		
		try {
			throw new MyException("自定义异常");

		} catch (MyException e) {
			System.out.println(e);
		}
	}
}
