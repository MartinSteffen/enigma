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
	private int ring;
	private char start;
	private char roller;
	public Roller(char roller, char start, int ring) throws IOException{
		this.roller=roller;
		this.start=start;
		this.ring=ring;
		System.out.println(".Roller created:"+roller+" "+start+" "+ring);
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[25];
		for (i=0;i<25;i++)
		rollerArray[i]=0;
System.out.println(".Roller created:");
	}
	public Roller(char roller){
		this.roller=roller;
		System.out.println(".Roller created:"+roller);
	}
}
