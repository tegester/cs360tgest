import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ToFile {

	public static void toFile(int[] arry, String fileName) {
		
		try {
			BufferedWriter bw  = new BufferedWriter(new FileWriter(fileName));
			
	           String ans = "";

	           for(int i = 0; i < arry.length; i++){
	               ans = i+","+String.valueOf(arry[i]);
	               bw.write(ans);
	               bw.newLine();
	               ans = "";
	           }

	           bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
