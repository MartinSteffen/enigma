/*
 * Created on 09.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.engine;
import java.io.*;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Roller{
	private boolean[] notch;
	private boolean r;
	private int[][] conf;
	private int ring;
	private char start;
	private char roller;
	private boolean rotate;
	public Roller(char roller, char start, int ring, int[][]conf) throws IOException{
		this.roller=roller;
		this.start=start;
		this.ring=ring;
		this.conf=conf;
		int i;
		boolean rotate=false;
		this.rotate=rotate;
		boolean[] notch=new boolean[26];
		for (i=0;i<=25;i++)
		notch[0]=false;
		if (roller=='1')
		notch[24]=true;
		if (roller=='2')
		notch[12]=true;
		if (roller=='3')
		notch[3]=true;
		if (roller=='4')
		notch[17]=true;
		if (roller=='5')
		notch[7]=true;
		this.notch=notch;
System.out.println(".Roller created:"+roller+" "+start+" "+ring);
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[26];
		for (i=0;i<=25;i++)
		rollerArray[i]=0;
System.out.println(".Roller created:");
	}
	public Roller(char roller,int[][] conf){
		this.roller=roller;
		this.conf=conf;
System.out.println(".Roller created:"+roller);
	}
	public Roller(char roller, int[][] conf, boolean r){
		this.roller=roller;
		this.conf=conf;
		this.r=r;
System.out.println(".Reflectorroller created:");
	}
	public int Ro(int input,boolean forw){
		int i;
//System.out.println(input+":input  start:"+(start-65)+" new input:"+(input+start-65)+"     "+forw+"       "+((char)(input+65))+"->"+((char)(input+start)));
		if (forw)input=input+(start-65); else input=input+(start-65);
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		if(forw) input=input+conf[input][0];
		else for (i=0;i<=25;i++){
			if (conf[i][1]==input){
			input=input-conf[i][0];
			i=26;}
			}
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		return input;
	}
public void rotate(){
	start=(char)((int)start+1);
	if ((int)(start)>90) start=(char)((int)start-26);
}
public boolean getRotate(){
	return rotate;
}
public void setRotate(boolean input){
	rotate=input;
}
public int getStart(){
	return ((int)start-65);
}
public boolean getNotch(int i){
	if (i>25) return notch[(i-26)];
	else return notch[i];
}
public int getRing(){
	return ring;
}
public void printRoller(){
	int i;
	for (i=0;i<26;i++)
	System.out.print(" "+conf[i][0]);
	System.out.println("");
	for (i=0;i<26;i++)
	System.out.print(" "+conf[i][1]);	
}}