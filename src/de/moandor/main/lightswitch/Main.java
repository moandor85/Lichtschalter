package de.moandor.main.lightswitch;
import de.moandor.main.lightswitch.userinterface.Console;
import de.moandor.main.lightswitch.userinterface.ConsoleImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console c = new ConsoleImpl();
		c.listen();

	}

}
