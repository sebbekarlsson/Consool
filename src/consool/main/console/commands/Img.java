package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;

public class Img extends Command {

	@Override
	public void run(String[] args) {
		String image = args[1];
		Console.log("<img src='"+image+"'>");
		
	}

}
