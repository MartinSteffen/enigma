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
		 * @param input String of en-/decrypted chars
		 * @param Filename Filename and path of file that should be exported from the enigma engine
		 * 
		 * @return int -1 if failure occured
		 * 				0 if ok
		 * 
		 * @throws IOException
		 */
public static int SaveFile(String input, String filename) throws IOException{
	char readString[];
	String writeString="";
	int j=0,i,WalzenZahl = 0,k,h=0;
	input=input.trim().toUpperCase();
	j=input.length();
	readString=input.toCharArray();
	if ((readString[0]=='-')&&((readString[3]=='-')||(readString[4]=='-'))){			//Rollerconfig exist?
			if (readString[3]=='-') {k=3;WalzenZahl = getNumericValue(readString[1]);}  //less then 10 rollers?
			else if (readString[4]=='-') {k=4;WalzenZahl = (getNumericValue(readString[1])*10+getNumericValue(readString[2]));} //less then 100 rollers? 
			else return -1;																//don't want more than 99 rollers!
				for (i=5;i<j;i++)
				if (readString[i]=='-') h=i;											//look for end of configuration
//			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(filename, false));
				for (i=(k+1);i<h;i++){
					if (i==(k+WalzenZahl+1)) writeString=writeString+"-";				//we want a standart fileheader
//					if ((i==(WalzenZahl*4+k-5))&&(h!=0)&&(readString[k-1]!='1')) writeString=writeString+"-";
					writeString=writeString+readString[i];
					}
				writeString=writeString+'\n';											//end of configuration -> carriage return
				for(i=(h+1);i<j;i++)
					writeString=writeString+readString[i];
				save.write(writeString);
				save.close();
//			}
/*			catch (IOException err) {
				System.err.println(err.getMessage());
				err.printStackTrace();
				return -1;
			}
/*		finally {
				if (input != null) {
					try {save.close();}
					catch(IOException err) {
						System.err.println( "Close-Error:"+ err.getMessage());
						err.printStackTrace();
					}
				}
		}*/
	}	
	else return 1;
/*		try {
		
		}
/*	catch (IOException err) {
	// TODO Auto-generated catch block
	System.err.println( "Error reading line:"+err.getMessage());
	err.printStackTrace();
	}
	finally {
		if (save != null) {
			try {save.close();}
			catch(IOException err) {
				System.err.println( "Close-Error:"+ err.getMessage());
				err.printStackTrace();
			}
		}
	return -1;
	}*/
	return -1;
}

	/**
 * @param c
 */
public static int getNumericValue(char c) {
	// TODO Auto-generated method stub
	int k=0,i;
	for (i=48;i<=57;i++){
		if (c==i) return k; 
		k++;
	}
	return -1;
}

/**
	 * @param Filename Filename and path of file that should be imported by the enigma engine
	 * 
	 * @return String from file. Should now be readable for the enigma engine
	 * 					-	in first appearence:	Start of configuration
	 * 						   second appearence:	start of roller configuration
	 * 							third appearence:	End of  configuration
	 * 					first part:		All numers except the last specify the number of rollers
	 * 									The last digit: 1 no plugs attached
	 * 												2 plugs attached
	 * 					second part:	Roller configuration and
	 * 									permutations of the plugboard
	 * 					third part:		Data to en-/decrypt
	 * 
	 * @throws	IOException
	 */
public static String LoadFile(String Filename) throws IOException{
	int i=0,j,k,l,m,o=0,h=0,WalzenConf = 0,WalzenZahl = 0;
	String line,input="";
	FileReader Test = null;
	char readConf[];
	BufferedReader in = new BufferedReader(new FileReader(Filename));
//	try {
//		BufferedReader in = new BufferedReader(new FileReader(Filename));
	while ((line = in.readLine()) != null){
		line = line.trim().toUpperCase();				//only uppercase and remove white space of both ends
		if(i!=0){
			j=line.length();
			readConf=line.toCharArray();
			for (k=0;k<j;k++)			
			if (((readConf[k]<91)&&(readConf[k]>64))||(readConf[k]==32)) input=input+readConf[k];
			else throw new FileException("Bad char ("+readConf[k]+") in File:"+Filename);
		}
		else{
			j=line.length();
			readConf=line.toCharArray(); i=1;
			for (k=0;k<j;k++){
				if (readConf[k]=='-') {
					if ((k<3)&&(WalzenZahl==0)){throw new FileException("Specify more rollers!");}		//min. of three rollers
					else {
						if (WalzenZahl==0) WalzenZahl = k;
						if (WalzenZahl>99) throw new FileException("Please specify less than 100 rollers");
						if ((WalzenZahl*4-5)<j) WalzenConf=(WalzenZahl*4-5); else WalzenConf=j-1;
						if ((WalzenZahl==k)&&((readConf[WalzenConf]!=readConf[k]&&((WalzenZahl*4-5)<(j-1)))||((readConf[WalzenConf]==readConf[k])&& ((WalzenZahl*4-5)==j))||((WalzenZahl*4-5)>j))) throw new FileException("Bad roller configuration in fileheader");
						else {
							for(m=WalzenZahl+1;m<(WalzenZahl*4-5);m++)
								if ((m<=(WalzenZahl*2-2))&&((readConf[m]<65)||(readConf[m]>90))) throw new FileException("Bad roller configuration:\""+readConf[m]+"\" at position:"+(m+1));
								else if ((m>(WalzenZahl*2-2))&&((readConf[m]>58)||(readConf[m]<47))) throw new FileException("Bad roller configuration:\""+readConf[m]+"\" at position:"+(m+1));
								else if (m>(WalzenZahl*2-2)&&(o==0)) {if (((getNumericValue(readConf[m])*10)+getNumericValue(readConf[m+1]))>25) throw new FileException("Offset is too high! At position:"+m+" and:"+(m+1)); else o=1;}
								else if (true) o=0;
								else if (((WalzenZahl*4-5)<j)&&(readConf[WalzenZahl*4-5]!='-')) throw new FileException("Bad roller configuration:\""+readConf[WalzenZahl*4-5]+"\" at position:"+(WalzenZahl*4-5));
							if (h!=0){
								if ((0!=(j+4-4*WalzenZahl)%2)||(26<(j+4-(4*WalzenZahl)))) throw  new FileException("Bad stickboard! Too many plugs ("+(j+4-4*WalzenZahl)+") or one unconnected ("+((j+4-4*WalzenZahl)%2)+")! "+k+" "+WalzenZahl+" "+j+" "+(WalzenZahl*4-5));
								else if (k==j-1) h=1;																		//no plugs attached
								else h=2;																//plugs attached
							}
							else h=1;
						}
					}
				}
			}			
			if (WalzenZahl != 0){									//Fileheader seems to exist
				for(k=0;k<j;k++){
					if (k==0) {Test=new FileReader("enigma/data/EnRo"+readConf[k]+".RoC");input="-"+WalzenZahl+h+"-"+readConf[k]+"";}			//tests, if roller exists and write numbers of rollers, existence of plugboard and first roller
					if ((k>0)&&(k<(WalzenZahl-1))) {Test=new FileReader("enigma/data/MeRo"+readConf[k]+".RoC");input=input+readConf[k];}		//tests, if roller exists
					if (k==(WalzenZahl-1)) {Test=new FileReader("enigma/data/ReRo"+readConf[k]+".RoC");input=input+""+readConf[k];} 			//tests, if reflector-roller exists
					else if ((k<=WalzenConf)&&(k>(WalzenZahl))) input=input+readConf[k];
					if (k>WalzenConf) {
						for (k=(WalzenConf+1);k<j;k++){
							if ((readConf[k]<65)||(readConf[k]>90)) throw new FileException(readConf[k]+" is bad char for plugboard at position: "+k);
						   	input=input+readConf[k];
						   	for (l=(k+1);l<j;l++) if (readConf[k]==readConf[l]) throw new FileException(readConf[k]+" :-: "+readConf[l]+" Only one plug per char permitted at position: "+k+" and "+l);
						}
					}
				}
				input=input+"-";
			}
			else input=input+line;							//No Fileheader? Then just readLine
		}
		}
		in.close();
//	}
/*
	catch (FileException err) {
		System.err.println(err.getMessage());
		err.printStackTrace();
	}
/*	catch (FileNotFoundException err) {
	// TODO Auto-generated catch block
	System.err.println( "File not found:"+err.getMessage());
	err.printStackTrace();
	throw new FileNotFoundException("TestIt");
	}

	catch (IOException err) {
	// TODO Auto-generated catch block
	System.err.println( "Error reading line:"+err.getMessage());
	err.printStackTrace();
	}
/*	finally {
		if (Filename != null) {
			try {in.close();}
			catch(IOException err) {
				System.err.println( "Close-Error:"+ err.getMessage());
				err.printStackTrace();
			}
		}		
	}*/	
	return input;
}

	/**
	 * @param arr
	 * @param subj
	 * @param from
	 * @param to
	 * @return true, if subject is in array between from and to
	 */
	private static boolean charInArray(char[] arr, char subj, int from, int to) {
		// TODO Auto-generated method stub
		int i;
		for (i=from;i<=to;i++)
		if (arr[i]==subj) return true;
		return false;
	}
}