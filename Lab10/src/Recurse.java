
public class Recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int strCount(String str, String sub) {
		  if(str.length() < sub.length()){//if smaller than the sub, then it cant be in it
		    return 0;
		  }
		  if(str.substring(0,sub.length()).equals(sub)){//if equal, then recurses to look at the string after the first match
		    return 1 + strCount(str.substring(sub.length()),sub);
		  }
		  else{//if theres no match, shift down a character until a match is found
		    return strCount(str.substring(1),sub);
		  }
		}
	
	public int bunnyEars(int bunnies) {
		  if(bunnies == 0){//if there no bunnies, no ears
		    return 0;
		  }
		  else{//count ears of one bunny, then kill it, repeat until no more bunnies
		    return 2 + bunnyEars(bunnies-1);
		  }
		}
	
	public int sumDigits(int n) {
		  if(n%10 == n){//if its only one digit
		    return n;
		  }
		  else{
		    int num = n/10;//gets all the digits except ones place
		    return n%10 + sumDigits(num);//add ones place with ones place of every number after repeated until only on digit
		  }
		}
}
