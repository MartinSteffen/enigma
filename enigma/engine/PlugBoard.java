/*
 * Created on 10.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.engine;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PlugBoard {
	private char[] PB;

	public PlugBoard(char[] PB){
		int i;
		this.PB=PB;		
		}
public char readChar(int pos){
	return PB[pos];
	}
}
