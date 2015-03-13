package consool.main.console;

import consool.main.console.commands.Calc;
import consool.main.console.commands.Clear;
import consool.main.console.commands.Download;
import consool.main.console.commands.Echo;
import consool.main.console.commands.Exit;
import consool.main.console.commands.Help;
import consool.main.console.commands.HttpPost;
import consool.main.console.commands.Img;
import consool.main.console.commands.Interwebs;
import consool.main.console.commands.LOCC;
import consool.main.console.commands.Mkdir;
import consool.main.console.commands.Ping;
import consool.main.console.commands.Property;
import consool.main.console.commands.Rm;
import consool.main.console.commands.Setbg;
import consool.main.console.commands.Website;

public enum CommandType {
	
	ECHO("echo (text)",new Echo()),
	MKDIR("mkdir (dir)",new Mkdir()),
	PING("ping (ip)",new Ping()),
	CALC("calc (value1) (action) (value3)",new Calc()),
	EXIT("exit",new Exit()),
	INTERWEBS("interwebs (url)",new Interwebs()),
	SETBG("setbg (red) (reen) (blue)",new Setbg()),
	RM("rm (dir)",new Rm()),
	PROPERTY("property (system property)",new Property()),
	CLEAR("clear",new Clear()),
	HTTPPOST("httpost (url) (attributes) (times)",new HttpPost()),
	DOWNLOAD("download (url) (output dir)",new Download()),
	WEBSITE("website (url)",new Website()),
	HELP("help",new Help()),
	LOCC("locc (.locc file)", new LOCC()),
	IMG("img (image url)", new Img());
	
	public Command command;
	public String usage;
	
	CommandType(String usage, Command command){
		this.usage = usage;
		this.command = command;
	}
}
