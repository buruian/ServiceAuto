/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.util;

/**
 *
 * @author iucosoft5
 */
public class AngajatNotFoundException extends Exception {

    public AngajatNotFoundException() {
        super("Angajat nu este gasit");
    }

    public AngajatNotFoundException(String message) {
        super(message);
    }
    
    
}
