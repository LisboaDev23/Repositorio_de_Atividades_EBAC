package src.main.java.domain;

import javax.persistence.*;
import java.time.Instant;

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
}
