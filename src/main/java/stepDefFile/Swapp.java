package stepDefFile;

public class Swapp {
public static void main(String[] args) {
	int a=10;
	int b=20;
	System.out.println("Before Swap"+a);
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("After Swap"+a);
	System.out.println("Given program is swapped successfully");
}
}
