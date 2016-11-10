package reviewjava;


/*
 * 使用static方法的时候，只能访问static声明的属性和方法，而非static
 * 声明的属性和方法是不能访问的
 */
class People{
	private String name;
	private static String country = "China";//静态变量，所有实例共同来维护
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		//静态属性或方法最好用类名来调用
		People.country = country;
	}
	
	public void getInformation(){
		System.out.println("Name:"+getName()+"\n"+"Country:"+getCountry());
	}
	
}


public class demo_static {

	public static void main(String[] args) {
		//静态方法在类实例化执行之前被执行
		//静态属性或方法最好用类名来调用
		People.setCountry("Australia");
		
		People p1 = new People();
		p1.setName("one");
		p1.getInformation();
		
		People p2 = new People();
		p2.setName("two");
		p2.getInformation();
		
		People p3 = new People();
		p3.setName("three");
		p3.getInformation();
		
	}
}
