package consool.main;

import java.util.ArrayList;

public class Main{
	static Thread consoleThread;
	public static ArrayList<String> vars = new ArrayList<String>();
	public static void main(String[] args){
		consoleThread = new Thread(new Runnable(){
			@Override
			public void run(){
				new Console();
			}
		});
		consoleThread.start();
	}
	
	public static void defineVariable(String varname, String value){
		if(isVariableDefined(varname)){
			for(int i = 0; i < vars.size(); i++){
				String vname = vars.get(i).split(":")[0];
				if(vname.equals(varname)){
					vars.set(i, varname+":"+value);
					return;
				}
			}
		}
		vars.add(varname+":"+value);
	}
	
	public static void removeVariable(String varname){
		for(int i = 0; i < vars.size(); i++){
			String vname = vars.get(i).split(":")[0];
			if(vname.equals(varname)){
				vars.remove(i);
			}
		}
	}
	
	public static String getVariableValue(String varname){
		for(int i = 0; i < vars.size(); i++){
			String vname = vars.get(i).split(":")[0];
			String value = vars.get(i).split(":")[1];
			if(vname.equals(varname)){
				return value;
			}
		}
		
		return null;
	}
	
	public static boolean isVariableDefined(String varname){
		for(int i = 0; i < vars.size(); i++){
			String vname = vars.get(i).split(":")[0];
			if(vname.equals(varname)){
				return true;
			}
		}
		
		return false;
	}
}
