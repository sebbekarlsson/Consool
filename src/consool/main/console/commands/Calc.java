package consool.main.console.commands;

import consool.main.Console;
import consool.main.console.Command;

public class Calc extends Command {

	@Override
	public void run(String[] args) {
		int value1 = Integer.parseInt(args[1]);
		String action = args[2].replace("\n", "").replace(" ", "");
		int value3 = Integer.parseInt(args[3]);
		double result = 0;
		
		
		if(action.contains("+")){
			result = value1 + value3;
			Console.log("yellow",result+"");
			return;
		}
		if(action.contains("-")){
			result = value1 - value3;
			Console.log("yellow",result+"");
			return;
		}
		if(action.contains("/")){
			result = value1 / value3;
			Console.log("yellow",result+"");
			return;
		}
		if(action.contains("%")){
			result = value1 % value3;
			Console.log("yellow",result+"");
			return;
		}
		if(action.contains("pow")){
			result = Math.pow(value1, value3);
			Console.log("yellow",result+"");
			return;
		}
		
	}

}
