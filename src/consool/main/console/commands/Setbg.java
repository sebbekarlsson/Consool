package consool.main.console.commands;

import java.awt.Color;

import consool.main.Console;
import consool.main.console.Command;

public class Setbg extends Command {

	@Override
	public void run(String[] args) {
		Console.consolePanel.setBackground(new Color(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3])));
		Console.log("yellow", "Background changed!");
	}

}
