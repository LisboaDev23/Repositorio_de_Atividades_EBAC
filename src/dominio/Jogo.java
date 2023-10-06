package dominio;
import java.util.Objects;

public class Jogo {
    //definindo as propriedades da minha classe Cliente
    private String nome;
    private Double preco;
    private Integer codigo;

    //definindo seu construtor onde pra que seja instanciado ele deverá ter todos os seus devidos atributos
    public Jogo(String nome, String preco, String codigo){
        this.nome=nome;
        this.preco=Double.valueOf(preco.trim());
        this.codigo=Integer.valueOf(codigo.trim());
    }

    //metodos getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    //equals and hashcode. Só será comparado pelo código do jogo.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return Objects.equals(codigo, jogo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    //toString

    @Override
    public String toString() {
        return "Nome:" + nome + '\'' +
                ", Preco:" + preco +
                ", Codigo=" + codigo;
    }
}
