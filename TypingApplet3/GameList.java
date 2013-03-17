//this will be the class that keeps track of all the words used
//in a particular game

class GameList   {

        String data;
        GameList next;

        GameList( String initstring )   {

                data = initstring;
                next = null;
        }

/****************************************************************************
search: Returns true if the target is found, false if not found
****************************************************************************/

        boolean search( String target )   {

                GameList current;

                current = this;
                while( current != null )   {

                        if( current.data.compareTo( target ) == 0 )   {

                                return true;
                        }

                        current = current.next;
                }
                return false;
        }  //end function search

        boolean tryToAdd( String newdata )   {

                GameList temp;
                GameList current;
                boolean found;

                temp = new GameList( newdata );
                current = this;
                found = false;
                while( current.next != null )   {

                        if( current.data.compareTo( newdata ) == 0 )   {

                                found = true;
                                break;
                        }
                        current = current.next;
                }  //while loop end => current points to last one, or already found 
                if( !found )   { //one  more chance to fine the word

                        if( current.data.compareTo( newdata ) != 0 )   {

                                current.next = temp;                                
                                //print();
                                return true;
                        }
                }                  
                return false;
        }  //end function tryToAdd

        void print()   {

                GameList current;
                current = this;
                while( current != null )   {

                        System.out.println( current.data );
                        current = current.next;
                }
        }//end function print


}  //end GameList class definition


