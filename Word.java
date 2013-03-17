//import WordNode;
//import PropSet;

class Word   {

        WordNode data;
        PropSet props;

        Word( int diff )   {

                props = new PropSet( diff );
                data = new WordNode( '_' );
                print();
        }

        void print()   {

                props.print();
                data.print();
        }

        void add()   {

                WordNode end, temp;
                char c;

                end = data.goToEnd();
                do  {

                        c = props.genChar();
                }
                while( end.rlist != null && end.rlist.search( c ) );
                temp = new WordNode( c );
                temp.back = end;
                end.forward = temp;
        }  //end function add

/****************************************************************************
remove: This function finds the last WordNode in this word's linked list of
        Word Nodes, takes it's character data, and removes that Node.
        Then it adds the character to the second-to-last WordNode's rlist
        by making a new RefuseListNode, and linking it to the last.
        If ,by doing this, you have filled up the second-to-last WordNode's
        refuse list, then remove will call itself.  If you are trying to
        remove the first Node in the list (_) this function will throw
        an exception.
***************************************************************************/

        void remove() throws FullWordException   {

                WordNode wend, wend2;
                RefuseListNode rend, temp;

                wend = data.goToEnd();
                wend2 = wend.back;

                if( wend.d == '_' )   {

                        throw new FullWordException();
                }
                temp = new RefuseListNode( wend.d );
                if( wend2.rlist == null )   { //the second to last node
                                              //has no refused characters
                                              //so far

                        wend2.rlist = temp;
                }
                else   {  //there is a list to add to on the second-to-last

                        rend = wend2.rlist.goToEnd();
                        rend.next = temp;
                }
                wend2.forward = null;  //remove last node
                //now check if filled up
                if( wend2.rlist.count() >= props.maxlen )   {

                        remove();  //okay, because just shortened it
                }
                if( wend2.d == '_' )   {

                        add();
                }
        } //end function remove

        StringBuffer makeStringBuffer()   {

                int c, i;
                StringBuffer tempbuf;
                WordNode current;

                tempbuf = new StringBuffer();
                current = data;
                i = 0;
                while( current != null )   {

                        if( current.d != '_' )   {

                                tempbuf.append( current.d );
                                ++i;
                        }
                        current = current.forward;
                }
                return tempbuf;
        } //end function makeStringBuffer


} //end Word class definition
