class Atracao {
    protected String nome;
    protected Integer capacidade;
    protected Double preco;

    public Atracao(String nome, int capacidade, double preco) {
        setNome(nome);
        setCapacidade(capacidade);
        setPreco(preco);
    }

    public Double calcularArrecacaoMaxima() {
        if (capacidade == null || preco == null)
            return null;
        return capacidade * preco;
    }

    protected void printarInfos() {
        System.out.println("nome: " + nome + " capacidade: " + capacidade + " preco: " + preco);
    }

    public void setNome(String nome) {
        if (!nome.isEmpty())
            this.nome = nome;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade > 0)
            this.capacidade = capacidade;
    }

    public void setPreco(double preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public Double getPreco() {
        return preco;
    }
}

class MontanhaRussa extends Atracao {
    private Integer alturaMinima;

    public MontanhaRussa(String nome, int capacidade, double preco, int alturaMinima) {
        super(nome, capacidade, preco);
        setAlturaMinima(alturaMinima);
    }

    public void exibirInformacoes() {
        super.printarInfos();
        System.out.print(" altura minima: "+ alturaMinima);
    }

    public void setAlturaMinima(int alturaMinima) {
        if (alturaMinima > 0)
            this.alturaMinima = alturaMinima;
    }

    public Integer getAlturaMinima() {
        return alturaMinima;
    }
}

class Carrosel extends Atracao {

    private Integer idade_minima;

    public Carrosel(String nome, int capacidade, double preco, int idade_minima) {
        super(nome, capacidade, preco);
        setIdade_minima(idade_minima);
    }

    public void exibirInformacoes() {
        super.printarInfos();
        System.out.print(" idade minima: "+idade_minima);
    }

    public void setIdade_minima(int idade_minima) {
        if (idade_minima > 0)
            this.idade_minima = idade_minima;
    }
    public Integer getIdade_minima() {
        return idade_minima;
    }

}
