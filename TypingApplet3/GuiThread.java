import java.awt.*;



class GuiThread extends Thread {

    TypingApplet ta;
    public GuiThread( TypingApplet init ) {

	ta = init;
    }

    public void run() {

	TypingGUI tg = new TypingGUI();
	tg.revalidate();
	tg.repaint();
	ta.setContentPane( tg );
	ta.tg = tg;
	TypingApplet.loaded = true;
	
    }
}//end GuiThread class definition
	
