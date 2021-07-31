
public class Insertion {

	public static void main(String[] args) {
		Integer[] a = {4,1,2,3,0};
		Integer[] b = {1,4,2};
		String[] c = {"Parth", "Justin", "Edward"};
		System.out.println(java.util.Arrays.toString(a) +" before");
		insertionSort(a);
		System.out.println(java.util.Arrays.toString(c)+" before");
		insertionSort(c);
		
	}
	public static <T> void insertionSort(Comparable<T>[] a) {
		int count = 0;
		int num = a.length;
		for(int i = 1; i < num; i++) {
			count++;
			Comparable<T> k = a[i];//gets next index
			int j = i - 1;//gets index before
			while(j >= 0 && a[j].compareTo((T) k) > 0) {//if j, the number before, is greater
				count++;
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = k;
		}
		System.out.println(java.util.Arrays.toString(a));
		System.out.println(count);
	}
}
