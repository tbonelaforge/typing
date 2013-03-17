import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TypingApplet extends JApplet   {

	public void init()   {

		setContentPane( new TypingGUI() );
	}

	public void start()   {

	
//                text.append( "Applet started: " + startCount++ + "\n" );
	}

	public void stop()   {

//                text.append( "Applet stopped. \n" );
	}
}  //end class TypingApplet
