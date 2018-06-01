package HW3;
import java.util.*;

public class hw123 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many people are in your array? ");
		int n = sc.nextInt();

		String[] names = new String[n];
		int[] ages = new int[n];
		String[] profs = new String[n];

		for(int i = 0; i < names.length; i++) {
			System.out.println("Input name, age and profession of the person " + (i+1) + " :");
			names[i] = sc.next();
			ages[i] = sc.nextInt();
			profs[i] = sc.next().trim().toLowerCase();
		}
		sc.close();

		Person people = new Person(names, ages);
		people.printYounger25();

		Child ch1 = new Child(names, ages, profs);
		ch1.printYounger25();

		Person ch2 = new Child(names, ages, profs);
		ch2.printYounger25();
		
		Oceanographer o = new Oceanographer();
		o.checkSound(new Dolphin());
		o.checkSound(new Whale());
	}
}

class Person {

	private String[] Name;
	private int[] Age;
	public Person(String[] names, int[] ages) {
		Name = names;
		Age = ages;
	}

	public void printYounger25() {
		System.out.println("The names of the people whose age is less than 25 are:");
		for(int i = 0; i < Age.length; i++) {
			if(Age[i] < 25){
				System.out.println("Name: " + Name[i]);
				System.out.println("Age: " + Age[i] + "\n");
			}
		}
	}

	public String[] getName() {
		return Name;
	}

	public int[] getAge() {
		return Age;
	}
}


class Child extends Person {

	private String[] Profession;
	private String[] Name = getName(); //I could use "protected" for the Person's fields, so that Child subclass directly inherited them, but that would allow someone to modify them from the main
	private int[] Age = getAge(); //that is why I decided to do it like this

	public Child(String[] names, int[] ages, String[] profs) {
		super(names, ages);
		Profession = profs;
	}

	public void printYounger25() {
		System.out.println("The names of the programmers whose age is less than 25 are:");
		for(int i = 0; i < Age.length; i++) {
			if(Age[i] < 25 && Profession[i].equals("programmer")) {
				System.out.println("Name: " + Name[i]);
				System.out.println("Age: " + Age[i] + "\n");
			}
		}
	}
}

interface LivesInOcean {
	public void makeSound();
}

class Oceanographer {
	public void checkSound(LivesInOcean obj) {
		obj.makeSound();
	}
}

class Whale implements LivesInOcean{
	public void makeSound() {
		System.out.println("Whale sound: whoaaaaaa"); //I have no idea what they sound like lol
	}
}

class Dolphin implements LivesInOcean{
	public void makeSound() {
		System.out.println("Dolphin sound: prewprewprew");
	}
}