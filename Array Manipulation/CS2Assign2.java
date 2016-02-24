import java.util.Arrays;

/**
 * Created by m on 1/21/16.
 */
public class CS2Assign2 {

    static String GetNameAndPID()
    {
        return( "Majeed, Farzain, f3394197");
    }

        //  Problem #1
    // Directions: Return true if the array contains, somewhere,
    // three increasing consecutive numbers like ....4, 5, 6,... or
    // 23, 24, 25.

    //  FindThreeIncreasingNumbers({1, 4, 5, 6, 2}) → true
    //  FindThreeIncreasingNumbers({1, 2, 3}) → true
    //  FindThreeIncreasingNumbers({1, 2, 4}) → false
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return
     *      returns true if there are three increasing consecutive numbers
     *      returns false if there are not three increasing consecutive numbers
     */
    static boolean FindThreeIncreasingNumbers(int[] NumberList)
    {
        int length = NumberList.length;
        //I use a simple for loop to iterate through the array.
        for(int i = 0; i < length; i++) {

            //I don't want to go out of bounds when I'm looking for my numbers.
            if(i+1 > length || i+2 > length || i+3 > length) {
                break;
            }

            //I have the NumberList[i] + 1 here because I check if it equals the number in the next
            //index, this way I know its increasing by 1. I do this again for indices 2 and 3.
             if(NumberList[i] + 1  == (NumberList[i+1]))
                if(NumberList[i+1] + 1 == NumberList[i+2])
                    return true;
        }

        return false;
    }

        //  Problem #2
    //  For each multiple of 10 in the given array, change all the values 
    //  following it to be that multiple of 10, until encountering another 
    //  multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.

    //  multiplesOfTen({2, 10, 3, 4, 20, 5}) → {2, 10, 10, 10, 20, 20}
    //  multiplesOfTen({10, 1, 20, 2}) → {10, 10, 20, 20}
    //  multiplesOfTen({10, 1, 9, 20}) → {10, 10, 10, 20}
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return NumberList
     *      int[] list of the same numbers changed to multiples of
     *      ten as they are encountered.
     */

    static int[] multiplesOfTen(int[] NumberList)
    {
        int length = NumberList.length;
        int value = 0;
        int index;

        //I use a simple for loop to iterate through the array.
        for(int i = 0; i < length; i++) {

            //I don't want to go out of bounds!
            if (i + 1 > length)
                return NumberList;
            //This checks if something is divisble by 10.
            if(NumberList[i] % 10 == 0) {
                //I want to keep track of the value.
                value = NumberList[i];
                //This index is basically keeps track of where the number was found.
                index = i + 1;

                //Going out of bounds is bad!!
                if(index > length)
                    return NumberList;

                //This for loop now goes out and changes the numbers not divible by 10.
                for(int j = index; j < length; j++) {

                    if(NumberList[index] % 10 != 0) {
                        NumberList[index] = value;
                    }

                    //The for loop breaks if a number that is divisible by 10 is found.
                    else
                        break;
                }
            }

            //Not divisible by 10? Lets move on.
            else
                continue;
        }

        return NumberList;
    }

    //  Problem #3
    //  We'll say that an element in an array is "alone" if there are 
    //  values before and after it, and those values are different 
    //  from it. Return a version of the given array where every instance 
    //  of the given value which is alone is replaced by whichever 
    //  value to its left or right is larger.

    //  CheckForAloneNumbers({1, 2, 3}, 2) → {1, 3, 3}
    //  CheckForAloneNumbers({1, 2, 3, 2, 5, 2}, 2) → {1, 3, 3, 5, 5, 2}
    //  CheckForAloneNumbers({3, 4}, 3) → {3, 4}
    
    /**
     * 
     * @param NumberList, changingNumber
     *      int[] list containing some numbers.
     *      int value of the number that should change in the array.
     * 
     * @return NumberList
     *      int[] list of numbers where every occurrence of changingNumber
     *      has been replaced by the larger of its two neighbors.
     */

    static int[] CheckForAloneNumbers(int[] NumberList, int changingNumber)
    {
        int length = NumberList.length;
        if(length <= 1)
            return NumberList;

        //I use a simple for loop to iterate through the array.
        for(int i = 1; i < length; i++) {
            //As always, going out of bounds sucks.
            if( i + 2 > length)
                break;
            //Lets check if anything matches our number!
            if(NumberList[i] == changingNumber) {

                //If left is greater than right, then lets set our middle to left.
                if(NumberList[i-1] > NumberList[i+1]) {
                    NumberList[i] = NumberList[i-1];
                }

                //If right is greater than left, than lets set our middle to right.
                if(NumberList[i-1] < NumberList[i+1]) {
                    NumberList[i] = NumberList[i+1];
                }

            }
        }

        return NumberList;

    }

    //  Problem #4
    //  Return a version of the given array where each zero value in 
    //  the array is replaced by the largest odd value to the right 
    //  of the zero in the array. If there is no odd value to the 
    //  right of the zero, leave the zero as a zero. 

    //  ReplaceZerosWithLargestOdd({0, 5, 0, 3}) → {5, 5, 3, 3}
    //  ReplaceZerosWithLargestOdd({0, 4, 0, 3}) → {3, 4, 3, 3}
    //  ReplaceZerosWithLargestOdd({0, 1, 0}) → {1, 1, 0}
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return NumberList
     *      int[] list containing the numbers where the zeros have been
     *      replaced with the largest odd number to the right of them.
     */

    public static int[] ReplaceZerosWithLargestOdd(int[] NumberList)
    {
        int length = NumberList.length, index = 0;
        boolean foundOdd = false;

        //I use a simple for loop to iterate through the array.
       for( int i = 0; i < length; i++) {

           //Trust me when I say going out of bounds is bad.
           if( i + 1 > length)
               break;

           //If I find a zero
           if (NumberList[i] == 0) {

               //I wanna keep track of my biggest odd number.
               int largestOdd = 0;
               //i strt at j+1 to to "backtrack" in my array when I find an odd.
               for(int j = i+1; j < length; j++) {

                   //I use a "found odd" flag
                   if(NumberList[j] == 0 && foundOdd) {
                       break;
                   }

                   if(NumberList[j] == 0 && foundOdd == false) {
                       continue;
                   }

                   //This is when I find an odd!
                   if(NumberList[j] % 2 == 1) {
                       //Here is how I find the largest odd!
                       if (NumberList[j] > largestOdd) {
                           largestOdd = NumberList[j];
                       }
                       //I set my index to the largest odd.
                       NumberList[i] = largestOdd;
                       foundOdd = true;
                   }
               }
           }
       }
        return NumberList;
    }

    //  Problem #5
    //  Given start and end numbers, return a new array containing 
    //  the sequence of integers from start up to but not including end, 
    //  so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number 
    //  will be greater or equal to the start number. 
    //  Note that a length-0 array is valid. 

    //  CreateIncreasingArray(5, 10) → {5, 6, 7, 8, 9}
    //  CreateIncreasingArray(11, 18) → {11, 12, 13, 14, 15, 16, 17}
    //  CreateIncreasingArray(1, 3) → {1, 2}    
    
    /**
     * 
     * @param start, end
     *      Two integers stating the start and end of the sequence.
     * 
     * @return NumberList
     *      int [] containg numbers ranging from start to end
     *      in order from least to greatest.
     */

    static int[] CreateIncreasingArray(int start, int end)
    {
        //I set the size of my array using the start/end inputs.
        int[] array = new int[end-start];

        //I use a simple for loop to iterate through the array.
        for(int i = 0; i < array.length; i++) {
            //To ge the right numbering, I add by i.
            array[i] = start + i;
        }

        return array;

    }

    //  Problem #6
    //  Given a non-empty array of ints, return a new array containing 
    //  the elements from the original array that come before the 
    //  first 4 in the original array. The original array will contain 
    //  at least one 4. Note that it is valid in java to create 
    //  an array of length 0.  

    //  CopyNumbersBeforeFour({1, 2, 4, 1}) → {1, 2}
    //  CopyNumbersBeforeFour({3, 1, 4}) → {3, 1}
    //  CopyNumbersBeforeFour({1, 4, 4}) → {1}
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return AbridgedList
     *      int[] list containing all the numbers that appeared
     *      before the first 4 in the array.
     */

    static int[] CopyNumbersBeforeFour(int[] NumberList)
    {
        int length = NumberList.length;
        int endingIndex = 0;

        //I use a simple for loop to iterate through the array.
        for (int i = 0; i < length; i ++) {

            //I wanna figure out where the 4 is here, so I can use the index later.
            if(NumberList[i] == 4) {
                endingIndex = i;
                break;
            }
        }

        //I set the array to exactly what it should be using the ending index.
        int[] array = new int[endingIndex];

        //Now I just iterate through my old array, and copy over to my new array up to the ending index.
        for (int i = 0; i< endingIndex; i++) {
            array[i] = NumberList[i];
        }
        return array;
    }

    //  Problem #7
    //  Return an array that contains the exact same numbers as 
    //  the given array, but rearranged so that all the zeros 
    //  are grouped at the start of the array. The order of the 
    //  non-zero numbers does not matter. So {1, 0, 0, 1} becomes 
    //  {0 ,0, 1, 1}. You may modify and return the 
    //  given array or make a new array.  

    //  MoveZerosToFront({1, 0, 0, 1}) → {0, 0, 1, 1}
    //  MoveZerosToFront({0, 1, 1, 0, 1}) → {0, 0, 1, 1, 1}
    //  MoveZerosToFront({1, 0}) → {0, 1}
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return RearrangedList
     *      int[] list containing all the numbers from original
     *      list with the zeros moved to the front.
     */

    static int[] MoveZerosToFront(int[] NumberList)
    {
        int length =  NumberList.length;
        int count = 0;
        int[] array = new int[NumberList.length];

        ////I use a simple for loop to iterate through the array and figure out how man 0's there are.
        for(int i = 0; i < length; i++) {

            if(NumberList[i] == 0) {
                count++;
            }
        }

        //I use another for loop to add my 0's to the array first.
        for(int i = 0; i < count; i++) {
            array[i] = 0;
        }

        //This final for loop adds in all my numbers that are not 0 to the end of the array.'
        for(int i = 0; i < length; i++) {
            if(NumberList[i] != 0) {
                array[count] = NumberList[i];
                count++;
            }
        }

        return array;
    }

        //  Problem #8
    //  Return an array that contains the exact same numbers as 
    //  the given array, but rearranged so that all the even numbers 
    //  come before all the odd numbers. Other than that, the 
    //  numbers can be in any order. You may modify and 
    //  return the given array, or make a new array.  

    //  EvenFrontOddBack({1, 0, 1, 0, 0, 1, 1}) → {0, 0, 0, 1, 1, 1, 1}
    //  EvenFrontOddBack({3, 3, 2}) → {2, 3, 3}
    //  EvenFrontOddBack({2, 2, 2}) → {2, 2, 2}
    
    /**
     * 
     * @param NumberList
     *      int[] list containing some numbers.
     * 
     * @return RearrangedList
     *      int[] list containing all the numbers from original
     *      list with the even numbers in the front and the
     *      odd numbers in the back.
     */

    static int[] EvenFrontOddBack(int[] NumberList)
    {
        int length = NumberList.length;
        int [] array = new int[NumberList.length];
        int counter = 0;

        //I use the same strategy here as I did above, I first copy in all the odds.
        for(int i = 0; i < length; i++) {

            if(NumberList[i] % 2 == 0) {
                array[counter] = NumberList[i];
                //I keep a counter to keep track of the index of my NEW array.
                counter++;
            }
        }

        //This final loop will move the odds to the back of my new array,
        for(int i = 0; i < length; i++) {
            if(NumberList[i] % 2 == 1) {
                array[counter] = NumberList[i];
                //I add on to my counter everytime once again!
                counter++;
            }

        }

        return array;
    }


    public static void main(String[] args)
    {
        int[] myArray = {2};
        boolean bool;
        //bool = FindThreeIncreasingNumbers(myArray);
        //myArray =  multiplesOfTen(myArray);
        //myArray = ReplaceZerosWithLargestOdd(myArray);
        //myArray =  CheckForAloneNumbers((myArray), 3);
        //myArray = CreateIncreasingArray(0, 1);
        //myArray = CopyNumbersBeforeFour(myArray);
        //myArray = MoveZerosToFront(myArray);
        myArray = EvenFrontOddBack(myArray);
        //System.out.print(bool);
        System.out.print(Arrays.toString(myArray));

    }
}
