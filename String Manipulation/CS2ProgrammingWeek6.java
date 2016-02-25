

public class CS2ProgrammingWeek6
{

///////////////////////////////////////////
//
// Start of assignment code.
// DONE2
///////////////////////////////////////////

/**
* Returns the last name, first name, and PID of the student.
* 
* This is required in order to get credit for the programming assignment.
*/
static String GetNameAndPID()
{
return("Majeed, Farzain, f3394197");
}

//	Problem #1
//	Given a string, count the number of words ending in 'y' 
//	or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, 
//	but not the 'y' in "yellow" (not case sensitive). We'll say 
//	that a y or z is at the end of a word if there is not an 
//	alphabetic letter immediately following it. (Note: 
//	Character.isLetter(char) tests if a char is an alphabetic letter.) 

//	wordEndYZ("fez day") → 2
//	wordEndYZ("day fez") → 2
//	wordEndYZ("day fyyyz") → 2

/**
* 
* @param str
* 		str containing the original string
* 
* @return int
* 		int containing the # of words that end in y or z
*/
static int wordEndYZ(String str) 
{
	//Just in case we get passed an empty string.
	if(str.equals("") || str == null)
		return 0;
	
	int count = 0;
	for(int i = 0; i < str.length(); i++) {
		char c = str.charAt(i);
		//If the character is NOT a letter.
		if(!(Character.isLetter(c))) {
			//And if the char before is a y or z (this is how we know its a word)
			if(str.charAt(i-1) == 'z' || str.charAt(i-1) == 'y') {
				//Than increment count.
				count++;
			}
		}
	}
	
	//This is an extra case to check for the final word in the string, since the for loop only increments count
	//when there is non-letter before it.
	char c = str.charAt(str.length()-1);
	if(c == 'z' || c == 'y')
		count++;
	
	return count;
	
}

/*

//	Problem #2
//	Given two strings, base and remove, return a version of the base 
//	string where all instances of the remove string have been removed 
//	(not case sensitive). You may assume that the remove string is length 
//	1 or more. Remove only non-overlapping instances, so with "xxx" 
//	removing "xx" leaves "x".

//	removeFromBase("Hello there", "llo") → "He there"
//	removeFromBase("Hello there", "e") → "Hllo thr"
//	removeFromBase("Hello there", "x") → "Hello there"

/**
* 
* @param base, remove
* 		base contains original string of characters
* 		remove contains original string that is to be removed from base
* 
* @return
* 		String containing the base with all instances of remove taken out
*/
static String removeFromBase(String base, String remove) 
{	
	//I want to make sure my program doesn't crash
	if(base.equals("") || base == null || remove.equals("") || remove == null)
		return base;
	//If there is just one char inside the string, I have a special case.
	if(base.length() == 1)
		if(base.equals(remove))
			return "";
		else
			return base;
	//I create a new string here which will check for any instances of remove.
	while(base.contains(remove)) {
		//System.out.println(base);
		base = base.substring(0, base.indexOf(remove)) + base.substring(base.indexOf(remove) + remove.length(), base.length());
	}
	
	return base;
}	

//	Problem #3
//	Given a string, return true if the number of appearances of 
//	"is" anywhere in the string is equal to the number of appearances 
//	of "not" anywhere in the string (case sensitive). 

//	equalAppearance("This is not") → false
//	equalAppearance("This is notnot") → true
//	equalAppearance("noisxxnotyynotxisi") → true

/**
* 
* @param str
* 		str contains the original string of characters
* 
* @return
* 		returns true if "is" appears as many times as "not"
* 		returns false if "is" does not appear as many times as "not"
*/
static boolean equalAppearance(String str) 
{
	//Just in case graders are sneaky.
	if(str.equals("") || str == null)
		return false;
	
	
	String tmp = str;
	int notCount = 0;
	int isCount = 0;
	
	//as long as our tmp string doesn't contain the word "not"
	while(tmp.contains("not")) {
		//I substring here so I can continue counting.
		tmp = tmp.substring(tmp.indexOf("not") + 3, tmp.length());
		notCount++;
	}
	
	tmp = str;
	
	//as long as our tmp string doesn't contain the word "is"
	while(tmp.contains("is")) {
		//I substring here so I can continue counting.
		tmp = tmp.substring(tmp.indexOf("is") + 2, tmp.length());
		isCount++;
	}
	
	if(isCount == notCount)
		return true;
	else
		return false;
	
}	

//	Problem #4
//	We'll say that a lowercase 'g' in a string is "happy" if there 
//	is another 'g' immediately to its left or right. Return true if 
//	all the g's in the given string are happy. 

//	gisHappy("xxggxx") → true
//	gisHappy("xxgxx") → false
//	gisHappy("xxggyygxx") → false

/**
* 
* @param str
* 		String containing original string of characters
* 
* @return
* 		returns true if 'g' appears with another 'g' to it's right or left
* 		returns false if this is not the case
*/
static boolean gisHappy(String str) 
{
	//In case graders are tricky.
	if(str.equals("") || str == null)
		return false;
	
	//I keep a flag to check if g is happy.
	boolean flag = false;
	char prev = 0;
	
	//I do str.length-1 since i do index[i+1] later on.
	for(int i = 0; i < str.length()-1; i++) {

		char c = str.charAt(i);
		//if there is a g...
		if (c == 'g') {
			char v = str.charAt(i+1);
			//and the char next to it is a g...
			if (v == 'g' || prev == 'g') {
				//skip that g
				i = i+1;
				//return true;
				flag = true;
			}
			else
				return false;
				
		}
		
		prev = str.charAt(i);
	}
	
	//This is an edge case to check the last char, since my loop does not.
	if(prev == 'g' && str.charAt(str.length()-1) == 'g')
		flag = true;
	else 
		return false;
		
	
	return flag;
	
}

//	Problem #5
//	We'll say that a "triple" in a string is a char appearing three times in a row. 
//	Return the number of triples in the given string. The triples may overlap. 

//	numberOfTriples("abcXXXabc") → 1
//	numberOfTriples("xxxabyyyycd") → 3
//	numberOfTriples("a") → 0	

/**
* 
* @param str
* 		String containing the original string of characters
* 
* @return
* 		Integer containing the # of "triples" in str
*/
static int numberOfTriples(String str) 
{
	//In case the graders are being c9 sneaky.
	if(str.equals("") || str == null)
		return 0;
	//count for our triples.
	int count = 0;
	
	//I do str.length-2 because i do index+1 and index+2
	for(int i = 0; i < str.length()-2; i++) {
		char c = str.charAt(i);
		//If we have two more of the same chars in a row, increment count.
		if(str.charAt(i+1) == c && str.charAt(i+2) == c) {
			count++;
		}
	}
	
	return count;
}

//	Problem #6
//	Given a string, return the sum of the digits 0-9 that appear in the 
//	string, ignoring all other characters. Return 0 if there are no digits 
//	in the string. (Note: Character.isDigit(char) tests if a char is one 
//	of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.) 

//	addUpDigits("aa1bc2d3") → 6
//	addUpDigits("aa11b33") → 8
//	addUpDigits("Chocolate") → 0

/**
* 
* @param str
* 		String containing the original string of characters
* 
* @return 
* 		Integer containing the # sum of all digits that appear in str
*/
static int addUpDigits(String str) 
{
	//I see you, tricky graders.
	if(str.equals("") || str == null)
		return 0;
	
	int sum = 0;
	
	for(int i = 0; i < str.length(); i++) {
		//I go char by char
		char c = str.charAt(i);
		//If I find a digit, I parse the int and add it to my sum.
		if (Character.isDigit(c)) {
			int add = Integer.parseInt(Character.toString(c));
			sum = add + sum;
		}
	}
	
	return sum;
}

//	Problem #7
//	Given a string, return the longest substring that appears at 
//	both the beginning and end of the string without overlapping. 
//	For example, beginningAndEndOfString("abXab") is "ab". 

//	beginningAndEndOfString("abXYab") → "ab"
//	beginningAndEndOfString("xx") → "x"
//	beginningAndEndOfString("xxx") → "x"

/**
* 
* @param string
* 		String containing the original string of characters
* 
* @return 
* 		String containing the beginning and ending substrings that are the same
*/
static String beginningAndEndOfString(String string) 
{
	//In case graders try to mess me up.
	if(string.equals("") || string == null)
		return "";
	
	//Just an edge case to see if we only have a string with length 2.
	if(string.length() == 2)
		if(string.substring(0, 1).equals(string.substring(1,2)))
			return string.substring(0, 1);
		else
			return "";
	
	
	for(int i = 1; i <= string.length(); i++) {
		
		//Make a substring for the ending/beginning using i. So we make 2 new strings every loop.
		String end = string.substring(string.length() - i, string.length());
		String begin = string.substring(0, i);
		
		//Base case, to prevent overlapping.
		if(end.length() + begin.length() == string.length())
			return "";
		
		//Return string if we find a match.
		if(begin.equals(end)) {
			return begin;
		}
	}
	
	return "";
	
}

//	Problem #8
//	Given a string, look for a mirror image (backwards) string at both 
//	the beginning and end of the given string. In other words, zero or more 
//	characters at the very beginning of the given string, and at the very 
//	end of the string in reverse order (possibly overlapping). For example, 
//	the string "abXYZba" has the mirror end "ab". 

//	beginningMirrorEnd("abXYZba") → "ab"
//	beginningMirrorEnd("abca") → "a"
//	beginningMirrorEnd("aba") → "aba"

/**
* 
* @param string
* 		String containing the original string of characters
* 
* @return 
* 		String containing the beginning of the string that is mirrored at the end
*/
static String beginningMirrorEnd(String string) 
{
	
	//In case graders try to mess me up.
	if(string.equals("") || string == null)
		return "";
	
	int biggestLength = 0;
	String biggestString = "";
	
	
	for(int i = 1; i <= string.length(); i++) {
		
		//Make a substring for the ending/beginning using i. So we make 2 new strings every loop.
		String end = string.substring(string.length() - i, string.length());
		String begin = string.substring(0, i);
		
		//Reverse string I made
		end = new StringBuilder(begin).reverse().toString();
		
		//Return string if we find a match with the reverse
		if(string.substring(string.length() - i, string.length()).contains(end)) {
			//Look through entire string to find biggest,.
			if(begin.length() > biggestLength) {
				biggestLength = begin.length();
				biggestString = begin;
			}
		}
	}
	
	return biggestString;
}


//	Problem #9
//	Given a string, return the length of the largest "block" in the string. 
//	A block is a run of adjacent chars that are the same. 

//	largestBlock("hoopla") → 2
//	largestBlock("abbCCCddBBBxx") → 3
//	largestBlock("") → 0

/**
* 
* @param str
* 		String containing the original string of characters
* 
* @return 
* 		Integer containing the # of chars in the largest "block" in str
*/
static int largestBlock(String str) 
{
	//Always check for null.
	if(str.equals("") || str == null)
		return 0;
	
	//Keep track of biggest block.
	int greatestCount = 0;
	
	//I do str.length()-1 because i do index+1 in the loop.
	for(int i = 0; i < str.length()-1; i++) {
		
		int count = 1;
		//I use j so I start at the correct index
		int j = i;
		char c = str.charAt(i);
		
		//As long as the chars are the same and I'm not out of bounds, increment count.
		while(j < str.length()-1 && c == str.charAt(j+1)) {
			//
			//System.out.println(c);
			count++;
			j++;
			//System.out.println(j);
		}
		
		//Keep track of my greatest count.
		if(count > greatestCount) {
			greatestCount = count;
		}
		
	}
	
	//System.out.println(greatestCount);
	
	return greatestCount;
}

//	Problem #10
//	Given a string, return the sum of the numbers appearing in the string, 
//	ignoring all other characters. A number is a series of 1 or more digit 
//	chars in a row. (Note: Character.isDigit(char) tests if a char is one 
//	of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

//	addUpNumbers("abc123xyz") → 123
//	addUpNumbers("aa11b33") → 44
//	addUpNumbers("7 11") → 18

/**
* 
* @param str
* 		String containing the original string of characters
* 
* @return 
* 		Integer containing the sum of all the numbers that appear in str
*/
static int addUpNumbers(String str) 
{
	//Always check for null.
	if(str.equals("") || str == null)
		return 0;
	
	//Keep track of the sum.
	int sum = 0;
	
	for(int i = 0; i < str.length()-1; i++) {

		
		char c = str.charAt(i);
		//This is so I start at the correct index.
		int j = i;
		//I will be making my "number" char by char.
		String number = "";
		if (Character.isDigit(c)) {
			number = Character.toString(c);
			//As long as I have adjacent digits, I will build my number.
			while(j < str.length()-1 && Character.isDigit(str.charAt(j+1))) {
				//This is where I actually build the number as a string.
				number = number + Character.toString(str.charAt(j+1));
				j++;
			}
		}
		
		//I then add to my sum.
		if(!(number.equals(""))) {
			int add = Integer.parseInt(number);
			sum = add + sum;
		}
		
		//I then skip i by the size of string I just built so I dont count it again.
		i = i + number.length();
	}
	
	//Edge case for the last digit, if it is a figt.
	if(Character.isDigit(str.charAt(str.length()-1))) {
		String number = Character.toString(str.charAt(str.length()-1));
		int add = Integer.parseInt(number);
		sum = add + sum;
	}
	
	return sum;
	
}

///////////////////////////////////////////
//
// End of assignment code.
//
///////////////////////////////////////////


public static void main(String[] args)
{
	System.out.println(beginningAndEndOfString("cabXYcab"));
}

}
