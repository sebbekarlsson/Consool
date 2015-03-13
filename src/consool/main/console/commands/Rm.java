package consool.main.console.commands;

import java.io.File;

import consool.main.Console;
import consool.main.console.Command;

public class Rm extends Command {

	@Override
	public void run(String[] args) {
		String file = args[1];
		File f = new File(file);
		
		
		if(!f.exists()){
			Console.log("red","File or directory does not exist");
			return;
		}
		
		f.delete();
		Console.log("yellow", file+" has been removed");
	}

}
