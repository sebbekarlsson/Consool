package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;

public class Clear extends Command {

	@Override
	public void run(String[] args) {
		Console.clear();
		
	}

}
