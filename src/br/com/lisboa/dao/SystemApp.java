package br.com.lisboa.dao;

import br.com.lisboa.domain.Game;

import javax.swing.*;

public class SystemApp {
    private static IGameDAO iGameDAO;
    public static void main (String args []){
        iGameDAO = new GameMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar um jogo, 2 para consultar, 3 para excluir um jogo, 4 para alterar os dados de um jogo ou 5 para sair","Cadastre um jogo", JOptionPane.INFORMATION_MESSAGE );
        //criando a condicional de caso o usuário digitar a opção de cadastro, executar a mensagem para cadastrar
        if (isOpcaoCadastro(opcao)){
            JOptionPane.showMessageDialog(null, "Ok, vamos cadastrar ","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        if (isOpcaoAlterar(opcao)){
            JOptionPane.showMessageDialog(null, "Vamos alterar o game", "Altere o jogo", JOptionPane.INFORMATION_MESSAGE);
        }
        //enquanto não for válido, se o usuário deixou vazio, ele sai do programa, caso ele só tenha digitado uma opção invalida, ele volta a solicitar um novo número
        while (!isOpcaoValida(opcao)){
        if ("".equals(opcao)){
            sair();
        }
        opcao = JOptionPane.showInputDialog(null, "Opção inválida. Digite 1 para cadastrar um jogo, 2 para consultar, 3 para excluir um jogo, 4 para alterar os dados de um jogo ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
        //enquanto na isOpcaoValida for selecionada a isOpcaoSair, acione o metodo sair();
        while (isOpcaoValida(opcao)){
            if (isOpcaoSair(opcao)){
                sair();
                //caso não, se a opção valida seja a de cadastro, criando uma variável que vai ser responsável por representar os dados
                //depois disso chamar o metodo cadastrar
            }
            else if (isOpcaoCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,"Digite o código do jogo,nome,preço separados por vírgula ", "Cadastro de jogo",JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isOpcaoAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,"Digite o novo código do jogo,nome,preço separados por vírgula ", "Alterando Jogo",JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            } else if (isOpcaoConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,"Digite o código do jogo que você quer consultar ", "Consultado Jogo",JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }
            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar um jogo, 2 para consultar, 3 para excluir um jogo, 4 para alterar os dados de um jogo ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        //para poder consultar, lá no método da interface é pedido o código que é um long, para podermos inseri-los é necessário transformar o dados para long
        //defino que a variável game da Classe Game é o jogo que será consultado, isso é válido para esse método
        Game game = iGameDAO.consultar(Long.parseLong(dados));
        if (game!=null){
            JOptionPane.showMessageDialog(null,"Esse é o jogo que consultou"+game.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"Esse jogo não está cadastrado", "Inválido", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //método cadastrar, onde nele eu declaro um array que vai pegar os dados separados por vírgula, e fazer um split para que ele insira esses dados no meu array
    private static void cadastrar(String dados) {
        String [] dadosSeparados = dados.split(",");
        //instanciando as informações do usuário que está cadastrando um jogo
        //Tentar validar se todos os campos estão preenchidos
        //se não estiver preenchido, passar null no construtor onde o valor é nulo
        //Game game = new Game(dadosSeparados[0], null, null, null)
        Game game = new Game(dadosSeparados[0], dadosSeparados[1],dadosSeparados[2]);
        //criando a variável Booleana onde ela recebe o metodo da interface cadastrar que vai fazer o cadastro do jogo
        Boolean isCadastrado = iGameDAO.cadastrar(game);
        //se foi cadastrado, exibir a mensagem de sucesso
        if(isCadastrado){
            JOptionPane.showMessageDialog(null, "Jogo cadastrado com sucesso ","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Jogo já cadastrado ","Inválido", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void alterar(String dados) {

    }
    

    //metodo representando
   /* private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;

    }
    */

// esse is representa "foi"

    //criando metodo de quando o usuário selecionar a opção cadastro
    private static boolean isOpcaoCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isOpcaoAlterar(String opcao){
        if ("4".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isOpcaoConsultar(String opcao){
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    //criando método da opção valida
    private static boolean isOpcaoValida (String opcao){
        if("1".equals(opcao) || "2".equals(opcao)
        || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }
    //criando o metodo que representa a opção sair
    private static boolean isOpcaoSair(String opcao){
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }
    //criando o método sair literalmente do programa
    private static void sair() {
        JOptionPane.showMessageDialog(null, "Tudo bem, obrigado ","SAIR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


}
