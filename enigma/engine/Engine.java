/*
 * Created on 09.11.2003
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
public class Engine {
	private int WalzenZahl;
	public Engine(int WalzenZahl, Roller[] Roller, PlugBoard pb){
		this.WalzenZahl=WalzenZahl;
		int i=0;
		System.out.println("creating engine...");
		System.out.println("WalzenZahl:"+WalzenZahl);
	}
}
