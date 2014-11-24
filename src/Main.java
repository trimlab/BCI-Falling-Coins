import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(new File("locations.in"));
		int n = scan.nextInt();
		double[] loc = new double[n];
		for(int i = 0;i < n; i++){
			loc[i] = scan.nextDouble();
		}
		MainGUI mainGUI = new MainGUI(loc);


	}

}
