package studentexample;

public class MainClass {
	
	public static void main(String[] args) {
		
		Student std1 =new Student(1,"ravi",15);
		Student std2 = new Student();
		std2.setId(2);
		std2.setName("sanjay");
		std2.setAge(18);
		
		
		System.out.println(std1);
		System.out.println(std2);
		
		
		
	}

}
