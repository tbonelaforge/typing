class RefuseListNode  {

        char d;
        RefuseListNode next;

        RefuseListNode( char init_char )   {

                d = init_char;
                next = null;
        }

        void print()   {

                RefuseListNode current;

                current = this;
                while( current != null )   {

                        System.out.print( current.d );
                        current = current.next;
                }
                System.out.println();
        }  //end function print

        RefuseListNode goToEnd()   {

                RefuseListNode current;

                current = this;
                while( current.next != null )   {

                        current = current.next;
                }
                return current;
        }  //end function goToEnd

        boolean search( char t )   {

                RefuseListNode current;

                current = this;
                while( current != null )   {

                        if( current.d == t )   {

                                return true;
                        }
                        current = current.next;
                }
                return false;
        }  //end function search

        int count()   {

                RefuseListNode current;
                int tempcount;

                current = this;
                tempcount = 0;
                while( current != null )   {

                        ++tempcount;
                        current = current.next;
                }
                return tempcount;
        }  //end function count.

}   //end RefuseListNode class definition
