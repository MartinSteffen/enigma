/*
 * Created on 05.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.io;
import java.io.*;
import java.util.jar.*;

import enigma.exceptions.*;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

public class FileIO {

	/**
		 *Saves the internal string to a file.<br>
		 *The result is a configuration header in the first line of the file and<br>
		 *the de-/encrypted text in the following line(s).<br>
		 * @param input String of en-/decrypted chars
		 * @param Filename Filename and path of file that should be exported from the enigma engine
		 * 
		 * @return int<br>
		 * -1 if failure occured<br>
		 * 0  if ok<br>
		 * 
		 * @throws IOException
		 */
public static int SaveFile(String input, String filename) throws IOException{
	char readString[];
	String writeString="";
	int j=0,i,NrOfRollers = 0,k,h=0;
	input=input.trim().toUpperCase();
	j=input.length();
	readString=input.toCharArray();
	if ((readString[0]=='-')&&((readString[3]=='-')||(readString[4]=='-'))){			//Rollerconfig exist?
			if (readString[3]=='-') {k=3;NrOfRollers = ((int)readString[1]-48);}  //less then 10 rollers?
			else if (readString[4]=='-') {k=4;NrOfRollers = (((int) readString[1]-48)*10+((int)readString[2]-48));} //less then 100 rollers? 
			else return -1;																//don't want more than 99 rollers!
				for (i=5;i<j;i++)
				if (readString[i]=='-') h=i;											//look for end of configuration
				BufferedWriter save = new BufferedWriter(new FileWriter(filename, false));
				for (i=(k+1);i<h;i++){
					if (i==(k+NrOfRollers+1)) writeString=writeString+"-";				//we want a standart fileheader
					writeString=writeString+readString[i];
					}
				writeString=writeString+'\n';											//end of configuration -> carriage return
				for(i=(h+1);i<j;i++)
					writeString=writeString+readString[i];
				save.write(writeString);
				save.close();
				return 1;
	}	
	else {
		BufferedWriter save = new BufferedWriter(new FileWriter(filename, false));
		for(i=(h);i<j;i++)
			writeString=writeString+readString[i];
		save.write(writeString);
		save.newLine();
		save.close();
		return 1;
	} 
}

/**
	 *Loads a file with conifguration header and converts it to an internal string.<br>
	 * @param Filename Filename and path of file that should be imported by the enigma engine
	 * 
	 * @return String from file. Should now be readable for the enigma engine<br>
	 * 					-<br>
	 * 					in first appearence:	Start of configuration<br>
	 * 					second appearence:		start of roller configuration<br>
	 * 					third appearence:		End of  configuration<br>
	 * 					first part:		Number which specify the number of rollers<br>
	 * 									The last digit:<br>
	 * 									1 no plugs are attached<br>
	 * 									2 plugs are attached<br>
	 * 					second part:	Roller configuration and permutations of the plugboard<br>
	 * 					third part:		Data to en-/decrypt<br>
	 * 
	 * @throws	IOException
	 */
public static String LoadFile(String Filename) throws IOException{
	int i=0,j,k,l,m,o=0,h=0,RollerConf = 0,NrOfRollers = 0;
	String line,input="";
	FileReader Test = null;
	char readConf[];
	BufferedReader in = new BufferedReader(new FileReader(Filename));
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
					if ((k<3)&&(NrOfRollers==0)){throw new FileException("Specify more rollers!");}		//min. of three rollers
					else {
						if (NrOfRollers==0) NrOfRollers = k;
						if (NrOfRollers>99) throw new FileException("Please specify less than 100 rollers");
						if ((NrOfRollers*4-5)<j) RollerConf=(NrOfRollers*4-5); else RollerConf=j-1;
						if ((NrOfRollers==k)&&((readConf[RollerConf]!=readConf[k]&&((NrOfRollers*4-5)<(j-1)))||((readConf[RollerConf]==readConf[k])&&((NrOfRollers*4-5)==j))||((NrOfRollers*4-5)>j))) throw new FileException("Bad roller configuration in fileheader");
						else {
							for(m=NrOfRollers+1;m<(NrOfRollers*4-5);m++)
								if ((m<=(NrOfRollers*2-2))&&((readConf[m]<65)||(readConf[m]>90))) throw new FileException("Bad roller configuration:\""+readConf[m]+"\" at position:"+(m+1));
								else if ((m>(NrOfRollers*2-2))&&((readConf[m]>58)||(readConf[m]<47))) throw new FileException("Bad roller configuration:\""+readConf[m]+"\" at position:"+(m+1));
								else if (m>(NrOfRollers*2-2)&&(o==0)) {if (((((int)readConf[m]-48)*10)+((int)readConf[m+1]-48))>25) throw new FileException("Offset is too high! At position:"+m+" and:"+(m+1)); else o=1;}
								else if (true) o=0;
								else if (((NrOfRollers*4-5)<j)&&(readConf[NrOfRollers*4-5]!='-')) throw new FileException("Bad roller configuration:\""+readConf[NrOfRollers*4-5]+"\" at position:"+(NrOfRollers*4-5));
							if (h!=0){
								if ((0!=(j+4-4*NrOfRollers)%2)||(26<(j+4-(4*NrOfRollers)))) throw  new FileException("Bad stickboard! Too many plugs ("+(j+4-4*NrOfRollers)+") or one unconnected ("+((j+4-4*NrOfRollers)%2)+")! "+k+" "+NrOfRollers+" "+j+" "+(NrOfRollers*4-5));
								else if (k==j-1) h=1;														//no plugs attached
									 else h=2;																//plugs attached
							}
							else h=1;
						}
					}
				}
			}			
			if (NrOfRollers != 0){									//Fileheader seems to exist
				for(k=0;k<j;k++){
					if (k==0) {/*Test=new FileReader("enigma/data/ReRo"+readConf[k]+".RoC");*/input="-"+NrOfRollers+h+"-"+readConf[k]+"";}			//tests if roller exists and write numbers of rollers, existence of plugboard and first roller
					if ((k>0)&&(k<(NrOfRollers-1))) {/*Test=new FileReader("enigma/data/MeRo"+readConf[k]+".RoC");*/input=input+readConf[k];}		//tests if roller exists
					if (k==(NrOfRollers-1)) {/*Test=new FileReader("enigma/data/EnRo"+readConf[k]+".RoC");*/input=input+""+readConf[k];} 			//tests if reflector-roller exists
					else if ((k<=RollerConf)&&(k>(NrOfRollers))) input=input+readConf[k];
					if (k>RollerConf) {
						for (k=(RollerConf+1);k<j;k++){
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
	return input;
}


/**
 * Reads the configuration of a given roller and returns the permutation as int[][].<br>
 */
public static int[][] readRoller(String file) throws IOException{
	int[][] diff=new int[26][2];
	boolean minus=false;
	int i,j;BufferedReader in;
	String fileName="enigma/data/"+file+".RoC",input="";
	if((new File("enigma.jar")).canRead()==true){
		JarFile read = new JarFile("enigma.jar");
		JarEntry inpi = read.getJarEntry(fileName);
		InputStream inp = read.getInputStream(inpi);
		in = new BufferedReader(new InputStreamReader(inp));
	}
	else in = new BufferedReader(new FileReader(fileName));
	char readConf[];
	for (i=0;i<26;i++){
		if ((input=in.readLine()) != null){
			j=input.length();
			readConf = input.toCharArray();
			minus=(readConf[0]=='-');
			if(!minus&&(j<2)) diff[i][0]=((int)readConf[0]-48);
			else if(!minus) diff[i][0]=(((int)readConf[0]-48)*10+((int)readConf[1]-48));
			else if(j<3) diff[i][0]=((int)readConf[1]-48);
			else diff[i][0]=(((int)readConf[1]-48)*10+((int)readConf[2]-48));
			if (minus) diff[i][0]=diff[i][0]*(-1);
			diff[i][1]=i+diff[i][0];
		}
		else throw new FileException("Bad roller configuration file:"+fileName);		
	}
	in.close();
	int[]help=new int[26];
	for (i=0;i<26;i++)
		help[diff[i][1]]=diff[i][0];
	for (i=0;i<26;i++)
		diff[i][1]=help[i];
	return diff;	
}}