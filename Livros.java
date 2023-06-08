
interface ItemVendavel {
    void setTitulo(String titulo);

    void setEstoque(Integer estoque);

    void setPreco(Double preco);

    String getTitulo();

    Integer getEstoque();

    Double getPreco();
}

class Livro implements ItemVendavel {
    private String titulo, autor;
    private Integer estoque = 0, paginas;
    private Double preco;

    public Livro(String titulo, String autor, Integer estoque, Integer paginas, Double preco) {
        setTitulo(titulo);
        setAutor(autor);
        setEstoque(estoque);
        setPaginas(paginas);
        setPreco(preco);
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(Integer paginas) {
        if (paginas > 0)
            this.paginas = paginas;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void setEstoque(Integer estoque) {
        if (estoque > 0)
            this.estoque = estoque;
    }

    @Override
    public void setPreco(Double preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public String getTitulo() {
        return null;
    }

    @Override
    public Integer getEstoque() {
        return null;
    }

    @Override
    public Double getPreco() {
        return null;
    }
}

class Livraria {
    private List<ItemVendavel> itens = new ArrayList<ItemVendavel>();

    public void venderLivro(String titulo) {
        for (ItemVendavel item : itens) {
            if (item instanceof Livro && ((Livro) item).getTitulo().equalsIgnoreCase(titulo))
                item.setEstoque(item.getEstoque() - 1);
        }
    }

    public void comprarLivro(Livro novoLivro) {
        for (ItemVendavel item : itens) {
            if (!(item instanceof Livro))
                continue;
            if (item.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())) {
                item.setEstoque(item.getEstoque() + 1);
                return;
            }
        }
        itens.add(novoLivro);
    }
}
