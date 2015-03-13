package consool.main.console;

import consool.main.console.commands.Echo;

public enum CommandType {
	
	ECHO("echo",new Echo());
	
	public Command command;
	public String name;
	
	CommandType(String name, Command command){
		this.name = name;
		this.command = command;
	}
}
