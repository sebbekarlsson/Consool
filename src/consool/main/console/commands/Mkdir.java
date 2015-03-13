package consool.main.console.commands;

import java.io.File;

import consool.main.Console;
import consool.main.console.Command;

public class Mkdir extends Command {

	@Override
	public void run(String[] args) {
		String dir = args[1];
		File file = new File(dir);
		file.mkdirs();
		Console.log("yellow","Directory "+dir+" created!");
	}

}
