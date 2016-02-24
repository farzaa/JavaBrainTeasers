import java.util.stream.IntStream;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2Week5Assign {


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
		return( "Majeed,Farzain,f683348");
	}

	//	Problem #1
	//	Given an array of ints, is it possible to choose a group 
	//	of some of the ints, such that the group sums to the given 
	//	target? This is a classic backtracking recursion problem. 
	//	Once you understand the recursive backtracking strategy in 
	//	this problem, you can use the same pattern for many problems to
	//	search a space of choices. Rather than looking at the whole array, 
	//	our convention is to consider the part of the array starting at 
	//	index start and continuing to the end of the array. The caller 
	//	can specify the whole array simply by passing start as 0. No loops 
	//	are needed -- the recursive calls progress down the array. 

	//	groupSumsTarget(0, {2, 4, 8}, 10) → true
	//	groupSumsTarget(0, {2, 4, 8}, 14) → true
	//	groupSumsTarget(0, {2, 4, 8}, 9) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target
	 * 		returns false if there is no group that sums to target
	 */
	
	static boolean groupSumsTarget(int start, int[] nums, int target) { 

		
		//Basic check to make sure we don't go out of bounds.
		if(start >= nums.length)
			return false;
		
		//I subtract from my target to figure out if I found the proper numbers.
		if(target - nums[start] == 0)
			return true;
		
		//If I get to this point it means that I am not out bounds, have not met my goal, and have not overshot.
		//So now I need to begin the recursion.
		else {
			
			//I do (target - nums[start]) because I want to check if the NEXT number in my array satisfies my function.
			if(groupSumsTarget(start + 1, nums, target - nums[start]))
				return true;
			//If my function still is not satisfied, I skip over the value giving my function trouble and move on to the next
			//one without changing my target.
			else{
				return(groupSumsTarget(start + 1, nums, target));
			}
		}
	}
	
	//	Problem #2
	//	Given an array of ints, is it possible to choose a group of 
	//	some of the ints, beginning at the start index, such that 
	//	the group sums to the given target? However, with the additional 
	//	constraint that all 6's must be chosen. (No loops needed.)

	//	groupSumsTarget6(0, {5, 6, 2}, 8) → true
	//	groupSumsTarget6(0, {5, 6, 2}, 9) → false
	//	groupSumsTarget6(0, {5, 6, 2}, 7) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including all 6's in the group
	 * 		returns false if there is no group that sums to target
	 */
	
	static boolean groupSumsTarget6(int start, int[] nums, int target) 
	{
		
		//Basic check to make sure we don't go out of bounds.
		if(start >= nums.length && target != 0)
			return false;
		if(start >= nums.length && target == 0)
			return true;
	
		//MAIN DIFFERENCE! If I find a 6 I want to start a whole new sequence of returns while still
		//including that 6 by subtracting it from my target. This way I don't exit prematurely.
		
		//I subtract from my target to figure out if I found the proper numbers.
		if(nums[start] == 6) 
			return groupSumsTarget6(start + 1, nums, target - nums[start]);
		
		//If I get to this point it means that I am not out bounds, have not met my goal, and have not overshot.
		//So now I need to begin the recursion.
		else {
		
			//I do (target - nums[start]) because I want to check if the NEXT number in my array satisfies my function.
			if(groupSumsTarget6(start + 1, nums, target - nums[start]))
				return true;
			//If my function still is not satisfied, I skip over the value giving my function trouble and move on to the next
			//one without changing my target.
			else{
				return(groupSumsTarget6(start + 1, nums, target));
			}
		}

	}
	
	//	Problem #4
	//	Given an array of ints, is it possible to choose a group of some 
	//	of the ints, such that the group sums to the given target with these 
	//	additional constraints: all multiples of 5 in the array must be 
	//	included in the group. If the value immediately following a multiple 
	//	of 5 is 1, it must not be chosen. (No loops needed.) 

	//	groupSumsTarget5(0, {2, 5, 10, 4}, 19) → true
	//	groupSumsTarget5(0, {2, 5, 10, 4}, 17) → true
	//	groupSumsTarget5(0, {2, 5, 10, 4}, 12) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including the specified constraints
	 * 		returns false if there is no group that sums to target
	 */
	
	static boolean groupSumsTarget5(int start, int[] nums, int target) 
	{

		
		//Basic check to make sure we don't go out of bounds.
		if(start >= nums.length){
			return false;
		}
		
		
		//I subtract from my target to figure out if I found the proper numbers.
		if(target - nums[start] == 0){
			return true;
		}
		
		//If the number is divisible by 5, than we want to include it for sure.
		if(nums[start] % 5 == 0){
		
			//IF the next number is divisible by 1 than we want to skip that one.
			if(nums[start + 1] == 1)
				return groupSumsTarget5(start + 2, nums, target - nums[start]);
			else 
				return groupSumsTarget5(start + 1, nums, target - nums[start]);
		}
		
		//If I get to this point it means that I am not out bounds, have not met my goal, and have not overshot.
		//So now I need to begin the recursion.
		else {
			
			//I do (target - nums[start]) because I want to check if the NEXT number in my array satisfies my function.
			if(groupSumsTarget5(start + 1, nums, target - nums[start]))
				return true;
			//If my function still is not satisfied, I skip over the value giving my function trouble and move on to the next
			//one without changing my target.
			else{
				return(groupSumsTarget5(start + 1, nums, target));
			}
		}

	}
	
	//	Problem #5
	//	Given an array of ints, is it possible to choose a group of some of 
	//	the ints, such that the group sums to the given target, with this 
	//	additional constraint: if there are numbers in the array that are adjacent 
	//	and the identical value, they must either all be chosen, or none of 
	//	them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all 
	//	three 2's in the middle must be chosen or not, all as a group. (one loop 
	//	can be used to find the extent of the identical values). 

	//	groupSumsTargetClump(0, {2, 4, 8}, 10) → true
	//	groupSumsTargetClump(0, {1, 2, 4, 8, 1}, 14) → true
	//	groupSumsTargetClump(0, {2, 4, 4, 8}, 14) → false	
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including the specified constraints
	 * 		returns false if there is no group that sums to target
	 */

	static boolean groupSumsTargetClump(int start, int[] nums, int target) 
	{
		
		if(start >= nums.length)
			return false;
		
		int i = 0;
		
		//I use a loop to figure out how big my clump
		while(nums[start] ==  nums[start + i]){
			i++;
			if(i+start > nums.length-1)
				break;
		}
	
		
		
		//I subtract from my target accoridng to the clump size to figure out if I found the proper numbers.
		if(target - i*nums[start] == 0)
			return true;

		else {
			//I do (target - nums[start])*i because I want to check if the NEXT number (after my clump) in my array satisfies my function.
			if(groupSumsTargetClump(start + i, nums, target - i*nums[start]))
				return true;
			//If my function still is not satisfied, I skip over the value giving my function trouble and move on to the next
			//one without changing my target.
			else{
				return(groupSumsTargetClump(start + i, nums, target));
			}
		}

	}
	
	//	Problem #6
	//	Given an array of ints, is it possible to divide the ints into two 
	//	groups, so that the sums of the two groups are the same. Every int must 
	//	be in one group or the other. Write a recursive helper method that takes 
	//	whatever arguments you like, and make the initial call to your recursive 
	//	helper from splitArray(). (No loops needed.)    

	//	divideArray({2, 2}) → true
	//	divideArray({2, 3}) → false
	//	divideArray({5, 2, 3}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met
	 */
	
	//this is the helper function which is called by the original.
	static boolean divideArray(int start, int[] nums, int sum1, int sum2) {
		
		
		if (start >= nums.length) {
			//This is our main base case, when the sums are equal.
			if (sum1 == sum2) return true;
			return false;
			
		}
		
		//we want to create two seperate sums which can be accomplished by shifting the sums seperately.
		if( divideArray(start + 1, nums, sum1, sum2 + nums[start])) return true;
		if( divideArray(start + 1, nums, sum1 + nums[start], sum2)) return true;
		
		return false;
	}
	
	//This calls our helper.
	static boolean divideArray(int[] nums) 
	{
		return( divideArray(0, nums, 0 ,0));
		
	}

	//	Problem #7
	//	Given an array of ints, is it possible to divide the ints into two groups, 
	//	so that the sum of one group is a multiple of 10, and the sum of the 
	//	other group is odd. Every int must be in one group or the other. Write 
	//	a recursive helper method that takes whatever arguments you like, and 
	//	make the initial call to your recursive helper from 
	//	splitOdd10(). (No loops needed.)  

	//	oddDivide10({5, 5, 5}) → true
	//	oddDivide10({5, 5, 6}) → false
	//	oddDivide10({5, 5, 6, 1}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met 
	 */
	
	static boolean oddDivide10Helper(int start, int[] nums, int sum1, int sum2) {
		if (start >= nums.length) {
			//This base case checks if either of our sums are either divisble by 10 or odd.
			if(sum1 % 10 == 0 && sum2 % 2 != 0  || sum1 % 2 != 0 && sum2 % 10 == 0) return true;
			return false;
			
		}
		
		//This is how we create two seperate "groups" of sums.
		if (oddDivide10Helper(start + 1, nums, sum1, sum2 + nums[start])) return true;
		if( oddDivide10Helper(start + 1, nums, sum1 + nums[start], sum2)) return true;
		
		return false;
	}
	
	//This calls our helper.
	static boolean oddDivide10(int[] nums) {
		
		return (oddDivide10Helper(0, nums, 0, 0));
	}
	
	//	Problem #8
	//	Given an array of ints, is it possible to divide the ints into 
	//	two groups, so that the sum of the two groups is the same, with 
	//	these constraints: all the values that are multiple of 5 must 
	//	be in one group, and all the values that are a multiple of 3 
	//	(and not a multiple of 5) must be in the other. (No loops needed.)  

	//	divide53({1,1}) → true
	//	divide53({1, 1, 1}) → false
	//	divide53({2, 4, 2}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met
	 */
	
	static boolean divide53(int start, int[] nums, int sum1, int sum2) 
	{
		
		if (start >= nums.length) {
			//return only if the sums are equal.
			if (sum1 == sum2) return true;
			return false;
		}
		
		//if nums[start] is divisible by 5 than we want to make a seperate call because we HAVE to include it in our sum.
		if(nums[start] % 5 == 0){
			return divide53(start + 1, nums, sum1, sum2 + nums[start]); 
		}
		
		//if nums[start] is divisible by 3 than we want to make a seperate call because we HAVE to include it in our sum.
		if(nums[start] % 3 == 0){
			return divide53(start + 1, nums, sum1 + nums[start], sum2); 
		}
		
		//This takes care of numbers that are not divisible by 5 or 3.
		if (divide53(start + 1, nums, sum1, sum2 + nums[start])) return true;
		if (divide53(start + 1, nums, sum1 + nums[start], sum2)) return true;
		
		return false;
		
	}
	
	static boolean divide53(int[] nums) {
		return (divide53(0, nums, 0, 0));
	}

	public static void main(String args[]) {
		int[] array =  {5,5,5 };
		boolean number = groupSumsTarget6(0, new int[] {6,1, 6}, 7);
		System.out.println(number);

	}

}
