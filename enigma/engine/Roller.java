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
	private int notch,turnover;
	private boolean r;
	private int[][] conf;
	private int ring,offset;
	private char start;
	private char roller;
	private boolean rotate,extraRot;
	public Roller(char roller, char start, int ring, int[][]conf) throws IOException{
		this.roller=roller;
		this.start=(char)((int)start-ring+1);
		if ((int)(this.start)>90) this.start=(char)((int)this.start-26);
		if ((int)(this.start)<65) this.start=(char)((int)this.start+26);
		this.ring=ring-1;
		this.conf=conf;
		int i;
		boolean rotate=false;
		this.rotate=rotate;
		this.extraRot=false;
		int notch=100;
		int turnover=100;
		if (roller=='1') {notch=24;turnover=16;} 
		else if (roller=='2') {notch=12;turnover=4;}
		else if (roller=='3') {notch=3;turnover=21;}
		else if (roller=='4') {notch=17;turnover=9;}
		else if (roller=='5') {notch=7;turnover=25;}
		this.notch=notch; this.turnover=turnover;
		if (roller=='A'||roller=='T'||roller=='C'||roller=='B')
		this.start=0+65;
		this.offset=0;
//if(((int)this.start+this.ring)>25) {this.rotate=true;this.start=(char)((int)this.start-26);}
//System.out.println(".Roller created:"+this.roller+" "+this.start+" "+this.ring);
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[26];
		for (i=0;i<=25;i++)
		rollerArray[i]=0;
//System.out.println(".Roller created:");
	}
	public Roller(char roller,int[][] conf){
		this.roller=roller;
		this.conf=conf;
//System.out.println(".Roller created:"+roller);
	}
	public Roller(char roller, int[][] conf, boolean r){
		this.roller=roller;
		this.conf=conf;
		this.r=r;
//System.out.println(".Reflectorroller created:");
	}
	public int Ro(int input,boolean forw){
		int i;
		input=input+(this.start-65);
		if (input>25) input=input-26;
		if (input<0) input=input+26;
//System.out.println("Input for "+this.roller+"  = "+input+"   "+((char)(input+65))+"  Start:"+this.start+" - "+(this.start-65));
		if(forw) input=input+this.conf[input][0];
		else input=input-this.conf[input][1];
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		input=input-(this.start-65);
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		return input;
	}
public void rotate(boolean extraRot){
	this.start=(char)((int)this.start+1);
	if ((int)(this.start-65)>25) this.start=(char)((int)this.start-26);
//System.out.println("                                 Roller:"+this.roller+" has been moved");
	if(extraRot) this.extraRot=false;
	else this.rotate=false;
}
public int getOffset(){
	return this.offset;
}
public void setOffset(){
	this.offset=26;
}
public boolean getRotate(){
	return this.rotate;
}
public void setRotate(boolean input){
	this.rotate=input;
}
public boolean getExtraRot(){
	return this.extraRot;
}
public void setExtraRot(boolean input){
	this.extraRot=input;
}
public int getStart(){
	return ((int)this.start-65);
}
public int getNotch(){
	return this.notch;
}
public int getTurnover(){
	return this.turnover;
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