import java.util.*;  
import java.util.stream.*;  
class SortListExample
{  
public static void main(String[] args)   
{  
//returns a list view   
List<String> slist = Arrays.asList("Tanu", "Kamal", "Suman", "Lucky", "Bunty", "Amit");  
List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());     
sortedList.forEach(System.out::println);  
}  
}  