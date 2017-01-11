/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.util;

/**
 *
 * @author iucosoft5
 */
public class ProprietarNotFoundException extends Exception{

    public ProprietarNotFoundException() {
        super("Proprietar nu este gasit");
    }

    public ProprietarNotFoundException(String message) {
        super(message);
    }
    
}
