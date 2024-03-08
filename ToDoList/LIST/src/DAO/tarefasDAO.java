package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexao.Conexao;
import entity.TarefasAfazer;

public class tarefasDAO {

    public void inserirTarefa(TarefasAfazer tarefas){
        String sql = "INSERT INTO afazer (NomeTarefa, DataDeEntrega) VALUES (?,?) ";

        PreparedStatement ps = null;

            try{
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, tarefas.getNomeTarefa());
                ps.setString(2, tarefas.getDataEntrega());

            ps.execute();
        //fechar ponteiro
            ps.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            }
    public void imprimirTabelaTarefas(){
        String sql = "SELECT * FROM afazer";

        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){
            System.out.println("-----------------------------------------------------------");
                System.out.println("| ID  |   Nome Tarefa      |   Data de Entrega    |");
                System.out.println("-----------------------------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("idaFazer");
                    String nomeTarefa = rs.getString("NomeTarefa");
                    String dataEntrega = rs.getString("DataDeEntrega");
                    System.out.printf("| %-4d| %-20s | %-20s |\n", id, nomeTarefa, dataEntrega);
                }
                System.out.println("-----------------------------------------------------------");

        } catch (SQLException e) {
        e.printStackTrace();
        }
}
    public void deletarTarefa(int idaFazer){
        String sql = "DELETE FROM afazer WHERE idaFazer = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)){
            ps.setInt(1, idaFazer); //configura o valor do id como paramêtro
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Tarefa deletada com sucesso.");

            }else{
                System.out.println("nenhuma tarefa encontrada com Id especificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
     //solicitar o id ao usuário para fazer o delete
     public void inputIdParaDeletar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa que deseja deletar: ");
        int id = sc.nextInt();//realiza o input ao usuário
        deletarTarefa(id);
    }

    public void alterarTarefas(int id, String novoValor, String campo){
        String sql = "UPDATE afazer SET" + campo + "= ? WHERE id = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)){
            ps.setString(1, novoValor);
            ps.setInt(2, id); //configura o valor do id como paramêtro
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Tarefa alterada com sucesso.");

            }else{
                System.out.println("nenhuma tarefa encontrada com Id especificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inputIdParaAlterar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa que deseja alterar: ");
        int id = sc.nextInt();//realiza o input ao usuário
        sc.nextLine();// Consume a nova linha deixada por nextint
        System.out.println("Digite o novo valor");
        String novoValor = sc.nextLine();
        System.out.println("Digite qual campo deseja alterar: (Nome ou data)");
        String campo = sc.nextLine();
        alterarTarefas(id, novoValor, campo);
        
    }
}
