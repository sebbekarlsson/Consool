package consool.main.console.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import consool.main.Console;
import consool.main.console.Command;
import consool.main.console.CommandHandler;

public class LOCC extends Command {

	@Override
	public void run(String[] args) {
		if(!args[1].endsWith(".locc")){
			Console.log("red","Can only execute .locc scripts");
			return;
		}
	
		File file = new File(args[1]);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			ArrayList<String> commands = new ArrayList<String>();
			while((line = reader.readLine()) != null){
				commands.add(line);
			}
			reader.close();
			
			for(int i = 0; i < commands.size(); i++){
				CommandHandler.handleArguments(commands.get(i).split(" "));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
