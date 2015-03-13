package consool.main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import consool.main.console.CommandHandler;

public class InputHandler implements KeyListener {
	public static int WIDTH = 640;
	public static int HEIGHT = 640 / 3;
	
	static JFrame frame = new JFrame();
	static JTextArea text = new JTextArea();

	public InputHandler(char c){
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		
		text.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		text.setText(c+"");
		text.addKeyListener(this);
		
		frame.add(text);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			String t = text.getText();
			String[] args = t.split(" ");
			
			text.setText(null);
			text.removeKeyListener(this);
			frame.dispose();
			
			new Thread(new Runnable(){

				@Override
				public void run() {
					
					CommandHandler.handleArguments(args);
					
				}}).start();
			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
