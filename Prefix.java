
import java.util.*;


public class Prefix {
	
	
	 public static void main(String[] args){
		 tester.test();
	}
	
	public static <T> List<T> longestPrefix(List<T> a, List<T> b, Comparator<? super T> cmp){
		List<T> returnList=new ArrayList<>();
		Iterator <T> iteratorA=a.iterator();
		Iterator <T> iteratorB=b.iterator();
		T elementA;
		T elementB;
		while (iteratorA.hasNext()&&iteratorB.hasNext()){
			elementA=iteratorA.next();
			elementB=iteratorB.next();
			if(cmp.compare(elementA, elementB)==0){
				returnList.add(elementA);
			}
			else{
				break;
			}
		}
		return returnList;
	}	
}
