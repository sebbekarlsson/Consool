package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;
import consool.main.console.CommandType;

public class Help extends Command {

	@Override
	public void run(String[] args) {
		CommandType[] types = CommandType.values();
		
		for(int i = 0; i < types.length; i++){
			String name = types[i].name();
			String usage = types[i].usage;
			Console.log("yellow","command: "+name);
			Console.log("white","Usage: "+usage+"<hr>");
		}
		
	}

}
