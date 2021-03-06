//Tyler Gester
//Project 2
//cs360
//10-18-15
public class Project2 {
	
	public static void main(String[] args){
		//check if args is not a string or multiple arguments 
		if(!String.class.isInstance(args[0])){
			System.out.println("please enter a file name");
			System.exit(2);
		}
		if(args.length != 1){
			System.out.println("please enter only a file name and nothing else ");
			System.exit(2);
		}
		//setup code for adding loop
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
		//do not forget to close file
		input.close();
		
		//uncomment lines in HashTab and the line below to print out the testing csv file 
//		ToFile.toFile(arry.testingtab,"output.csv");
		
		//print out hash table in correct form 
		System.out.println(arry);
	}
}