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
		int i,h,hh;
		final int offset = -65;
		roller[WalzenZahl-2].setRotate(true);
System.out.println("");
System.out.println("Input:"+input);
		for(i=(WalzenZahl-2);i>0;i--){
			h=roller[i].getStart();//-roller[i].getRing()-1;
			hh=roller[i-1].getStart();//-roller[i-1].getRing()-1;
			if (h>25) h=h-26;
			if (h<0) h=26+h;
			if (hh>25) hh=hh-26;
			if (hh<0) hh=26+hh;
//System.out.println("i:"+i+" | Start-Ring:"+h+"  |Walze "+(i-1)+" hat Narbe an Pos. Start-Ring? "+roller[i-1].getNotch());
//			if ((roller[i-1].getNotch(h))&&(roller[i].getRotate())) roller[i-1].setRotate(true);
System.out.println(h+":h || hh:"+hh+"  ||  "+(roller[i-1].getNotch()+hh)+" - "+(roller[i].getTurnover()+h));
			if(((roller[i-1].getNotch()+hh)==(h+roller[i].getRing()))&&(roller[i].getRotate()))roller[i-1].setRotate(true);
			else
			roller[i-1].setRotate(false);
		}
//roller[3].setRotate(true);
//roller[2].setRotate(true);
//roller[1].setRotate(true);
		for(i=WalzenZahl-2;i>0;i--)
			if(roller[i].getRotate())roller[i].rotate();
		int inp=((int)input+offset);
		inp=inp+pb.pb(inp);
		for(i=WalzenZahl-1;i>=0;i--){
//if(i==0)
//System.out.println("-----------------------------------"+inp);
//System.out.println("Input for "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
			inp=roller[i].Ro(inp,true);
//System.out.println("Return of "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
		}
//System.out.println("-----------------------------------"+inp);
		for (i=1;i<=WalzenZahl-1;i++){
			inp=roller[i].Ro(inp,false);
//System.out.println("Return of "+roller[i].getRoller()+"  = "+inp+"   "+((char)(inp+65))+" ");
		}
//System.out.println("plubboard:"+inp);
		inp=inp+pb.pb(inp);
//System.out.println("plubboard:"+inp);
		input=(char)(inp-offset);
System.out.println("Output:"+input);
System.out.println("");
		return input;
	}
	
}
