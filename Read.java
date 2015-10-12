import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Read{
	BufferedReader reader;
	
	public Read(String file){
		try {
			reader = Files.newBufferedReader(Paths.get(file));
			if(!reader.ready()){
				System.out.println("please use a vialid file");
				System.exit(4);
			}
		} catch (IOException e) {
			System.out.println("please enter a valed text file");
			System.exit(99);
		}
		
	}
	//returns the next word even if there are preceding separators
	//returns null if there is no next word
	public String readWord(){
		String newword = "";
		try{
			String separators = ",.!?\"%$&- 	"+'\n'+'\r'+"1234567890";
			//read first character
			int c = reader.read();
			//check if next character is end of file
			if (c == -1){
				return null;
			}
			String letter = Character.toString((char) c);
			//remove preceding separators or reach end of file
			while(separators.contains(letter)){
				c = reader.read();
				if (c == -1){
					return null;
				}
				letter = Character.toString((char) c);
			}
			//now letter is always the first part of a word 
			while(!separators.contains(letter)){
				newword= newword + letter;
				c = reader.read();
				if (c == -1){
					return newword;
				}
				letter = Character.toString((char) c);
			}
			
		}catch (IOException e) {
			System.out.println("check readword io error");
			System.exit(9);
		}
		return newword;
	}
	
	public void close(){
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("issues with closing");
			System.exit(22);
		}
	}
}

