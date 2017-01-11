/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.model;

/**
 *
 * @author iucosoft5
 */
public class Masina {

    private int id;
    private String nrInmatriculare;
    private String marca;
    private String model;
    private int anu;
    private String combustibil;
    private String modelMotor;
    private Proprietar proprietar;
    private Reparatie listaReparatiilor;

    public Masina() {
    }

    public Masina(int id, String nrInmatriculare, String marca, String model, int anu, String combustibil, String modelMotor) {
        this(id, nrInmatriculare, marca, model, anu, combustibil, modelMotor, null);
    }

    public Masina(int id, String nrInmatriculare, String marca, String model, int anu, String combustibil, String modelMotor, Proprietar proprietar) {
        this.id = id;
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.model = model;
        this.anu = anu;
        this.combustibil = combustibil;
        this.modelMotor = modelMotor;
        this.proprietar = proprietar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnu() {
        return anu;
    }

    public void setAnu(int anu) {
        this.anu = anu;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public String getModelMotor() {
        return modelMotor;
    }

    public void setModelMotor(String modelMotor) {
        this.modelMotor = modelMotor;
    }

    public Proprietar getProprietar() {
        return proprietar;
    }

    public void setProprietar(Proprietar proprietar) {
        this.proprietar = proprietar;
    }

    public Reparatie getListaReparatiilor() {
        return listaReparatiilor;
    }

    public void setListaReparatiilor(Reparatie listaReparatiilor) {
        this.listaReparatiilor = listaReparatiilor;
    }

    @Override
    public String toString() {
        return "Masini{" + "id=" + id + ", nrInmatriculare=" + nrInmatriculare + ", marca=" + marca + ", model=" + model + ", anu=" + anu + ", combustibil=" + combustibil + ", modelMotor=" + modelMotor + ", proprietar=" + proprietar + '}';
    }

}
