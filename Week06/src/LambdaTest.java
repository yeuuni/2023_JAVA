interface ArrayProcessing {
	double apply(double[] array);
}
public class LambdaTest {
	
	public static final ArrayProcessing maxer = array -> {
		double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        
        return max;
	};
      
	public static final ArrayProcessing miner = array -> {
		double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    };
    
	public static final ArrayProcessing sumer = array -> {
	       double sum = 0;
	        for (double num : array) {
	            sum += num;
	        }
	        return sum / array.length;
	    };
	    
	    public static void main(String[] args) {
	        double[] array = { 10.5, 3.2, 8.7, 6.1, 5.9 };

	        // (1) 최대값 계산
	        double max = maxer.apply(array);
	        System.out.println("Maximum value: " + max);

	        // (2) 최소값 계산
	        double min = miner.apply(array);
	        System.out.println("Minimum value: " + min);

	        // (3) 평균값 계산
	        double average = sumer.apply(array);
	        System.out.println("Average value: " + average);
	    }
	}