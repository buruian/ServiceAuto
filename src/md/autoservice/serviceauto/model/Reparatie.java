/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author iucosoft5
 */
public class Reparatie {

    private int id;
    private Date dataIntrare;
    private Date dataIesire;
    private String probleme;
    private List<Angajat> listaReparatori;
    private Masina masina;

    public Reparatie() {
    }

    public Reparatie(int id, Date dataIntrare, Date dataIesire, String probleme) {
        this.id = id;
        this.dataIntrare = dataIntrare;
        this.dataIesire = dataIesire;
        this.probleme = probleme;
    }

    public Reparatie(int id, Date dataIntrare, Date dataIesire, String probleme, List<Angajat> listaReparatori, Masina masina) {
        this.id = id;
        this.dataIntrare = dataIntrare;
        this.dataIesire = dataIesire;
        this.probleme = probleme;
        this.listaReparatori = listaReparatori;
        this.masina = masina;
    }

    public Reparatie(int id, Date dataIntrare, Date dataIesire, String probleme, Masina masini) {
        this.id = id;
        this.dataIntrare = dataIntrare;
        this.dataIesire = dataIesire;
        this.probleme = probleme;
        this.masina = masini;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataIntrare() {
        return dataIntrare;
    }

    public void setDataIntrare(Date dataIntrare) {
        this.dataIntrare = dataIntrare;
    }

    public Date getDataIesire() {
        return dataIesire;
    }

    public void setDataIesire(Date dataIesire) {
        this.dataIesire = dataIesire;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public List<Angajat> getListaReparatori() {
        return listaReparatori;
    }

    public void setListaReparatori(List<Angajat> listaReparatori) {
        this.listaReparatori = listaReparatori;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    @Override
    public String toString() {
        return "Reparati{" + "dataIntrare=" + dataIntrare + ", dataIesire=" + dataIesire + ", probleme=" + probleme + ", listaReparatori=" + listaReparatori + '}';
    }

}
