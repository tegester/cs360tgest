import java.util.Objects;


public class word {
	String loname;
	linkedList words;
	int count = 0;
	
	

	public word(String name) {
		loname = name.toLowerCase();
		count ++;
		words = new linkedList();
		if(!Objects.equals(loname, name)){
			words.add(name);
		}
	}
	
	public String getname(){
		return loname;
	}
	
	public void addword(String word){
		count++;
		if(!Objects.equals(loname, word) && words.contains(word)){
			words.add(word);
		}	
	}

}
