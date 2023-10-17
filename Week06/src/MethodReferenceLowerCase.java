import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class MethodReferenceLowerCase {
	
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[]
				{"Apple", "Banana", "Cherry"});
		
		List<String> lowerCaseList = listOfNames.stream()
                .map(MethodReferenceLowerCase::toLowerCase)
                .collect(Collectors.toList());
		
		System.out.println("Original list: " + listOfNames);
        System.out.println("Lowercase list: " + lowerCaseList);		
	
		

	}

}

