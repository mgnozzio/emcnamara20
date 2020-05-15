import java.util.Scanner;
public class HelloWorld3 {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("What is your name?");
	String answer = s.nextLine();
	System.out.println("It is nice to meet you," + answer);
	}
}
