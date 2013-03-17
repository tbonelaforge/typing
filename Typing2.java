import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



class Typing2   {

        public static void main( String [] args )   {

                JFrame frame = new JFrame( "Typing2" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setSize( 300, 300 );
                frame.setLocation( 200, 200 );
                frame.setContentPane( new TypingGUI() );
                frame.setVisible( true );
        }  //end main function
} //end Typing2 class definition.        

                                           
        

