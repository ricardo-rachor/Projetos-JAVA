public class Documento {
    private String nome;
    private String tipo;
    private int tamanho;

    // Construtor
    public Documento(String nome, String tipo, int tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    // Métodos para definir os valores dos atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamanho(int tamanho) {
        if (tamanho > 0) {
            this.tamanho = tamanho;
        } else {
            System.out.println("O tamanho do documento deve ser maior que 0.");
        }
    }

    // Métodos para retornar os valores de cada atributo
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamanho() {
        return tamanho;
    }
}
