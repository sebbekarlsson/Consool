package consool.main.console;

import consool.main.console.commands.Calc;
import consool.main.console.commands.Echo;
import consool.main.console.commands.Exit;
import consool.main.console.commands.Interwebs;
import consool.main.console.commands.Mkdir;
import consool.main.console.commands.Ping;

public enum CommandType {
	
	ECHO("echo",new Echo()),
	MKDIR("mkdir",new Mkdir()),
	PING("ping",new Ping()),
	CALC("calc",new Calc()),
	EXIT("exit",new Exit()),
	INTERWEBS("interwebs",new Interwebs());
	
	public Command command;
	public String name;
	
	CommandType(String name, Command command){
		this.name = name;
		this.command = command;
	}
}
