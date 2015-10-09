public class hashTab {
	//word[] table;
	linkedList<word>[] table;
	int length;
	float currHash;
	int fill;
	int power;

	public hashTab() {
		//h(k) = floor(length(k*currHash mod(1))
		//Initial length of table 
		power = 10;
		length = (int) Math.pow(2, power);
		currHash = (float) (Math.sqrt(5)-1)/2;
		fill = 0;
		//table = new word[length];
		table = new linkedList[length];
	}
	
	public void addword(String nWord){
		fill++;
		//convert nword to lower case
		String lword = nWord.toLowerCase();
		//Calculate k value by each character's ASCII value * its index+1
		int hash = hashWord(lword);
		table[hash].add(new word(nWord));
		if((float)fill/length >= .5){
			doub();
		}
		
	}
	
	private void doub() {
		power++;
		linkedList<word>[] newtable = new linkedList[(int) Math.pow(2, power)];
		
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