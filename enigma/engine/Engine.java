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
	private PlugBoard pb;
	private Roller[] roller;
	private int WalzenZahl;
	public Engine(int WalzenZahl, Roller[] roller, PlugBoard pb){
		this.WalzenZahl=WalzenZahl;
		this.roller=roller;
		this.pb=pb;
		int i=0;
		System.out.println("creating engine...");
		System.out.println("WalzenZahl:"+WalzenZahl);
	}
	public char toEnigma(char input){
		int i;
		final int offset = -65;
		int inp=((int)input+offset);
		inp=inp+PlugBoard.pb(inp);
		for(i=WalzenZahl-1;i>=0;i--){
		inp=roller[i].Ro(inp,true);
System.out.println("Return of"+roller[i]+"  ="+inp);
		}
System.out.println("Halbzeit:"+inp);
		for (i=1;i<=WalzenZahl-1;i++){
		inp=roller[i].Ro(inp,false);
		System.out.println("Return of"+roller[i]+"  ="+inp);
		}
System.out.println("plubboard:"+inp);
		inp=inp+PlugBoard.pb(inp);
System.out.println("plubboard:"+inp);
		input=(char)(inp-offset);
		return input;
	}
	
}
