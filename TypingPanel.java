import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Math;
import java.io.*;
import java.net.*;

class TypingPanel extends JPanel implements KeyListener   {

        WordSet ws;
        Word req_word;
        int req_pick;
        Lexicon llist;
        Lexicon nlist;
        Lexicon vlist;
        GameList glist;
        StringBuffer req_str;       
        int req_index;
        int times_right;
        boolean RTS;
        boolean gameover;
        boolean removed;
        JTextField t;
        JLabel req;
        JLabel mes;
        String seedhtml;
        String levelscorehtml;
        String beatlevelhtml;
        String totalscorehtml;
        String highscorehtml;
        JLabel levelscorelabel, beatlevellabel;
        JLabel totalscorelabel, highscorelabel;
        SeedImage seedimage;
        int level, levelscore, totalscore;
        int [] beatscore;
        int highscoretobeat;



        void updateRequirement()   {

                req_str = req_word.makeStringBuffer();
                req_str.append( ' ' );
                req_index = 0;
                times_right = 0;
                req.setText( new String( req_str ) );
        }

        void resetWord()   {
                int pick;

                pick = (req_pick + 1) % ws.length;
                req_word = ws.data[pick].d;
                req_pick = pick;
                seedhtml = makeSeedHTML();
                if( seedimage != null )   {
                        seedimage.set( req_word.props );
                        seedimage.seedinfo.setText( seedhtml );
                        //seedinfo is the name of seedimage's Jlabel
                }
        }  //end function resetWord.

        void resetTypingPanel()   {
                ws = new WordSet( level, 2 + level );  
                for( int i = 0; i < ws.length; ++i )   {
                        ws.data[i].d.add();  //each has at least one letter
                }
                resetWord();  //sets the current required word, and the seedHTML
                glist = new GameList( "_" );  
                t.setText( "" );
                updateRequirement();  
                RTS = false;     
                removed = false; 
                gameover = false;
                levelscore = 0;
                levelscorehtml = makeLevelScoreHTML();
                levelscorelabel.setText( levelscorehtml );
                getScores();
                beatlevelhtml = makeBeatLevelHTML();
                beatlevellabel.setText( beatlevelhtml );
                totalscorehtml = makeTotalScoreHTML();
                totalscorelabel.setText( totalscorehtml );
                highscorehtml = makeHighScoreHTML();
                highscorelabel.setText( highscorehtml );
        }  //end function resetTypingPanel

        public TypingPanel(PointerPack labels )  {
                setLayout( new GridLayout( 3, 1 ) );
                level = 1;
                seedimage = labels.seedimage;
                levelscorelabel = labels.score1;
                beatlevellabel = labels.score2;
                totalscorelabel = labels.score3;
                highscorelabel = labels.score4;

                llist = new Lexicon( "lexicon.txt" );
                nlist = new Lexicon( "nouns.txt" );
                vlist = new Lexicon( "verbs.txt" );

                JPanel p = new JPanel();                
                mes = new JLabel( " " );
                p.add( mes );
                add( p );

                t = new JTextField( 10 );
                p = new JPanel();
                p.add( t );
                add( p );

                req = new JLabel();
                req.setHorizontalAlignment( JLabel.CENTER );
                req.setPreferredSize( new Dimension( 400, 15 ) );

                p = new JPanel();
                p.add( req );
                add( p );

                t.addKeyListener( this );
                setPreferredSize( new Dimension( 400, 80 ) );              
                beatscore = new int[3];
                for( int i = 0; i < 3; ++i )   {

                        beatscore[i] = 0;
                }
                highscoretobeat = 0;
                resetTypingPanel();
                totalscore = 0;
        }  //end TypingPanel constructor

        public void keyPressed( KeyEvent e )   {
        }

        public void keyTyped( KeyEvent e )   {

                char x;
                String newword;

                x = e.getKeyChar();
                if ( gameover )   {

                        int result;
                        boolean possiblequit;

                        writeOutScores();
                        possiblequit = true;
                        if( levelscore > beatscore[level - 1]  )   {
                                //beat the level
                                
                                totalscore = totalscore + levelscore;
                                totalscorehtml = makeTotalScoreHTML();                                totalscorelabel.setText( totalscorehtml );

                                if( totalscore > highscoretobeat )    {

                                        highscoretobeat = totalscore;
                                        highscorehtml = makeHighScoreHTML();
                                        highscorelabel.setText( highscorehtml );

                                        writeOutScores();
                                        mes.setText( "You beat the high score!" );
                                        //show a dialog here
                                }
                                if( levelAdvanceable() )   {

                                        if( level >= 3 ) totalscore = 0;
                                        level = (level % 3) + 1;
                                        possiblequit = false;
                                }
                        }
                        if( possiblequit && wantToQuit() )   {

                                System.exit( 0 );
                        }
                        else resetTypingPanel();
                }   //end case gameover
                if( x == '!' && (req_str.charAt( req_index ) == ' ') && !RTS )   {//begin case score

                        StringBuffer word;

                        word = req_word.makeStringBuffer();
                        newword = new String( word );

                        if( llist.isIn( word )
                            || nlist.isPlural( word )
                            || vlist.isRegPast( word ) )   {

                                //word already in lexicon
                                if( glist.tryToAdd( newword ) )   {
                                        //gets awarded a score
                                        int sc;

                                        sc = score( newword );
                                        mes.setText( "you scored " + sc + " points!" );

                                        levelscore = levelscore + sc;
                                        levelscorehtml = makeLevelScoreHTML();
                                        levelscorelabel.setText( levelscorehtml );
                                        RTS = true;

                                        ++ws.data[req_pick].numspent;
                                        seedhtml = makeSeedHTML();

                                        //seedimage.
                                        //check if used == 4, then possibly remove
                                        if( ws.data[req_pick].numspent >= 5 - level )   {

                                                ws.removeWordAt( req_pick );
                                                removed = true;
                                                if( ws.length <= 0 )   {

                                                        gameover = true;
                                                }
                                        }
                                } //end inner if
                                else   {
                                        mes.setText( "you have already used that word..." );
                                }                               
                        } //end outer if 
                        else   {    //implies not a word
                                mes.setText( newword + " aint no word I ever heard of!" );
                        }
                        e.consume();
                }
                else if( (x == '\n' || x == '!') && RTS && (req_str.charAt( req_index ) == ' ') )   {

                        e.consume();
                        resetWord();
                        removed = false;

                        //put the removed flag back down
                        updateRequirement();
                        RTS = false;
                        t.setText( "" );
                        mes.setText( "" );
                        repaint();
                }       
                else if( x == '?' && !RTS )   { //begin case "remove"

                        try   {
                                req_word.remove();
                        } catch( FullWordException fwe )   {
                                ws.data[req_pick] = new WordPair( level, 0 );
                                ws.data[req_pick].d.add();
                                req_word = ws.data[req_pick].d;
                                seedhtml = makeSeedHTML();
                                seedimage.set( req_word.props );
                                seedimage.seedinfo.setText( seedhtml );
                        }
                        updateRequirement();
                        e.consume();
                        t.setText( "" );
                        mes.setText( "" );
                        RTS = false;
                        repaint();                        
                } //end case remove
                else if( x == req_str.charAt( req_index ) )   { //got one right
                      if( x == ' ' )   {  //got the whole word right
                                //check if remove flag is up
                                if( removed )   {
                                        resetWord();
                                        updateRequirement();
                                        removed = false;
                                        RTS = false;
                                        req_index = 0;
                                        e.consume();
                                        t.setText( "" );
                                        mes.setText( "" );
                                        repaint();
                                        return;
                                }
                                ++times_right;

                                if( times_right >= (4 - level) )   {
                                        req_word.add();
                                        updateRequirement();
                                        e.consume();
                                }
                                else   {  //not enough times right,
                                        req_index = 0;
                                        e.consume();
                                }
                               
                                RTS = false;
                                t.setText( "" );
                                mes.setText( "" );
                                repaint();
                        }  //end case got the whole word right
                        else   {       //just one character
                                ++req_index;
                        }
                }        //end case got one right

                else   { //got it wrong: typed a character that didn't match, and wasn't ?, !, or cr
                        e.consume();                    
                        req_index = 0;
                        RTS = false;
                        t.setText( "" );
                        mes.setText( "" );
                        repaint();
                }

        }  //end function keyTyped

        public void keyReleased( KeyEvent e )   {
        } //end function keyReleased

        void appendRowString( StringBuffer b, char side )   {

                        if( level == 3 )   {

                                b.append( "1,2,3" );
                        }
                        else    {

                             int lr = ws.data[req_pick].d.props.lm + 1;
                             int rr = ws.data[req_pick].d.props.rm + 1;
                             int r = (side == 'r') ? rr : lr;
                             b.append( r );
                             if( level == 2 )   {

                                b.append( "," + (r + 1) );
                             }
                        }
        }


        String makeSeedHTML ()   {

                StringBuffer temp;
                char c;

               temp = new StringBuffer( "<html>Level: " );
               temp.append( level );
               temp.append( "<br>" );
               temp.append( "Seed: " );
               temp.append( req_pick + 1);
               temp.append( " / " );
               temp.append( level + 2 );
               temp.append( "<br>" );
               temp.append( "Used: " );
               temp.append( ws.data[req_pick].numspent + " / " );
               temp.append( 5 - level );
               temp.append( "</html>" );
               return new String( temp );
        }  //end function makeSeedHTML

        String makeLevelScoreHTML()   {
                StringBuffer temp;

                temp = new StringBuffer( "<html><center>Level Score <br>" );
                temp.append( levelscore );
                temp.append( "</center></html>" );
                return new String( temp );
        }

        String makeBeatLevelHTML()   {
                StringBuffer temp;
                temp = new StringBuffer( "<html><center>Score to Beat<br>" );
                temp.append( beatscore[level - 1] );
                temp.append( "</center></html>" );
                return new String( temp );
        }

        String makeTotalScoreHTML()   {
                StringBuffer temp;

                temp = new StringBuffer( "<html><center>Total Score<br>" );
                temp.append( totalscore );
                temp.append( "</center></html>" );
                return new String( temp );
        }

        String makeHighScoreHTML()   {

                StringBuffer temp;
                temp = new StringBuffer( "<html><center>High Score<br>" );
                temp.append( highscoretobeat );
                temp.append( "</center></html>" );
                return new String( temp );
        }

        void getScores()   {
		for( int i = 0; i < 3; ++i )   {
			beatscore[i] = 0;
		}
		highscoretobeat = 0;

		URL u;
                InputStream in;
                InputStreamReader isr;
                BufferedReader br;
                String line;
                int levelindex;
                int value;


		try   {
                        u = new URL( "http://www.tajspav.com/levelscores.txt" );
                        isr = new InputStreamReader( u.openStream() );
                        br = new BufferedReader( isr );

                        levelindex = 0;
                        while( (line = br.readLine() ) != null )   {
                                value = Integer.parseInt( line );
                                if( levelindex < 3 )   {
                                        beatscore[levelindex] = value;
                                }
                                else   { //last line.
                                        highscoretobeat = value;
                                }
                                ++levelindex;
                        }  //end while loop => end of file read
                }  //end try block.
                catch( Exception e )   {
                        //System.out.println( "Something Really wierd happened" );
                }
        }  //end function getScores

        void writeOutScores ()   {

        }  //end function writeOutScores


        int score( String s )   {
                return req_word.props.maxlen * s.length();
        }
                
        boolean levelAdvanceable()   {
                int result;
                if( level >= 3 )   {
                        result = JOptionPane.showConfirmDialog( null, "Wanna play again?" );
                        if( result != JOptionPane.YES_OPTION ) System.exit( 0 );
                        return true;
                }
                result = JOptionPane.showConfirmDialog( null, "Wanna go up a level?" );
                if( result == JOptionPane.YES_OPTION )   {

                        return true;
                }
                return false;
        }

        boolean wantToQuit()   {
                int result;
                result = JOptionPane.showConfirmDialog( null, "Wanna repeat the same level?" );
                if( result != JOptionPane.YES_OPTION )   return true;
                else return false;
        }

                        

}  //end TypingPanel class definition
