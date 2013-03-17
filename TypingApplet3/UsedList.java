import java.io.*;
import java.net.*;

class UsedList   {

        String [] data;
        String filename;
        File in;
        FileReader fr;
        BufferedReader br;
        File out;
        FileWriter fw;
        PrintWriter pw;
       


        UsedList( int len )   {

                data = new String[len];
        }

	UsedList( String url, boolean urlused )   {

		String line;
		int length;
		int index;
		boolean first_line_read;

		URL u;
                InputStream in;
                InputStreamReader isr;
                BufferedReader br;        

		try   {

                        u = new URL( url );
                        isr = new InputStreamReader( u.openStream() );
                        br = new BufferedReader( isr );
			index = 0;
                        first_line_read = false;          
			while( ( line = br.readLine() ) != null )   {

                                if( first_line_read )   {

                                        data[index] = new String( line );
                                        ++index;
                                }
                                else   {


                                        length = Integer.parseInt( line );
                                        data = new String[length];
                                        first_line_read = true;
                                }
                        }  //break from loop implies we have reached the end of
                          //the file
                        if( !first_line_read )   {

                                data = new String[0];
                        }
                         
                }
                catch( MalformedURLException e )    {

                        System.out.println( "there was a malformed  url" );
                }
                catch( Exception e )   {

                        System.out.println( "The file could not be read" );
                }
	}//end url name constructor.

	UsedList( String wordfile )   {

                String line;
                int length;
                int index;
                boolean first_line_read;


                filename = new String( wordfile );
                try   {

                        in = new File( wordfile );
                        if( !in.exists() || !in.canRead() )   {

                                in.createNewFile();
                        }
                        fr = new FileReader( in );
                        br = new BufferedReader( fr );
                        index = 0;
                        first_line_read = false;
                        while( ( line = br.readLine() ) != null )   {

                                if( first_line_read )   {

                                        data[index] = new String( line );
                                        ++index;
                                }
                                else   {


                                        length = Integer.parseInt( line );
                                        data = new String[length];
                                        first_line_read = true;
                                }
                        }  //break from loop implies we have reached the end of
                          //the file
                        if( !first_line_read )   {

                                data = new String[0];
                        }
                } //end try block
                catch( IOException ioe )   {

                        System.out.println( "Something really wierd happened" );
                }
        }  //end filename constructor.
                              
                
        void print()   {

                int l;

                l = data.length;
                System.out.println( l );
                for( int i = 0; i < l; ++i )   {

                        System.out.println( data[i] );
                }
        }

        void output()   {

                int len;

                try   {

                        out = new File( filename );
                        fw = new FileWriter( out );
                        pw = new PrintWriter( fw );
                        len = data.length;
                        pw.println( len );
                        for( int i = 0; i < len; ++i )   {

                                pw.println( data[i] );
                        }
                        fw.close();
                }
                catch( IOException ioe )   {

                        System.out.println( "Something really wierd happened" );
                }
        } //end function output

        int indexOfInsertion( String target )   {

                int l, m, u;

                if( data.length == 0 )   { //empty array

                        return 0;
                }
                l = 0;
                u = data.length - 1;

                do  {

                        m = (l + u) / 2;
//System.out.print( "u is: " + u + " l is : " + l + " m is: " + m + "\n" );
                        if( data[m].compareTo( target ) == 0 )   {

                                return -1;
                        }

                        if( (l == m) || (u == m) )   {

                                if( data[l].compareTo( target ) >= 1 )   {

                                        return l;
                                }
                                if( data[u].compareTo( target ) <= -1 )   {

                                        return u + 1;
                                }
                                return u;
                        }


                        if( data[m].compareTo( target ) <= -1 )   {
                                //mid is new low
                                l = m;
                        }
                        if( data[m].compareTo( target ) >= 1 )   {
                                //mid is new upper
                                u = m;
                        }
                        
                }   //end "do" block
                while( true );
        }  //end function indexOfInsertion

        boolean tryToInsert( String new_word )  {

                int ioi, i, j;
                String [] temp;

                if( (ioi = indexOfInsertion( new_word )) == -1 )   {
                        //already in list
                        return false;
                }
                //otherwise, have to transfer to a new array, one longer
                temp = new String[data.length + 1];
                j = 0;
                i = 0;
                while( j < temp.length )  {

                        if( j == ioi )   {

                                temp[j] = new_word;
                        }
                        else   {

                                temp[j] = data[i];
                                ++i;
                        }
                        ++j;
                }
                data = temp;
                output();
                return true;
        }  //end function tryToInsert
                        
}  //end UsedList class definition
