package dao;

import dominio.Jogo;

import javax.swing.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JogoMapDAO implements IJogoDAO{
    //CLASSE RESPONSÁVEL POR FAZER TODA A CAPTAÇÃO DO USUÁRIO E GUARDAR NUMA COLLECTION MAP
    private Map<Integer,Jogo>jogosMap = new HashMap<>();
//    public JogoMapDAO(){
//        this.jogosMap=new HashMap<>();
//    }
    @Override
    public Boolean cadastrar(Jogo jogo) {
        if (this.jogosMap.containsKey(jogo.getCodigo())){
            return false;
        }
        this.jogosMap.put(jogo.getCodigo(),jogo);
        return true;
    }

    @Override
    public void alterar(Jogo jogo) {
        Jogo jogoCadastrado = this.jogosMap.get(jogo.getCodigo());
        if (jogoCadastrado!=null){
            jogoCadastrado.setNome(jogo.getNome());
            jogoCadastrado.setCodigo(jogo.getCodigo());
            jogoCadastrado.setPreco(jogo.getPreco());
        }
        JOptionPane.showMessageDialog(null,"Jogo não encontrado no banco de dados.");
    }

    @Override
    public void excluir(Jogo jogo) {
        if (this.jogosMap.containsKey(jogo)){
            jogosMap.remove(jogo);
            JOptionPane.showMessageDialog(null,"Jogo excluído com sucesso.");
        }
        JOptionPane.showMessageDialog(null,"Jogo não encontrado no banco de dados.");
    }

    @Override
    public Jogo consultar(Integer codigo) {
        Jogo jogoCadastrado = this.jogosMap.get(codigo);
        if (jogoCadastrado!=null){
            JOptionPane.showMessageDialog(null,codigo);
        }
        JOptionPane.showMessageDialog(null,"Jogo não encontrado no banco de dados.");
        return jogoCadastrado;
    }

    @Override
    public Collection<Jogo> allGames() {
        return this.jogosMap.values() ;
    }
}
