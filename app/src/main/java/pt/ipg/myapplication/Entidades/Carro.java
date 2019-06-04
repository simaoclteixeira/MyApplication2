package pt.ipg.myapplication.Entidades;

public class Carro {



    private int id_Carros;
    private String Marca;
    private String Modelo;
    private Float Lotacao;
    private String Tracao;
    private Float Peso;

    public Carro(){
        this.setId_Carros(0);
        this.setMarca("");
        this.setModelo("");
        this.setLotacao((float) 0);
        this.setTracao("");
        this.setPeso((float) 0);
    }

    public int getId_Carros() {
        return id_Carros;
    }

    public void setId_Carros(int id_Carros) {
        this.id_Carros = id_Carros;
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

    public Float getLotacao() {
        return Lotacao;
    }

    public void setLotacao(Float lotacao) {
        Lotacao = lotacao;
    }

    public String getTracao() {
        return Tracao;
    }

    public void setTracao(String tracao) {
        Tracao = tracao;
    }

    public Float getPeso() {
        return Peso;
    }

    public void setPeso(Float peso) {
        Peso = peso;
    }

    @Override
    public String  toString(){

        return this.getMarca() + " - " + this.getModelo();
    }
}
