package consool.main.console;

import java.util.Random;

import consool.main.Console;

public class CommandHandler {
	
	static Random random = new Random();
	
	public static void handleArguments(String[] args){
		String commandName = args[0];
		
		for(int i = 0; i < args.length; i++){
			String argument = args[i];
			if(argument.contains("#rand")){
				args[i] = random.nextInt(Integer.parseInt(argument.split("#rand&")[1]))+"";
			}
		}
		
		try{
		CommandType.valueOf(commandName.toUpperCase()).command.run(args);
		}catch(IllegalArgumentException e){
			Console.log("red", "Bad arguments or no such command");
		}
	}
}
