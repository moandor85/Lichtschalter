package de.moandor.lightswitch.userinterface;

import java.util.Scanner;

import de.moandor.lightswitch.logic.LightSwitch;
import de.moandor.lightswitch.logic.LightSwitchManager;
import de.moandor.lightswitch.properties.PropertyManager;
import de.moandor.lightswitch.properties.PropertyManagerImpl;

public class ConsoleImpl implements Console {

	@Override
	public void listen() {
		Scanner sc = new Scanner(System.in);
		
		LightSwitch ls = LightSwitchManager.getInstanceOf();
		
		PropertyManager propMan = new PropertyManagerImpl();
		ls.setAddress(propMan.getLocalSwitchIP());
	    //ls.setAddress("http://192.168.0.4/");
	    
	    ls.setUser("BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY");
	    
		while (true) {
			System.out.print(ConsoleCommands.ENTER_COMMAND);
		    String inputLN = sc.nextLine();
		    //Command for halt!
		    if(inputLN.equals(ConsoleCommands.EXIT)){
		    	break;
		    }
		    // Command for off
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_OFF)){
		    	ls.switchLightOff();
		    	System.out.println(ConsoleCommands.LIGHT_SWITCHED_OFF);
		    }
		    //Command for on 
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_ON)){
		    	ls.switchLightOn();
		    	System.out.println(ConsoleCommands.LIGHT_SWITCHED_ON);
		    }
		    else{
		    	System.out.println(ConsoleCommands.COMMAND_NOT_FOUND);
		    }
		}
		sc.close();
	}

}
