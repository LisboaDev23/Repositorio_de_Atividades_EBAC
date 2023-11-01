package src.main.java.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_EMPRESARIO")
public class Empresario {
    @Id
    @GeneratedValue(generator = "EMPRESARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EMPRESARIO_SEQ", sequenceName = "SQ_EMPRESARIO", initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",nullable = false,unique = true)
    private String nome;

    @Column(name = "CNPJ",nullable = false,unique = true)
    private Long cnpj;

//    @OneToOne(mappedBy = "empresario")
//    private Fabrica fabrica;

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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

//    public Fabrica getFabrica() {
//        return fabrica;
//    }
//
//    public void setFabrica(Fabrica fabrica) {
//        this.fabrica = fabrica;
//    }
}
