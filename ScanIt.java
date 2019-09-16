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
    LineNumberReader reader = new LineNumberReader(new FileReader(f));
     		
    int c = 0;
    int d = 0;
    int lineNumber = 1;
    char secondChar;		


    while((c = reader.read()) != -1){ 																										//While the file has not yet been fully traversed
    	char character = (char) c;
    	StringBuilder builder = new StringBuilder();

    	if(Character.isDigit(character)){																							    	//If it reads a digit
    		builder.append(character);
    		d = reader.read(); 
    		secondChar = (char) d;
    		if(secondChar != '.'){																												//If there's no . after a digit, it mus be an integer
    		  lineNumber = reader.getLineNumber() + 1;
    			System.out.println(lineNumber + ": integer '" + builder + "' found");
    			builder.setLength(0);   				
    		}

    		else if(secondChar == '.'){																										//If there's a ., it must be a float
    			builder.append(secondChar);
    			d = reader.read();
   				secondChar = (char) d;
   				while(Character.isDigit(secondChar)){																				//Adds as many decimal places as needed 
		 				builder.append(secondChar);
		 				d = reader.read();
	  				secondChar = (char) d; 
   				}
   				lineNumber = reader.getLineNumber() + 1;
	  			System.out.println(lineNumber + ": float '" + builder + "' found"); 
	  			builder.setLength(0);   				
    		}
    		
    			if(secondChar != ' '){																										//Makes sure it doesn't skip over a character if they are not separated by a space
			  		character = secondChar;
			  	}
    	}
    	
    	
    	 if(character == '.'){																											//Also detects floats that don't have a full number at the start
    	   builder.append(character);
    		 d = reader.read();
    		 secondChar = (char) d;
    	   while(Character.isDigit(secondChar)){ 
		  	   builder.append(secondChar);
		  		 d = reader.read();
		  		 secondChar = (char) d; 
    		 }   
    		 
    		 if(builder.length() > 1){																									//If the length is more than one, then there are numbers attached and it's a float
    	   	 lineNumber = reader.getLineNumber() + 1;	
    		   System.out.println(lineNumber + ": float '" + builder + "' found"); 
		 
		  		if(secondChar == '.'){
		   	   lineNumber = reader.getLineNumber() + 1;
   			   System.out.println(lineNumber + ": operator '" + character + "' found");
		 		 }

    		 }
    		 else{																																					//Otherwise, it's an operator
   			   lineNumber = reader.getLineNumber() + 1;
   			   System.out.println(lineNumber + ": operator '" + character + "' found");

   			 }		   
    	 }
    	
    	 if(character == '+' || character == '-' ||character == '&' ||character == '/' ||character == '*' ||character == '(' ||character == ')' ||character == '[' ||character == ']'|| character == 				 '=' 			|| character == '!' ||character == ':'|| character == ',' ||character == '<'|| character == ';'){
    		lineNumber = reader.getLineNumber() + 1;
    		System.out.println(lineNumber + ": operator '" + character + "' found");								//Detects operators
    	 }
    		
    	 if(character == '"'){																																		//Detects Strings
    		d = reader.read();
    		secondChar = (char) d;
    		while(secondChar != '"'){																																//Adds characters as long as needed
    			builder.append(secondChar);
	    		d = reader.read();
  	  		secondChar = (char) d;
  	  		if((int)secondChar == 92){																														//If there's a front slash it handles three cases;
  	  			character = secondChar;
  	  			d = reader.read();
  	  			secondChar = (char) d;
  	  			if(secondChar == '"'){																															//If the next character is a ", it adds " to the String
  	  				builder.append(secondChar);
  	  				d = reader.read();
  	  				secondChar = (char) d;
  	  			}
  	  			else if((int)secondChar == 92){																											//If the next character is another \, it adds all but the first 
  	  				d = reader.read();
  	  				secondChar = (char) d;
  	  				builder.append(character);

  	  			}
  	  			else{																																								//If the next character is anything else, it just adds everything to the string normally
  	  				builder.append(character);
  	  			}
  	  		}
  	  		if(secondChar == '"'){
  	  		}
    		}
    		lineNumber = reader.getLineNumber() + 1;
    	  System.out.println(lineNumber + ": string '" + builder + "' found");
    	}
    	
    	 if(Character.isLetter(character) || character == '_'){																	//Detects identifiers
    			builder.append(character);
    			d = reader.read(); 
  	  		secondChar = (char) d;

  	  		while(Character.isLetter(secondChar) || secondChar == '_' || Character.isDigit(secondChar)){
			  		builder.append(secondChar);
			  		d = reader.read();
			  		secondChar = (char) d;
    			}	  
    		 lineNumber = reader.getLineNumber() + 1;
    		 System.out.println(lineNumber + ": identifier '" + builder + "' found"); 	
    	}
    	


  		 if(character == '@' || character == '$' || character == '{' || character == '}' || character == '!' || character == '#' || character == '`' || character == '~' || character == '?' || character 			 == '^' || character == '|'){
  		  lineNumber = reader.getLineNumber() + 1;
  			System.out.println(lineNumber + ": Unknown character " + "0x" + Integer.toHexString((int)character));											//Detects unknown characters
  		}
    }  
	reader.close();
 	}
 	
 
	 public static void main(String[] args)throws IOException, FileNotFoundException{
	 	ScanIt();
	 }
 }
