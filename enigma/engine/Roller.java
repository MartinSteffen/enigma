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
		this.start=(char)((int)start+ring);
		if ((int)(this.start)>90) this.start=(char)((int)this.start-26);
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
		if (roller=='A'||roller=='T'||roller=='C'||roller=='B')
		this.start=0+65;
System.out.println(".Roller created:"+this.roller+" "+this.start+" "+this.ring);
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
		/*if (forw)*/input=input+(this.start-65);// else input=input+(start-65);
		if (input>25) input=input-26;
		if (input<0) input=26+input;
System.out.println("Input for "+this.roller+"  = "+input+"   "+((char)(input+65))+"  Start:"+this.start+" - "+(this.start-65));
		if(forw) input=input+conf[input][0];
		else input=input-conf[input][1];
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		return input;
	}
public void rotate(){
	this.start=(char)((int)this.start+1);
	if ((int)(this.start)>90) this.start=(char)((int)this.start-26);
System.out.println("Roller:"+this.roller+" has been moved");
}
public boolean getRotate(){
	return this.rotate;
}
public void setRotate(boolean input){
	this.rotate=input;
}
public int getStart(){
	return ((int)this.start-65);
}
public boolean getNotch(int i){
	if (i>25) return this.notch[(i-26)];
	else return this.notch[i];
}
public int getRing(){
	return this.ring;
}
public char getRoller(){
	return this.roller;
}
public void printRoller(){
	int i;
	for (i=0;i<26;i++)
	System.out.print(" "+this.conf[i][0]);
	System.out.println("");
	for (i=0;i<26;i++)
	System.out.print(" "+this.conf[i][1]);	
}}