import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.io.IOException;
//import java.lang.StringBuilder;
//import java.util.*; 



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
    	//d = c.read();
    	if(character == '0' || character == '1' || character == '2' ||character == '3' ||character == '4' ||character == '5' ||character == '6' ||character == '7' ||character == '8' ||character == '9'){
    		builder.append(character);
    		reader.skip(1);
    		//MIGHT be on to something. If characater is an int, skip 
    		//MAYBE get rid of this second while loop
    		//while((c = reader.read()) != -1){
    			if(character != '.'){
    				System.out.println("integer '" + builder + "' found");
    				//reader.read();
    			}
    		
    			else if(character == '.'){
    				builder.append(character);
    				d = reader.read();
    				secondChar = (char) d;
    				System.out.println("float '" + builder + "' found");
    			}
    		//}
  
    	}
    	
    	if(character == '+' || character == '-' ||character == '&' ||character == '/' ||character == '*' ||character == '(' ||character == ')' ||character == '[' ||character == ']'|| character == '=' ||character == '!' ||character == ':'|| character == '.' ||character == ',' ||character == '<'|| character == ';'){
    		System.out.println(": operator '" + character + "' found");
    		}
    	if(character == 'p')
    		System.out.print("HI");

    //	System.out.println(character);
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
		/*File f = new File("prog.x");
    Scanner fileScanner = new Scanner(f);
    int lineNumber = 0;
    while(fileScanner.hasNextLine()){
    	System.out.println(fileScanner.nextLine());
    	System.out.println(lineNumber + ": ");
    	lineNumber++;
    }
     fileScanner.close();
     System.out.printf("%d lines\n", lineNumber);*/
	 	ScanIt();
	 }
 }
