
//container class for words keeps a linked list of types of the word and the number of times it is used 
public class Word {
	private String loname; 
	LinkedList<String> words;
	int count = 0;
	
	//add the first word 
	public Word(String name) {
		//save the lower name for use in equals 
		loname = name.toLowerCase();
		count ++;
		words = new LinkedList<String>();
		//if word added is not lower-case, add it to the list of different ones 
		if(!loname.equals(name)){
			words.add(name);
		}
	}
	
	public String getname(){
		return loname;
	}
	
	// add a new word
	public void addword(String word){
		// always increment the count
		count++;
		//if not lower-case or in the list of different words, add it to the list of different words
		if(!loname.equals(word) && !words.contains(word)){
			words.add(word);
		}	
	}

	//convert words to string 
	public String toString(){
		
		String sPrint = loname;
		if(words.isList()){
			sPrint = sPrint+" (";
			words.newWalk();
			//check if there are more words in the list
			while(words.isNext()){
				//gets next word and adds it to the string
				sPrint = sPrint+ words.nextNode()+" ";
			}
			// remove the last space 
			sPrint =sPrint.substring(0,sPrint.length()-1);
			sPrint = sPrint+")";
		}
		sPrint = sPrint +" - "+ count;
		return sPrint;
	}

}
