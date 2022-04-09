public class Solution {
    public static int[] solution(int[] pegs) {
        int[] finalResult = new int[2];
        int result = 0;
        int numerator = 2;
        int denominator = 1;
        
        if(pegs.length % 2 == 0)
        {
        	denominator = 3;
        }
        
        int initialSign = 1;
        
        for(int i=1; i < pegs.length; i++)
        {
        	result = result + ((pegs[i] - pegs[i-1]) * initialSign);
        	initialSign = -initialSign;
        }
        
        if(result < 2)
        {
        	return new int []{-1, -1};
        }
        
        
        if(result % denominator == 0)
        {
            if(denominator == 3)
            {
                finalResult[0] = (result * numerator)/3;
            }
            else
            {
                finalResult[0] = (result * numerator);
            }
            finalResult[1] = 1;
        }
        else
        {
            finalResult[0] = result * numerator;
            finalResult[1] = 3;
        }
        
        double currentRadius = (double)finalResult[0]/finalResult[1];
        
        // Check if all are above 1
        for(int i=1; i < pegs.length - 1; i++)
        {
        	double next = (pegs[i] - pegs[i-1]) - currentRadius;
        	if(next < 1)
        	{
        	    return new int []{-1, -1};
        	}
        	else
        	{
        	    currentRadius = next;
        	}
        }

        return finalResult;
    }
}
