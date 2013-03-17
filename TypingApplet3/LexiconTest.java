class LexiconTest   {

        public static void main( String [] args )   {

                Lexicon testlex;
                testlex = new Lexicon( "http://www.tajspav.com/verbs.txt" );
		testlex.print();
                
/*               
		testlex.build( "WordLists/noun_communication.txt", false );
                testlex.build( "WordLists/noun_event.txt", false );
                testlex.build( "WordLists/noun_feeling.txt", false );
                testlex.build( "WordLists/noun_food.txt", false );
                testlex.build( "WordLists/noun_group.txt", false );
                testlex.build( "WordLists/noun_location.txt", false );
                testlex.build( "WordLists/noun_motive.txt", false );
                testlex.build( "WordLists/noun_object.txt", false );
                testlex.build( "WordLists/noun_person.txt", false );
                testlex.build( "WordLists/noun_phenomenon.txt", false );
                testlex.build( "WordLists/noun_plant.txt", false );



                testlex.build( "WordLists/noun_possesion.txt", false );
                testlex.build( "WordLists/noun_process.txt", false );
                testlex.build( "WordLists/noun_quantity.txt", false );
                testlex.build( "WordLists/noun_relation.txt", false );
                testlex.build( "WordLists/noun_shape.txt", false );
                testlex.build( "WordLists/noun_state.txt", false );
                testlex.build( "WordLists/noun_substance.txt", false );
                testlex.build( "WordLists/noun_time.txt", false );
                testlex.build( "WordLists/noun_tops.txt", false );

*/

//                testlex.print();
                /*                
                StringBuffer newword = new StringBuffer( "xc" );
                System.out.println( newword + " is " + testlex.isIn( newword ) + "ly in the list " );
                System.out.println( newword + " is " + testlex.isPlural( newword ) + "ly a plural " );
                System.out.println( newword + " is " + testlex.isRegPast( newword ) + "ly a regular past tense verb" );
                */
                
                System.exit( 0 );
        }//end function main
}//end LexiconTest class definition
