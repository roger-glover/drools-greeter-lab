package org.integrallis.greeting;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class GreetingsExample {

    public static final void main(String[] args) {
    	KieSession kSession = null;
        try {
            // load up the knowledge base
        	    
        	// 1. - Get the KieServices singleton factory
	        KieServices ks = KieServices.Factory.get();
	        
	        // 2. - Get KieContainer from the KieServices factory
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	        
    	    // 3. - Build a new KieSession
            kSession = kContainer.newKieSession("ksession-rules");

            // 4. - Assert some Facts (Person/TimeOfDay objects)
            
            // 5. - Fire the Rules
            kSession.fireAllRules();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
