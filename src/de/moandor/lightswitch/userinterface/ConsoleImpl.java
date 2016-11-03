package de.moandor.lightswitch.userinterface;

import java.util.Scanner;

import de.moandor.lightswitch.logic.LightSwitch;
import de.moandor.lightswitch.logic.LightSwitchManager;

public class ConsoleImpl implements Console {

	@Override
	public void listen() {
		Scanner sc = new Scanner(System.in);
		
		LightSwitch ls = LightSwitchManager.getInstanceOf();
	    ls.setAddress("http://192.168.178.31/");
	    ls.setUser("BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY");
	    
		while (true) {
			System.out.print(ConsoleCommands.ENTER_COMMAND);
		    String inputLN = sc.nextLine();
		    
		    if(inputLN.equals(ConsoleCommands.EXIT)){
		    	break;
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_OFF)){
		    	ls.switchLightOff();
		    	System.out.println(ConsoleCommands.LIGHT_SWITCHED_ON);
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_OFF)){
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
