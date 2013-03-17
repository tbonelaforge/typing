class LinkedString   {

        String d;
        LinkedString next;

        LinkedString()   {

                d = null;
                next = null;
        }

        LinkedString( String init )   {

                d = new String( init );
                next = null;
        }

        void add( String init )   {

                LinkedString current;

                current = this;
                while( current.next != null )   {

                        current = current.next;
                }
                //found the end.
                if( current.d == null )   {  //the first one

                        current.d = new String( init );
                        
                }
                else   {//need to make a new one

                        LinkedString temp = new LinkedString( init );
                        current.next = temp;
                }
        }//end function add

        void add( StringBuffer init )   {

                String temp = new String( init );
                add( temp );
        }

        LinkedString add( LinkedString init )   {

                LinkedString current = this;
                while( current.next != null )   {

                        current = current.next;
                }
                if( current.d == null )   { //first one

                        return init;
                }
                else   {

                        current.next = init;
                        return this;
                }
        }//end function add (with LinkedStrings)                
        void print()   {

                LinkedString current = this;
                while( current != null )   {

                        System.out.println( current.d == null ? "nothing" : current.d );
                        current = current.next;
                }
        }//end function print
}//end linked String class definition

                        
