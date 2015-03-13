package consool.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class Console implements KeyListener {
	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 2;
	public static JFrame frame = new JFrame();
	public static JEditorPane consolePanel = new JEditorPane();
	public static JScrollPane scroll = new JScrollPane(consolePanel);
	
	public Console(){
		init();
	}
	
	private void init(){
		frame.setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		
		consolePanel.setPreferredSize(new Dimension(WIDTH * SCALE, (HEIGHT * SCALE)));
		consolePanel.setBackground(Color.black);
		consolePanel.setContentType("text/html");
		consolePanel.setEditable(false);
		consolePanel.addKeyListener(this);
		
		HTMLEditorKit editorKit = (HTMLEditorKit)consolePanel.getEditorKit();
		StyleSheet s = editorKit.getStyleSheet();
		s.addRule("span{color:white; margin:0; padding:0; font-family:Arial; font-size:12px;}");
		editorKit.setStyleSheet(s);

		
		frame.add(scroll);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
		
		
	}
	
	public static void log(String text){
		HTMLDocument doc = (HTMLDocument)consolePanel.getDocument();
		HTMLEditorKit editorKit = (HTMLEditorKit)consolePanel.getEditorKit();
		
		try {
			editorKit.insertHTML(doc, doc.getLength(), "<span>"+text+"</span>", 0, 0, null);
			scroll.getVerticalScrollBar().setValue(doc.getLength());
		} catch (BadLocationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void log(String color, String text){
		log("<font color='"+color+"'>"+text+"</font>");
	}
	public static void clear(){
		consolePanel.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		new Thread(new Runnable(){
			@Override
			public void run(){
				new InputHandler(e.getKeyChar());
			}
		}).run();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
