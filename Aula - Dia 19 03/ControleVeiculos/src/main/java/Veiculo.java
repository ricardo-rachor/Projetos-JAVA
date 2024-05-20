public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private int km;
    private double valorVenda;

    public Veiculo() {
        this.marca = "Desconhecido";
        this.modelo = "Desconhecido";
        this.ano = 0;
        this.km = 0;
        this.valorVenda = 0.0;
    }

    public void setMarca(String marca) {
        if (!marca.isEmpty()) {
            this.marca = marca;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        if (!modelo.isEmpty()) {
            this.modelo = modelo;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setAno(int ano) {
        if (ano >= 1950) {
            this.ano = ano;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setKm(int km) {
        if (km >= 0) {
            this.km = km;
        }
    }

    public int getKm() {
        return km;
    }

    public void setValorVenda(double valorVenda) {
        if (valorVenda >= 0) {
            this.valorVenda = valorVenda;
        }
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void aumentarKm(int valor) {
        if (valor >= 0) {
            this.km += valor;
        }
    }
}