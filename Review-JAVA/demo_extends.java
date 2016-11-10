package reviewjava;


/*
 * JAVA�̳в�֧�ֶ�̳�
 */
class Person{
	private int age;
	private String name;
	
	public Person(){
		System.out.println("construction method of Person");//����Ĺ��췽����������Ĺ��췽��ִ��
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void tell(){
		System.out.println("\ntell-person");
	}
}

class Student extends Person{
	private int score;
	
	public Student(){
		System.out.println("construction method of Student");
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void getInformation(){
		System.out.print("Name:"+getName()+"\n"+"Age:"+getAge()+"\n"+"Score:"+getScore());
	}
	
	public void tell(){ //��д�����tell����������������tell����ִ���Լ���tell������
		super.tell();//���ø����tell����
		System.out.println("tell-student");
	}
}

public class demo_extends {
	public static void main(String[] args) {
		Student s = new Student();
		s.setName("SHI SHENGJIA");
		s.setAge(22);
		s.setScore(100);
		s.getInformation();
		s.tell();
	}
}
