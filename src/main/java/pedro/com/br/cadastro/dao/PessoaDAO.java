package pedro.com.br.cadastro.dao;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import pedro.com.br.cadastro.bean.Pessoa;
import pedro.com.br.cadastro.connection.ConnectionFactory;

public class PessoaDAO {
    //inserir pessoa
    public static Pessoa persist(Pessoa p){
        //Criar a conexão
        EntityManager em = ConnectionFactory.getConnection();
        //fazer as transações
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            //caso êxito, printar ação na tela e dar um commit
            System.out.println("Pessoa adicionada com sucesso!");    
        } catch (Exception e) {
            //exibir o erro e desfazer a ação
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir Pessoa ==>> "+e.getMessage() );
        } finally{
            //fechar a conexão
            em.close();
        }
        //retornar o objeto
        return p;
    }
    //remover pessoa
    public static void remove (Integer id){
        //Criar a conexão
        Pessoa p = null;
        EntityManager em = ConnectionFactory.getConnection();
        //fazer as transações
        try {
            em.getTransaction().begin();
            p = em.find(Pessoa.class, id);
            em.remove(p);
            em.getTransaction().commit();
            //caso êxito, printar ação na tela e dar um remove
            System.out.println("Pessoa removida com sucesso!");    
        } catch (Exception e) {
            //exibir o erro e desfazer a ação
            em.getTransaction().rollback();
            System.out.println("Erro ao remover Pessoa ==>> "+e.getMessage() );
        } finally{
            //fechar a conexão
            em.close();
        }
        //retornar o objeto
    }
    //atualizar pessoa
    public static Pessoa merge(Pessoa p){
        //Criar a conexão
        EntityManager em = ConnectionFactory.getConnection();
        //fazer as transações
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            //caso êxito, printar ação na tela e dar um merge
            System.out.println("Pessoa atualizada com sucesso!");    
        } catch (Exception e) {
            //exibir o erro e desfazer a ação
            em.getTransaction().rollback();
            System.out.println("Erro ao atualizar Pessoa ==>> "+e.getMessage() );
        } finally{
            //fechar a conexão
            em.close();
        }
        //retornar o objeto
        return p;
    }
    //listar por id;
    public static Pessoa findByid(Integer id){
        //Criar a conexão
        Pessoa p = null;
        EntityManager em = ConnectionFactory.getConnection();
        //fazer as transações
        try {
            p = em.find(Pessoa.class, id);
            //caso êxito, printar ação na tela e dar um find
            System.out.println("Pessoa buscada com sucesso!");    
        } catch (Exception e) {
            //exibir o erro e desfazer a ação
            System.out.println("Erro ao buscar Pessoa ==>> "+e.getMessage() );
        } finally{
            //fechar a conexão
            em.close();
        }
        //retornar o objeto
        return p;
    }
    
    public static List<Pessoa> findAll(){
        //criar o objeto lista
        List<Pessoa> l = new ArrayList<>();
        //criar o objeto de conexão
        EntityManager em = ConnectionFactory.getConnection();
        try {
            //armazenar pessoas nas listas
            l = em.createQuery("from Pessoa ").getResultList();
        } catch (Exception e) {
            //exibir o erro!
            System.out.println(e.getMessage());
        } finally{
            //fechar a conexão
            em.close();
        }
        return l;
    }
}
