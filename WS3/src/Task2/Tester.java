package Task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Tester {

	public static void main(String[] args) {
		
		 List<String> topNames2017 = Arrays.asList(
				 "Amelia",
				 "Olivia",
				 "emily",
				 "Isla",
				 "Ava",
				 "oliver",
				 "Jack",
				 "Charlie",
				 "harry",
				 "Jacob"
		 );
        
		 lambda(topNames2017);
		 System.out.println();
		 System.out.println();
         methodRef(topNames2017);
         System.out.println();
         System.out.println();
         streams(topNames2017);
	}
    
    public static void lambda(List<String> list)
    {
         java.util.Collections.sort(list);
		 
		 list.forEach((String input) ->
		 {
			 System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1));
		 });
    }
    
    public static void methodRef(List<String> list)
    {   
        java.util.Collections.sort(list);
        
        list.forEach(new Consumer<String>() {
            public void accept(String input) {
                System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1));
            }
        });
    }
                     
    public static void streams(List<String> list){
    	java.util.Collections.sort(list);
        list.stream()
            .map(input -> input.substring(0, 1).toUpperCase() + input.substring(1))
            .forEach(System.out::println);
    }                
}