/*
 * Created on 05.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.io;
import java.io.*;
import enigma.exceptions.*;
/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

public class FileIO {
	/**
	 * @param input Filename and path of file that should be imported by the enigma engine
	 * 
	 * @return String from file. Should now be readable for the enigma engine
	 * 
	 */
public static String LoadFile(String input) {
	int i=0,j,k,l,h=0,WalzenConf = 0,WalzenZahl = 0;
	String line;
	FileReader Test = null;
	char readConf[];
	BufferedReader in = null;
	try {
		in = new BufferedReader(new FileReader(input));
		while ((line = in.readLine()) != null){
			line = line.trim().toUpperCase();				//only uppercase and remove white space of both ends
			if(i!=0) 
			input=input+line;
			else{
				j=line.length();
				readConf=line.toCharArray(); i=1;
				for (k=0;k<j;k++){
					if (readConf[k]=='-') {
						if ((k<3)&&(WalzenZahl==0)){throw (Throwable) new FileException("Specify more rollers!");}		//min. of three rollers
						else {if (WalzenZahl==0) WalzenZahl = k;
						if ((WalzenZahl*4-5)<j) WalzenConf=(WalzenZahl*4-5); else WalzenConf=j-1;
						if ((WalzenZahl==k)&&((readConf[WalzenConf]!=readConf[k]&&((WalzenZahl*4-5)<(j-1)))||((readConf[WalzenConf]==readConf[k])&& ((WalzenZahl*4-5)==j))||((WalzenZahl*4-5)>j))) throw (Throwable) new FileException("Bad roller configuration in fileheader");
						else if (h!=0){
							if ((0!=(j+4-4*WalzenZahl)%2)||(26<(j+4-(4*WalzenZahl)))) throw (Throwable) new FileException("Bad stickboard! Too many plugs ("+(j+4-4*WalzenZahl)+") or one unconnected ("+((j+4-4*WalzenZahl)%2)+")! "+k+" "+WalzenZahl+" "+j+" "+(WalzenZahl*4-5));
							else if (k==j-1) h=1;																		//no plugs attached
								 else h=2;																//plugs attached
							}
						else h=1;
						}
					}
				}			
				if (WalzenZahl != 0){									//Fileheader seems to exist
					for(k=0;k<j;k++){
						if (k==0) {Test=new FileReader("enigma/data/EnRo"+readConf[k]+".RoC");input="-"+WalzenZahl+h+"-"+readConf[k]+"";}			//tests, if roller exists and write numbers of rollers, existence of plugboard and first roller
						if ((k>0)&&(k<(WalzenZahl-1))) {Test=new FileReader("enigma/data/MeRo"+readConf[k]+".RoC");input=input+readConf[k];}		//tests, if roller exists
						if (k==(WalzenZahl-1)) {Test=new FileReader("enigma/data/ReRo"+readConf[k]+".RoC");input=input+""+readConf[k];} 			//tests, if reflector-roller exists
						else if ((k<WalzenConf)&&(k>(WalzenZahl))) input=input+readConf[k];
						if (k>WalzenConf) {
							for (k=(WalzenConf+1);k<j;k++){
								if ((readConf[k]<65)||(readConf[k]>90)) throw (Throwable) new FileException(readConf[k]+" is bad char for plugboard at position: "+k);
							   	input=input+readConf[k];
							   	for (l=(k+1);l<j;l++) if (readConf[k]==readConf[l]) throw (Throwable) new FileException(readConf[k]+" :-: "+readConf[l]+" Only one plug per char permitted at position: "+k+" and "+l);
							}
						}
					}
					input=input+"-";
				}
				else input=input+line;							//No Fileheader? Then just readLine
			}
		}
		in.close();
	}

	catch (FileException err) {
		System.err.println(err.getMessage());
		err.printStackTrace();
	}
	catch (FileNotFoundException err) {
	// TODO Auto-generated catch block
	System.err.println( "File not found:"+err.getMessage());
			err.printStackTrace();
	}
	catch (IOException err) {
	// TODO Auto-generated catch block
	System.err.println( "Error reading line:"+err.getMessage());
	err.printStackTrace();
	}
	finally {
		if (input != null) {
			try {in.close();}
			catch(IOException err) {
				System.err.println( "Close-Error:"+ err.getMessage());
				err.printStackTrace();
			}
		}
	return input;		
	}	
}

	/**
	 * @param arr
	 * @param subj
	 * @param from
	 * @param to
	 * @return true, if subject is in array between from and to
	 */
/*	private static boolean charInArray(char[] arr, char subj, int from, int to) {
		// TODO Auto-generated method stub
		int i;
		for (i=from;i<=to;i++)
		{
		System.out.println(arr[i]+" "+subj);
		if (arr[i]==subj) {System.out.println(arr[i]+" true "+subj); return true;}
		}
		System.out.println(" false ");
		return false;
	}*/
}