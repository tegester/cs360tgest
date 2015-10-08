public class hashTab {
	//word[] table;
	int[] table;
	float currHash;
	int fill;
	int power;
	int length;

	public hashTab() {
		//h(k) = floor(length(k*currHash mod(1))
		//Initial length of table 
		power = 10;
		int length = (int) Math.pow(2, power);
		currHash = (float) (Math.sqrt(5)-1)/2;
		fill = 0;
		//table = new word[length];
		table = new int[length];
	}
	
	public void addword(String nWord){
		fill++;
		//convert nword to lower case
		String lword = nWord.toLowerCase();
		//Calculate k value by each character's ASCII value * its index+1
		int hash = hashWord(lword);
		//remove and accualy hash ...
		table[hash]++;
	}
	
	//get random number and check divisible by 2 then repeat until non divisible by 2 number is found 
	private int hashWord(String lword){
		int k =0;
		for(int i=0; i<lword.length();i++){
			k = k + (int)(lword.charAt(i))*(i+1);
		}
		int hashNumber =(int) Math.floor(length*((k*currHash)%(1)));
		return hashNumber;
	}
}