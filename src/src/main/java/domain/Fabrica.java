package src.main.java.domain;

import javax.persistence.*;
import javax.swing.event.ListDataEvent;
import java.util.List;

@Entity
@Table(name = "TB_FABRICA")
public class Fabrica {
    @Id
    @GeneratedValue(generator = "FABRICA_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FABRICA_SEQ", sequenceName = "SQ_FABRICA", initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",nullable = false,unique = true)
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_empresario_fk",
            foreignKey = @ForeignKey(name = "fk_fabrica_empresario"),
            referencedColumnName = "id", nullable = false)
    private Empresario empresario;

    @OneToMany(mappedBy = "fabrica")//Uma fábrica, produz vários produtos, no mappedBy vou dizer de onde vou referenciar e fazer a ligação do to Many, nesse caso é a propriedade fabrica la na classe Produto
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

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

    public Empresario getEmpresario() {
        return empresario;
    }

    public void setEmpresario(Empresario empresario) {
        this.empresario = empresario;
    }
}
