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
	public Roller(String roller, char start, int ring) throws IOException{
	super();
	}
	public Roller(){						//Roller without permutations
		int i;
		int[] rollerArray=new int[25];
		for (i=0;i<25;i++)
		rollerArray[i]=0;
	}
}
