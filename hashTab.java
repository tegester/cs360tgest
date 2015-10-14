public class HashTab {
	//word[] table;
	LinkedList<Word>[] table;
	int length;
	double currHash;
	int fill;
	int power;
//	int[] testingtab;

	public HashTab() {
		//Initial length of table 
		power = 1;
		length = (int) Math.pow(2, power);
		//book suggest this is good hash
//		currHash = (Math.sqrt(5)-1)/2;
		//Changed to this hash testing showed slight improvement over other 
		currHash = (Math.exp(Math.PI))%1;
		fill = 0;
		//table = new word[length];
		table = new LinkedList[length];
//		testingtab= new int[length];
		for(int i=0; i < length; i++){
			table[i] = new LinkedList<Word>();
//			testingtab[i] = 0;
		}
	}
	
	public void addword(String nWord){
		//convert nword to lower case
		String lword = nWord.toLowerCase();
		//Calculate k value by each character's ASCII value * its index+1
		int hash = hashWord(lword);
		Word wordwithstring = indexHasWord(hash,lword);
		if(wordwithstring != null){
				wordwithstring.addword(nWord);
		}
		else{
			table[hash].add(new Word(nWord));
//			testingtab[hash]++;
			fill++;
		}
		if((float)fill/length >= 1){
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
//		ToFile.toFile(testingtab, "output"+String.valueOf(length)+".csv");
		power++;
		length = length * 2;
		LinkedList<Word>[] newtable = new LinkedList[length];
//		int[] newtestingtab = new int[length];
		for(int i=0; i < length; i++){
			newtable[i] = new LinkedList<Word>();
//			newtestingtab[i]=0;
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
//					newtestingtab[newhash]++;
				}
			}
		}
		table = newtable;
//		testingtab = newtestingtab;
		
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
		int wordLen = lword.length();
		for(int i=0; i<wordLen;i++){
			//conversion to int is sum of s[i] * 73 ^(n-1-i)
			k = k*73 + lword.charAt(i);
			
		}
		k = Math.abs(k);
		//currently using (Math.sqrt(5)-1)/2; for hash
		//see excel files for progression of hash 
		int hashNumber =(int) Math.floor(length*((k*currHash)%(1)));
		return hashNumber;
	}
}