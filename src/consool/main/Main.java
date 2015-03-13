package consool.main;

public class Main{
	static Thread consoleThread;
	static Thread inputThread;
	public static void main(String[] args){
		consoleThread = new Thread(new Runnable(){
			@Override
			public void run(){
				new Console();
			}
		});
		
		inputThread = new Thread(new Runnable(){
			@Override
			public void run(){
				
			}
		});
		
	}
}
