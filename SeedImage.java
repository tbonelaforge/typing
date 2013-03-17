import javax.swing.*;
import java.awt.*;

public class SeedImage extends JPanel   {

        ImageIcon[] lpan_on = new ImageIcon[3];
        ImageIcon[] lpan_off = new ImageIcon[3];
        ImageIcon[] rpan_on = new ImageIcon[3];
        ImageIcon[] rpan_off = new ImageIcon[3];
      
        JLabel[] lpan = new JLabel[3];
        JLabel[] rpan = new JLabel[3];
        Container row1box, row2box, row3box;
        Container outerbox;
        //Container  outouterbox;
        JLabel seedinfo;
        JPanel p;

        public SeedImage()   {

                setLayout( new BorderLayout() );

                lpan_off[0] = new ImageIcon( "pan1_l-0.gif" );
                lpan_on[0] = new ImageIcon( "pan1_l-1.gif" );
                rpan_off[0] = new ImageIcon( "pan1_r-0.gif" );
                rpan_on[0] = new ImageIcon( "pan1_r-1.gif" );

                lpan_off[1] = new ImageIcon( "pan2_l-0.gif" );
                lpan_on[1] = new ImageIcon( "pan2_l-1.gif" );
                rpan_off[1] = new ImageIcon( "pan2_r-0.gif" );
                rpan_on[1] = new ImageIcon( "pan2_r-1.gif" );

                lpan_off[2] = new ImageIcon( "pan3_l-0.gif" );
                lpan_on[2] = new ImageIcon( "pan3_l-1.gif" );
                rpan_off[2] = new ImageIcon( "pan3_r-0.gif" );
                rpan_on[2] = new ImageIcon( "pan3_r-1.gif" );


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
        
