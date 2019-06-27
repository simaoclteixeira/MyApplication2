package pt.ipg.myapplication.Entidades;

public class Mota {



    private int id_Motas;

    public int getId_Motas() {
        return id_Motas;
    }

    public void setId_Motas(int id_Motas) {
        this.id_Motas = id_Motas;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Float getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(Float cilindrada) {
        Cilindrada = cilindrada;
    }

    public Float getPeso() {
        return Peso;
    }

    public void setPeso(Float peso) {
        Peso = peso;
    }

    private String Marca;
    private String Modelo;
    private Float Cilindrada;
    private Float Peso;




    @Override
    public String  toString(){

        return this.getMarca() + " - " + this.getModelo();
    }
}