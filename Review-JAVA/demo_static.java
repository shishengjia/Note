package reviewjava;


/*
 * ʹ��static������ʱ��ֻ�ܷ���static���������Ժͷ���������static
 * ���������Ժͷ����ǲ��ܷ��ʵ�
 */
class People{
	private String name;
	private static String country = "China";//��̬����������ʵ����ͬ��ά��
	
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
		//��̬���Ի򷽷����������������
		People.country = country;
	}
	
	public void getInformation(){
		System.out.println("Name:"+getName()+"\n"+"Country:"+getCountry());
	}
	
}


public class demo_static {

	public static void main(String[] args) {
		//��̬��������ʵ����ִ��֮ǰ��ִ��
		//��̬���Ի򷽷����������������
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
