package reviewjava;

//����ָ��������ͣ�һ��2�����ڱȽϺ���
class Point<T> {
	private T x;
	private T y;

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	public void getInfo() {
		System.out.println("X:" + getX() + " Y:" + getY());
	}

}

public class demo_generic {

	public static void main(String[] args) {
		
		Point<Integer> p1 = new Point<Integer>();
		p1.setX(6);
		p1.setY(8);
		p1.getInfo();
		
		Point<Double> p2 = new Point<Double>();
		p2.setX(6.50);
		p2.setY(8.50);
		p2.getInfo();
		
		String[] arr_1 = { "hello", "world", "happy" };
		print(arr_1);

		Integer[] arr_2 = { 1, 2, 3, 4 };
		print(arr_2);
	}

	// ��������
	public static <T> void print(T arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

}
