import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.BorderLayout;


class PointerPack   {

        TypingPanel tpan;
        JLabel score1, score2, score3, score4;
	SeedImage seedimage;

        PointerPack()   {

                tpan = null;
                score1 = null;
                score2 = null;
                score3 = null;
                score4 = null;
		seedimage = null;
        }
}

class TypingGUI extends JPanel   {

        PointerPack pack;

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
		add( si, BorderLayout.CENTER );
		pack.seedimage = si;
                
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
                p.add( pack.tpan );
                add( p, BorderLayout.NORTH );
        }  //end TypingGUI constructor


}  //end TypingGUI class definition
