
public class Project2 {
	
	public static void main(String[] args){
		//check if args is not a string or multiple arguments 
		if(!String.class.isInstance(args[0])){
			System.out.println("please enter a file name");
			System.exit(2);
		}
		if(args.length != 1){
			System.out.println("please enter only a file name");
			System.exit(2);
		}
		Read input = new Read(args[0]);
		HashTab arry = new HashTab();
		//read first word before loop
		String theword = input.readWord();
		while(theword != null){
			//read all the words 
			//put words into table
			arry.addword(theword);
			//last null will not be sent to hash table
			theword = input.readWord();
		}
		input.close();
		
		//umcomment lines in HashTab and these to print out the output files 
//		ToFile.toFile(arry.testingtab,"output.csv");
		
		//print out hash table in correct form 
		System.out.println(arry);
	}
}