import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;

public class TypingApplet extends JApplet  {

        static boolean loaded;
        static URL codebase;
        String message;
        TypingGUI tg;
        
    //LoadThread thread;
	
        public void init()   {

  	        message = "Loading...";
	        codebase = this.getCodeBase();
	        loaded = false;
		new LoadThread( this ).start();	       
		new GuiThread( this ).start();
		//setContentPane( new TypingGUI() );
		
		
	}
    /*   
        public void paint( Graphics g ) {
	    //System.out.println( "Typing Applet's paint got called" );
	    if( loaded ) {

		super.paint( g );
	    }
	    else {//!loaded

		g.setColor( Color.blue );
		g.fillRect( 0, 0, this.getSize().width, this.getSize().height );

		g.setColor( Color.white );
		g.drawString( message, 10, 20 );
	    }
	}//end overridden paint method
    */
    /*
            public void run() {

	    try {

		paint( this.getGraphics() );

		while( !loaded ) {

		    message += "..";
		    paint( this.getGraphics() );
		    thread.sleep( 500 );
		}
	    }
	    catch( InterruptedException e ) {

		System.out.println( "Interrupted" );
	    }
	    finally {

		loaded = true;
		paint( this.getGraphics() );
	    }
	}//end run method
    */
	public void start()   {

	
//                text.append( "Applet started: " + startCount++ + "\n" );
	}

	public void stop()   {

//                text.append( "Applet stopped. \n" );
	}
    /*
        public static void setLoaded() {

	    loaded = true;
	}
    */
}  //end class TypingApplet
