package src.main.java.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {



    @Id
    @GeneratedValue(generator = "PRODUTO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "SQ_PRODUTOS", initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CODIGO",length = 20,nullable = false,unique = true)
    private Long codigo;

    @Column(name = "PRECO", nullable = false)
    private Double preco;

    @Column(name = "DATA_FABRICACAO", nullable = false)
    private String dataFabricacao;

//    @ManyToOne
//    @JoinColumn(name = "ID_PRODUTO_FK",
//    foreignKey = @ForeignKey(name = "FK_FABRICA_PRODUTO"),
//    referencedColumnName = "ID", nullable = false)
//    private Fabrica fabrica;
//
//    public Fabrica getFabrica() {
//        return fabrica;
//    }
//
//    public void setFabrica(Fabrica fabrica) {
//        this.fabrica = fabrica;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", dataFabricacao='" + dataFabricacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(codigo, produto.codigo) &&
                Objects.equals(dataFabricacao, produto.dataFabricacao);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, preco, dataFabricacao);
    }
}
