package de.moandor.lightswitch.properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

public class PropertyManagerImpl implements PropertyManager {
	
	private Properties lsProps;
	private String propertyFileName = ".lightswitch.properties"; 
	
	public PropertyManagerImpl () {
		lsProps = new Properties();
		loadProperties();
	}

	@Override
	public String getLightSwitchUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalSwitchIP() {
		
		String localSwitchIP;
		
		localSwitchIP = lsProps.getProperty("localSwitchIP");
		
		return localSwitchIP;
	}
	
	private void loadProperties(){
		
		try {
			InputStream input;
			input = new FileInputStream(propertyFileName);
			
			lsProps.load(input);
		} catch (FileNotFoundException fnfex){
			//create new properties File if none is found
			createNewPropertiesFile();
			
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	private void createNewPropertiesFile(){
		
		try{
			OutputStream output;
			output = new FileOutputStream(propertyFileName);
			
			String localSwitchIp = getLocalSwitchIPAddr();
			
			lsProps.setProperty("localSwitchIP", "http://" + localSwitchIp + "/");
			
			lsProps.store(output, null);
			
		}catch (IOException io){
			io.printStackTrace();
		}
		
	}
	
	private String getLocalSwitchIPAddr() {
		
		StringBuffer response = new StringBuffer();
		String respString = new String();
		
		try {
			URL url = new URL("https://www.meethue.com/api/nupnp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			
			while( (inputLine = in.readLine()) != null  ){
				response.append(inputLine);
			}
			in.close();
			
			respString = response.toString();
			
			//regEx the response into a correct IPV4 addr
			respString = respString.replaceFirst(".*internalipaddress.{3}", "");
			respString = respString.replaceFirst(".{3}$", "");
			
			
		} catch (MalformedURLException e ) {
			
			e.printStackTrace();
		} catch (ProtocolException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return respString;
	}

}
