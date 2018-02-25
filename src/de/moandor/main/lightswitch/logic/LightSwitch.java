package de.moandor.main.lightswitch.logic;

public interface LightSwitch {
	
	/**
	 * The address of the hue bridge has to be initial set.
	 * @param address
	 */
	public void setAddress(String address);
	
	public String getAddress();
	
	/**
	 * The user registered at the hue bridge has to be initial set.
	 * @param user
	 */
	public void setUser(String user);
	
	public String getUser();
	
	public void switchLightOn();
	
	public void switchLightOff();

}
