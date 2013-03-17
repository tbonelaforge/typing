//import Word.*;
import java.io.*;

class NodeTest   {

        public static void main( String  [] args )   {

                Word my_word;

                try  {
                my_word = new Word( 2 );
//                my_word.print();
                for( int i = 0; i < 3; ++i )   {

                        my_word.add();
                        my_word.print();
System.in.read();
                }
                for( int i = 0; i < 3; ++i )  {


                        for( int j = 0; j < 26; ++j )   {


                                my_word.add();
                                my_word.print();
                                System.in.read();
                                my_word.remove();
                                my_word.print();
                                System.in.read();
                        }
                }
                my_word.add();
                my_word.print();
System.in.read();                
                my_word.remove();
                my_word.print();
                } catch( IOException ioe )   {

                        System.out.print( "There was an IOException\n" );
                } catch( FullWordException fwe )  {

                        System.out.print( "There was a full word exception.\n" );
                }



                


        }  //end main function

}  //end class definition
