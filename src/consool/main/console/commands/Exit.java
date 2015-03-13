package consool.main.console.commands;

import consool.main.console.Command;

public class Exit extends Command {

	@Override
	public void run(String[] args) {
		System.exit(0);
		
	}

}
