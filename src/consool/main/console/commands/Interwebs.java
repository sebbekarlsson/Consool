package consool.main.console.commands;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import consool.main.Console;
import consool.main.console.Command;

public class Interwebs extends Command {

	@Override
	public void run(String[] args) {
		String url = args[1];

		if(Desktop.isDesktopSupported()){
			Console.log("yellow","Opening default browser with url: "+url);
			{
				try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException | URISyntaxException e) {
					Console.log("red","Bad url syntax");
				}
			}
		}else{
			Console.log("red","Could not find desktop");
		}

	}

}
