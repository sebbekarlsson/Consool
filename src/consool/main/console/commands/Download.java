package consool.main.console.commands;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import consool.main.Console;
import consool.main.console.Command;

public class Download extends Command {
	boolean done = false;
	@Override
	public void run(String[] args) {
		String url = args[1];
		String dir = args[2];

		try{
		
		URL website = new URL(url);
		ReadableByteChannel rbc;
		rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = null;
		fos = new FileOutputStream(dir);

		new Thread(new Runnable(){

			@Override
			public void run() {

				try {
					

					while(done == false){
						Console.log("yellow","Downloading from: "+url+" ...");
						Thread.sleep(1000);
					}
				

					
			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}}).start();


				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				Console.log("yellow",url+" COMPLETE!");
				done = true;
		
		}catch(IOException e){
			Console.log("red", "Unknown error");
		}



	}

}
