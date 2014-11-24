import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		if (args.length != 3) {
			System.out
					.println("Incorrect number of arguments. Arguments should be presented as:\n"
							+ "testFile outputFile testID\n"
							+ "or\n"
							+ "duration outputFile testID");
			System.exit(1);
		}

		int duration;
		try {
			Scanner scan = new Scanner(new File(args[0]));
			duration = scan.nextInt();
			scan.close();
		} catch (FileNotFoundException fnf) {
			try {
				duration = Integer.parseInt(args[0]);
			} catch (NumberFormatException nf) {
				System.out
						.println("error reading duration: must be an integer value");
				System.exit(1);
				duration = -1;
			}
		}

		new MainGUI(duration, args[1], args[2]);

	}

}
