import java.io.*;
public class JC {
  public static void main( String args[] )
    throws IOException, InterruptedException {
    String fn = "JC.java";
    if( args.length > 0 ) fn = args[0];
    System.out.println( "BEGIN (" + fn + ")" );
    Process p =     Runtime.getRuntime().exec( "javac -verbose " + fn );
    String buf;
    BufferedReader se = new BufferedReader
    ( new InputStreamReader( p.getErrorStream() ) );
    while( (buf = se.readLine()) != null ) 
    System.out.println( " : " + buf );
    System.out.println( "END (rc:" + p.waitFor() + ")" );
  }
}

