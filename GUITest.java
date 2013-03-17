import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class TypingGUI extends JPanel   {

        TypingPanel tpan;

        public TypingGUI()   {

                JLabel temp;
                int borderwidth;


                setLayout( new BorderLayout() );
                borderwidth = 1;

                JPanel p = new JPanel();
                tpan = new TypingPanel();
                p.add( tpan );
                add( p, BorderLayout.NORTH );

                //temp = new JLabel( "This\n will \nbe the\n Text that describes\n the seed that\n we're currently \n playing with", JLabel.CENTER );
                //temp.setBorder( new LineBorder( Color.black, borderwidth ) );
                //add( temp, BorderLayout.SOUTH );

                p = new JPanel();
                p.setLayout( new GridLayout( 2, 1 ) );
                JLabel l = new JLabel( "Score1", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                l = new JLabel( "Score2", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );

                add( p, BorderLayout.WEST );

                p = new JPanel();
                p.setLayout( new GridLayout( 2, 1 ) );
                l = new JLabel( "Score3", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                l = new JLabel( "Score4", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                add( p, BorderLayout.EAST );

                temp = new JLabel( tpan.seedhtml, JLabel.CENTER );
                temp.setBorder( new LineBorder( Color.black, borderwidth ) );
                add( temp, BorderLayout.CENTER );
                tpan.seedinfo = temp;

        }  //end constructor
}  //end TypingGUI class definition

public class GUITest extends JPanel   {


        public static void main( String [] args )   {

                JFrame frame = new JFrame( "Typing2" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setSize( 300, 300 );
                frame.setLocation( 200, 200 );
                frame.setContentPane( new TypingGUI() );
                frame.setVisible( true );
        }  //end main function
}  //end GUITest class definition
        
