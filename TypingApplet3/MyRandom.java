import java.util.*;


class MyRandom extends Random   {

        MyRandom()   {

                super ();
        }

        int myNextInt( int bl, int bu )   {

                int range = bu-bl;
                return bl + nextInt( range + 1 );
        }

        public int genPick( int m, int d )   {

                return myNextInt( 5*m, (5*m + 5*d - 1) );
        }
}  //end MyRandom class Definition
