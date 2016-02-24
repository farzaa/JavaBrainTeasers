import com.sun.tools.javac.util.StringUtils;

import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek3
{

    ///////////////////////////////////////////
    //
    // Start of assignment code.
    //
    ///////////////////////////////////////////

    /**
     * Returns the last name, first name, and PID of the student.
     *
     * This is required in order to get credit for the programming assignment.
     */
    static String GetNameAndPID()
    {
        return("Majeed,Farzain,f3394197");
    }

    //	Problem #1
    //	Given a string and a non-empty substring sub, compute recursively if at
    //	least n copies of sub appear in the string somewhere, possibly with
    //	overlapping. N will be non-negative.

    //	subCopies("catcowcat", "cat", 2) → true
    //	subCopies("catcowcat", "cow", 2) → false
    //	subCopies("catcowcat", "cow", 1) → true

    /**
     *
     * @param str, sub, n
     * 		String str contains the original string to be tested against
     * 		String sub contains the string that is used to test against str
     * 		int n specifies how many copies of sub to check for
     *
     * @return
     * 		returns true if there are n copies of sub in str
     * 		returns false if there are not n copies of sub in str
     */


    static boolean subCopies(String str, String sub, int n) {

        //System.out.println(str);
        if(sub == null)
            return false;
        //Here I check if our string is empty or doesn't contain our sub, than we can stop!
        if(!str.contains(sub) || str.equals("") || str == null)
            if(n == 0)
                return true;
            //I return false if our str doesn't contain our sub AND n doesn't equal 0.
            else
                return false;
        //n being 0 is important because it tells us when we return.
        if(n == 0) {
            if(str.contains(sub))
                return true;
        }

        //We want to sub our string until it doens't have our sub.
        if(str.substring(0, sub.length()).contains(sub)) {
            return subCopies(str.substring(1, str.length()), sub, n-1);
        }

        return subCopies(str.substring(1, str.length()), sub, n);

    }

    //  Problem #2
    //  Given a non-negative int n, return the sum of its digits recursively 
    //  (no loops). Note that mod (%) by 10 yields the rightmost 
    //  digit (126 % 10 is 6), while divide (/) by 10 removes the 
    //  rightmost digit (126 / 10 is 12).

    //  sumDigitsInNumber(126) → 9
    //  sumDigitsInNumber(49) → 13
    //  sumDigitsInNumber(12) → 3
    
    /**
     * 
     * @param n
     *      int n contains integer to deal with.
     * 
     * @return integer
     *      integer that is the sum of each digit in int n.
     */

    static int sumDigitsInNumber(int n)
    {
        //Super simple! Just return the last digit of each number.
        if(n % 10 == n)
            return n;

        //I add on the digit I get every time.
        return (n % 10) + sumDigitsInNumber(n / 10);
    }

    //  Problem #3
    //  Given base and n that are both 1 or more, compute recursively (no loops) 
    //  the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    //  exponential(3, 1) → 3
    //  exponential(3, 2) → 9
    //  exponential(3, 3) → 27
    
    /**
     * 
     * @param base, n
     *      int base containing the base of the term
     *      int n containing the exponent of the term
     * 
     * @return integer
     *      integer that corresponds with equating base to the n power
     */

    static int exponential(int base, int n)
    {
        //I want to keep on going until n == 1
        if (n == 0)
            return 1;
        if(n == 1)
            return base;

        //I multiply my base over and over again until n = 1 than we stop!
        return base * exponential(base, n-1);
    }

    static int exponential(int base, int n) 
    {
    }   

    //  Problem #4
    //  Given a string, compute recursively (no loops) a new string 
    //  where all the lowercase 'x' chars have been changed to 'y' chars. 

    //  changeXtoY("codex") → "codey"
    //  changeXtoY("xxhixx") → "yyhiyy"
    //  changeXtoY("xhixhix") → "yhiyhiy"
    
    /**
     * 
     * @param str
     *      String containing original string of chars to deal with
     * 
     * @return String
     *      String of characters where the lowercase x's have been changed to y's
     */

    public static String changeXtoY(String str)
    {
        //Here is when we know to stop!
        if(str == null || str.equals(""))
            return "";

        //if we find an x, add a y to our string and lets move along!
        if (str.substring(0, 1).contains("x"))
            return "y" + changeXtoY(str.substring(1, str.length()));

        //The string I return goes char by char and checks whats x or y.
        return str.substring(0, 1) + changeXtoY(str.substring(1, str.length()));
    }

    public static String changeXtoY(String str) 
    {
    }
    
    //  Problem #5
    //  Given an array of ints, compute recursively if the array 
    //  contains a 6. We'll use the convention of considering only 
    //  the part of the array that begins at the given index. 
    //  In this way, a recursive call can pass index+1 to move down 
    //  the array. The initial call will pass in index as 0. 

    //  find6({1, 6, 4}, 0) → true
    //  find6({1, 4}, 0) → false
    //  find6({6}, 0) → true    
    
    /**
     * 
     * @param nums, index
     *      int[] list containing the original array of numbers
     *      int containing the position to start in nums
     * 
     * @return boolean
     *      returns true if a 6 is found in the array
     *      returns false if no 6 is found in the array
     */

    static boolean find6(int[] nums, int index)
    {
        //I dont wanna go out of bounds!
        if(index > nums.length - 1)
            return false;
        //If we get a 6 then we win!
        if(nums[index] == 6) {
            return true;
        }

        //Add to the index by 1 everytime to move along the array.
        return find6(nums, index + 1);

    }

    //  Problem #7
    //  We'll say that a "pair" in a string is two instances of 
    //  a char separated by a char. So "AxA" the A's make a pair. 
    //  Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for 
    //  A and 1 for x. Recursively compute the number of 
    //  pairs in the given string.  

    //  numberPairs("axa") → 1
    //  numberPairs("axax") → 2
    //  numberPairs("axbx") → 1
    
    /**
     * 
     * @param str
     *      String containing the original chars provided
     * 
     * @return 
     *      int with the number of pairs as defined above
     */

    static String insertAsterisk(String str)
    {
        if(str == null || str.equals(""))
            return "";
        //I do this so that we don't go out of bounds and our last char doesn't get an
        //asterick after it.
        if(str.length() < 2)
            return str.substring(0, 1);
        //I simple make the string char by char.
        return str.substring(0, 1) + "*" + insertAsterisk(str.substring(1, str.length()));
    }

    //  Problem #7
    //  We'll say that a "pair" in a string is two instances of 
    //  a char separated by a char. So "AxA" the A's make a pair. 
    //  Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for 
    //  A and 1 for x. Recursively compute the number of 
    //  pairs in the given string.  

    //  numberPairs("axa") → 1
    //  numberPairs("axax") → 2
    //  numberPairs("axbx") → 1
    
    /**
     * 
     * @param str
     *      String containing the original chars provided
     * 
     * @return 
     *      int with the number of pairs as defined above
     */
    static int numberPairs(String str)
    {
        //in case graders get sneaky.
        if (str == null)
            return 0;
        if(str.length() < 3)
            return 0;

        //First i figure out what we are working with.
        char first = str.charAt(0);
        char middle = str.charAt(1);
        char second = str.charAt(2);

        //Than I check if everything is a char;
        if((first == second) && Character.isLetter(first)  && Character.isLetter(middle)) {
            return 1 + numberPairs(str.substring(1, str.length()));
        }

        return numberPairs(str.substring(1, str.length()));
    }

        //  Problem #8
    //  Given a string, return recursively a "cleaned" string where 
    //  adjacent chars that are the same have been reduced 
    //  to a single char. So "yyzzza" yields "yza".  

    //  reduceChars("yyzzza") → "yza"
    //  reduceChars("abbbcdd") → "abcd"
    //  reduceChars("Hello") → "Helo"
    
    /**
     * 
     * @param str
     *      String containing the original chars
     * 
     * @return 
     *      String with all repeated, adjacent chars are removed
     */

    static String reduceChars(String str)
    {
        if(str.equals("") || str == null)
            return "";

        //I wanna store that char I find to check later.
        String firstChar = str.substring(0, 1)
;        //while the rest of our string contains that first char
        while(str.substring(1, str.length()).contains(firstChar)) {
                //By doing this I can skip all of the same char.
                str = str.substring(1, str.length());
        }
        //I go char by char.
        return firstChar + reduceChars(str.substring(1, str.length()));
    }

        //  Problem #9
    //  Given a string, return true if it is a nesting of zero or more 
    //  pairs of parenthesis, like "(())" or "((()))". Suggestion: 
    //  check the first and last chars, and then recur on what's inside them.  

    //  nestedParens("(())") → true
    //  nestedParens("((()))") → true
    //  nestedParens("(((x))") → false
    
    /**
     * 
     * @param str
     *      String containing the original chars
     * 
     * @return 
     *      returns true if there are zero or more pairs of parenthesis
     *      returns false if there are not zero or more pairs of parenthesis
     */

    static boolean nestedParens(String str)
    {
        if (str == null)
            return false;

        if(str.equals(""))
            return true;

        for(int i = 0; i < str.length(); i++) {
            //First I wanna check if our string contains parens.
            if(Character.getType(str.charAt(i)) == 21 || Character.getType(str.charAt(i)) == 22) {
                ;
            }
            //If its not a paren, we return false;
            else
                return false;
        }
        //Here i check if we have matching parens on opposite sides of the string.
        if(str.substring(0, 1).equals("(") && str.substring(str.length() - 1, str.length()).equals(")")) {
            //Substring by both opposite sides by 1 char every time.
            return nestedParens(str.substring(1, str.length() - 1));
        }
        else
            return false;
    }

    //  Problem #10

    //  Given a string and a non-empty substring sub, compute 
    //  recursively the largest substring which starts and 
    //  ends with sub and return its length.  

    //  subStrSub("catcowcat", "cat") → 9
    //  subStrSub("catcowcat", "cow") → 3
    //  subStrSub("cccatcowcatxx", "cat") → 9
    
    /**
     * 
     * @param str, sub
     *      String containing the original chars to be tested against
     *      String containing the original chars to test with
     * 
     * @return 
     *      integer containing the largest number of chars in string 
     *      that start and end with sub
     */

    static int subStrSub(String str, String sub)
    {
        //This saves us from the trickery of the graders!
        if (str == null)
            return 0;
        if (sub == null)
            return 0;
        if(str.equals(""))
            return 0;

        //We don't want to go out of bounds!
        if(str.length() >= sub.length()) {
            //Lets check if our sub is contained at this point.
            String string = str.substring(0, sub.length());

            //If the string we just made contains our sub than figure out where it is!
            if (string.equals(sub)) {
                if (str.indexOf(sub, 2) == -1)
                    return sub.length();
                else
                    //return index of the sub at that point in the str
                    return str.indexOf(sub, 2) + subStrSub(str.substring(str.indexOf(sub, 2)), sub);
            }

            else
                //Lets go char by char.
                return subStrSub(str.substring(1), sub);
        }

        return 0;
    }



    public static void main(String args[]) {
        int test;
        //int array[] = {6};
        //boolean test;
        //String test;
        //test = subCopies("catcowcat", "cow", 1);
        //test = sumDigitsInNumber(12);
        //test = exponential(3, 2);
        //test = changeXtoY("xhixhix");
        //test = find6(array, 0);
        //test = insertAsterisk("hello");
        //test = numberPairs("axbx");
        //test =  reduceChars("abbbcdd");
        //test = nestedParens("(A)");
        test = subStrSub("catcowcat", "cow");
        System.out.println(test);

        //String str = "hahawowhawow";
        //System.out.println(str.indexOf("ha"));


       // if(str.substring(0, 1).equals("(") && str.substring(str.length() - 1, str.length()).equals(")")) {
       //     if(str.contains)
       // }
        //System.out.println(Character.getType('('));
    }

  }