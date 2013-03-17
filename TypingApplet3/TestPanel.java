import javax.swing.*;
import java.awt.*;
import java.net.*;

public class TestPanel extends JPanel {

    URL url;
    ImageIcon ii;
    JLabel jl;
    String filename;

    public TestPanel() {

	setLayout( new BorderLayout() );
	filename = "http://www.tajspav.com/pan" + 1 + "_l-0.gif";
	System.out.println( filename );
	try {

	    url = new URL( filename );
	}
	catch( MalformedURLException murle ) {

	    System.out.println( "there was a malformed url" );
	}
	ii = new ImageIcon( url );
	jl = new JLabel( ii );
	add( jl, BorderLayout.CENTER );
    }

    public static void main( String[] args ) {

	TestPanel testpanel;
	JFrame frame = new JFrame( "shit" );
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.setSize( 360, 200 );
	frame.setLocation( 200, 200 );
	testpanel = new TestPanel();
	frame.setContentPane( testpanel );
	frame.setVisible( true );
    }  //end main function
}//end TestPanel class definition
	
