package Task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

        topNames2017 = Arrays.asList(
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

         methodRef(topNames2017);
         System.out.println();
         System.out.println();


        topNames2017 = Arrays.asList(
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

         streams(topNames2017);
	}
    
    public static void lambda(List<String> list)
    {
        list.replaceAll(input -> { return input.substring(0, 1).toUpperCase() + input.substring(1); });
        list.sort((a, b) -> {return a.compareTo(b);});
        list.forEach(System.out::println);
    }
    
    public static void methodRef(List<String> list)
    {
        list.replaceAll(Tester::firstUpper);
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }
                     
    public static void streams(List<String> list){
    	java.util.Collections.sort(list);
        list.stream()
                .map(Tester::firstUpper)
                .sorted(String::compareTo)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static String firstUpper(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}