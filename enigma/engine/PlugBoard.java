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
	private int[] PB;

	public PlugBoard(int[] PB){
		int i;
		this.PB=PB;		
		}
public int readChar(int pos){
	return PB[pos];
	}
public int pb(int input){
	return PB[input];
}
public void printPlugBoard(){
	int i;
	System.out.println("The plugboard:");
	for (i=0;i<26;i++){
		System.out.print(" "+PB[i]);
		}
	System.out.println("");
}}