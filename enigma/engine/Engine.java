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
	public Engine(String input/*int WalzenZahl*/){
		this.WalzenZahl=WalzenZahl;
		Roller[] Roller=new Roller[WalzenZahl];
		int i=0;
		System.out.println("Create engine");
		for (i=0;i<WalzenZahl;i++)
			{
			Roller[i]=new Roller();
			System.out.println(i+".Roller created");
			}
	}
}
