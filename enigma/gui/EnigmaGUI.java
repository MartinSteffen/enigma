/*
 * Created on 08.01.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.gui;
import enigma.exceptions.*;
import enigma.engine.*;
import enigma.io.*;
import enigma.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class EnigmaGUI implements ActionListener{
Engine enigma;
String config,failure;
JFrame frame;
int i;
	public EnigmaGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		config="-52-B123AAAA010101-AA-";
		failure=""+"\n";
		try{
		enigma=BuildEnigma.BuildEnimga(config,config,config);
		}
		catch (IOException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
			failure=err.getMessage()+"\n";
		}
		catch (FileException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
			failure=err.getMessage()+"\n";
		}
		GridBagLayout gridbag=new GridBagLayout();
Dimension Dim1= new Dimension(20,1),Dim2= new Dimension(190,1),Dim3= new Dimension(70,1),
Dim4= new Dimension(70,1),Dim5= new Dimension(135,1),Dim6= new Dimension(25,1),
Dim12= new Dimension(1,1),Dim7= new Dimension(130,1),Dim8= new Dimension(10,1),
Dim9= new Dimension(40,1),Dim10= new Dimension(25,1),Dim11= new Dimension(6,1),
Dim13= new Dimension(40,1),Dim14= new Dimension(30,1),Dim15= new Dimension(30,1),
Dim16= new Dimension(30,1),Dim17= new Dimension(30,1),Dim18= new Dimension(30,1);				
		final String Roller1="1", Roller2="2", Roller3="3", Roller4="4", Roller5="5";
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	frame = new JFrame("EnigmaGUI");
		frame.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {System.exit(0);}});
		JMenuBar menu = new JMenuBar();
	JMenu menuFile = new JMenu("Datei");  
		menuFile.setMnemonic(KeyEvent.VK_D);
		menu.add(menuFile);            
	JMenuItem LoadS = new JMenuItem("Lade Quelltext", KeyEvent.VK_L);  
		menuFile.add(LoadS);                                      
	JMenuItem SaveS = new JMenuItem("Speichere Quelltext", KeyEvent.VK_S);                                      
		menuFile.add(SaveS);                                            
	JMenuItem LoadC = new JMenuItem("Lade Konfiguration", KeyEvent.VK_K);                                   
		menuFile.add(LoadC);
	JMenuItem SaveC = new JMenuItem("Speichere Konfiguration", KeyEvent.VK_A);                                      
		menuFile.add(SaveC);  
	JMenuItem Exit = new JMenuItem("Beenden", KeyEvent.VK_B);
		menuFile.add(Exit);
		frame.getContentPane().add(menu);
		frame.setJMenuBar(menu); 
	JToolBar toolBar1 = new JToolBar();
		toolBar1.setFloatable(false);
		toolBar1.setMargin(null);
	JLabel RRo = new JLabel("Reflektor: ");
		String[] RRoS = {"B","C"};
		final JComboBox RRoller = new JComboBox(RRoS);
		toolBar1.add(new JToolBar.Separator());
		toolBar1.add(RRo);
		toolBar1.add(RRoller);
	JLabel TRo = new JLabel("3. Walze: ");
		String[] TRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox TRoller = new JComboBox(TRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(TRo);
		toolBar1.add(TRoller);
		TRoller.setActionCommand("DritteWalze");
	JLabel SRo = new JLabel("2. Walze: ");
		String[] SRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox SRoller = new JComboBox(SRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(SRo);
		toolBar1.add(SRoller);
		SRoller.setActionCommand("ZweiteWalze");
	JLabel FRo = new JLabel("1. Walze: ");
		String[] FRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox FRoller = new JComboBox(FRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(FRo);
		toolBar1.add(FRoller);
		FRoller.setActionCommand("ErsteWalze");
		SRoller.removeItem(TRoller.getSelectedItem());
		FRoller.removeItem(TRoller.getSelectedItem());		
		FRoller.removeItem(SRoller.getSelectedItem());
		TRoller.removeItem(SRoller.getSelectedItem());
		TRoller.removeItem(FRoller.getSelectedItem());
		SRoller.removeItem(FRoller.getSelectedItem());
	JLabel ERo = new JLabel("Eintrittswalze: ");
		String[] ERoS = {"A","T"};
		final JComboBox ERoller = new JComboBox(ERoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(ERo);
		toolBar1.add(ERoller);
	JButton Quit = new JButton("Verlassen");
		Quit.setMnemonic(KeyEvent.VK_V);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(Quit);
		toolBar1.add(new JToolBar.Separator(Dim12));
		JToolBar toolBar2 = new JToolBar();
	JLabel TRoST = new JLabel("GrundstellungStellungDritteWalze");
		String[] TRoSTA ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		final JComboBox TRSTA = new JComboBox(TRoSTA);
		toolBar2.add(new JToolBar.Separator(Dim2));
		TRSTA.setMaximumRowCount(5);
		toolBar2.add(TRSTA);
	JLabel SRoST = new JLabel("GrundstellungStellungDritteWalze");
		String[] SRoSTA ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		final JComboBox SRSTA = new JComboBox(SRoSTA);
		toolBar2.add(new JToolBar.Separator(Dim3));
		SRSTA.setMaximumRowCount(5);
		toolBar2.add(SRSTA);	
	JLabel FRoST = new JLabel("GrundstellungStellungDritteWalze");
		String[] FRoSTA ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		final JComboBox FRSTA = new JComboBox(FRoSTA);
		toolBar2.add(new JToolBar.Separator(Dim4));
		FRSTA.setMaximumRowCount(5);
		toolBar2.add(FRSTA);
		toolBar2.add(new JToolBar.Separator(Dim5));
	JLabel StartP = new JLabel("Grundstellung");
		toolBar2.add(StartP);
		toolBar2.add(new JToolBar.Separator(Dim6));
		JToolBar toolBar3 = new JToolBar();
		toolBar3.add(new JToolBar.Separator(Dim2));
	JLabel TRoRi = new JLabel ("RingstellungDritteWalze");
		String[] TRoRin = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		final JComboBox TRRI = new JComboBox(TRoRin);
		TRRI.setMaximumRowCount(3);
		toolBar3.add(TRRI);
	JLabel SRoRi = new JLabel ("RingstellungZweiteWalze");
		String[] SRoRin = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		final JComboBox SRRI = new JComboBox(TRoRin);
		toolBar3.add(new JToolBar.Separator(Dim3));
		SRRI.setMaximumRowCount(3);
		toolBar3.add(SRRI);
	JLabel FRoRi = new JLabel ("RingstellungErsteWalze");
		String[] FRoRin = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		final JComboBox FRRI = new JComboBox(TRoRin);
		toolBar3.add(new JToolBar.Separator(Dim4));
		FRRI.setMaximumRowCount(3);
		toolBar3.add(FRRI);
	JLabel RingP = new JLabel("Ringstellung");
		toolBar3.add(new JToolBar.Separator(Dim5));
		toolBar3.add(RingP);
		toolBar3.add(new JToolBar.Separator(Dim6));
	JToolBar toolBar4 = new JToolBar();
		toolBar4.add(new JToolBar.Separator(Dim7));
		final JTextField[] PP=new JTextField[13];
		for(i=0;i<13;i++){
			PP[i]=new JTextField("",2);
			toolBar4.add(PP[i]);
			toolBar4.add(new JToolBar.Separator(Dim8));
		}
		toolBar4.add(new JToolBar.Separator(Dim9));
		JLabel PlugB = new JLabel("Steckerbrett");
		toolBar4.add(PlugB);
		toolBar4.add(new JToolBar.Separator(Dim10));
	JToolBar toolBar5 = new JToolBar();
		toolBar5.setLayout(gridbag);
		JButton Conf = new JButton("Konfiguration ¸bernehmen");
		Conf.setMnemonic(KeyEvent.VK_K);
		Conf.setPreferredSize(new Dimension(200,41));
		toolBar5.add(Conf);
		JButton delOutp = new JButton("Ausgabe lˆschen");
		delOutp.setMnemonic(KeyEvent.VK_A);
		delOutp.setPreferredSize(new Dimension(200,41));
		JButton delInp = new JButton("Eingabe lˆschen");
		delInp.setMnemonic(KeyEvent.VK_E);
		delInp.setPreferredSize(new Dimension(200,41));
		toolBar5.add(delInp);
		toolBar5.add(new JToolBar.Separator(Dim16));
		toolBar5.add(Conf);
		toolBar5.add(new JToolBar.Separator(Dim16));
		toolBar5.add(delOutp);
	JToolBar toolBar6 = new JToolBar();
		toolBar6.setLayout(gridbag);
		final JButton[] OutV=new JButton[26];
			toolBar6.add(new JToolBar.Separator(Dim11));
		for(i=0;i<26;i++){
			OutV[i]=new JButton((char)(i+65)+"");
			OutV[i].setPreferredSize(new Dimension(24,24));
			toolBar6.add(OutV[i]);
			OutV[i].setBackground(new Color(200,200,200));
			toolBar6.add(new JToolBar.Separator(Dim11));
		}
	JToolBar toolBar7 = new JToolBar();
		final JTextArea input=new JTextArea(4,30);
		input.setLineWrap(true);
		input.setAutoscrolls(true);
		final JTextArea output=new JTextArea(4,30);
		output.setLineWrap(true);
		output.setEditable(false);
		JScrollPane INP = new JScrollPane(input);
		JScrollPane OUT = new JScrollPane(output);
		JLabel INPL=new JLabel("Eingabe:");
		INP.setColumnHeaderView(INPL);
		JLabel OUTL=new JLabel("Ausgabe:");
		OUT.setColumnHeaderView(OUTL);
		toolBar7.add(new JToolBar.Separator(Dim13));
		toolBar7.add(INP);
		toolBar7.add(new JToolBar.Separator(Dim13));
		toolBar7.add(OUT);
		toolBar7.add(new JToolBar.Separator(Dim13));
	JToolBar toolBar8 = new JToolBar();
	JToolBar toolBar10 = new JToolBar();
	JToolBar toolBar11= new JToolBar();
		final JButton[] InV=new JButton[27];
		toolBar8.add(new JToolBar.Separator(Dim14));
		for(i=0;i<26;i++){
			InV[i]=new JButton((char)(i+65)+"");
			InV[i].setPreferredSize(new Dimension(30,30));
			InV[i].setActionCommand(i+"");
		}
		toolBar8.setLayout(gridbag);
		toolBar8.add(new JToolBar.Separator(Dim15));toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[16]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[22]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[4]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[17]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[19]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[25]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[20]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[8]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[14]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar8.add(InV[15]);toolBar8.add(new JToolBar.Separator(Dim15));
		toolBar10.setLayout(gridbag);
		toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[0]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[18]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[3]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[5]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[6]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[7]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[9]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[10]);toolBar10.add(new JToolBar.Separator(Dim16));
		toolBar10.add(InV[11]);toolBar10.add(new JToolBar.Separator(Dim16));		
		toolBar11.setLayout(gridbag);
		toolBar11.add(InV[24]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[23]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[2]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[21]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[1]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[13]);toolBar11.add(new JToolBar.Separator(Dim17));
		toolBar11.add(InV[12]);toolBar11.add(new JToolBar.Separator(Dim17));		
		toolBar8.add(new JToolBar.Separator(Dim18));
		InV[26]=new JButton("");
		InV[26].setActionCommand(" ");
		InV[26].setPreferredSize(new Dimension(600,30));
		final JTextArea status=new JTextArea(2,70);
		status.setLineWrap(true);
		JScrollPane STATUS= new JScrollPane(status);
		JLabel STATL=new JLabel("Statusfenster:");
		STATUS.setColumnHeaderView(STATL);
		status.setAutoscrolls(true);
		status.insert(">",0);
		status.insert(failure,1);
		status.setEditable(false);
toolBar1.setFloatable(false);toolBar2.setFloatable(false);toolBar3.setFloatable(false);
toolBar4.setFloatable(false);toolBar5.setFloatable(false);toolBar6.setFloatable(false);
toolBar7.setFloatable(false);toolBar8.setFloatable(false);toolBar10.setFloatable(false);
		toolBar11.setFloatable(false);
frame.getContentPane().setLayout(new FlowLayout());frame.getContentPane().add(toolBar1);
frame.getContentPane().add(toolBar2);frame.getContentPane().add(toolBar3);frame.getContentPane().add(toolBar5);
frame.getContentPane().add(toolBar4);frame.getContentPane().add(toolBar6);frame.getContentPane().add(toolBar7);
frame.getContentPane().add(toolBar8);frame.getContentPane().add(toolBar10);frame.getContentPane().add(toolBar11);
		frame.getContentPane().add(InV[26]);
		frame.getContentPane().add(STATUS);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.requestFocus();

		
		
		
		LoadS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			;
				if(e.getActionCommand()=="Lade Konfiguration"){
				;
				}
			frame.requestFocus();
		}});
		SaveS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				;
				if(e.getActionCommand()=="Lade Konfiguration"){
				;
				}
			frame.requestFocus();
		}});





		
		SaveC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int[][]state;String parse,directory,file,newConfig="";int i,j;int[]test=new int[26];char[]testChar=new char[2];
				if(e.getActionCommand()=="Speichere Konfiguration"){
					state=enigma.getState();
					for(i=0;i<26;i++)
						test[i]=1;
newConfig="-52-"+RRoller.getSelectedItem()+TRoller.getSelectedItem()+SRoller.getSelectedItem()+FRoller.getSelectedItem()+ERoller.getSelectedItem()+TRSTA.getSelectedItem()+SRSTA.getSelectedItem()+FRSTA.getSelectedItem()+TRRI.getSelectedItem()+SRRI.getSelectedItem()+FRRI.getSelectedItem()+"-";
					try{
						for(i=0;i<13;i++){
							parse=PP[i].getText();
							PP[i].setText("");
							parse=parse.trim().toUpperCase();
							j=parse.length();
							testChar=parse.toCharArray();
							if(j>1){
if ((testChar[0]<91)&&(testChar[1]<91)&&(testChar[0]>64)&&(testChar[1]>64)){
System.out.println(test[(int)testChar[0]-65]+"  "+(test[(int)testChar[1]-65]));
if((test[(int)testChar[0]-65]==1)&&(test[(int)testChar[1]-65]==1)) {
	test[(int)testChar[0]-65]=0; test[(int)testChar[1]-65]=0;
	PP[i].setText(testChar[0]+""+testChar[1]);
	newConfig=newConfig+PP[i].getText();
}
else throw new FileException("Jeder Buchstabe darf nur mit einem Kabel angeschlossen werden! Ausnahme: z.B.: AA (keine Permutation)");
}
else throw new FileException("Es sind nur Klein- und Groﬂbuchstaben erlaubt! Keine Sonderzeichen. Erlaubt sind: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
							}
						}
						j=0;
						for(i=0;i<26;i++)
							if(test[i]==0) j=1;
						if(j==0) newConfig=newConfig+"AA-";
							else newConfig=newConfig+"-";
					}
					catch (FileException err){
						System.err.println(err.getMessage());
						err.printStackTrace();
						status.insert(err.getMessage()+"\n",1);
					}
					input.setText("");
					output.setText("");
					FileDialog sDiag = new FileDialog(frame,"Speichere Konfigurtion");
					sDiag.show();
					directory=sDiag.getDirectory();
					file=sDiag.getFile();
					if(file!=null){
						try{
							FileIO.SaveFile(newConfig,directory+file);
						}
						catch (IOException err){
							System.err.println(err.getMessage());
							err.printStackTrace();
							status.insert(err.getMessage()+"\n",1);
						}
					}
				}
			frame.requestFocus();
		}});
		LoadC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int k,j;int[]test=new int[26];String directory,file,newConfig,first,second,third=" ";int[][]state;char[]test1=new char[5],test2=new char[5],test3=new char[5];
				boolean firstS=false,secondS=false,thirdS=false;
				if(e.getActionCommand()=="Lade Konfiguration"){
				FileDialog lDiag = new FileDialog(frame,"Lade Konfigurtion");
				lDiag.show();
				directory=lDiag.getDirectory();
				file=lDiag.getFile();
				if(file!=null){
					try{
						newConfig=FileIO.LoadFile(directory+file);
						enigma=BuildEnigma.BuildEnimga(newConfig,config,config);
						state=enigma.getState();
TRSTA.setSelectedIndex((int)state[2][2]);SRSTA.setSelectedIndex((int)state[3][2]);FRSTA.setSelectedIndex((int)state[4][2]);
TRRI.setSelectedIndex((int)state[2][1]-1);SRRI.setSelectedIndex((int)state[3][1]-1);FRRI.setSelectedIndex((int)state[4][1]-1);
						if(state[1][0]=='B') RRoller.setSelectedIndex(0);
							else RRoller.setSelectedIndex(1);
		while(!firstS||!secondS||!thirdS){
TRoller.setSelectedIndex(0);first=(String)TRoller.getItemAt(0);test1=first.toCharArray();
second=(String)TRoller.getItemAt(1);test2=second.toCharArray();third=(String)TRoller.getItemAt(2);test3=third.toCharArray();
			if((char)state[2][0]==test1[0]){TRoller.setSelectedIndex(0);firstS=true;}
				else if((char)state[2][0]==test2[0]){TRoller.setSelectedIndex(1);firstS=true;}
				else if((char)state[2][0]==test3[0]){TRoller.setSelectedIndex(2);firstS=true;}
SRoller.setSelectedIndex(0);first=(String)SRoller.getItemAt(0);test1=first.toCharArray();
second=(String)SRoller.getItemAt(1);test2=second.toCharArray();third=(String)SRoller.getItemAt(2);test3=third.toCharArray();
			if((char)state[3][0]==test1[0]){SRoller.setSelectedIndex(0);secondS=true;}
				else if((char)state[3][0]==test2[0]){SRoller.setSelectedIndex(1);secondS=true;}
				else if((char)state[3][0]==test3[0]){SRoller.setSelectedIndex(2);secondS=true;}
FRoller.setSelectedIndex(0);first=(String)FRoller.getItemAt(0);test1=first.toCharArray();
second=(String)FRoller.getItemAt(1);test2=second.toCharArray();third=(String)FRoller.getItemAt(2);test3=third.toCharArray();
			if((char)state[4][0]==test1[0]){FRoller.setSelectedIndex(0);thirdS=true;}
				else if((char)state[4][0]==test2[0]){FRoller.setSelectedIndex(1);thirdS=true;}
				else if((char)state[4][0]==test3[0]){FRoller.setSelectedIndex(2);thirdS=true;}
		}
						if(state[5][0]=='A') ERoller.setSelectedIndex(0);
							else ERoller.setSelectedIndex(1);
						j=0;
						for(k=0;k<26;k++)
							test[k]=1;
						for(k=1;k<27;k++){
							if(state[6][k]!=0){
								if((test[k-1]==1)&&(test[k-1+state[6][k]]==1)){
PP[j].setText(((char)(k+64))+""+((char)(k+state[6][k]+64)));j++;
test[k-1]=0;test[k-1+state[6][k]]=0;
								}
							}
							if(j==13) i=27;
						}
						for(k=j;k<13;k++)
							PP[k].setText("");
						input.setText("");output.setText("");
						for(k=0;k<26;k++)
							OutV[k].setBackground(new Color(200,200,200));
					}
					catch (IOException err){
						System.err.println(err.getMessage());
						err.printStackTrace();
						status.insert(err.getMessage()+"\n",1);
					}
				}
				}
			frame.requestFocus();
		}});
		Exit.addActionListener(this);
		Quit.addActionListener(this);
		TRSTA.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.requestFocus();
			}
		});
		SRSTA.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.requestFocus();
			}
		});
		FRSTA.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.requestFocus();
			}
		});
		delInp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if("Eingabe lˆschen"==e.getActionCommand()) input.setText("");
				frame.requestFocus();
			}
		});
		delOutp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if("Ausgabe lˆschen"==e.getActionCommand())	output.setText("");
				frame.requestFocus();
			}
		});
		for(i=0;i<26;i++){
			OutV[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.requestFocus();
			}});}
		for(i=0;i<26;i++){
			InV[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					char[]parse=new char[2];char parse3,outp;String parse2;int[][]state;
					parse2=e.getActionCommand();
					if(parse2.length()<2)
						parse=('0'+e.getActionCommand()).toCharArray();
					else parse=e.getActionCommand().toCharArray();
					parse3=(char)((int)(parse[0]-48)*10+((int)(parse[1]-48))+65);
					input.append(parse3+"");
					outp=enigma.toEnigma(parse3);
					output.append(""+outp);
					for(i=0;i<26;i++)
						OutV[i].setBackground(new Color(200,200,200));
					OutV[outp-65].setBackground(new Color(255,255,255));
					state=enigma.getState();
TRSTA.setSelectedIndex((int)state[2][2]);SRSTA.setSelectedIndex((int)state[3][2]);FRSTA.setSelectedIndex((int)state[4][2]);
					frame.requestFocus();
				}
			});
		}
		InV[26].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(" "==e.getActionCommand()){
					input.append(" ");
					output.append(" ");
					frame.requestFocus();
		}}});
		Conf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String newConfig=" ",parse;int i,j;int[]test=new int[26];char[]testChar=new char[2];
				for(i=0;i<26;i++)
					OutV[i].setBackground(new Color(200,200,200));
				for(i=0;i<26;i++)
					test[i]=1;
				if (e.getActionCommand()=="Konfiguration ¸bernehmen"){
newConfig="-52-"+RRoller.getSelectedItem()+TRoller.getSelectedItem()+SRoller.getSelectedItem()+FRoller.getSelectedItem()+ERoller.getSelectedItem()+TRSTA.getSelectedItem()+SRSTA.getSelectedItem()+FRSTA.getSelectedItem()+TRRI.getSelectedItem()+SRRI.getSelectedItem()+FRRI.getSelectedItem()+"-";
					try{
						for(i=0;i<13;i++){
							parse=PP[i].getText();
							PP[i].setText("");
							parse=parse.trim().toUpperCase();
							j=parse.length();
							testChar=parse.toCharArray();
							if(j>1){
if ((testChar[0]<91)&&(testChar[1]<91)&&(testChar[0]>64)&&(testChar[1]>64)){
									if((test[(int)testChar[0]-65]==1)&&(test[(int)testChar[1]-65]==1)) {
										test[(int)testChar[0]-65]=0; test[(int)testChar[1]-65]=0;
										PP[i].setText(testChar[0]+""+testChar[1]);
										newConfig=newConfig+PP[i].getText();
									}
									else throw new FileException("Jeder Buchstabe darf nur mit einem Kabel angeschlossen werden! Ausnahme: z.B.: AA (keine Permutation)");
								}
								else throw new FileException("Es sind nur Klein- und Groﬂbuchstaben erlaubt! Keine Sonderzeichen. Erlaubt sind: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
							}
						}
						j=0;
						for(i=0;i<26;i++)
							if(test[i]==0) j=1;
						if(j==0) newConfig=newConfig+"AA-";
						else newConfig=newConfig+"-";
						enigma=BuildEnigma.BuildEnimga(newConfig,config,config);
					}
					catch (IOException err){
						System.err.println(err.getMessage());
						err.printStackTrace();
						status.insert(err.getMessage()+"\n",1);
					}
					catch (FileException err){
						System.err.println(err.getMessage());
						err.printStackTrace();
						status.insert(err.getMessage()+"\n",1);
					}
					input.setText("");
					output.setText("");
					frame.requestFocus();
				}
			}
		});
		output.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {frame.requestFocus();}
		});
		status.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {frame.requestFocus();}
		});
		input.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {
				char inp,outp=' ';int i;int[][]state;
				inp=java.lang.Character.toUpperCase(arg0.getKeyChar());
					if((inp>64)&&(inp<91)){
						outp=enigma.toEnigma(inp);
						output.append(""+outp);
						for(i=0;i<26;i++)
							OutV[i].setBackground(new Color(200,200,200));
						OutV[outp-65].setBackground(new Color(255,255,255));
						state=enigma.getState();
TRSTA.setSelectedIndex((int)state[2][2]);SRSTA.setSelectedIndex((int)state[3][2]);FRSTA.setSelectedIndex((int)state[4][2]);
					}
					else if(inp==32) output.append(""+outp);
					else{
						status.insert("Fehler! "+inp+" ist kein g¸ltiges Zeichen!\n",1);
//
//input.remove(arg0.getKeyLocation());
//
					}
			}
		});
		frame.addKeyListener(new KeyListener(){
					public void keyPressed(KeyEvent arg0) {}
					public void keyReleased(KeyEvent arg0) {}
					public void keyTyped(KeyEvent arg0) {
						char inp,outp=' ';int i;int[][]state;String test="";
						if(arg0.getModifiers()==8);
						else{
						inp=java.lang.Character.toUpperCase(arg0.getKeyChar());
							if((inp>64)&&(inp<91)){
								outp=enigma.toEnigma(inp);
								output.append(""+outp);
								input.append(""+inp);
								for(i=0;i<26;i++)
									OutV[i].setBackground(new Color(200,200,200));
								OutV[outp-65].setBackground(new Color(255,255,255));
								state=enigma.getState();
TRSTA.setSelectedIndex((int)state[2][2]);SRSTA.setSelectedIndex((int)state[3][2]);FRSTA.setSelectedIndex((int)state[4][2]);
							}
							else if(inp==32) {output.append(""+outp);input.append(""+outp);} 
							else{
								status.insert("Fehler! "+inp+" ist kein g¸ltiges Zeichen!\n",1);
							}
					}
				}});
		RRoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.requestFocus();
		}});
		ERoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.requestFocus();
		}});
		FRoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String SaveTh,SaveSe,SaveFi,first,second,third;
				if (e.getActionCommand()=="ErsteWalze"){
					SaveTh=(String)TRoller.getSelectedItem();
					SaveSe=(String)SRoller.getSelectedItem();
					SaveFi=(String)FRoller.getSelectedItem();
					FRoller.removeAllItems();
					if((Roller1!=SaveSe)&&(Roller1!=SaveTh))FRoller.addItem(Roller1);
					if((Roller2!=SaveSe)&&(Roller2!=SaveTh))FRoller.addItem(Roller2);
					if((Roller3!=SaveSe)&&(Roller3!=SaveTh))FRoller.addItem(Roller3);
					if((Roller4!=SaveSe)&&(Roller4!=SaveTh))FRoller.addItem(Roller4);
					if((Roller5!=SaveSe)&&(Roller5!=SaveTh))FRoller.addItem(Roller5);
					FRoller.setSelectedItem(SaveFi);
					frame.requestFocus();
				}}
		});
		SRoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String SaveTh,SaveSe,SaveFi,first,second,third;
				if (e.getActionCommand()=="ZweiteWalze"){
					SaveTh=(String)TRoller.getSelectedItem();
					SaveSe=(String)SRoller.getSelectedItem();
					SaveFi=(String)FRoller.getSelectedItem();
					SRoller.removeAllItems();
					if((Roller1!=SaveFi)&&(Roller1!=SaveTh))SRoller.addItem(Roller1);
					if((Roller2!=SaveFi)&&(Roller2!=SaveTh))SRoller.addItem(Roller2);
					if((Roller3!=SaveFi)&&(Roller3!=SaveTh))SRoller.addItem(Roller3);
					if((Roller4!=SaveFi)&&(Roller4!=SaveTh))SRoller.addItem(Roller4);
					if((Roller5!=SaveFi)&&(Roller5!=SaveTh))SRoller.addItem(Roller5);
					SRoller.setSelectedItem(SaveSe);
					frame.requestFocus();
				}}
		});
		TRoller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String SaveTh,SaveSe,SaveFi,first,second,third;
				if (e.getActionCommand()=="DritteWalze"){
					SaveTh=(String)TRoller.getSelectedItem();
					SaveSe=(String)SRoller.getSelectedItem();
					SaveFi=(String)FRoller.getSelectedItem();
					TRoller.removeAllItems();
					if((Roller1!=SaveSe)&&(Roller1!=SaveFi))TRoller.addItem(Roller1);
					if((Roller2!=SaveSe)&&(Roller2!=SaveFi))TRoller.addItem(Roller2);
					if((Roller3!=SaveSe)&&(Roller3!=SaveFi))TRoller.addItem(Roller3);
					if((Roller4!=SaveSe)&&(Roller4!=SaveFi))TRoller.addItem(Roller4);
					if((Roller5!=SaveSe)&&(Roller5!=SaveFi))TRoller.addItem(Roller5);
					TRoller.setSelectedItem(SaveTh);
					frame.requestFocus();
				}}
		});
		frame.requestFocus();
		}
	public void actionPerformed(ActionEvent a) {
			String str = a.getActionCommand();
			if(str.equals("Beenden")) System.exit(0);
			if(str.equals("Verlassen")) System.exit(0);
		}

}
