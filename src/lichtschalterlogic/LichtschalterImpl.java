package lichtschalterlogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import UserInterface.ConsoleCommands;

public class LichtschalterImpl implements Lichtschalter {

	@Override
	public void swichLightOn() {
		// switch on light 1 & 2
		
		System.out.println(
				this.executePut(
						"http://192.168.178.31/api/BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY/lights/1/state",
						"{\"on\":true}")
				);
		
		System.out.println(
				this.executePut(
						"http://192.168.178.31/api/BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY/lights/2/state",
						"{\"on\":true}")
				);
		
		System.out.println(ConsoleCommands.LIGHT_SWITCHED_ON);
		
	}

	@Override
	public void swichLightOff() {
		// switch off light 1 & 2
		
		System.out.println(
				this.executePut(
						"http://192.168.178.31/api/BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY/lights/1/state",
						"{\"on\":false}")
				);
		
		System.out.println(
				this.executePut(
						"http://192.168.178.31/api/BoqfyjzI99Xfej56EdTSy59DH7T0dj-QgFqEllFY/lights/2/state",
						"{\"on\":false}")
				);
		
		System.out.println(ConsoleCommands.LIGHT_SWITCHED_OFF);
	}
	
	private String executePut(String targetURL, String urlParameters) {
		  
		URL url = null;
		try {
			url = new URL(targetURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection httpCon = null;
		try {
			httpCon = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpCon.setDoOutput(true);
		try {
			httpCon.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStreamWriter out;
		String readLine=null;
		try {
			out = new OutputStreamWriter(httpCon.getOutputStream());
			out.write(urlParameters);
			out.close();
			if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
				BufferedReader in = new BufferedReader(
							new InputStreamReader(
									httpCon.getInputStream()
								)
							);
				
				StringBuffer response = new StringBuffer();
				
				while((readLine = in.readLine()) != null){
					response.append(readLine);
				}
				in.close();
			}
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readLine;
		}
}
