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
	private char start,start1;
	private char roller;
	private boolean rotate,extraRot;
	public Roller(char roller, char start, int ring, int[][]conf) throws IOException{
		this.roller=roller;
		this.start1=start;
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
		this.notch=notch;
		this.turnover=turnover;
		if (roller=='A'||roller=='T'||roller=='C'||roller=='B')
		this.start=0+65;
		this.offset=0;
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[26];
		for (i=0;i<=25;i++)
		rollerArray[i]=0;
	}
	public Roller(char roller,int[][] conf){
		this.roller=roller;
		this.conf=conf;
	}
	public Roller(char roller, int[][] conf, boolean r){
		this.roller=roller;
		this.conf=conf;
		this.r=r;
	}
	/**
	 * Simulates this roller.<br>
	 * @param input char that should pass this roller
	 * @param forw in which direction is the roller passed
	 * @return returns modified char
	 */
	public int Ro(int input,boolean forw){
		int i;
		input=input+(this.start-65);
		if (input>25) input=input-26;
		if (input<0) input=input+26;
		if(forw) input=input+this.conf[input][0];
		else input=input-this.conf[input][1];
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		input=input-(this.start-65);
		if (input>25) input=input-26;
		if (input<0) input=26+input;
		return input;
	}
	/**
	 * Simulates the rotation of this roller.<br>
	 * @param extraRot Simulates the anomaly of the enigma
	 */
public void rotate(boolean extraRot){
	this.start=(char)((int)this.start+1);
	if ((int)(this.start-65)>25) this.start=(char)((int)this.start-26);
	this.start1=(char)((int)this.start1+1);
	if ((int)(this.start1-65)>25) this.start1=(char)((int)this.start1-26);
	if(extraRot) this.extraRot=false;
	else this.rotate=false;
}
/**
 * By calculating the start position an offset may occour which is handled here.<br>
 * @return offset of this roller
 */
public int getOffset(){
	return this.offset;
}
/**
 * Sets the offset.<br>
 *
 */
public void setOffset(){
	this.offset=26;
}
/**
 * Is this roller set to rotate?.<br>
 * @return true or false
 */
public boolean getRotate(){
	return this.rotate;
}
/**
 * This roller will rotate in an instant.<br>
 * @param input true or false
 */
public void setRotate(boolean input){
	this.rotate=input;
}
/**
 * Is this roller set to perform an extra rotation?.<br>
 * @return true or false
 */
public boolean getExtraRot(){
	return this.extraRot;
}
/**
 * This roller will perform an extra rotation.<br>
 * This handles the anomaly of the enigma.
 * @param input true or false
 */
public void setExtraRot(boolean input){
	this.extraRot=input;
}
/**
 * Returns the current position of this roller.<br>
 * @return the current position
 */
public int getStart(){
	return ((int)this.start-65);
}
/**
 * Returns the current position without ring modification.<br>
 * @return the current position without ring modification
 */
public int getStart1(){
	return ((int)this.start1-65);
}
/**
 * Returns the position of the notch of this roller.<br>
 * @return int for notch
 */
public int getNotch(){
	return this.notch;
}
/**
 * Returns the position of the turnover of this roller.<br>
 * @return int for turnover
 */
public int getTurnover(){
	return this.turnover;
}
/**
 * Returns the position of the ring for this roller.<br>
 * @return int for ring
 */
public int getRing(){
	return this.ring;
}
/**
 * Returns name of this roller.<br>
 * @return name of this roller
 */
public char getRoller(){
	return this.roller;
}
/**
 * Prints this roller to the screen.<br>
 */
public void printRoller(){
	int i;
	for (i=0;i<26;i++)
	System.out.print(" "+this.conf[i][0]);
	System.out.println("");
	for (i=0;i<26;i++)
	System.out.print(" "+this.conf[i][1]);	
}}