package lab5;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;


public class TestSparseMatrix {


		public static void main(String[] args) throws IOException {
			
			 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Enter Matrix Size");
 
			    int mat_size = myObj.nextInt();  // Read user input
			System.out.println("enter default value");
		    double default_value = myObj.nextDouble();  // Read user input
			
			SparseMatrix c=new SparseMatrix(mat_size,default_value);
			SparseMatrix b=new SparseMatrix(mat_size,default_value);
			
			InputStreamReader reader = new InputStreamReader(System.in);
			StreamTokenizer tokens = new StreamTokenizer(reader);
	 

			String tmpString;
			if ((tokens.nextToken()) != StreamTokenizer.TT_WORD)
			{
				tmpString = new String("" + tokens.nval);
			} 
			else {
				tmpString = tokens.sval;
			}
			while (!tmpString.equals("Q")) {
				
				switch (tmpString) {
			
				case "print":
					System.out.println(c.toString());
					break;
				case "put":
					tokens.nextToken();
					int i= (int) tokens.nval;
					tokens.nextToken();
					int j= (int) tokens.nval;
					tokens.nextToken();
					double val= (double) tokens.nval;
					c.put(i, j, val);
					break;
				case "get":
					tokens.nextToken();
					int i1= (int) tokens.nval;
					tokens.nextToken();
					int j1= (int) tokens.nval;
					
					System.out.println(c.get(i1, j1));
					break;
				case "size":
					 System.out.println(c.getSize());
					
					break;
				case "multc":
					tokens.nextToken();
					int i2= (int) tokens.nval;
					
					c.multByConstant(i2);
					break;
				case "transpose":
					c.transpose();
					break;
				case "add":
					c.Addition(b);
					break;
				case "sub":
					c.subtraction(b);
					break;
				default:
					
					break;
				}
				
				if ((tokens.nextToken()) != StreamTokenizer.TT_WORD) {
					tmpString = new String("" + tokens.nval);
				} else {
					
					tmpString = tokens.sval;
				}
			
		} 
			
			myObj.close();
		}

	}


