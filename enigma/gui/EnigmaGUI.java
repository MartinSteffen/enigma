/*
 * Created on 08.01.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.gui;
import enigma.exceptions.*;
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
		
		JToolBar toolBar = new JToolBar();

		toolBar.setFloatable(false);
		toolBar.setMargin(null);
		JLabel ERo = new JLabel("Eintrittswalze");
		String[] ERoS = {"Eintrittswalze 'A'","Eintrittswalze 'T'"};
		final JComboBox ERoller = new JComboBox(ERoS);
		toolBar.add(ERoller);
		
		
		
		
		JButton Quit = new JButton("Verlassen");
		Quit.setMnemonic(KeyEvent.VK_V);
		toolBar.add(Quit);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(toolBar);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setResizable(false);
		LoadS.addActionListener(this);
		SaveS.addActionListener(this);
		LoadC.addActionListener(this);
		SaveC.addActionListener(this);
		Exit.addActionListener(this);
		Quit.addActionListener(this);
	}


	public void actionPerformed(ActionEvent a) {
		String str = a.getActionCommand();
		if(str.equals("Beenden")) System.exit(0);
		if(str.equals("Verlassen")) System.exit(0);

		


	}
}
