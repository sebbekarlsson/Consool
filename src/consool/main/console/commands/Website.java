package consool.main.console.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import consool.main.Console;
import consool.main.console.Command;

public class Website extends Command {

	boolean done = false;
	
	@Override
	public void run(String[] args) {
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(done == false){
					Console.log("yellow","Fetching: "+args[1]);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}).start();
		
		 URL website;
		try {
			website = new URL(args[1]);
			URLConnection yc = website.openConnection();
	         BufferedReader in = new BufferedReader(new InputStreamReader(
	                 yc.getInputStream(), "UTF-8"));
	         String inputLine;
	         StringBuilder a = new StringBuilder();
	         while ((inputLine = in.readLine()) != null)
	             a.append(inputLine);
	         in.close();
	         Console.log(a.toString());
	         done = true;
		} catch (MalformedURLException e) {
			Console.log("red","invalid url");
			done = true;
		} catch (UnsupportedEncodingException e) {
			Console.log("red","unsupported encoding");
			done = true;
		} catch (IOException e) {
			Console.log("red","Unknown error");
			done = true;
		}
         
        
		
	}

}
