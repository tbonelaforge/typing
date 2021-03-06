import java.io.*;

class Lexicon extends UsedList   {

        FileParser fparse;

        Lexicon( String wordfile )   {

                super( wordfile );
                //super( wordfile, true );  //hard coded to work with url's need to be changed
                //fparse = new FileParser();
        }

        void build( String wordlistname, boolean onlyfirst )   {

                LinkedString current;

                fparse.load( wordlistname, onlyfirst );
                current = fparse.record;
                while( current != null )   {

                        tryToInsert( current.d );
                        current = current.next;
                }
        }//end function build

        boolean isIn( StringBuffer word )   {

/*
System.out.println( "this is a breakpoint" );
try{
System.in.read();
}
catch( IOException ioe )   {
}
*/

                return ( indexOfInsertion( new String( word ) ) == -1 );
        }

        boolean isRegPast( StringBuffer word )   {

                int len;
                StringBuffer verb;

                verb = new StringBuffer( new String( word ) );
                len = verb.length();
                if( len <= 3 ) return false;
                if( ( verb.charAt( len - 1 ) == 'd' )
                    && ( verb.charAt( len - 2 ) == 'e' ) )   {

                        verb.setLength( len - 2 );
                        if( isIn( verb ) )   {

                                return true;
                        }
                        if( ( verb.charAt( len - 3 ) == 'k' )
                            && ( verb.charAt( len - 2 ) == 'c' ) )   {

                                verb.setLength( len - 3 );
                                return( isIn( verb ) );
                        }
                        if( verb.charAt( len - 3 ) == verb.charAt( len - 4 ) )   {

                                verb.setLength( len - 3 );
                                return isIn( verb );
                        }
                        verb.append( 'e' );
                        return isIn( verb );
                }
                else return false;
        }//end function isRegPast

        boolean isPlural( StringBuffer word )   {

                int len;
                StringBuffer noun;

                noun = new StringBuffer( word.toString() );
                len = noun.length();
                if( len <= 2 ) return false;
                if( noun.charAt( len - 1 ) == 's' )   {

                        noun.setLength( len - 1 );
                        if( isIn( noun ) ) return true;
                        if( noun.charAt( len - 2 ) == 'e' )   {
                                 //only if e followed by s.
                                noun.setLength( len - 2 );
                                if( isIn( noun ) ) return true;
                                if( noun.charAt( len - 3 ) == 'i' )   {

                                        noun.setCharAt( len - 3, 'y' );
                                        return isIn( noun );
                                }
                        }
                }
                return false;
        }//end function isPlural

}//end Lexicon class definition.

                        


