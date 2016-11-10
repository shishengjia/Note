package reviewjava;


/*
 * JAVA继承不支持多继承
 */
class Person{
	private int age;
	private String name;
	
	public Person(){
		System.out.println("construction method of Person");//父类的构造方法先于子类的构造方法执行
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
	
	public void tell(){ //重写父类的tell方法，子类对象调用tell方法执行自己的tell方法，
		super.tell();//调用父类的tell方法
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
