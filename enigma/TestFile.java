/*
 * Created on 07.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma;
import enigma.io.*;
import java.io.*;
import enigma.engine.*;
/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class TestFile {
	public static String TestIO(){
		String File,Save,input="";
				int i;
				File="enigma/data/ReadHeader.txt";
				Save="enigma/data/ReadHeader.tmp";
				System.out.println("___");
		  		System.out.println("Try to read: \""+File+"\"");
		  		System.out.println("^^^");
		  		try{
		  			input=FileIO.LoadFile(File);
					System.out.println("___");
					System.out.println("Try to save: \""+Save+"\"");
					System.out.println("^^^");
					System.out.println(input);
					FileIO.SaveFile(input,Save);
		  			}
				catch (IOException err) {
					// TODO Auto-generated catch block
					System.err.println( "Error reading line:"+err.getMessage());
					err.printStackTrace();
			}
				
				return input;
	}

	public static void main(String[] args) {
		System.out.println(TestIO());
		Engine test=new Engine(99);
	}
}
