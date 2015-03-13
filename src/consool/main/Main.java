package consool.main;

public class Main{
	static Thread consoleThread;
	public static void main(String[] args){
		consoleThread = new Thread(new Runnable(){
			@Override
			public void run(){
				new Console();
			}
		});
		consoleThread.start();
	}
}
