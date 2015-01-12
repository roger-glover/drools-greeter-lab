package org.integrallis.greeting;

import static org.integrallis.greeting.Person.Education.COLLEGE;
import static org.integrallis.greeting.Person.Gender.MALE;
import static org.integrallis.greeting.Person.MaritalStatus.SINGLE;

public class SpaghettiGreeter {
	
	public static void greet(Person person, TimeOfDay timeOfDay) {
		String greeting = "";
		if (timeOfDay.getHour() < 12) {
			greeting = "Good Morning";
		} else if ((timeOfDay.getHour() >= 12) && (timeOfDay.getHour() <= 17)) {
			greeting = "Good Afternoon";
	    } else if ((timeOfDay.getHour() >= 18) && (timeOfDay.getHour() <= 22)) {
	    	    greeting = "Good Evening";
	    } else {
	    	    greeting = "Good Night";
	    }
		
		String salutation = "";
		
		if (person.getEducation() == Person.Education.PHD) {
			salutation = "Dr.";
		}
		else if (person.getAge() > 10) {
			if (person.getGender() == Person.Gender.FEMALE) {
				if (person.getMaritalStatus() == Person.MaritalStatus.MARRIED) {
					salutation = "Mrs.";
				} else if (person.getMaritalStatus() == Person.MaritalStatus.SINGLE) {
					salutation = "Ms.";
				}
			} else if (person.getGender() == Person.Gender.MALE) {
				salutation = "Mr.";
			}
		} else {
			salutation = "Little";
		}
		
		System.out.println(greeting + " " + salutation + " " + person.getName());
	}
	
	public static void main(String[] args) {
		Person mauriceMoss = new Person("Maurice Moss", MALE, 32, SINGLE, COLLEGE);
		TimeOfDay nineAm = new TimeOfDay(9, 0);
		
		greet(mauriceMoss, nineAm);
	}

}
