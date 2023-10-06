package dominio;

import dao.IJogoDAO;
import dao.JogoMapDAO;

import javax.swing.*;
import java.util.List;

public class App {
    /*primeiramente deverá ser definida uma propriedade de classe do tipo da interface que é responsável pelo
    banco de dados e sua instância será uma referência para chamar os métodos de JogoMapDAO.
     */
    private static IJogoDAO jogoDAO;
    public static void main(String[] args) {
        jogoDAO = new JogoMapDAO();
        String escolherOpcao = JOptionPane.
                showInputDialog(null,
                        "Digite 1 para cadastrar,2 para consultar,3 para excluir,4 para alterar e 5 para sair.",
                        "Opção",JOptionPane.QUESTION_MESSAGE);
        while (!isOpcaoValida(escolherOpcao)){
            if (escolherOpcao.equals("")){
                sair();
            }
            escolherOpcao = JOptionPane.
                    showInputDialog(null,
                            "Opção inválida,tente novamente." +
                                    "Digite 1 para cadastrar,2 para consultar,3 para excluir,4 para alterar e 5 para sair.",
                            "Opção",JOptionPane.QUESTION_MESSAGE);

        }
        if (escolherOpcao.equals("1")){
            String opcaoCadastro = JOptionPane.
                    showInputDialog(null,
                            "Digite o nome do jogo que quer cadastrar, o seu código e o seu preço separados por vírgula","Cadastrar",
                            JOptionPane.QUESTION_MESSAGE);
            JogoMapDAO cadastrar = new JogoMapDAO();
            List<String> dadosSeparados = List.of(opcaoCadastro.split(","));
            Jogo jogoCadastrado = new Jogo(dadosSeparados.get(0),dadosSeparados.get(1),dadosSeparados.get(2));
            Boolean isCadastrado = jogoDAO.cadastrar(jogoCadastrado);
            if (isCadastrado){
                JOptionPane.
                        showMessageDialog(null,
                                "Jogo cadastrado com sucesso!","SUCESSO!",
                                JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.
                        showMessageDialog(null,
                                "Jogo já cadastrado!","Ops!",
                                JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (escolherOpcao.equals("2")){
            String opcaoConsulta = JOptionPane.
                    showInputDialog(null,
                            "Digite o código do jogo que quer consultar","Consultar",
                            JOptionPane.QUESTION_MESSAGE);
            consultar(opcaoConsulta);
        }
        if (escolherOpcao.equals("3")){
            String opcaoExcluir = JOptionPane.
                    showInputDialog(null,
                            "Digite o nome do jogo que quer excluir","Excluir",
                            JOptionPane.QUESTION_MESSAGE);
        }
        if (escolherOpcao.equals("4")){
            String opcaoAlterar = JOptionPane.
                    showInputDialog(null,
                            "Digite o nome do jogo que quer alterar","Alteração",
                            JOptionPane.QUESTION_MESSAGE);
        }
        if (escolherOpcao.equals("5")){
            sair();
        }
    }
    public static void consultar(String dados){
        Jogo jogo = jogoDAO.consultar(Integer.parseInt(dados));
        if (jogo!=null){
            JOptionPane.showMessageDialog(null,
                    "Jogo encontrado " + jogo.toString(),"SUCESSO!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            while (jogo == null){
                String opcaoConsulta = JOptionPane.
                        showInputDialog(null,
                                "Digite o código do jogo que quer consultar, caso não queira consultar digite 0, caso queira voltar a tela inicial digite 00","Consultar",
                                JOptionPane.QUESTION_MESSAGE);
                if (opcaoConsulta.equals("0")){
                    sair();
                }
                consultar(opcaoConsulta);
            }
        }

    }
    public static void sair(){
        JOptionPane.showMessageDialog(null,
                "Ok, até logo!","Bye,bye!",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    public static Boolean isOpcaoValida(String opcao){
        if (opcao.equals("1")||opcao.equals("2")||opcao.equals("3")
                ||opcao.equals("4")||opcao.equals("5")){
            return true;
        }
        return false;
    }
}
