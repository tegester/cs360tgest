
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
		String theword = input.readWord();
		while(theword != null){
			arry.addword(theword);
			theword = input.readWord();
		}
		input.close();
		ToFile.toFile(arry.testingtab,"output.csv");
		System.out.println(arry);
	}
}