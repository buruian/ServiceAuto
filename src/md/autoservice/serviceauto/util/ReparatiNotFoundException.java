/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.util;

/**
 *
 * @author iucosoft5
 */
public class ReparatiNotFoundException extends Exception {
     public ReparatiNotFoundException() {
        super("Reparatia nu este gasita");
    }

    public ReparatiNotFoundException(String message) {
        super(message);
    }
}
