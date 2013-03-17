import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



class Typing   {

        public static void main( String [] args )   {

                JFrame frame = new JFrame( "T's Typing" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setSize( 300, 300 );
                frame.setLocation( 200, 200 );
                frame.setContentPane( new TypingGUI() );
                frame.setVisible( true );
        }  //end main function
} //end Typing class definition.        

                                           
        

