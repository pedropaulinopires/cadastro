package pedro.com.br.cadastro.teste;

import java.util.List;

import pedro.com.br.cadastro.bean.Pessoa;
import pedro.com.br.cadastro.dao.PessoaDAO;

public class Teste {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Allan");
        List<Pessoa> l = PessoaDAO.findAll();
        for(int i = 0 ; i < l.size(); i++){
            int id = l.get(i).getId();
            String nome =l.get(i).getNome();
            System.out.println("Pessoa: ID="+id+"//Nome="+nome+".");
            System.out.println();
        }
    }
}

