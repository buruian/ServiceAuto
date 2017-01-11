/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.model;

/**
 *
 * @author iucosoft5
 */
public abstract class Persoana {
    
    private int id;
    private String nume;
    private String prenume;
    private int nrTelefon;

    public Persoana() {
    }

    public Persoana(int id, String nume, String prenume, int nrTelefon) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(int nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    @Override
    public String toString() {
        return "Persoana{" + "id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", nrTelefon=" + nrTelefon + '}';
    }

}
