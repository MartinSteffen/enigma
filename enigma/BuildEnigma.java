/*
 * Created on 03.12.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma;
import enigma.engine.*;
import enigma.exceptions.*;
import enigma.io.*;
import java.io.*;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class BuildEnigma {
	public static Engine BuildEnimga(String input,String File, String Save) throws IOException,IllegalArgumentException{
		char readString[];
		Roller[] Roller;
		int[] PlugArr=new int[26];
		PlugBoard PB=new PlugBoard(PlugArr);
		int NrOfRollers=0,j=0,h=0,m=0,o=0,off2;
		boolean plugB=false;
		String line;
		int i;
		j=input.length();
		readString=input.toCharArray();
		if (readString[0]=='-'){
			if (readString[3]=='-'){NrOfRollers=((int)readString[1]-48); if (readString[2]=='2') plugB=true;} 
			else {NrOfRollers=(((int)readString[1]-48)*10+((int)readString[2]-48));m=1;if(readString[3]=='2') plugB=true;}
			Roller=new Roller[NrOfRollers];	
			o=4+m;
			int off=o+NrOfRollers*2-2;				
			for (i=0;i<NrOfRollers;i++){
				if ((i!=0)&&(i!=NrOfRollers-1)){Roller[i]=new Roller(readString[i+o],readString[i+o+NrOfRollers-1],(((int)readString[off]-48)*10+((int)readString[off+1]-48)),FileIO.readRoller("MeRo"+readString[i+o]));off=off+2;} 
				else {	if (i==0){Roller[i]=new Roller(readString[i+o],'A',(((int) readString[off]-48)*10+((int)readString[off+1]-48)),FileIO.readRoller("ReRo"+readString[i+o]));}	//reflectorroller
						else {Roller[i]=new Roller(readString[i+o],'A',(((int)readString[off]-48)*10+((int)readString[off+1]-48)),FileIO.readRoller("EnRo"+readString[i+o]));}}				//entryroller
			}
			if(plugB){
				for (i=5;i<j;i++)
					if(readString[i]=='-') {
						off=i+1;
						off2=-65;
						for (h=0;h<j-off+1;h+=2){
							PlugArr[(readString[h+off]+off2)]=(readString[h+off+1]-readString[h+off]);
							PlugArr[(readString[h+1+off]+off2)]=(readString[h+off]-readString[h+off+1]);
							if (((off+h+2)==j-1)||(readString[off+h+2]=='-')) h=j-1;
						}
						i=j;
					}
			}
		}
		else throw new FileException("No configuration header given!");		
		return new Engine(NrOfRollers,Roller,PB,plugB);
	}
	public static Engine BuildEnimga(int[][] state) throws IOException{
		int i;
		Roller[] Roller;
		int[] PlugArr=new int[26];
		PlugBoard PB=new PlugBoard(PlugArr);
		boolean plugB=false;
		int NrOfRollers=0;
		if (state[0][0]<100)NrOfRollers=state[0][0];
		else throw new IllegalArgumentException("Specify more rollers!");
		Roller=new Roller[NrOfRollers];
		for(i=1;i<=NrOfRollers;i++)
			if (i==1)Roller[i-1]=new Roller((char)(state[i][0]),'A',state[i][1],FileIO.readRoller("ReRo"+(char)state[i][0]));
			else if (i==NrOfRollers)Roller[i-1]=new Roller((char)state[i][0],'A',state[i][1],FileIO.readRoller("EnRo"+(char)state[i][0]));
			else Roller[i-1]=new Roller((char)state[i][0],(char)(state[i][2]+65),state[i][1],FileIO.readRoller("MeRo"+(char)state[i][0]));
		if(state[NrOfRollers+1][0]==1){
			plugB=true;
			for(i=1;i<27;i++)
				PlugArr[i-1]=state[NrOfRollers+1][i];
		}
		return new Engine(NrOfRollers,Roller,PB,plugB);
	}
}
