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
		int i,h;
		final int offset = -65;
		roller[WalzenZahl-2].setRotate(true);
		for(i=(WalzenZahl-2);i>0;i--){
			h=roller[i].getStart()-roller[i].getRing();
			if (h>25) h=h-26;
			if (h<0) h=26+h;	
System.out.println("i:"+i+" | Start-Ring:"+h+"  |Walze "+(i-1)+" hat Narbe an Pos. Start-Ring? "+roller[i-1].getNotch(h));
			if ((roller[i-1].getNotch(h))&&(roller[i].getRotate())) roller[i-1].setRotate(true);
			else roller[i-1].setRotate(false);
		}
		for(i=WalzenZahl-2;i>0;i--)
			if(roller[i].getRotate())roller[i].rotate();
		int inp=((int)input+offset);
//System.out.println(inp+":inp | offset:"+offset+" input:"+input);
		inp=inp+pb.pb(inp);
System.out.println(roller[3].getStart()+":Start |5| rotate:"+roller[3].getRotate()+" || "+roller[2].getStart()+":Start |3| rotate:"+roller[2].getRotate()+" || "+roller[1].getStart()+":Start |1| rotate:"+roller[1].getRotate());
		for(i=WalzenZahl-1;i>=0;i--){
if(i==0)
System.out.println("-----------------------------------"+inp);
System.out.println("Input for "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
			inp=roller[i].Ro(inp,true);
System.out.println("Return of "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
		}
System.out.println("-----------------------------------"+inp);
		for (i=1;i<=WalzenZahl-1;i++){
			inp=roller[i].Ro(inp,false);
System.out.println("Return of "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
		}
//System.out.println("plubboard:"+inp);
		inp=inp+pb.pb(inp);
//System.out.println("plubboard:"+inp);
		input=(char)(inp-offset);
		return input;
	}
	
}
