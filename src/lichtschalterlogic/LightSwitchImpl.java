package lichtschalterlogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class LightSwitchImpl implements LightSwitch {
	
	private String address;
	
	private String user;
	
	@Override
	public void setAddress(String address) {
		
		this.address = address;
		
	}

	@Override
	public String getAddress() {
		
		return this.address;
	}

	@Override
	public void setUser(String user) {

		this.user = user;
		
	}

	@Override
	public String getUser() {
		
		return this.user;
	}

	@Override
	public void switchLightOn() {
		// switch on light 1 & 2
		
		System.out.println(
				this.executePut(this.address+"api/"+this.user+"/lights/1/state",
						"{\"on\":true}"));
		
		System.out.println(
				this.executePut(this.address+"api/"+this.user+"/lights/2/state",
						"{\"on\":true}"));
		
		
		
	}

	@Override
	public void switchLightOff() {
		// switch off light 1 & 2
		
		System.out.println(
				this.executePut(this.address+"api/"+this.user+"/lights/1/state",
						"{\"on\":false}"));
		
		System.out.println(
				this.executePut(this.address+"api/"+this.user+"/lights/2/state",
						"{\"on\":false}"));
		
		
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
