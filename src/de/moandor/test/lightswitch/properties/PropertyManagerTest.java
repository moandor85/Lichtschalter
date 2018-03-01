package de.moandor.test.lightswitch.properties;

import org.junit.Test;
import de.moandor.main.lightswitch.properties.PropertyManager;
import de.moandor.main.lightswitch.properties.PropertyManagerImpl;
import static org.junit.Assert.*;
import org.junit.Before;


public class PropertyManagerTest {
	
	PropertyManager propMan;

    @Before
    public void init() {
    	
    	propMan = new PropertyManagerImpl();
    }

    @Test
    public void positivIPTest() {
    	
    	String localSwIP = propMan.getLocalSwitchIP();
    	
    	assertTrue(localSwIP.matches("http://[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}/"));
    }
    
    @Test
    public void positivUserTest() {
    	
    	String user = propMan.getLightSwitchUser();
    	
    	assertNotNull(user);
    }


}
