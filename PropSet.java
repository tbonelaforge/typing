//import  MyRandom;

class PropSet   {

        int d;  //for difficulty, can be 1, 2, or 3
        int lm, rm;  /*depends on difficulty: if d=1, can be 0,1, or 2,
                      if d=2, can be 0, or 1. else always zero.*/
        char which_side;  //can be 'l', 'r', or 'b'.
        int maxlen;

        static MyRandom randy = new MyRandom ();
        static char [] lside = {'q', 'w', 'e', 'r', 't',
                                'a', 's', 'd', 'f', 'g',
                                'z', 'x', 'c', 'v', 'b'};

        static char [] rside = {'y', 'u', 'i', 'o', 'p',
                                'h', 'j', 'k', 'l', ';',
                                'n', 'm', ',', '.', '/'};





/****************************************************************************
PropSet( int init_diff ):    initial value constructor, should create a randomized
                     lm and rm value based on the assigned difficulty,
                     as well as randomly picking a side.
****************************************************************************/

        PropSet( int init_diff )   {

                lm = rm = 0;
                d = init_diff;
                int temp1, temp2;
                temp2 = randy.myNextInt( 0, 3-d );
                if( (temp1 = randy.myNextInt( 0, 3 )) == 0 )   {//1/4 the time

                        which_side = 'l';
                        lm = temp2;
                }
                else if( temp1 == 1 )   { //1/4 the time

                        which_side = 'r';
                        rm = temp2;
                }
                else   {  //half the time

                        which_side = 'b';
                        lm = temp2;
                        rm = randy.myNextInt( 0, 3-d );
                }
                maxlen = calcMax();

        }  //end valued constructor.



/****************************************************************************
calcSubractor:     determines the amount of non-letter characters that
                   should be eliminated from the total refuse-list count
****************************************************************************/

        int calcSubtractor( )   {  //only should get called when side is r or b

                if( (d == 1 && rm == 1) || (d == 2 && rm == 0) )  {

                        return 1;
                }
                else if( d == 1 && rm == 2 )  {

                        return 3;
                }
                else if( (d == 2 && rm == 1) || d == 3 /*rm can be either three values */ )   {

                        return 4;
                }
                else   { // d == 1 && rm == 0

                        return 0;
                }
        }   //end functiong calc Subtractor

                

/****************************************************************************
calcMax:                //returns the maximum number of characters that can
                          //be in a refuse list associated with a wor_node
                          // with these properties.
****************************************************************************/

        public int calcMax ()   {

                int subtractor = 0;
                int tempmax = 0;

                if( which_side == 'b' )   {

                        tempmax = 10*d;
                        subtractor = calcSubtractor();
                }
                else   {  //side is l or r

                        tempmax = 5*d;
                        if( which_side == 'r' )   {

                                subtractor = calcSubtractor();
                        }
                        else   {  //side is left, no subtractor

                                subtractor = 0;
                        }
                }
                return tempmax - subtractor;
        }  //end function calcMax

        void print()   {

                System.out.print( "The difficulty is : " + d + "\n" );
                System.out.print( "With lm = " + lm + " and rm = " + rm + "\n" );
                System.out.print( "And the side is: " + which_side + "\n" );
                System.out.print( "And the max length for a refuse list is: " + maxlen + "\n" );
                System.out.print( "the random number generator has address: " + randy + "\n" );
        }  //end function print.
/****************************************************************************
genRSideChar: Weeds out the non-letter characters on the right-hand side of
              the keyboard.
****************************************************************************/

        char genRSideChar()   {

                char temp;

                do   {

                        temp = rside[randy.genPick( rm, d )];
                }
                while( temp == ';' || temp == ',' || temp == '.'
                                || temp == '/' );
                return temp;
        }


/****************************************************************************
genChar: Produces a random character that is not a ';', ',', '.', or '/'
        by using the current values in it's PropSet.
****************************************************************************/

        char genChar()   {
                
                char temp;
                if( which_side == 'l' )   {

                        return lside[randy.genPick( lm, d )];
                }
                else if( which_side == 'r' )  {

                        return genRSideChar();
                }
                else   {//could be either side

                        int side_decide = randy.myNextInt( 0, 1 );
                        if( side_decide == 0 )   { //left

                                return lside[randy.genPick( lm, d )];
                        }
                        else   {   //this one's right

                                return genRSideChar();                                                     
                        }
                }  //end else
        } //end function genChar

}  //end PropSet Class Definition

