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
	int i=0,j,k,l,h=0,WalzenZahl = 0;
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
						if ((k<3)&&(WalzenZahl==0)){throw (Throwable) new FileException("Specify more rollers!");}
						else {if (WalzenZahl==0) WalzenZahl = k;}				//min. of three rollers
/*weitermachen*/						if ((k!=(WalzenZahl*4-5))&&(k>3)&&(h==0)){throw (Throwable) new FileException("Bad roller configuration in fileheader");}
						if ((((h!=0)&&(WalzenZahl!=0))||((0!=(j+4-4*WalzenZahl)%2))&&(h!=0))||((21<(j+4-(4*WalzenZahl)))&&(h!=0))){throw (Throwable) new FileException("Bad stickboard! Too many plugs ("+(j+4-4*WalzenZahl)+") or one unconnected!"+k+" "+WalzenZahl+" "+j+" "+(WalzenZahl*4-5));}
						else {if (h==1){k=j;h=2;}}						//length of stickboard is and all plugs are attached
						if (k==(WalzenZahl*4-5)) h=1;		//length of roller configuration is ok
					}
				}
				if (WalzenZahl != 0){						//Fileheader seems to exist
					for(k=0;k<j;k++){
						if(k==0) {Test=new FileReader("enigma/data/EnRo"+readConf[k]+".RoC");input=WalzenZahl+""+h+""+readConf[k]+"";}				//tests, if roller exists and write numbers of rollers, existence of plugboard and first roller
						if ((k>0)&&(k<(WalzenZahl-1))) {Test=new FileReader("enigma/data/MeRo"+readConf[k]+".RoC");input=input+readConf[k];}	//tests, if roller exists
						if (k==(WalzenZahl-1)) {Test=new FileReader("enigma/data/ReRo"+readConf[k]+".RoC");input=input+WalzenZahl+""+readConf[k];} //tests, if reflector-roller exists
						if (k>(j+4-4*WalzenZahl)) {for (k=(j+4-4*WalzenZahl);k<j;k++){if ((readConf[k]<65)||(readConf[k]>90)) throw (Throwable) new FileException(readConf[k]+" is bad char for plugboard at position: "+k);
																	   input=input+readConf[k];
																	   for (l=(k+1);l<j;l++) if (readConf[k]==readConf[l]) throw (Throwable) new FileException(readConf[k]+" :-: "+readConf[l]+" Only one plug per char permitted at position: "+k+" and "+l);
																	  }
											}
					}
				}
			else input=input+line;							//No Fileheader? Then just readLine
			}
		}
			in.close();
	} catch (FileException err) {
			System.err.println(err.getMessage());
			err.printStackTrace();
		}
		  catch (FileNotFoundException err) {
			// TODO Auto-generated catch block
			System.err.println( "File not found:"+err.getMessage());
			err.printStackTrace();
		} catch (IOException err) {
			// TODO Auto-generated catch block
			System.err.println( "Error reading line:"+err.getMessage());
			err.printStackTrace();
		}
		finally {
			if (input != null) {
			  try {in.close();}
			  catch(IOException err)
			  {
				System.err.println( "Close-Error:"+ err.getMessage());
				err.printStackTrace();
			  }
			}
		return input;		
		}	
	}
}
