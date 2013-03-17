import javax.swing.*;
import java.awt.*;
import java.net.*;

public class SeedImage extends JPanel   {

        ImageIcon[] lpan_on = new ImageIcon[3];
        ImageIcon[] lpan_off = new ImageIcon[3];
        ImageIcon[] rpan_on = new ImageIcon[3];
        ImageIcon[] rpan_off = new ImageIcon[3];
        
        URL url;
      
        JLabel[] lpan = new JLabel[3];
        JLabel[] rpan = new JLabel[3];
        Container row1box, row2box, row3box;
        Container outerbox;
        //Container  outouterbox;
        JLabel seedinfo;
        JPanel p;
        String filename;
        String codebase;  // string here, whereas in the Applet class, it is a static URL object

        public SeedImage()   {

                setLayout( new BorderLayout() );

		for( int i=0; i<3; ++i ) {
		    
		try {
                
		    codebase = TypingApplet.codebase.toString();
		    //System.out.println( "I think the code base is " + codebase );
		    filename = codebase + "pan" + (i+1) + "_l-0.gif";
		    //System.out.println( "I think the file name is " + filename );
		    url = new URL( filename );
		    lpan_off[i] = new ImageIcon( url );

		    filename = codebase + "pan" + (i+1) + "_l-1.gif";
		    //filename = "http://www.tajspav.com/pan" + (i+1) + "_l-1.gif";
		    url = new URL( filename );
		    lpan_on[i] = new ImageIcon( url );

		    filename = codebase + "pan" + (i+1) + "_r-0.gif";
		    //filename = "http://www.tajspav.com/pan" + (i+1) + "_r-0.gif";
		    url = new URL( filename );
		    rpan_off[i] = new ImageIcon( url );

		    filename = codebase + "pan" + (i+1) + "_r-1.gif";
		    //filename = "http://www.tajspav.com/pan" + (i+1) + "_r-1.gif";
		    url = new URL( filename );
		    rpan_on[i] = new ImageIcon( url );
		}//end try statement		
		catch( MalformedURLException murle ) {

		    System.out.println( "there was a malformed url" );
		}
		}//end for loop



                seedinfo = new JLabel( "<html>Seed:*<br>used:*/*</html>", JLabel.CENTER );
                //set border and add?
                //outouterbox = Box.createVerticalBox();
                //outouterbox.add( seedinfo );
                p = new JPanel();
                p.add( seedinfo );
                add( p, BorderLayout.NORTH );
                //outerbox = new JPanel();
                //outerbox.setLayout( new BorderLayout() );
                outerbox = Box.createVerticalBox();
                row1box = Box.createHorizontalBox();                                
                lpan[0] = new JLabel( lpan_off[0] );
                row1box.add( lpan[0] );
                rpan[0] = new JLabel( rpan_off[0] );
                row1box.add( rpan[0] );
                outerbox.add (row1box);

                row2box = Box.createHorizontalBox();
                lpan[1] = new JLabel( lpan_off[1] );
                row2box.add( lpan[1] );
                rpan[1] = new JLabel( rpan_off[1] );
                row2box.add( rpan[1] );
                outerbox.add (row2box);

                row3box = Box.createHorizontalBox();
                lpan[2] = new JLabel( lpan_off[2] );
                row3box.add( lpan[2] );
                rpan[2] = new JLabel( rpan_off[2] );
                row3box.add( rpan[2] );
                outerbox.add (row3box);
                //outerbox.setMinimumSize( new Dimension( 200, 60 ) );

                p = new JPanel();
                p.add( outerbox );
                p.setMinimumSize( new Dimension( 200, 60 ) );
                p.setPreferredSize( new Dimension( 200, 60 ) );
                //outouterbox.add( outerbox );
                add( p, BorderLayout.CENTER );
                //add( outouterbox );
                p = new JPanel();
                p.add( new JLabel( "<html>&copy; T. Ford</html>", JLabel.CENTER ) );
                add( p, BorderLayout.SOUTH );                                        

        }  //end constructor

        public static void main( String [] args )   {

                SeedImage seedimage;
                PropSet p;
                JFrame frame = new JFrame( "Border1" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setSize( 360, 200 );
                frame.setLocation( 200, 200 );
                seedimage = new SeedImage();
                frame.setContentPane( seedimage );
                frame.setVisible( true );
                p = new PropSet( 1 );
                p.print();
                seedimage.set( p );

        }  //end main function


        public void set( PropSet p )   {

        int row;
        char c;
        c = p.which_side;
        JLabel l,r;
        for( row = 0; row < 3; ++row )    { //loop through the rows

                //decide the fate of this row's panels
                l = lpan[row];
                r = rpan[row];
                if (c == 'l' )   {

                        r.setIcon( rpan_off[row] );
                        if( (p.lm+1 <= row+1) && (row+1 <= p.lm+p.d) )   {
                                //left panel within range

                                l.setIcon( lpan_on[row] );
                        }
                        else   {

                                l.setIcon( lpan_off[row] );
                        }

                }   //end case left side
                else if (c == 'r' )   {

                        l.setIcon( lpan_off[row] );
                        if( (p.rm+1 <= row+1) && (row+1 <= p.rm+p.d) )   {
                                  //right panel within range

                                r.setIcon( rpan_on[row] );
                        }
                        else   {

                                r.setIcon( rpan_off[row] );
                        }

                }    //end case right side
                else   {  //side is both

                        if( (p.rm+1 <= row+1) && (row+1 <= p.rm+p.d) )   {
                                  //right panel within range

                                r.setIcon( rpan_on[row] );
                        }
                        else   {

                                r.setIcon( rpan_off[row] );
                        }
                        if( (p.lm+1 <= row+1) && (row+1 <= p.lm+p.d) )   {
                                //left panel within range

                                l.setIcon( lpan_on[row] );
                        }
                        else   {

                                l.setIcon( lpan_off[row] );
                        }
                }  //end case both
        }//end for loop

        }//end set function

                
                

}  //end SeedImage class definition
        
