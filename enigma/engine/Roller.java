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
	private boolean r;
	private int[] conf;
	private int ring;
	private char start;
	private char roller;
	public Roller(char roller, char start, int ring, int[]conf) throws IOException{
		this.roller=roller;
		this.start=start;
		this.ring=ring;
		this.conf=conf;
System.out.println(".Roller created:"+roller+" "+start+" "+ring);
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[26];
		for (i=0;i<=25;i++)
		rollerArray[i]=0;
System.out.println(".Roller created:");
	}
	public Roller(char roller,int[] conf){
		this.roller=roller;
		this.conf=conf;
System.out.println(".Roller created:"+roller);
	}
	public Roller(char roller, int[] conf, boolean r){
		this.roller=roller;
		this.conf=conf;
		this.r=r;
System.out.println(".Reflectorroller created:");
	}
	public int Ro(int input,boolean forw){
System.out.println(input+":input  start:"+(start-65)+" new input:"+(input+start-65));
		input=input+start-65;
		if (input>25) input=input-25;
		if(forw) return input=input+conf[input];
		else return input=input-conf[input];
	}
public void printRoller(){
	int i;
	for (i=0;i<26;i++)
	System.out.print(" "+conf[i]);	
}}