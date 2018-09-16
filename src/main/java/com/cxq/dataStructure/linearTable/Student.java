package com.cxq.dataStructure.linearTable;

public class Student {

	public String name;
	public Student previous;
	public Student next;
	
	public Student() {
		super();
	}

	public Student(String name, Student previous, Student next) {
		super();
		this.name = name;
		this.previous = previous;
		this.next = next;
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public void add(String name){
	}
}
