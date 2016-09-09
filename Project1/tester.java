//this project was made by Robert Milne
import java.util.Arrays;
import java.util.List;


public class tester {

	public static void test(){
		 List<Integer> listA=Arrays.asList(1,2,4,5);
		 List<Integer> listB=Arrays.asList(1,2,3,4);
		 List<Integer> listC=Arrays.asList();
		 PrefixComparator cmp=new PrefixComparator();
		 List<Integer> returnPrefix=Prefix.longestPrefix(listA,listB, cmp );
		 System.out.print(returnPrefix);
		 returnPrefix=Prefix.longestPrefix(listA,listA, cmp );
		 System.out.print(returnPrefix);
		 returnPrefix=Prefix.longestPrefix(listA,listC, cmp );
		 System.out.print(returnPrefix);
		 returnPrefix=Prefix.longestPrefix(listC,listC, cmp );
		 System.out.print(returnPrefix);
	}
}
