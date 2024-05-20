public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private int km;

    public void def_dados(String marca, String modelo, int ano, int km) {
        //Define os dados do veículo com base nos parâmetros fornecidos.
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km;
    }

    public void mostrar_dados() {
        //Exibe os dados do veículo.
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Kilometragem: " + km + " km");
    }

    public void aumentar_km(int valor) {
        //Adiciona um valor à quilometragem do veículo.
        this.km += valor;
    }

    //Retorna a quilometragem e o ano do veículo, respectivamente.
    public int ret_km() {
        return km;
    }

    public int ret_ano() {
        return ano;
    }
}
