//import RefuseListNode

class WordNode  {

        char d;
        WordNode back, forward;
        RefuseListNode rlist;

        WordNode( char init_char )   {

                d = init_char;
                back = null;
                forward = null;
                rlist = null;
        }

        void print()   {

                WordNode current;

                current = this;
                while( current != null )   {

                        System.out.println( current.d );
                        System.out.print( "   " );
                        if( current.rlist != null )  {

                                current.rlist.print();
                        }
                        System.out.println();
                        current = current.forward;
                }
        }  //end function print

        WordNode goToEnd()   {

                WordNode current;

                current = this;
                while( current.forward != null )   {

                        current = current.forward;
                }
                return current;
        }  //end function goToEnd

}//end WordNode class definition
