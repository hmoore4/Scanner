import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;



/*
 * @author Hunter Moore
 * 9/15/19
 * Program scans through text document and identifies different types of tokens
 */
 
 public class ScanIt{
 
 	public static void ScanIt() throws IOException, FileNotFoundException{

    File f = new File("prog.x");
    Scanner fileScanner = new Scanner(f);
    LineNumberReader reader = new LineNumberReader(new FileReader(f));
     		
    int c = 0;
    int d = 0;
    int lineNumber = 1;

/*	while((c = reader.read()) != -1){
	if(reader.readLine() != null)
				lineNumber++;
	System.out.print(lineNumber);
				}*/
				   /* while(fileScanner.hasNext()){
				        	System.out.println(fileScanner.next());
				        	fileScanner.next();*/
		 // while(fileScanner.hasNextLine())
		  //{
		  	//lineNumber++;
		  	//System.out.print(lineNumber);
		  	//}
		  	//}
    while((c = reader.read()) != -1){ //&& reader.readLine() != null){
		
    //	if(reader.readLine() != null)
			//	lineNumber++;
    

    	StringBuilder builder = new StringBuilder();
    	char character = (char) c;
    	char secondChar;		
    	
    	
    	/*		reader.mark(c);
		while(reader.readLine() != null){
			lineNumber++;
			reader.reset();
		}*/
    	if(Character.isDigit(character)){
    		builder.append(character);
    		d = reader.read();
    		secondChar = (char) d;
    		if(secondChar != '.'){
    		  lineNumber = reader.getLineNumber() + 1;
    			System.out.println(lineNumber + ": integer '" + builder + "' found");
    		}
    		
    		else if(secondChar == '.'){
    			builder.append(secondChar);
    			d = reader.read();
   				secondChar = (char) d;
   				while(secondChar == '0' || secondChar== '1' || secondChar == '2' || secondChar == '3' || secondChar == '4' || secondChar == '5' || secondChar == '6' || secondChar == '7' || secondChar == 						'8'|| secondChar == '9'){
		 				builder.append(secondChar);
		 				d = reader.read();
	  				secondChar = (char) d; 
   				}
   				lineNumber = reader.getLineNumber() + 1;
	  				System.out.println(lineNumber + ": float '" + builder + "' found");    				
    		}  
    	}
    	
    	
    	if(character == '.'){
    	  builder.append(character);
    		d = reader.read();
    		secondChar = (char) d;
    	   while(secondChar == '0' || secondChar== '1' || secondChar == '2' || secondChar == '3' || secondChar == '4' || secondChar == '5' || secondChar == '6' || secondChar == '7' || secondChar == 				 '8'|| secondChar == '9'){ 
		  	 		builder.append(secondChar);
		  			d = reader.read();
		  			secondChar = (char) d; 

    		 }
    		 		if(builder.length() > 1){
    		 		lineNumber = reader.getLineNumber() + 1;
    			  	System.out.println(lineNumber + ": float '" + builder + "' found"); 
    			  	}
    			  else{
    			  lineNumber = reader.getLineNumber() + 1;
    			  	System.out.println(lineNumber + ": operator '" + builder + "' found");
    			  	}
    			   
    	}
    	
    	if(character == '+' || character == '-' ||character == '&' ||character == '/' ||character == '*' ||character == '(' ||character == ')' ||character == '[' ||character == ']'|| character == '=' ||character == '!' ||character == ':'|| character == '.' ||character == ',' ||character == '<'|| character == ';'){
    	lineNumber = reader.getLineNumber() + 1;
    		System.out.println(lineNumber + ": operator '" + character + "' found");
    		}
    		
    	if(character == '"'){

    		d = reader.read();
    		secondChar = (char) d;
    		while(secondChar != '"'){
    			builder.append(secondChar);
	    		d = reader.read();
  	  		secondChar = (char) d;
  	  		if(secondChar == '"'){
  	  		//Need to figure out how to include substrings in string... Has something to do with allow for \ and not having to check the next character
  	  			  		/*if(secondChar == '\'){
							builder.append(secondChar);
	    				d = reader.read();
							builder.append(secondChar);
							d = reader.read();
  	  				secondChar = (char) d;
						}*/
  	  		
  	  		
  	  		}
    		}
    		lineNumber = reader.getLineNumber() + 1;
    	  System.out.println(lineNumber + ": string '" + builder + "' found");
    	}
    	
    	if(Character.isLetter(character) || character == '_'){
    			builder.append(character);
    			d = reader.read();
  	  		secondChar = (char) d;
  	  		while(Character.isLetter(secondChar) || secondChar == '_' || Character.isDigit(secondChar)){
			  		builder.append(secondChar);
			  		d = reader.read();
			  		secondChar = (char) d;
    			}	  
    			//CLOSER EXCEPT OPERATOR AFTER PRINT ISN"T SHOWING
    			 lineNumber = reader.getLineNumber() + 1;
    			 System.out.println(lineNumber + ": identifier '" + builder + "' found"); 		
    	}
    	
    	//if(character == '\u2122') System.out.print("HI"); 
    	
    	//LINENUMBER... IF CHARACTER EQUALS LINE BREAK THEN ADD TO LINE NUMBER
    	    //if(character == '\10'){ System.out.println("lineNumber: "); lineNumber++;}

    	//UNKNOWN CHARACTER -- FIND UNICODE FOR IT IN CHAR API
    	//else(
    	//	System.out.print(": unknown character " + Character.);
    	//)
    	
    	 	    	    	//	System.out.println(": unknown character " + builder + Character.getName(character) + "    " + (int)character);
    }
  
 /*  
    int lineNumber = 1;
    while(fileScanner.hasNext()){
    	System.out.println(fileScanner.next());
      //System.out.println("'" + fileScanner.next() + "' found");
    		
		  while(fileScanner.hasNextLine()){
		  System.out.println(fileScanner.nextLine());
		  	lineNumber++;
		  }
    
    }
     fileScanner.close();
     System.out.printf("%d lines\n", lineNumber);

*/
	 	
	//}
	reader.close();
 	}
 	
 
	 public static void main(String[] args)throws IOException, FileNotFoundException{
	 	ScanIt();
	 }
 }
