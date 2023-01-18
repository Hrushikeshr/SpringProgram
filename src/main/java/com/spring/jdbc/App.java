package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Project Started");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);

		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		
		char ch='n';
		do {
			System.out.println("Enter 1 for insert 2 for update and 3 for delete and 4 for get student data by id, 5 for get all student: ");
			int num = scanner.nextInt();
			switch (num) {
			case 1 -> {
				System.out.println("Enter the Id of the person: ");
				student.setId(scanner.nextInt());
				System.out.println("Enter the name of the person: ");
				student.setName(scanner.next());
				System.out.println("Enter the city of the person: ");
				student.setCity(scanner.next());
				result = studentDao.insert(student);
				System.out.println("Table Change: " + result);
			}
			case 2 -> {
				System.out.println("Enter the Id of the person: ");
				student.setId(scanner.nextInt());
				System.out.println("Enter the name of the person: ");
				student.setName(scanner.next());
				System.out.println("Enter the city of the person: ");
				student.setCity(scanner.next());
				result = studentDao.change(student);
				System.out.println("Table Change: " + result);
			}
			case 3 -> {
				System.out.println("Enter the Id of the person: ");
				result = studentDao.delete(scanner.nextInt());
				System.out.println("Table Change: " + result);
			}
			case 4 -> {
				System.out.println("Enter the Id of the person: ");
				Student nStudent = studentDao.getStudent(scanner.nextInt());
				System.out.println(nStudent);
			}
			case 5 -> {
				System.out.println("List Of Students...");
				List<Student> studentsList= studentDao.getAllStudents();
				for (Student student2 : studentsList) {
					System.out.println(student2);
				}
				
			}
		
			default -> System.out.println("Please Enter a Correct input");
			}

			
			System.out.println("Enter Y for continue: ");
			ch=scanner.next().trim().charAt(0);
		}while(ch=='y');
		scanner.close();
	}
}
