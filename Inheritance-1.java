class Produto {
    protected String codigo, descricao;
    protected Double preco, peso;

    public Produto(String codigo, String descricao, Double preco, Double peso) {
        setCodigo(codigo);
        setDescricao(descricao);
        setPreco(preco);
        setPeso(peso);
    }

    public double calcularFrete() {
        return peso * 6.50;
    }

    public void setCodigo(String codigo) {
        if (!codigo.isEmpty())
            this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty())
            this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public void setPeso(Double peso) {
        if (peso > 0)
            this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPeso() {
        return peso;
    }
}

class CD extends Produto {
    private String nomeBanda;

    public CD(String codigo, String descricao, Double preco, Double peso, String nomeBanda) {
        super(codigo, descricao, preco, peso);
        setNomeBanda(nomeBanda);
    }

    public void setNomeBanda(String nomeBanda) {
        if (!descricao.isEmpty())
            this.nomeBanda = nomeBanda;
    }

    public String getNomeBanda() {
        return nomeBanda;
    }
}

class Software extends Produto {
    private String categoria;

    public Software(String codigo, String descricao, Double preco, Double peso, String categoria) {
        super(codigo, descricao, preco, peso);
        setCategoria(categoria);
    }

    public void setCategoria(String categoria) {
        if (!descricao.isEmpty())
            this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}

class Livro extends Produto {
    private String autor;

    public Livro(String codigo, String descricao, Double preco, Double peso, String autor) {
        super(codigo, descricao, preco, peso);
        setAutor(autor);
    }

    public void setAutor(String autor) {
        if (!descricao.isEmpty())
            this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
}
