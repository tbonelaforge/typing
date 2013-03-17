//  this will be the file array testing class.

import java.io.*;

class FileTest   {

        public static void main( String [] args )   {

                UsedList my_list = new UsedList( "words_lv1.txt" );
                my_list.print();
                my_list.output();
                my_list.tryToInsert( "and" );
                my_list.print();
                my_list.output();
               
        }
}  //end FileTest definition
