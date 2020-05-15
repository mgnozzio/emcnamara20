
public class Chapter2Calculations {

	public static void main(String[] args) {
		int T1 = 1;
		int T2 = 1;
		for (int i = 0; i <= 11; i++) {
			System.out.print(" " + T1);
			int temp = T1;
			T1 = T2;
			T2 = T2 + temp;
			
		}
			
			

	}

}
