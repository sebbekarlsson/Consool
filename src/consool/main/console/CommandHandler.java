package consool.main.console;

import consool.main.Console;

public class CommandHandler {
	
	
	public static void handleArguments(String[] args){
		String commandName = args[0];
		try{
		CommandType.valueOf(commandName.toUpperCase()).command.run(args);
		}catch(IllegalArgumentException e){
			Console.log("red", "Bad arguments or no such command");
		}
	}
}
