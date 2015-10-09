import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Project2 {
	
	public static void main(String[] args){

		word[] arr = new word[10];
		arr[0] = new word("hey");
		System.out.println(String.valueOf('c'));
		for(int i =0; i <arr.length; i++){
			//System.out.println("here at "+i);
			if (null != arr[i]){
				System.out.println(arr[i].getname());
			}
		}
		linkedList<String> st = new linkedList<String>();
		st.add("hey");
		System.out.println(st.toString());
		linkedList wd = new linkedList();
		wd.add(arr[0]);
		System.out.println(wd.toString());
		
		char c = 'z';
		System.out.println((int) c);
		String caps = "He'y";
		String lower = "he'y";
		if(Objects.equals(caps.toLowerCase(), lower)){
			System.out.println("yep");
		}
		else{
			System.out.println(caps +" dose not equal "+ lower);
			System.out.println("nope");
		}
	}
	
}

class read{
	BufferedReader reader;
	
	public read(String file){
		try {
			reader = Files.newBufferedReader(Paths.get(file));
		} catch (IOException e) {
			System.out.println("please eneter a valed text file");
			System.exit(99);
		}
	}
	
	//public String readword(){
		
		
		
//	}
}
