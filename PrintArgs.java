import java.lang.Integer;
import java.util.Arrays;
public class PrintArgs {
	public static void Q9(String[] args) {
		System.out.println(args[0]);
	}


//Question 9:
//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 
//Index 0 out of bounds for length 0 at PrintArgs.main(PrintArgs.java:4)

	public static void Q10(String[] args) {
		String[] names = { "Le", "langage", "Java", "me", "plait", "beaucoup"};
		//Question 10//
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}
		//Question 11//
		for (String name : names) {
			System.out.println(name.toString());
		}
	}
//Question 12//
	public static void Q12(String[] args) {
		int a=0;
		int[] tab=new int[20];
		int i=0;
		var j=0;
		for(String name : args) {
			a=Integer.parseInt(name);
			tab[i]=a;
			i++;	
		}
		for(int num: tab) {
			System.out.println("Element" + i + "=" + num);
			j++;
		}
	}
	
//Question 13//
	public static int Q13(int[] tab) {
		int S=0;
		for(int i=0; i<tab.length; i++) {
			S=S+tab[i];
		}
		System.out.println(S);
		return S;
	}
//Question 14//
	public static void main(String[] args) {
		int[] tab= {7, 8, 9, 10, 11};
		PrintArgs.Q9(args);
		PrintArgs.Q10(args);
		PrintArgs.Q12(args);
		PrintArgs.Q13(tab);
	}
}
