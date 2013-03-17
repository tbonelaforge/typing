import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.io.*;

public class ShowApplet extends JApplet   {

	JTextArea text = new JTextArea();
	int startCount;

	public void init()   {

                URL u;
                InputStream in;
                InputStreamReader isr;
                BufferedReader br;
                String line;

                JButton button = new JButton( "Press Me" );
		button.addActionListener( new ActionListener()  {
			 
			public void actionPerformed( ActionEvent e )   {

				text.append( "Button Pressed!\n" );
			}
		} );
		getContentPane().add( "Center", new JScrollPane( text ) );
                JPanel panel = new JPanel();
		panel.add( button );
		getContentPane().add( "South", panel );
		text.append( "Java Version: " + System.getProperty( "java.version" ) + "/n" );
		text.append( "Applet init()\n" );
                try   {

                        u = new URL( "http://www.tajspav.com/test.txt" );
                        isr = new InputStreamReader( u.openStream() );
                        br = new BufferedReader( isr );
                        while( ( line = br.readLine() ) != null )   {

                                text.append( line );
                        }
                         
                }
                catch( Exception e )   {

                        text.append( "The file could not be read" );
                }


	}

	public void start()   {

	
		text.append( "Applet started: " + startCount++ + "\n" );
	}

	public void stop()   {

		text.append( "Applet stopped. \n" );
	}
}
