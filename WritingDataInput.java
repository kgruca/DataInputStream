import java.io.*;
import java.text.*;
import java.util.*;

public class WritingDataInput {

	public static void main(String[] args) throws Exception{
		
		DataInputStream myFileIn;
		DataOutputStream myFileOut;
		final int SIZE = 80;
		int k;
		float myFloats[];
		NumberFormat tidy = NumberFormat.getNumberInstance(Locale.US);
		tidy.setMaximumFractionDigits(2);
		tidy.setMinimumFractionDigits(2);
		tidy.setMinimumIntegerDigits(2);
		
		myFloats = new float[SIZE];
		for(k = 0; k < myFloats.length; k++)
			myFloats[k] = (float)(Math.random() / (Math.random() + 1));
			
		try {
			myFileOut = new DataOutputStream( new FileOutputStream("TestStream.dat"));
			for(k = 0; k < myFloats.length; k++)
				myFileOut.writeFloat(myFloats[k]);
			myFileOut.close();
			
			myFileIn = new DataInputStream(new FileInputStream("TestStream.dat"));
			for(k = 0; myFileIn.available() > 0; k++)
				myFloats[k] = myFileIn.readFloat();
			myFileIn.close();
			
			for(k = 0; k < myFloats.length; k++) {
				System.out.print(tidy.format(myFloats[k]) + " ");
				if(k % 10 == 0)
					System.out.println();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("\nOops, problem opening the file");
		}
	}
}
