/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.model;

/**
 *
 * @author iucosoft5
 */
public class Proprietar extends Persoana {

    String email;

    public Proprietar() {
    }

    public Proprietar(String email) {
        this.email = email;
    }

    public Proprietar(int id, String nume, String prenume, int nrTelefon, String email) {
        super(id, nume, prenume, nrTelefon);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proprietar{" + super.toString() + "email=" + email + '}';
    }

}
