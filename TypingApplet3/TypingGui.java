import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.BorderLayout;


class PointerPack   {

        TypingPanel tpan;
        JLabel score1, score2, score3, score4;
        //JLabel seedlabel;
	SeedImage seedimage;

        PointerPack()   {

                tpan = null;
                //seedlabel = null;
                score1 = null;
                score2 = null;
                score3 = null;
                score4 = null;
		seedimage = null;
        }
}

class TypingGUI extends JPanel   {

        PointerPack pack;
        /*
        TypingPanel tpan;
        JLabel seedlabel;
        */


        public TypingGUI()   {

                int borderwidth;
                JPanel p;
                JLabel l; JLabel temp;
		SeedImage si;


                pack = new PointerPack();
                setLayout( new BorderLayout() );
                borderwidth = 1;

                


                p = new JPanel();
                p.setLayout( new GridLayout( 2, 1 ) );
                l = new JLabel( "Default", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                pack.score1 = l;


                l = new JLabel( "Score to Beat", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                pack.score2 = l;

                add( p, BorderLayout.WEST );



                
		si = new SeedImage();
                si.setBorder( new LineBorder( Color.black, borderwidth ) );
                //si.setPreferredSize( new Dimension( 200, 80 ) );
		add( si, BorderLayout.CENTER );
		pack.seedimage = si;
		//l = new JLabel( "default", JLabel.CENTER );
                //l.setBorder( new LineBorder( Color.black, borderwidth ) );
                //add( l, BorderLayout.CENTER );
                //l.setVisible( true );
                //pack.seedlabel = l;

                
                p = new JPanel();
                p.setLayout( new GridLayout( 2, 1 ) );
                l = new JLabel( "Total Score", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                pack.score3 = l;





                l = new JLabel( "High Score", JLabel.CENTER );
                l.setBorder( new LineBorder( Color.black, borderwidth ) );
                p.add( l );
                pack.score4 = l;
                add( p, BorderLayout.EAST );

		p = new JPanel();
                pack.tpan = new TypingPanel( pack );
                //tpan.seedinfo = seedlabel;
                p.add( pack.tpan );
                add( p, BorderLayout.NORTH );
                                

        }  //end constructor


        /*
        void resetTypingPanel()   {

                JPanel p;
                
                Container c;
                Component temp;


                c = (Container) getComponent( 1 );  //the second component added should have been a TypingPanel-holding JPanel
                if( c == null )    {

                        p = new JPanel();
                        tpan = new TypingPanel( this, seedlabel );              
                        p.add( tpan );
                        add( p, BorderLayout.NORTH );
                }
                else   {


                        tpan.t.removeKeyListener( tpan );
                        temp = c.getComponent( 0 );  //this should be the old TypingPanel
                        
                        c.remove( temp );
                        tpan = new TypingPanel( this, seedlabel );
                        c.add( tpan );
                        revalidate();
                }
                        
        }//end function resetTypingPanel
        */


}  //end TypingGUI class definition
