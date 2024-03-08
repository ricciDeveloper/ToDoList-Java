package entity;

import java.util.Scanner;

public class TarefasAfazer {
    private String nomeTarefa;
    private String dataEntrega;
    Scanner sc = new Scanner(System.in);
    //getter and setter
    public String getNomeTarefa() {
        return nomeTarefa;
    }
    public void setNomeTarefa() {
        this.nomeTarefa = sc.nextLine();
    }
    public String getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega() {
        this.dataEntrega = sc.nextLine();
        
    }
    
}
