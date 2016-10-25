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
		    ls.setAddress("http://192.168.178.31/");
		    ls.setUser("BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY");
		    
		    
		    if(inputLN.equals(ConsoleCommands.EXIT)){
		    	break;
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_OFF)){
		    	ls.switchLightOff();
		    }
		    else if(inputLN.equals(ConsoleCommands.SWITCH_LIGHT_ON)){
		    	ls.switchLightOn();
		    }
		    else{
		    	System.out.println(ConsoleCommands.COMMAND_NOT_FOUND);
		    }
		}
		sc.close();
	}

}
