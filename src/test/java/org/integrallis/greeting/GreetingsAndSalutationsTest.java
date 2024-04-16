package org.integrallis.greeting;

import static org.integrallis.greeting.Person.Education.*;
import static org.integrallis.greeting.Person.Gender.*;
import static org.integrallis.greeting.Person.MaritalStatus.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.integrallis.drools.junit.BaseDroolsTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GreetingsAndSalutationsTest extends BaseDroolsTestCase {
	private Person person;
	private TimeOfDay timeOfDay;
	private String expectedGreeting;

	public GreetingsAndSalutationsTest(Person person, TimeOfDay timeOfDay, String expectedGreeting) { 
		super("ksession-rules");
		this.person = person;
		this.timeOfDay = timeOfDay;
		this.expectedGreeting = expectedGreeting;
	}
	
	@Test
	public void testGreetingsAndSalutations() {
		knowledgeSession.insert(person);
		knowledgeSession.insert(timeOfDay);
	
		knowledgeSession.fireAllRules();
		
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingsAndSalutations" );
		
		assertEquals("There should be only one greeting and salutation", 1, results.size());
		
		for ( QueryResultsRow row : results ) {
		    //TODO cast this appropriately ==> row.get( "greeting" );
			String greeting = "";
		    assertEquals(expectedGreeting, greeting);
		}		
	}
	
	@Parameters 
	public static List<Object[]> fooBar() {
		return Arrays.asList(new Object[][] {{ new Person("Stephen Falken", MALE, 48, SINGLE, PHD), new TimeOfDay(9, 0), "Good Morning, Dr. Stephen Falken" },
				                             { new Person("Richie Rich", MALE, 9, SINGLE, NONE), new TimeOfDay(13, 0), "Good Afternoon, Little Richie Rich" },
				                             { new Person("Maurice Moss", MALE, 32, SINGLE, COLLEGE), new TimeOfDay(23, 0), "Good Night, Mr. Maurice Moss" },
				                             { new Person("Jen Barber", FEMALE, 35, SINGLE, COLLEGE), new TimeOfDay(11, 0), "Good Morning, Ms. Jen Barber" },
				                             { new Person("Jennifer Katherine Mack", FEMALE, 48, MARRIED, COLLEGE), new TimeOfDay(15, 0), "Good Afternoon, Mrs. Jennifer Katherine Mack" },
				                             { new Person("Marie Curie", FEMALE, 45, MARRIED, PHD), new TimeOfDay(19, 0), "Good Evening, Dr. Marie Curie" }});
	}

}
