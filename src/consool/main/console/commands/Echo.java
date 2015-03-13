package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;

public class Echo extends Command {

	@Override
	public void run(String[] args) {
		String msg = "";
		
		for(int i = 1; i < args.length; i++){
			msg += args[i];
		}
		
		Console.log(msg);
		
	}

}
