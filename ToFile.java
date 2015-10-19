import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//used only when making testing array 
public class ToFile {

	public static void toFile(int[] arry, String fileName) {
		
		try {
			BufferedWriter bw  = new BufferedWriter(new FileWriter(fileName));
			
	           String ans = "";
	           
	           //writes csv lines of "index,data"
	           for(int i = 0; i < arry.length; i++){
	               ans = i+","+String.valueOf(arry[i]);
	               bw.write(ans);
	               bw.newLine();
	               ans = "";
	           }
	           //close file
	           bw.close();
		} catch (IOException e) {
			System.out.println("Error writing to file");
			System.exit(3);
		}
	}
}
