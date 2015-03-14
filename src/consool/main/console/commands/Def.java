package consool.main.console.commands;

import consool.main.Main;
import consool.main.console.Command;

public class Def extends Command {

	@Override
	public void run(String[] args) {
		String varname = args[1];
		String value = args[2];
		
		Main.defineVariable(varname, value);
		
	}

}
