/*
 * Created on 05.11.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package enigma.exceptions;

/**
 * @author jdan
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class FileException extends RuntimeException{
	public FileException(String err){
		super(err);
	 }
	 public FileException(){
	 	super("File Exception");
	 }
}
