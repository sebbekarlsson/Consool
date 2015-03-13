package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;

public class Property extends Command {

	@Override
	public void run(String[] args) {
		String property = args[1];
		Console.log("yellow",System.getProperty(property));
		
	}

}
