/*
 * Created on 07.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma;
import enigma.io.*;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class TestFile {
	public static String TestIO(){
		String File;
				int i;
				File="enigma/data/ReadHeader.txt";
				System.out.println();
		  		System.out.println("Try to read: \"enigma/data/ReadHeader.txt\"");
		  		System.out.println();
				return FileIO.LoadFile(File);
	}

	public static void main(String[] args) {
		System.out.println(TestIO());
	}
}
