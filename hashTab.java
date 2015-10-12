public class HashTab {
	//word[] table;
	LinkedList<Word>[] table;
	int length;
	float currHash;
	int fill;
	int power;

	public HashTab() {
		//h(k) = floor(length(k*currHash mod(1))
		//Initial length of table 
		power = 1;
		length = (int) Math.pow(2, power);
		//book suggest this is good hash
		currHash = (float) (Math.sqrt(5)-1)/2;
		fill = 0;
		//table = new word[length];
		table = new LinkedList[length];
		for(int i=0; i < length; i++){
			table[i] = new LinkedList<Word>();
		}
	}
	
	public void addword(String nWord){
		//convert nword to lower case
		String lword = nWord.toLowerCase();
		//Calculate k value by each character's ASCII value * its index+1
		int hash = hashWord(lword);
		if(table[hash].isList()){
			Word wordwithstring = indexHasWord(hash,lword);
			if(wordwithstring != null){
				wordwithstring.addword(nWord);
//				System.out.println("old " +nWord);
			}
			else{
				table[hash].add(new Word(nWord));
				fill++;
//				System.out.println("new Same hash " +nWord);
			}
		}
		else{
			table[hash].add(new Word(nWord));
			fill++;
//			System.out.println("new " +nWord);
		}
		if((float)fill/length > 1){
			doub();
		}
		
	}
	
	private Word indexHasWord(int hash, String lword){
		table[hash].newWalk();
		Word temp= null;
		Word curr = null;
		while(table[hash].isNext()){
			curr = table[hash].nextNode();
			if(lword.equals(curr.getname())){
				temp = curr;
			}
		}
		return temp;
		
	}
	
	private void doub() {
		power++;
		length = length * 2;
		LinkedList<Word>[] newtable = new LinkedList[length];
		for(int i=0; i < length; i++){
			newtable[i] = new LinkedList<Word>();
		}
		Word moving = null;
		int newhash;
		for(int i =0; i< table.length;i++){
			if(table[i].isList()){
				table[i].newWalk();
				while(table[i].isNext()){
					moving = table[i].nextNode();
					newhash= hashWord(moving.getname());
					newtable[newhash].add(moving);
				}
			}
		}
		table = newtable;
	}
	
	public String toString(){
		String st = "";
		for(int i =0; i< table.length;i++){
			if(table[i].isList()){
				table[i].newWalk();
				while(table[i].isNext()){
					st= st + table[i].nextNode()+"\n";
				}
			}
		}
		return st;
	}
	
	private int hashWord(String lword){
		int k =0;
		for(int i=0; i<lword.length();i++){
			k = k + (int)(lword.charAt(i))*(i+1);
		}
		int hashNumber =(int) Math.floor(length*((k*currHash)%(1)));
		return hashNumber;
	}
}