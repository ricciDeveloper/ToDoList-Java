import DAO.tarefasDAO;
import entity.TarefasAfazer;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("ola");
        TarefasAfazer tf = new TarefasAfazer();
        System.out.println("Digite a tarefa a inserir na lista");
        tf.setNomeTarefa();
        System.out.println("Data de conclusão da tarefa:  (exemplo: 2020-02-20)");
        tf.setDataEntrega();

        new tarefasDAO().inserirTarefa(tf);

         
         System.out.println("Segue todas as tarefas da lista: \n\n");
         new tarefasDAO().imprimirTabelaTarefas();
         new tarefasDAO().inputIdParaDeletar();
         new tarefasDAO().imprimirTabelaTarefas();
         new tarefasDAO().inputIdParaAlterar();
    }
}
