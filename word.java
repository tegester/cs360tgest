import java.util.Objects;


public class Word {
	private String loname; 
	LinkedList<String> words;
	int count = 0;

	public Word(String name) {
		loname = name.toLowerCase();
		count ++;
		words = new LinkedList<String>();
		if(!loname.equals(name)){
			words.add(name);
		}
	}
	
	public String getname(){
		return loname;
	}
	
	
	
	public void addword(String word){
		count++;
		if(!loname.equals(word) && !words.contains(word)){
			words.add(word);
		}	
	}

	public String toString(){
		
		String sPrint = loname;
		if(words.isList()){
			sPrint = sPrint+" (";
			words.newWalk();
			while(words.isNext()){
				sPrint = sPrint+ words.nextNode()+" ";
			}
			sPrint =sPrint.substring(0,sPrint.length()-1);
			sPrint = sPrint+")";
		}
		sPrint = sPrint +" - "+ count;
		return sPrint;
	}

}
