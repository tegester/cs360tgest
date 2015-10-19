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
		//table starts out at a length of 2
		power = 1;
		length = (int) Math.pow(2, power);
		//book suggest this is good hash
//		currHash = (Math.sqrt(5)-1)/2;
		//tested if rehashing is important ... it is
//		currHash = 1;
		//Changed to this hash testing showed slight improvement over others 
		//please see excel files for test good hashes had low max chains and fewer zeros
		currHash = (Math.exp(Math.PI))%1;
		//fill is the load factor 
		fill = 0;
		//java doesn't like this line the type is checked in the loop. 
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
		//Calculate k value by each character's ASCII 
		int hash = hashWord(lword);
		//find if the index already has the word return word or null if not
		Word wordwithstring = indexHasWord(hash,lword);
		//if the word exist add to that word
		if(wordwithstring != null){
				wordwithstring.addword(nWord);
		}
		//if not make a new word class. increment fill if adding new word
		else{
			table[hash].add(new Word(nWord));
//			testingtab[hash]++;
			fill++;
		}
		// check for load factor
		//wiki suggest that at a load factor of one the average linked list should still be short
		// testing shows at a load factor of 1 the longest linked list is still under 10 long at 2^16 entries 
		if((float)fill/length >= 1){
			doub();
		}
		
	}
	
	// look for word in index's linked list return word or null if not found
	//order N for n long list
	private Word indexHasWord(int hash, String lword){
		table[hash].newWalk();
		Word temp= null;
		Word curr = null;
		//run through linked list
		while(table[hash].isNext()){
			curr = table[hash].nextNode();
			//compare for word
			if(lword.equals(curr.getname())){
				temp = curr;
				break;
			}
		}
		return temp;
		
	}
	
	//makes a new array of 2^(power+1) and move values to new array
	//this could be faster if I made it multi-threaded it would have the same algremithic speed but...
	//you can still add words while the table is moving 
	private void doub() {
//		ToFile.toFile(testingtab, "output"+String.valueOf(length)+".csv");
		// make new array of longer length
		power++;
		length = length * 2;
		//make new array
		LinkedList<Word>[] newtable = new LinkedList[length];
//		int[] newtestingtab = new int[length];
		for(int i=0; i < length; i++){
			newtable[i] = new LinkedList<Word>();
//			newtestingtab[i]=0;
		}
		//move each word to new table
		Word moving = null;
		int newhash;
		//loop through old table
		for(int i =0; i< table.length;i++){
			//check for list at that index
			if(table[i].isList()){
				//walk each list and move each node
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
	
	//print function by looping through table and printing each list
	public String toString(){
		String st = "";
		for(int i =0; i< table.length;i++){
			if(table[i].isList()){
				table[i].newWalk();
				while(table[i].isNext()){
					//converts table to string by linked list's toString()
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
			//see excel files for failed versions 
			k = k*73 + lword.charAt(i);
			
		}
		k = Math.abs(k);
		//currently using (Math.sqrt(5)-1)/2; for hash
		//see excel files for progression of hash 
		int hashNumber =(int) Math.floor(length*((k*currHash)%(1)));
		return hashNumber;
	}
}