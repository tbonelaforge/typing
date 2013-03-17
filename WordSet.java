import java.io.*;

class WordPair  {

        Word d;
        int numspent;

        WordPair( int dif, int spent )   {

                d = new Word( dif );
                numspent = spent;
        }

        void print()   {

                d.print();
                System.out.println( "spent = " + numspent );
        }
        

                
}  //end WordPair class definition

class WordSet   {

        WordPair [] data;
        int length;

        WordSet ( int diff, int sublevel )   {

                data = new WordPair[sublevel];
                for( int i = 0; i < sublevel; ++i )   {

                        data[i] = new WordPair( diff, 0 );
                }
                length = sublevel;
        }

        void print()   {

                InputStreamReader converter = new InputStreamReader( System.in );
                BufferedReader in = new BufferedReader( converter );
                try  {
                for( int i = 0; i < length; ++i )   {

                        System.out.println( "Word " + i + "is: " );
                        data[i].print();
                        in.readLine();

                }
                }
                catch( IOException ioe )   {

                        System.out.println( "Something wierd happened" );
                }
        }  //end function print.

        void removeWordAt( int index )   {

                WordPair [] temp = new WordPair[length - 1];
                int i = 0;

                for( int j = 0; j < length - 1; ++j )   {

                        if( i == index )   {

                                ++i;
                        }
                        temp[j] = data[i];
                        ++i;
                }
                data = temp;
                length = length - 1;
        }  //end function removeWordAt               

}  //end WordSet class definition
