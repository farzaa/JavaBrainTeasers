import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2Week7
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
	//	We want to make a row of bricks that is goal inches long. We have a number of 
	//	small bricks (1 inch each) and big bricks (5 inches each). Return true if it 
	//	is possible to make the goal by choosing from the given bricks. This is a 
	//	little harder than it looks and can be done without any loops.

	//	makeRowOfGoalBricks(3, 1, 8) → true
	//	makeRowOfGoalBricks(3, 1, 9) → false
	//	makeRowOfGoalBricks(3, 2, 10) → true
	
	/**
	 * 
	 * @param small, big, goal
	 * 		int containing the number of 1inch bricks available
	 * 		int containing the number of 5inch bricks available
	 * 		int containing the number of inches for the goal
	 * 
	 * @return 
	 * 		returns true if the goal can be reached with the available bricks
	 * 		returns false if the goal cannot be reached with the available bricks
	 */
	static boolean makeRowOfGoalBricks(int small, int big, int goal) 
	{
		
	if(small < 0 && big < 0) {
		return false;
	}
	
	if(goal < 0)
		return false;
	
	//Take care of negative inputs.
	if(small < 0)
		small = 0;
	if(big < 0)
		big = 0;
	
	//If goal is ever 0, we can leave.
	while(goal != 0) {	
		//If the goal is divisible by 5...
		if(goal % 5 == 0) {
			//And we have a 5 inch brick and have a goal of 0, just return.
			if( big!= 0 && goal - 5 == 0) {
				//goal = goal -5;
				//big = big -1;
				return true;
			}
			
			//Or else, we just decrease our goal if we have a 5 inch brick
			else if (big != 0) {
				goal = goal - 5;
				big = big - 1;
				continue;
			}	
		}
		
		//Lets first make sure we have a once inch brick.
		if(small != 0) {
			goal = goal - 1;	
			small = small - 1;
		}
		
		//This is how I decided to break out of my loop.
		if(small == 0 && (goal%5) != 0) {
			//System.out.println("break");
			break;
		}
	}

	if(goal == 0)	
		return true;
	
	return false;
			
		
	}

	//	Problem #2
	//	Given 3 int values, a b c, return their sum. However, if one of the values 
	//	is the same as another of the values, it does not count towards the sum.

	//	sumExcludingDuplicates(1, 2, 3) → 6
	//	sumExcludingDuplicates(3, 2, 3) → 2
	//	sumExcludingDuplicates(3, 3, 3) → 0
	
	/** 
	 * 
	 * @param a, b, c
	 * 		ints containing the original integers to sum
	 * 
	 * @return
	 * 		returns the sum of the input where duplicates are not included
	 */
	static int sumExcludingDuplicates(int a, int b, int c) 
	{
	
		//int a1, 
		int sum = 0;
		
		//Check a is not a dup.
		if(a-b != 0 && a-c !=0) {
			sum = sum + a;
		}
		
		//Check b is not a dup.
		if(b-c != 0 && b-a != 0) {
			sum = sum + b;
		}
		
		//Check c is not a dup.
		if(c-a != 0 && c-b != 0) {
			sum = sum + c;
		}
		
		//Return sum of non-dups.
		return sum;
	}	

	//	Problem #3
	//	Given 3 int values, a b c, return their sum. However, if one of the values is 
	//	13 then it does not count towards the sum and values to its right do not 
	//	count. So for example, if b is 13, then both b and c do not count. 

	//	sumExcludingUnluckyNums(1, 2, 3) → 6
	//	sumExcludingUnluckyNums(1, 2, 13) → 3
	//	sumExcludingUnluckyNums(1, 13, 3) → 1
	
	/**
	 * 
	 * @param a, b, c
	 * 		ints containing the original integers to sum
	 * 
	 * @return
	 * 		returns the sum of the input where values to the right of 13, inclusive, are not included
	 */
	static int sumExcludingUnluckyNums(int a, int b, int c) 
	{
		int sum = 0;
		
		//Make sure a is not a 13
		if(a != 13)
			sum = sum + a;
		else
			//I just return if we find a 13 since we don't want to include the rest of the numbers.
			return sum;
		
		//Make sure b is not a 13
		if(b != 13)
			sum = sum + b;
		else
			return sum;
		
		//Make sure c is not a 13
		if(c != 13)
			sum = sum + c;
		else
			return sum;
		
		return sum;
		
	}	

	//	Problem #4
	//	Given 3 int values, a b c, return their sum. However, if any of the values is a 
	//	teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 
	//	and 16 do not count as teens. Write a separate helper "public int fixTeen(int n) 
	//	{"that takes in an int value and returns that value fixed for the teen rule. In 
	//	this way, you avoid repeating the teen code 3 times (i.e. "decomposition").

	//	sumExcludingTeens(1, 2, 3) → 6
	//	sumExcludingTeens(2, 13, 1) → 3
	//	sumExcludingTeens(2, 1, 14) → 3
	
	/**
	 * 
	 * @param a, b, c
	 * 		ints containing the original integers to sum
	 * 
	 * @return
	 * 		returns the sum of the input where teens are not included
	 */
	static int sumExcludingTeens(int a, int b, int c) 
	{
		a = fixTeen(a);
		b = fixTeen(b);
		c = fixTeen(c);
		
		return a + b + c;
	}
	
	static int fixTeen(int num)
	{
	
		boolean negFlag = false;
	if( num == -15)
		return num;
	if(num == -16)
		return num;
	
	//Adjust for negative #.
	if (num < 0) {
		negFlag = true;
		num = (-1)*num;
	}
	if(num >= 0) {	
		//Set our bounds for the teens.
		//The later two conditions is how we know the number will be a teen.
		if (num - 10 != 0 && num - 10 >= 3  && num - 10 <= 9) {
			//If we hit a 15, make it 0
			if(num - 10 == 5) {
				if(negFlag)
					return -1*num;
				return num;
			}
			//If we hit a 16 make it 0
			if(num - 10 == 6) {
				if(negFlag)
					return -1*num;
				return num;
			}
			else return 0;
		}
	}
		if(negFlag)
			return -1*num;
		
		return num;
	}

//still need to adjust these for negatives		
	//	Problem #5
	//	For this problem, we'll round an int value up to the next multiple of 10 if its rightmost 
	//	digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple 
	//	of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, 
	//	a b c, return the sum of their rounded values. To avoid code repetition, write a separate 
	//	helper "public int round10(int num) {" and call it 3 times. Write the helper entirely below 
	//	and at the same indent level as roundSum().

	//	roundedSum(16, 17, 18) → 60
	//	roundedSum(12, 13, 14) → 30
	//	roundedSum(6, 4, 4) → 10
	
	/**
	 * 
	 * @param a, b, c
	 * 		ints containing the original integers to sum
	 * 
	 * @return
	 * 		returns the sum of the input where each value is rounded to the nearest tens place
	 */
	static int roundedSum(int a, int b, int c) 
	{
		return round(a) + round(b) + round(c);
	}
	
	static int round(int num)
	{	
		if(num % 10 >= 5)
			return 10 - (num%10) + num;
		return num - ((num%10));
					
	}
	
	//	Problem #6
	//	Given three ints, a b c, return true if one of b or c is "close" (differing from 
	//	a by at most 1), while the other is "far", differing from both other values by 2 
	//	or more. Note: Math.abs(num) computes the absolute value of a number. 

	//	isCloseAndFar(1, 2, 10) → true
	//	isCloseAndFar(1, 2, 3) → false
	//	isCloseAndFar(4, 1, 3) → true
	
	/**
	 * 
	 * @param a, b, c
	 * 		ints with original integers to compute relativity
	 * 
	 * @return 
	 * 		returns true if one of b or c is close to a and if the other is far from both other values
	 */
	static boolean isCloseAndFar(int a, int b, int c) 
	{
		a = Math.abs(a);
		b = Math.abs(b);
		c = Math.abs(c);
		
		if(Math.abs(a-b) <= 1)
			if(Math.abs(a-c) >= 2 && Math.abs(b-c) >= 2)
				return true;
		
		if(Math.abs(a-c) <= 1)
			if(Math.abs(a-b) >= 2 && Math.abs(c-b) >= 2)
				return true;
		
		return false;
		
	}
	
	//	Problem #7
	//	Given 2 int values greater than 0, return whichever value is nearest to 21 without 
	//	going over. Return 0 if they both go over. 

	//	blackjack(19, 21) → 21
	//	blackjack(21, 19) → 21
	//	blackjack(19, 22) → 19
	
	/**
	 * 
	 * @param a, b
	 * 		ints representing the values of two cards in a game of black jack
	 * 
	 * @return 
	 * 		returns the value of the int that is closest to 21 without going over
	 */
	static int blackjack(int a, int b) 
	{
		//Simple base cases, if we immediately find a 21.
		if (a == 21)
			return a;
		if(b== 21)
			return b;
		
		//These cases just make my calculations easier. 
		if( a > 21)
			if( b <= 21)
				return b;
		
		if( b > 21)
			if( a <= 21)
				return a;
		
		//First I check if the number is under 21, than I check if the difference is greater than b-a.
		if ( a - 21 <= 0 && (a-b) > (b-a) )
			return a;
		//First I check if the number is under 21.
		else if(b - 21 <= 0) {
			return b;
		}
		
		return 0;
	}
	
	//	Problem #8
	//	Given three ints, a b c, one of them is small, one is medium and one is large. 
	//	Return true if the three values are evenly spaced, so the difference between 
	//	small and medium is the same as the difference between medium and large. 

	//	spacedEvenly(2, 4, 6) → true
	//	spacedEvenly(4, 6, 2) → true
	//	spacedEvenly(4, 6, 3) → false
	
	/**
	 * 
	 * @param a, b, c
	 * 		ints containing original integers to compute with
	 * 
	 * @return 
	 * 		returns true if the input values are evenly spaced
	 * 		returns false if the input values are not evenly spaced
	 */
	static boolean spacedEvenly(int a, int b, int c) 
	{
		int[] array = new int[3];
		//I just put my numbers in an array and sort it.
		array[0] = a; array[1] = b; array[2] = c;
		java.util.Arrays.sort(array);
		//I then check if the differences are equal, I use Math.abs in case of negative numbers.
		if (Math.abs(array[1] - array[0]) == Math.abs(array[2] - array[1]))
			return true;
		
		return false;
	}
	
	//	Problem #9
	//	We want to make a package of goal kilos of chocolate. We have small bars 
	//	(1 kilo each) and big bars (5 kilos each). Return the number of small bars 
	//	to use, assuming we always use big bars before small bars. Return -1 
	//	if it can't be done.

	//	makeKilosOfChocolate(4, 1, 9) → 4
	//	makeKilosOfChocolate(4, 1, 10) → -1
	//	makeKilosOfChocolate(4, 1, 7) → 2
	
	/**
	 * 
	 * @param small, big, goal
	 * 		int containing the number of 1kilo bars available
	 * 		int containing the number of 5kilo bars available
	 * 		int containing the number of kilos for the goal
	 * 
	 * @return 
	 * 		returns the value of the number of small bars needed to meet the goal
	 */
	static int makeKilosOfChocolate(int small, int big, int goal) 
	{
		if(small < 0 && big < 0) {
			return -1;
		}
		
		if(goal < 0)
			return -1;
		
		//Take care of negative inputs.
		if(small < 0)
			small = 0;
		if(big < 0)
			big = 0;
		
		int smallCounter = 0;
		
		//If goal is ever 0, we can leave.
		while(goal != 0) {	
			//System.out.print(smallCounter);
			//If the goal is divisible by 5...
			if(goal % 5 == 0) {
				//And we have a 5 inch brick and have a goal of 0, just return.
				if( big!= 0 && goal - 5 == 0) {
					//goal = goal -5;
					//big = big -1;
					if(smallCounter == 0)
						return -1;
					else 
						return smallCounter;
				}
				
				//Or else, we just decrease our goal if we have a 5 inch brick
				else if (big != 0) {
					goal = goal - 5;
					big = big - 1;
					continue;
				}	
			}
			
			//Lets first make sure we have a once inch brick.
			if(small != 0) {
				goal = goal - 1;	
				small = small - 1;
				smallCounter++;
			}

			//This is how I decided to break out of my loop.
			if(small == 0 && (goal%5) != 0) {
				//System.out.println("break");
				break;
			}
		}
		//System.out.println(goal);
		if(goal == 0 && smallCounter != 0)	
			return smallCounter;
		
		else
			return -1;
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
		System.out.println(makeKilosOfChocolate(0, 5, 15));
	}
	
}