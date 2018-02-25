package de.moandor.test.lightswitch.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import de.moandor.main.lightswitch.logic.LightSwitch;
import de.moandor.main.lightswitch.logic.LightSwitchManager;

public class LightSwitchManagerTest {
	
	LightSwitch lightSwitch; 
	
	@Test
	public void getInstanceOfTest (){
		
		lightSwitch = null;
		
		lightSwitch = LightSwitchManager.getInstanceOf();
		
		assertNotNull(lightSwitch);
		
	}

}
