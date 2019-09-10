import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * @author Hunter Moore
 * 9/15/19
 * Program scans through text document and identifies different types of tokens
 */
 
 public class ScanIt{
 
 	public static void ScanIt() throws IOException, FileNotFoundException{
    File f = new File("prog.x");
    Scanner fileScanner = new Scanner(f);
    BufferedReader reader = new BufferedReader(new FileReader(f));
     		
    int c = 0;
    int d = 0;

    while((c = reader.read()) != -1){
    	StringBuilder builder = new StringBuilder();
    	char character = (char) c;
    	char secondChar;		
    	if(Character.isDigit(character)){
    		builder.append(character);
    		d = reader.read();
    		secondChar = (char) d;
    		if(secondChar != '.'){
    			System.out.println(": integer '" + builder + "' found");
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
	  				System.out.println(": float '" + builder + "' found");    				
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
    		 		if(builder.length() > 1)
    			  	System.out.println(": float '" + builder + "' found"); 
    			  else
    			  	System.out.println(": operator '" + builder + "' found");
    			   
    	}
    	
    	if(character == '+' || character == '-' ||character == '&' ||character == '/' ||character == '*' ||character == '(' ||character == ')' ||character == '[' ||character == ']'|| character == '=' ||character == '!' ||character == ':'|| character == '.' ||character == ',' ||character == '<'|| character == ';'){
    		System.out.println(": operator '" + character + "' found");
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
    	  System.out.println(": string '" + builder + "' found");
    	}
    	
    	if(Character.isLetter(character) || character == '_'){
    			builder.append(character);
    			d = reader.read();
  	  		secondChar = (char) d;
  	  		while(Character.isLetter(secondChar) || secondChar == '_' || secondChar == '0' || secondChar== '1' || secondChar == '2' || secondChar == '3' || secondChar == '4' || secondChar == '5' || 					secondChar == '6' || secondChar == '7' || secondChar == 				 '8'|| secondChar == '9'){
  	  		builder.append(secondChar);
  	  		d = reader.read();
  	  		secondChar = (char) d;

    			}	  
    			//CLOSER EXCEPT OPERATOR AFTER PRINT ISN"T SHOWING
    			 System.out.println(": identifier '" + builder + "' found"); 		
    	}
    	
    	//UNKNOWN CHARACTER -- FIND UNICODE FOR IT IN CHAR API
    	//else(
    	//	System.out.print(": unknown character " + Character.);
    	//)
    	
    	
    	
    	
    	
    }
  
 /*  
    int lineNumber = 1;
    while(fileScanner.hasNext()){
    	System.out.println(fileScanner.next());
      //System.out.println("'" + fileScanner.next() + "' found");
    	if(fileScanner.hasNextInt()){
    		System.out.println(lineNumber + ": integer '" + fileScanner.next() + "' found");
    		}

    
			//if(fileScanner.next() == "+")
			    	//	System.out.println(lineNumber + ": operator '" + fileScanner.next() + "' found");

    	 if(fileScanner.hasNextFloat()){
    	     System.out.println(lineNumber + ": Float '" + fileScanner.next() + "' found");}


		  //while(fileScanner.hasNextLine()){
		  	//System.out.println(fileScanner.nextLine());
		  	//lineNumber++;
		  //}
    
    }
     fileScanner.close();
     System.out.printf("%d lines\n", lineNumber);
*/
 	
 	}
 
	 public static void main(String[] args)throws IOException, FileNotFoundException{
	 	ScanIt();
	 }
 }
