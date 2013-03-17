import java.io.*;

class FileParser   {

        File infile;
        String wordfile;
        FileReader fr;
        BufferedReader br;

        boolean in_block;
        char c;

        String line;
        LinkedString record;

        FileParser()   {

                in_block = false;
                c = ' ';
                infile = null;
                wordfile = null;
                fr = null;
                br = null;
                record = null;
        }//end default constructor

        boolean isWord( StringBuffer block )   {

                int len = block.length();
                char c;

                for( int i = 0; i < len; ++i )   {

                        c = block.charAt( i );
                        if( Character.isLetter( c ) )   {

                                block.setCharAt( i, Character.toLowerCase( c ));
                        }
                        else return false;
                }
                return true;
        }  //end isWord function
        

        void parse( String raw, boolean onlyfirst )   {

                int len;
                StringBuffer buffer;

                len = raw.length();
                in_block = false;
                buffer = new StringBuffer();

                for( int i = 0; i < len; ++i )  {

                        c = raw.charAt( i );
                        if( c == ' ' || c == '\t' || c == '\n' )   {

                                if( in_block )   {

                                        if( isWord( buffer ) )   {

                                                record.add( buffer );
                                        }
                                        if( onlyfirst ) return;
                                        in_block = false;

                                }
                                else   {

                                        //do nothing
                                }
                        }
                        else if( !in_block )  {  //else => c!=' ' && c != '\t'

                                buffer = new StringBuffer();
                                buffer.append( c );
                                in_block = true;
                        }
                        else   {

                                buffer.append( c );
                        }
                }//end for loop => last character read
                if( in_block && isWord( buffer ) )   {

                        record.add( buffer );
                }               
        }  // end function parse


        void load( String filename, boolean onlyfirst )   {

                wordfile = filename;
                record = new LinkedString();
                try   {

                        infile = new File ( wordfile );
                        if( !infile.canRead() || !infile.exists() )   {

                                System.out.println( "The file cannot be read, or does not exist" );
                        }
                        fr = new FileReader( infile );
                        br = new BufferedReader( fr );
                        
                        while( (line = br.readLine() ) != null )   {

                                parse( line, onlyfirst );
                        }
                        
                }   //end try block
                catch( IOException ioe )   {

                        System.out.println( "Something really wierd happened" );
                }                
        }//end function load
}//end FileParser class definition
                
                        


        
