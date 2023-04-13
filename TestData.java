//********************************************************************
//  TestData.java       Java Foundations
//
//  Demonstrates I/O exceptions and the use of a character file
//  output stream.
//********************************************************************

import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
* This class creates a file named test.dat and allows the user to open the file 
* if their desired file name matches.
* 
*
* @author Ethan Hopkins
* @version 1.0
* TestData Class
* Spring Semester/Freshman Year
*/


public class TestData
{
   //-----------------------------------------------------------------
   //  Creates a file of test data that consists of ten lines each
   //  containing ten integer values in the range 10 to 99.
   //-----------------------------------------------------------------
   public static void main(String[] args) throws IOException,FileNotFoundException
   {
      final int MAX = 10;

      int value;
      String file = "test.dat";

      Random rand = new Random();
      Scanner scan = new Scanner(System.in); 
    //  Scanner scan = new Scanner(System.in);
      
      FileWriter fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter outFile = new PrintWriter(bw);
      
      for (int line=1; line <= MAX; line++)
      {
         for (int num=1; num <= MAX; num++)
         {
            value = rand.nextInt(90) + 10;
            outFile.print(value + "   ");
         }
         outFile.println();
      }

      outFile.close();
      System.out.println("Output file has been created: " + file);
      
      
      System.out.println("Enter name of file to open: ");
      String input = scan.nextLine();
      
      
      
      /**
       * Try-catch block to catch the FileNotFound exception if the input file doesn't exist
       */
      try {
    	  for (int i = 0; i < MAX; i++) {
    		FileReader fr = new FileReader(input); //new FileReader object to read the input
    		BufferedReader br = new BufferedReader(fr);//new BufferedReader object to read the contents of the file  
    	  	System.out.println(br.readLine());
 
      	}
      } catch (FileNotFoundException exception) {
    	  System.out.println("File does not exist.");
      }//end try-catch block
      
   }
   
   //end program
}		
