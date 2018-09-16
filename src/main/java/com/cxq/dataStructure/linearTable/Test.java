package com.cxq.dataStructure.linearTable;

public class Test {
	public static void main(String[] args) {
		/*Test test = new Test();
		test.inset();
		test.sum();
		//递归求和
		System.out.println("1+2+...+99+100=" + test.sum(100));
		*/
		
		
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
	}
	
	private int sum(int i){
		if(i == 1)
			return 1;
		return i + sum(i - 1);
	}
	
	private void sum(){
		int sum = 0;
		for(int i = 1; i <= 100; i ++){
			sum += i;
		}
		System.out.println("1+2+...+99+100=" + sum);
	}
	
	
	
	private void inset() {
		Student s = new Student();
		s.next = new Student("a");
		s.next.next = new Student("b");
		s.next.next.next = new Student("c");
		s.next.next.next.next = new Student("d");
		
		Student t = new Student();
		while(s != null){
			Student temp = new Student();
			System.out.print(s.name);

			//头插法插入
			temp.name = s.name;
			
			
			
			s = s.next;
		}
		System.out.println();
		
		
		
		
		
		
		while(t != null){
			System.out.print(t.name);
			t = t.next;
		}
		
		System.out.println("\nok");
	}
}
