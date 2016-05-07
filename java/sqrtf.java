public class sqrtf {    
    public static float sqrtf(float number) {
    	float low = 0.0f;
    	float high = number;
        float guess = (low + number) * 0.5f;
        while (Math.abs(guess * guess - number) > 0.00001) {
        	System.out.println("guess is "+guess);
            if(guess*guess>number) {
            	high = guess;
            } else {
            	low = guess;
            }
            guess = (low+high)/2.0f;
        }
        return guess;
    }
}
