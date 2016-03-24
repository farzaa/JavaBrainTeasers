import java.text.DecimalFormat;
import java.util.Arrays;

//DONE
public class Cipher {
	
	//Established table 
	static double[] table = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2, 0.8,
							 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0, 6.3, 9.1, 2.8, 1.0, 2.4,
							 0.2, 2.0, 0.1};
	
	//Changes char to int.
	static int let2nat(char c)
	{
		return c - 'a';
	}
	
	//Chnages int to respected char.
	static char nat2let(int code)
	{
		return (char) (code + 'a');
	}
	
	//Shifts code to encode.
	static char shift(int shiftAmt, char c)
	{
		int pos = let2nat(c) + shiftAmt;
		if(pos > 25)
			pos = pos - 26;
		
		return nat2let(pos);
	}
	
	//Shifts backwards to decode.
	static char reverseShift(int shiftAmt, char c)
	{
		int pos = let2nat(c) - shiftAmt;
		if(pos < 0)
			pos = 26 + pos;
		
		return nat2let(pos);
	}
	
	//Encodes by shifting each char.
	static String encode(int shiftAmt, String str)
	{
		char[] newString = str.toCharArray();
		for(int i = 0; i < newString.length; i++)
		{
			//System.out.println(newString[i]);
			if(Character.isLowerCase(newString[i]))
				newString[i] = shift(shiftAmt, newString[i]);
			//System.out.println(newString[i]);
		}
		String ret = new String(newString);
		return ret;
	}
	
	//Decodes by doing the opposite of encode.
	static String decode(int shiftAmt, String str)
	{
		char[] newString = str.toCharArray();
		for(int i = 0; i < newString.length; i++)
		{
			//System.out.println(newString[i]);
			if(Character.isLowerCase(newString[i]))
				newString[i] = reverseShift(shiftAmt, newString[i]);
			//System.out.println(newString[i]);
		}
		String ret = new String(newString);
		return ret;
		
	}
	
	//Checks total number of lowercase letters.
	static int lowers(String str)
	{
		char[] newString = str.toCharArray();
		int total = 0;
		for(int i = 0; i < newString.length; i++) 
		{
			if(Character.isLowerCase(newString[i]))
				total++;
		}
		
		return total;
		
	}
	
	//Returns total number of char c in a string str.
	static int count(char c, String str)
	{
		char[] newString = str.toCharArray();
		int total = 0;
		for(int i = 0; i < newString.length; i++) 
		{
			if(c == newString[i])
				total++;
		}
		
		return total;
	
	}
	
	//Calculates a percent.
	static double percent(int num1, int num2)
	{
		double num = ((1.0*num1)/num2)*100;
		double round = Math.round(num * 10000.0) / 10000.0;
		return round;
	}
	
	//Creates a frequency array.
	static double[] freqs(String str)
	{
		double[] freq = new double[26];
		
		for(int i = 0; i < 26; i++)
		{
			if(str.contains(Character.toString(nat2let(i))))
			{
				freq[i] = percent(count(nat2let(i), str), lowers(str));
			}
			
		}
		
		return freq;	
	}
	
	//Rotates frequency array a give number of times.
	static double[] rotate(int n, double[] list)
	{
		int j = 0;
		double[] newList = new double[list.length];
		for(int i = n; i < list.length; i++)
		{
			newList[j] = list[i];
			j++;
		}
		
		for(int i = 0; i < n; i++)
		{
			newList[j] = list[i];
			j++;
		}
		
		return newList;	
	}
	

	//Calculates chi square.
	static double chisqr(double[] os) 
	{
		double total = 0;
		
		for(int i = 0; i < os.length; i++)
		{
			double current = 0;
			double numerator = 0;
			
			numerator = os[i] - table[i];
			numerator = numerator * numerator;
			current = 1.0*numerator/table[i];
			total = total + current;
		}
		double round = Math.round(total * 10000.0) / 10000.0;
		return round;
	}
	
	//Calculates position of a double in frequency array. 
	static int position(double a, double[] list)
	{
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] == a)
			{
				return i;
			}
		}
		
		return 1000000;
	}
	
	//Cracks stirng by finding rotation with loweest chi square value
	//to figure out the shift factor.
	static String crack(String str)
	{
		//System.out.println(str);
		double chiSqrResult = 0;
		double[] freqArray = freqs(str);
		int smallestRotation = 100000000;
		double smallestChiSquare = chisqr(freqArray);
		for(int i = 0; i < 26; i++)
		{
			double[] test = rotate(i, freqArray);
			//freqArray = rotate(i, freqArray);
			chiSqrResult = chisqr(test);
			
			//System.out.println(chiSqrResult);
			//System.out.println(smallestChiSquare);
			
			if(chiSqrResult < smallestChiSquare)
			{
				smallestChiSquare = chiSqrResult;
				smallestRotation = i;
			}
		}
		
		//System.out.println("Smallest Square is..." +smallestChiSquare + "at rotation..." + smallestRotation);
		//System.out.println(decode(smallestRotation, str));
		 //-> "nyhoht" rack(encode(3,"thefiveboxingwizardsjumpquickly"))->

		return decode(smallestRotation, str);
		
	}
	
	
	public static void main(String args[]) 
	{
		System.out.println("myxqbkdevkdsyxc yx mywzvodsxq dro ohkw!");
		System.out.println(crack("myxqbkdevkdsyxc yx mywzvodsxq dro ohkw!"));
		
	}

}
