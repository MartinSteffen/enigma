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
	public static String TestIO(String File, String Save) throws IOException{
		char readString[];
		Roller[] Roller;
		int[] PlugArr=new int[26];
		PlugBoard PB=new PlugBoard(PlugArr);
		int WalzenZahl=0,j=0,h=0,m=0,o=0,off2;
		boolean plugB=false;
		String input="",input2="",line;
				int i;
				System.out.println("___");
		  		System.out.println("Try to read: \""+File+"\"");
		  		System.out.println("^^^");
//		  		try{
		  			input=FileIO.LoadFile(File);
//		  			input2=FileIO.LoadFile("enigma/data/Klartext.txt");
					
					System.out.println("___");
					System.out.println("Try to save: \""+Save+"\"");
					System.out.println("^^^");
//					System.out.println(input);
//					FileIO.SaveFile(input,Save);
//		  			}
/*				catch (IOException err) {
					// TODO Auto-generated catch block
					System.err.println("Error reading line:"+err.getMessage());
					err.printStackTrace();
				}*/
				j=input.length();
				readString=input.toCharArray();
				if (readString[0]=='-'){
					if (readString[3]=='-')
					{WalzenZahl=FileIO.getNumericValue(readString[1]); if (readString[2]=='2') plugB=true;} 
					else {WalzenZahl=((FileIO.getNumericValue(readString[1]))*10+(FileIO.getNumericValue(readString[2])));m=1;if(readString[3]=='2') plugB=true;}
					Roller=new Roller[WalzenZahl];	
						o=4+m;int off=o+WalzenZahl*2-2;				
						for (i=0;i<WalzenZahl;i++){
//System.out.print("<>"+i);
							if ((i!=0)&&(i!=WalzenZahl-1))
							{Roller[i]=new Roller(readString[i+o],readString[i+o+WalzenZahl-1],(FileIO.getNumericValue(readString[off])*10+FileIO.getNumericValue(readString[off+1])),FileIO.readRoller("MeRo"+readString[i+o]));off=off+2;} 
							else {if (i==0){Roller[i]=new Roller(readString[i+o],'A',(FileIO.getNumericValue(readString[off])*10+FileIO.getNumericValue(readString[off+1])),FileIO.readRoller("ReRo"+readString[i+o]));}//reflectorroller
							else {Roller[i]=new Roller(readString[i+o],'A',(FileIO.getNumericValue(readString[off])*10+FileIO.getNumericValue(readString[off+1])),FileIO.readRoller("EnRo"+readString[i+o]));}}//entryroller
						}
						if(plugB){
							for (i=5;i<j;i++)
							if(readString[i]=='-') {
								off=i+1;
								off2=-65;
								PlugArr=new int[26];
								PB = new PlugBoard(PlugArr);
								for (h=0;h<j-off+1;h+=2){
//System.out.println(h+"  "+readString[h+off]+" "+readString[h+off+1]+" "+(readString[h+off]+off2));
									PlugArr[(readString[h+off]+off2)]=(readString[h+off+1]-readString[h+off]);
									PlugArr[(readString[h+1+off]+off2)]=(readString[h+off]-readString[h+off+1]);
									if (((off+h+2)==j-1)||(readString[off+h+2]=='-')) h=j-1;
								}
								i=j;
							}
						}
				}
				else throw new FileException("No configuration header given!");
//for (i=0;i<WalzenZahl;i++){
//System.out.println("Printing roller:"+i);
//Roller[i].printRoller();
//System.out.println("");
//}
//PB.printPlugBoard();
//System.out.println("Test to create engine:");
				Engine enigma = new Engine(WalzenZahl,Roller,PB);
//System.out.println("... success");
				String ttee="";
				int help=0;
				for (i=0;i<j;i++){
					if(readString[i]=='-')help++;
					if (help==4) {help=i+1;i=j;}
					if ((help==3)&&(!plugB)){help=i+1;i=j;}
//System.out.println(help+":help | i:"+i); 
				}
				for (i=help;i</*2+help*/j;i++)
					if (readString[i]==32) ttee=ttee+readString[i];
					else ttee=ttee+(enigma.toEnigma(readString[i]));
				System.out.println("Output:");
				System.out.println(ttee);
//				System.out.println(input2);
//				System.out.println("Input:");
//				for (i=help;i<j;i++)
//					System.out.print(readString[i]);
				System.out.println("");
//				try{
//					System.out.println("Try to Save...");
					FileIO.SaveFile(ttee,Save);
//}
/*				catch (IOException err){
					System.err.println(err.getMessage());
					err.printStackTrace();
				}*/
				
				return input;
	}

	public static void main(String[] args) {
		try{
//			System.out.println(TestIO("enigma/data/C543A-OJE241202-ABEFIJMNQRUV.test","enigma/data/C543A-OJE241202-ABEFIJMNQRUV.EncTest"));

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
