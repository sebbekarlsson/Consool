package consool.main.console.commands;

import java.io.DataOutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import consool.main.Console;
import consool.main.console.Command;

public class HttpPost extends Command {

	@Override
	public void run(String[] args) {
		int times = 1;
		if(args[3] != null){
			times = Integer.parseInt(args[3]);
		}
		for(int i = 0; i < times; i++){
			try {
				sendPost(args[1],args[2]);
			} catch (Exception e) {
				Console.log("red","Error");
			}
		}

	}

	private void sendPost(String url, String parameters) throws Exception {

		new Thread(new Runnable(){

			@Override
			public void run() {

				Console.log("yellow","Sending 'POST' request to URL : " + url);

			}

		}).start();


		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Java Software");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = parameters;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		Console.log("yellow","Response Code : " + responseCode);


}

}
