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
	public String LoadFile(String input) {
		int i=0,j,k,l,WalzenZahl = 0;
		String line;
		char readConf[];
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(input));
			while ((line = in.readLine()) != null){
				line = line.trim().toUpperCase();
				if(i!=0) 
				input=input+line;
				else{
					j=line.length();
					readConf=line.toCharArray(); i++;
					for(k=0;k<j;k++){
						if (readConf[k]=='-'){
							if (k<3){throw (Throwable) new FileException("Bad file header or symbol");}
/*weitermachen*/							if(readConf[k]=='A') input=input+readConf[k];
							else { if (readConf[k]=='T') input=input+readConf[k]; 
							else { input=input+readConf[k];}}}
							}
					}
 
//					else input=input+line;
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
