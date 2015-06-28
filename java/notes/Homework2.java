public class Homework2 {
    /*
        you can put your tests inside the static main function
     */
    public static void printNameArrays(String[] names) {
        for(int i=0; i<names.length; i++) {
            System.out.println( names[i] );
        }

    }
    public static void main(String[] args) {
        // Uncomment to test your functions below
        // For example, you could do:
        String[] names = nameMixer("George Washington", "Barack Obama", "Bill Clinton");

        printNameArrays( names );

        String[] fancyNames = nameMixer("Bob Squarepants", "Jumpy Monkey", "Harry Porter");
        printNameArrays( fancyNames );
    }

    /***
     * This function takes in three names and returns an array of new names by mixing up
     * given firstNames and lastNames and combining them into new names.
     *
     * You can't return any names that was passed into the function.
     *
     * @param name1 - a String representing a name where firstName and lastName are separated by a space.
     * @param name2
     * @param name3
     * @return an array of names (of String type) for example,
     * {"George Clinton", "Bill Washington", ... }
     */
    public static String[] nameMixer(String name1, String name2, String name3) {
        String[] result = new String[9];

        // create an array of firstNames;
        String[] firstNames = new String[3];
        firstNames[0] = name1.split(" ")[0];
        firstNames[1] = name2.split(" ")[0];
        firstNames[2] = name3.split(" ")[0];

        //create an array of lastNames;
        String[] lastNames = new String[3];
        lastNames[0] = name1.split(" ")[1];
        lastNames[1] = name2.split(" ")[1];
        lastNames[2] = name3.split(" ")[1];

        /* 
        loop through firstNames {
            grab one from firstNames assign it to fname

            loop through lastNames {
                grab one from lastNames
                assign lname 

                newName = fname + " " + lname

                result[place] = newName;
            }
        }
        */
        int index = 0;
        for(int i=0; i<3; i++) {
            String tempFirstName = firstNames[i];
            for(int j=0; j<3; j++) {
                String tempLastName = lastNames[j];

                String newName = tempFirstName + " " + tempLastName;
                result[ index ] = newName;
                index = index + 1;
            }

        }

        return result;
    }

    /***
     * This function takes our name mixer to a new level by taking
     *  an array of names and returns an array of new names by mixing up
     *  given firstNames and lastNames and combining them into new names.
     *
     * @param inNames - an array of names, where each name is a String
     * @return - an array of names, where each name is a String
     */
    public static String[] superNameMixer(String[] inNames) {


        return new String[1];
    }
}
