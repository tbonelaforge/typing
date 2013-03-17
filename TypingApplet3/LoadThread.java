import java.awt.*;


class LoadThread extends Thread {

    TypingApplet ta;  //will be used to paint the appplet
    String message;
    StringBuffer messagebuffer;
    char[] temp;
    char[] tempchar;
    int messagecap;

    public LoadThread( TypingApplet init ) {

	ta = init;
	message = "Loading...Please feel free to read the instructions...";
	messagebuffer = new StringBuffer( message );
	messagecap = message.length();
	//System.out.println( "I THINK THE CAPACITY IS" + messagecap );
        temp = new char[messagecap-3];
	tempchar = new char[3];
	    
    }

    public void run() {

	
	while (!TypingApplet.loaded) {

	    //System.out.println( "waiting to load" );
	    try {

		sleep( 500 );		
		paintApplet();		
		//ta.repaint();
	    }
	    catch( InterruptedException ie ) {

		System.out.println( "Interrupted" );		
	    }
	}//end while
	//ta.revalidate();
        //ta.repaint();
        //ta.tg.setVisible( true );
        //ta.tg.repaint();
	ta.resize( new Dimension( 361, 250 ) );
	ta.resize( 360, 250 );
	
	
	System.out.println( "LoadThread terminated" );
    }//end run method

    public void paintApplet() {

	messagebuffer = new StringBuffer( message );
	//the message buffer and the message string hold the same characters.
	Graphics g = ta.getGraphics();
	//System.out.println( "the TypingApplet addres is" + ta );
	//System.out.println( "the graphics context is" + g );
	g.setColor( Color.blue );
	g.fillRect(0, 0, ta.getSize().width, ta.getSize().height );

	g.setColor( Color.white );
	messagebuffer.getChars( 0, 3, tempchar, 0 );

	//System.out.println( "The first chars are " + tempchar );
	messagebuffer.getChars( 3, messagecap, temp, 0 );
	//System.out.println( "The temp array is" + new String( temp ) );
	messagebuffer = new StringBuffer( new String( temp ) );
	messagebuffer.append( tempchar );
	//System.out.println( "the new buffer is " + messagebuffer ); 
	message = new String( messagebuffer );
       
	
        g.drawString( message , 40, 140 );
	//System.out.println( "the dimension I think are: " + ta.getSize().width +  ta.getSize().height );
	//ta.repaint();
    }//end paintApplet method

}//end class definition
