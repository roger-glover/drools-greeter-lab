package org.integrallis.greeting;

import static org.integrallis.greeting.Person.Education.*;
import static org.integrallis.greeting.Person.Gender.*;
import static org.integrallis.greeting.Person.MaritalStatus.*;
import static org.junit.Assert.*;

import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.integrallis.drools.junit.BaseDroolsTestCase;
import org.junit.Test;

public class SimpleGreetingAndSalutationsTest extends BaseDroolsTestCase {

	public SimpleGreetingAndSalutationsTest() {
		super("ksession-rules");
	}

	@Test
	public void testGreetingForMorningTimes() {
		TimeOfDay nineAm = new TimeOfDay(9, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(nineAm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Morning", "Good Morning", greeting.getGreeting());
		}
	}
	
	@Test
	public void testGreetingForAfterNoonTimes() {
		TimeOfDay onePm = new TimeOfDay(13, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(onePm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Afternoon", "Good Afternoon", greeting.getGreeting());
		}
	}	
	
	@Test
	public void testGreetingForEveningTimes() {
		TimeOfDay sevenPm = new TimeOfDay(19, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(sevenPm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Evening", "Good Evening", greeting.getGreeting());
		}
	}
	
	@Test
	public void testGreetingForNightTimes() {
		TimeOfDay elevenPm = new TimeOfDay(23, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(elevenPm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Night", "Good Night", greeting.getGreeting());
		}
	}
}