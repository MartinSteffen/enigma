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
import enigma.exceptions.*;
/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class TestFile {
	public static String TestIO() throws IOException{
		char readString[];
		Roller[] Roller;
		char[] PlugArr=new char[26];
		PlugBoard PB=new PlugBoard(PlugArr);
		int WalzenZahl=0,j=0,h=0,m=0,o=0;
		boolean plugB=false;
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
					System.err.println("Error reading line:"+err.getMessage());
					err.printStackTrace();
				}
				j=input.length();
				readString=input.toCharArray();
				if (readString[0]=='-'){
					if (readString[3]=='-')
					{WalzenZahl=FileIO.getNumericValue(readString[1]); if (readString[2]=='2') plugB=true;} 
					else {WalzenZahl=((FileIO.getNumericValue(readString[1]))*10+(FileIO.getNumericValue(readString[2])));m=1;if(readString[3]=='2') plugB=true;}
					Roller=new Roller[WalzenZahl];	
						o=4+m;int off=o+WalzenZahl*2-2;				
						for (i=0;i<WalzenZahl;i++){
System.out.print(i);
							if ((i!=0)&&(i!=WalzenZahl-1))
							{Roller[i]=new Roller(readString[i+o],readString[i+o+WalzenZahl-1],(FileIO.getNumericValue(readString[off])*10+FileIO.getNumericValue(readString[off+1])));off=off+2;} 
							else {if (i==0){Roller[i]=new Roller(readString[i+o]);}
							else {Roller[i]=new Roller(readString[i+o]);}}
						}
						if(plugB){
							for (i=4;i<j;i++)
							if(readString[i]=='-') {
								off=i+1;
								PlugArr=new char[26];
								PB = new PlugBoard(PlugArr);
								for (h=0;h<j-off+1;h++){
								PlugArr[h]=readString[h+off];
								if (((off+h+1)==j-1)||(readString[off+h+1]=='-')) h=j-1;
								}
								i=j;
							}
						}
				}
				else throw new FileException("No configuration header given!");
System.out.println("Plugboard created:");
for(i=0;i<26;i++)
System.out.print(PB.readChar(i));	
System.out.println("");
System.out.println("Test to create engine:");
				Engine enigma = new Engine(WalzenZahl,Roller,PB);		
				return input;
	}

	public static void main(String[] args) {
		try{
		System.out.println(TestIO());
		}
		catch (IOException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
		}
	}
}
