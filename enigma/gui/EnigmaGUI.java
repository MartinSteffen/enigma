/*
 * Created on 08.01.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.gui;
//import enigma.exceptions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class EnigmaGUI implements ActionListener{
	public EnigmaGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		JFrame frame;
		Dimension Dim1= new Dimension(45,1),
		Dim2= new Dimension(160,1),
		Dim3= new Dimension(85,1),
		Dim4= new Dimension(85,1),
		Dim5= new Dimension(235,1),
		Dim6= new Dimension(25,1),
		Dim12= new Dimension(1,1),
		Dim7= new Dimension(30,1),
		Dim8= new Dimension(10,1),
		Dim9= new Dimension(35,1),
		Dim10= new Dimension(25,1);
//		Dim11= new Dimension(140,1);
		
				
		final String Roller1="Walze '1'", Roller2="Walze '2'", Roller3="Walze '3'", Roller4="Walze '4'", Roller5="Walze '5'";
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
	JLabel RRo = new JLabel("Reflektor");
		String[] RRoS = {"Reflektor 'B'","Reflektor 'C'"};
		final JComboBox RRoller = new JComboBox(RRoS);
		toolBar1.add(new JToolBar.Separator());
		toolBar1.add(RRoller);
	JLabel TRo = new JLabel("DritteWalze");
		String[] TRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox TRoller = new JComboBox(TRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(TRoller);
		TRoller.setActionCommand("DritteWalze");
	JLabel SRo = new JLabel("ZweiteWalze");
		String[] SRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox SRoller = new JComboBox(SRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(SRoller);
		SRoller.setActionCommand("ZweiteWalze");
	JLabel FRo = new JLabel("ErsteWalze");
		String[] FRoS = {Roller1,Roller2,Roller3,Roller4,Roller5};
		final JComboBox FRoller = new JComboBox(FRoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
		toolBar1.add(FRoller);
		FRoller.setActionCommand("ErsteWalze");
		SRoller.removeItem(TRoller.getSelectedItem());
		FRoller.removeItem(TRoller.getSelectedItem());		
		FRoller.removeItem(SRoller.getSelectedItem());
		TRoller.removeItem(SRoller.getSelectedItem());
		TRoller.removeItem(FRoller.getSelectedItem());
		SRoller.removeItem(FRoller.getSelectedItem());
	JLabel ERo = new JLabel("Eintrittswalze");
		String[] ERoS = {"Eintrittswalze 'A'","Eintrittswalze 'T'"};
		final JComboBox ERoller = new JComboBox(ERoS);
		toolBar1.add(new JToolBar.Separator(Dim1));
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
		toolBar2.add(TRSTA);
	JLabel SRoST = new JLabel("GrundstellungStellungDritteWalze");
		String[] SRoSTA ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		final JComboBox SRSTA = new JComboBox(SRoSTA);
		toolBar2.add(new JToolBar.Separator(Dim3));
		toolBar2.add(SRSTA);	
	JLabel FRoST = new JLabel("GrundstellungStellungDritteWalze");
		String[] FRoSTA ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		final JComboBox FRSTA = new JComboBox(FRoSTA);
		toolBar2.add(new JToolBar.Separator(Dim4));
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
		toolBar3.add(TRRI);
	JLabel SRoRi = new JLabel ("RingstellungDritteWalze");
		String[] SRoRin = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		final JComboBox SRRI = new JComboBox(TRoRin);
		toolBar3.add(new JToolBar.Separator(Dim3));
		toolBar3.add(SRRI);
	JLabel FRoRi = new JLabel ("RingstellungDritteWalze");
		String[] FRoRin = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		final JComboBox FRRI = new JComboBox(TRoRin);
		toolBar3.add(new JToolBar.Separator(Dim4));
		toolBar3.add(FRRI);
	JLabel RingP = new JLabel("Ringstellung");
		toolBar3.add(new JToolBar.Separator(Dim5));
		toolBar3.add(RingP);
		toolBar3.add(new JToolBar.Separator(Dim6));
	JToolBar toolBar4 = new JToolBar();
		toolBar4.add(new JToolBar.Separator(Dim7));
		final TextField PP1 = new TextField("AA", 2);
		toolBar4.add(PP1);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP2 = new TextField("BB", 2);
		toolBar4.add(PP2);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP3 = new TextField("CC", 2);
		toolBar4.add(PP3);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP4 = new TextField("DD", 2);
		toolBar4.add(PP4);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP5 = new TextField("EE", 2);
		toolBar4.add(PP5);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP6 = new TextField("FF", 2);
		toolBar4.add(PP6);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP7 = new TextField("GG", 2);
		toolBar4.add(PP7);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP8 = new TextField("HH", 2);
		toolBar4.add(PP8);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP9 = new TextField("II", 2);
		toolBar4.add(PP9);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP10 = new TextField("JJ", 2);
		toolBar4.add(PP10);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP11 = new TextField("KK", 2);
		toolBar4.add(PP11);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP12 = new TextField("LL", 2);
		toolBar4.add(PP12);
		toolBar4.add(new JToolBar.Separator(Dim8));
		final TextField PP13 = new TextField("MM", 2);
		toolBar4.add(PP13);
		toolBar4.add(new JToolBar.Separator(Dim9));
		JLabel PlugB = new JLabel("Steckerbrett");
		toolBar4.add(PlugB);
		toolBar4.add(new JToolBar.Separator(Dim10));
						
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(toolBar1);
		frame.getContentPane().add(toolBar2);
		frame.getContentPane().add(toolBar3);
		frame.getContentPane().add(toolBar4);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		
		LoadS.addActionListener(this);
		SaveS.addActionListener(this);
		LoadC.addActionListener(this);
		SaveC.addActionListener(this);
		Exit.addActionListener(this);
		Quit.addActionListener(this);
	
		
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
				//	
				//	SRoller.updateUI();
				//	TRoller.updateUI();
				//	SRoller.setSelectedItem(SaveSe);
				//	TRoller.setSelectedItem(SaveTh);
				//	
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
				}}
		});
		
		}


		public void actionPerformed(ActionEvent a) {
		String str = a.getActionCommand();
		if(str.equals("Beenden")) System.exit(0);
		if(str.equals("Verlassen")) System.exit(0);

	}
}
