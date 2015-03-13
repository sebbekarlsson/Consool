package consool.main.console.commands;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import consool.main.Console;
import consool.main.console.Command;

public class Ping extends Command {
	
	boolean test;
	
	@Override
	public void run(String[] args) {
		String ip = args[1];
		test = true;


		new Thread(new Runnable(){

			@Override
			public void run() {

				while(test){
					Console.log("yellow", "Sending ping request to: "+ip);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}



			}}).start();

		try {


			InetAddress inet;
			inet = InetAddress.getByName(ip);

			if (inet.isReachable(5000)){
				Console.log("yellow",ip+" is reachable!");
				test = false;
			}
			else{
				Console.log("red",ip+" is not reachable.");
				test = false;
			}
		} catch (UnknownHostException e) {
			Console.log("red","Unknown host");
			test = false;
		} catch (IOException e) {
			Console.log("red","Unknown error");
			test = false;
		}



	}

}
