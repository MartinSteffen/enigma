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
	private int[][] state;
	private PlugBoard pb;
	private Roller[] roller;
	private int NrOfRollers;
	private boolean pbp;
	public Engine(int NrOfRollers, Roller[] roller, PlugBoard pb, boolean pbp){
		this.NrOfRollers=NrOfRollers;
		this.roller=roller;
		this.pb=pb;
		int i=0;
		this.pbp=pbp;
	}
	public char toEnigma(char input){
		int i,start,turnOver;
		final int offset = -65;
		for (i=(NrOfRollers-3);i>0;i--)
		if(roller[i].getExtraRot()) {
			roller[i].rotate(false);
			roller[i+1].rotate(false);
			roller[i].setExtraRot(false);
		}
		roller[NrOfRollers-2].setRotate(true);						//this one rotates everytime
		for(i=(NrOfRollers-2);i>0;i--){
			start=roller[i].getStart()+roller[i].getRing()-roller[i].getOffset();
			turnOver=roller[i].getTurnover();	
			if((start==turnOver)&&(roller[i].getRotate())&&(i>1))roller[i-1].setRotate(true);
			else
				{roller[i-1].setRotate(false);roller[i-1].setExtraRot(false);}
			if((roller[i].getRotate())&&(i!=NrOfRollers-2)&&(start+1==turnOver)&&(roller[i].getRotate()))roller[i-1].setExtraRot(true);
			if(((start-26)==(turnOver))&&(i!=NrOfRollers-2)&&(i>=1)) {roller[i-1].setRotate(true);roller[i].setRotate(true);}
		}
		for(i=NrOfRollers-2;i>0;i--)
			if(roller[i].getRotate())roller[i].rotate(false);
		int inp=((int)input+offset);
		inp=inp+pb.pb(inp);
		for(i=NrOfRollers-1;i>=0;i--)
			inp=roller[i].Ro(inp,true);
		for (i=1;i<=NrOfRollers-1;i++)
			inp=roller[i].Ro(inp,false);
		inp=inp+pb.pb(inp);
		input=(char)(inp-offset);
		return input;
	}
	
	/**
		  @return 	int[][]
		  			0|0=Nr. of rollers,
					1|n=specific rollers,
					1|0=start of roller,
					1|1=ring of roller,
					1|2=current pos. of roller,
					2=Plugboard permutations. 1 if true
	*/
	public int[][] getState(){
		int i,j;
		int[][] state=new int[this.NrOfRollers+2][27];				
		state[0][0]=this.NrOfRollers;
		for(i=0;i<this.NrOfRollers;i++){
			state[i+1][0]=this.roller[i].getRoller();
			state[i+1][1]=((this.roller[i].getRing())+1);
			if (state[i+1][1]<0)state[i+1][1]=state[i+1][1]+26;
			state[i+1][2]=this.roller[i].getStart1();
		}
		if (this.pbp){state[this.NrOfRollers+1][0]=1;for(j=0;j<26;j++)state[this.NrOfRollers+1][j+1]=pb.readChar(j);}
		else state[this.NrOfRollers+1][0]=0;
		this.state=state;
		return this.state;
	}
	public void printState(){
		int i,j;
		System.out.println("This enigma has "+this.state[0][0]+" rollers!");
		System.out.print("Rollers: ");
		for(i=1;i<=(this.state[0][0]);i++)
			System.out.print("   "+((char)state[i][0]));
		System.out.println("");
		System.out.print("Ring:        ");
		for(i=2;i<(this.state[0][0]);i++)
			if(state[i][1]<10)System.out.print("   "+state[i][1]);
			else System.out.print("  "+state[i][1]);
		System.out.println("");
		System.out.print("Start:       ");
		for(i=2;i<(this.state[0][0]);i++)
			System.out.print("   "+((char)(state[i][2]+65)));
		System.out.println("");
		if(this.state[this.state[0][0]+1][0]==1){System.out.println("This enigma has plugboard permutations!");for(j=0;j<26;j++)System.out.print(" "+state[this.NrOfRollers+1][j+1]);System.out.println("");}
		else System.out.println("This enigma has no plugboard permutations!");
	}
	public boolean ifPb(){
		return this.pbp;
	}
}
