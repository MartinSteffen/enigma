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
//		System.out.println("creating engine...");
//		System.out.println("WalzenZahl:"+WalzenZahl);
	}
	public char toEnigma(char input){
		int i,start,turnOver;
		final int offset = -65;
for (i=(WalzenZahl-3);i>0;i--)
if(roller[i].getExtraRot()) {
	roller[i].rotate(false);
	roller[i+1].rotate(false);
	roller[i].setExtraRot(false);
}
		roller[WalzenZahl-2].setRotate(true);
//System.out.println("");
//System.out.println("Input:"+input);		
		for(i=(WalzenZahl-2);i>0;i--){
			start=roller[i].getStart()+roller[i].getRing()-roller[i].getOffset();
			turnOver=roller[i].getTurnover();	
//System.out.println(start+":Start = TO:"+turnOver+"    "+i+":i  Rot:"+roller[i].getRotate());
			if((start==turnOver)&&(roller[i].getRotate())&&(i>1))roller[i-1].setRotate(true);
			else
				{roller[i-1].setRotate(false);roller[i-1].setExtraRot(false);}
			if((roller[i].getRotate())&&(i!=WalzenZahl-2)&&(start+1==turnOver)&&(roller[i].getRotate()))roller[i-1].setExtraRot(true);
			if(((start-26)==(turnOver))&&(i!=WalzenZahl-2)&&(i>=1)) {roller[i-1].setRotate(true);roller[i].setRotate(true);}
		}
		for(i=WalzenZahl-2;i>0;i--)
			if(roller[i].getRotate())roller[i].rotate(false);
		int inp=((int)input+offset);
		inp=inp+pb.pb(inp);
		for(i=WalzenZahl-1;i>=0;i--)
			inp=roller[i].Ro(inp,true);
		for (i=1;i<=WalzenZahl-1;i++)
			inp=roller[i].Ro(inp,false);
		inp=inp+pb.pb(inp);
		input=(char)(inp-offset);
//System.out.println("Output:"+input);
//System.out.println("");
		return input;
	}	
}
