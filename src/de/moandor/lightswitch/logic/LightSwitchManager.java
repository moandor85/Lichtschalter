package de.moandor.lightswitch.logic;

public class LightSwitchManager {
	
	private static LightSwitch LIGHT_SWITCH;
	
	public static void initiate(){
		
	}
	
	public static LightSwitch getInstanceOf(){
		if(LightSwitchManager.LIGHT_SWITCH == null){
			LightSwitchManager.LIGHT_SWITCH = new LightSwitchImpl();
		}
		return LightSwitchManager.LIGHT_SWITCH;
	}

}
