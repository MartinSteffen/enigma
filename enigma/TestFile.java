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
	public static String TestIO(String File, String Save) throws IOException{
		int i,j,help=0;
		char readString[];
		String input="",decoded="";
		System.out.println("___");
		System.out.println("Try to read: \""+File+"\"");
		System.out.println("^^^");
		input=FileIO.LoadFile(File);
		System.out.println("___");
		System.out.println("Try to save: \""+Save+"\"");
		System.out.println("^^^");
		Engine enigma = BuildEnigma.BuildEnimga(input,File,Save);//new Engine(NrOfRollers,Roller,PB);
//String ttee="";
enigma.getState();
enigma.printState();
		j=input.length();
		readString=input.toCharArray();
		for (i=0;i<j;i++){
			if(readString[i]=='-')help++;
			if (help==4) {help=i+1;i=j;}
			if ((help==3)&&(!enigma.ifPb())){help=i+1;i=j;}
		}
		for (i=help;i</*2+help*/j;i++)
			if (readString[i]==32) decoded=decoded+readString[i];
			else decoded=decoded+(enigma.toEnigma(readString[i]));
		System.out.println("Output:");
		System.out.println(decoded);
		System.out.println("");
		FileIO.SaveFile(decoded,Save);
enigma.getState();
enigma.printState();
System.out.println(input);
		return input;
	}

	public static void main(String[] args) {
		try{
//			System.out.println(TestIO("enigma/data/C543A-OJE241202-ABEFIJMNQRUV.test","enigma/data/C543A-OJE241202-ABEFIJMNQRUVtest.klartext"));

			TestIO("enigma/data/B123A-EGO010101.txt","enigma/data/B123A-EGO010101.klartext");
			TestIO("enigma/data/B345A-OIL010101.txt","enigma/data/B345A-OIL010101.klartext");
			TestIO("enigma/data/B512A-ORT010101-ABEFIJMNQRUV.txt","enigma/data/B512A-ORT010101-ABEFIJMNQRUV.klartext");
			TestIO("enigma/data/B531A-PUT171202.txt","enigma/data/B531A-PUT171202.klartext");
			TestIO("enigma/data/C135A-ACE011102-ABEFIJMNQRUV.txt","enigma/data/C135A-ACE011102-ABEFIJMNQRUV.klartext");
			TestIO("enigma/data/C451A-ALF160303.txt","enigma/data/C451A-ALF160303.klartext");
			TestIO("enigma/data/C234A-EGO010101-ABEFIJMNQRUV.txt","enigma/data/C234A-EGO010101-ABEFIJMNQRUV.klartext");
			TestIO("enigma/data/C543A-OJE241202-ABEFIJMNQRUV.txt","enigma/data/C543A-OJE241202-ABEFIJMNQRUV.klartext");
		}
		catch (IOException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
		}
	}
}
