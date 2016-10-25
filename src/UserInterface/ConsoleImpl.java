package UserInterface;

import java.util.Scanner;

import lichtschalterlogic.Lichtschalter;
import lichtschalterlogic.LichtschalterImpl;

public class ConsoleImpl implements Console {

	@Override
	public void listen() {
		Scanner sc = new Scanner(System.in);
	    
		while (true) {
			System.out.print(ConsoleCommands.ENTER_COMMAND);
		    String inputLN = sc.nextLine();
		    
		    Lichtschalter ls = new LichtschalterImpl();
		    
		    if(inputLN.equals(ConsoleCommands.EXIT)){
		    	break;
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_OFF)){
		    	ls.swichLightOff();
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_ON)){
		    	ls.swichLightOn();
		    }
		    else{
		    	System.out.println(ConsoleCommands.COMMAND_NOT_FOUND);
		    }
		}
		sc.close();
	}

}
