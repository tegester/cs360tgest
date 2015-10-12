import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Project2 {
	
	public static void main(String[] args){
		
		if(!String.class.isInstance(args[0])){
			System.out.println("please inter a file name");
			System.exit(2);
		}
		read input = new read(args[0]);
		System.out.println(input.readWord());
		
		HashTab arry = new HashTab();
		arry.addword("hey");
		arry.addword("Hey");
		arry.addword("hEy");
		arry.addword("Hey");
		arry.addword("hey");
		arry.addword("boo");
		arry.addword("yo");
		
		System.out.println(arry);
		
//		Word[] arr = new Word[10];
//		arr[0] = new Word("hey");
//		System.out.println(String.valueOf('c'));
//		for(int i =0; i <arr.length; i++){
//			//System.out.println("here at "+i);
//			if (null != arr[i]){
//				System.out.println(arr[i].getname());
//			}
//		}
//		LinkedList<String> st = new LinkedList<String>();
//		st.add("hey");
//		System.out.println(st.toString());
//		LinkedList<Word> wd = new LinkedList<Word>();
//		wd.add(arr[0]);
//		System.out.println(wd.toString());
//		
//		char c = 'z';
//		System.out.println((int) c);
//		String caps = "He'y";
//		String lower = "he'y";
//		if(Objects.equals(caps.toLowerCase(), lower)){
//			System.out.println("yep");
//		}
//		else{
//			System.out.println(caps +" dose not equal "+ lower);
//			System.out.println("hey");
//		}
	}
	
}

class read{
	BufferedReader reader;
	
	public read(String file){
		try {
			reader = Files.newBufferedReader(Paths.get(file));
			if(!reader.ready()){
				System.out.println("please use a vialid file");
				System.exit(4);
			}
		} catch (IOException e) {
			System.out.println("please eneter a valed text file");
			System.exit(99);
		}
		
	}
	//returns the next word even if there are preceding separators
	//returns null if there is no next word
	public String readWord(){
		String newword = "";
		try{
			String separators = ",.!?\"%$&- 	\n\r1234567890";
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
}
