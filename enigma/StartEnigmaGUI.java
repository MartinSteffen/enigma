/*
 * Created on 08.01.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma;
import enigma.gui.*;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StartEnigmaGUI{

	public static void main(String[] args) {
		try{
		EnigmaGUI egui = new EnigmaGUI();
		}
		catch (ClassNotFoundException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
			}
		catch (InstantiationException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
		}
		catch (IllegalAccessException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
		} 
		catch (UnsupportedLookAndFeelException err){
			System.err.println(err.getMessage());
			err.printStackTrace();
		}
	}
}
