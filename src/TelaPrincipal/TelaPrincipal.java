
package TelaPrincipal;

import funcionario.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaPrincipal {
    
       // guarda
      private static ArrayList<Funcionario>listaFuncionarios = new ArrayList<Funcionario>();   
     
     public static void main(String[] args){
         Menu();
     }// fim do main
     
     private static void Menu(){
         String tela = "1) Cadastrar Funcionário" +
                     "\n2) Listar Funcionários" +
                     "\n3) Pesquisar por código" + 
                     "\n4) EditarFuncionario" +
                     "\n7) Sair";
         
         String opcao = "";
         do{
             
          opcao = JOptionPane.showInputDialog(tela);   
           
          if(opcao.equals("1")){
              cadastrarFuncionario();
          }
          else if(opcao.equals("2")){
             listarFuncionarios();     
          }
          
          else if(opcao.equals("3")){
            pesquisarPorCodigo();      
          }
           else if(opcao.equals("4")){
            editarFuncionario();      
          }
          
         }while(!opcao.equals("7"));
     }
     
     private static void cadastrarFuncionario(){
         
         // entrada de dados
         String nome = JOptionPane.showInputDialog( "Informe o nome: ");
         String cpf =   JOptionPane.showInputDialog( "Informe o CPF: ");
         String celular = JOptionPane.showInputDialog("Informe o celular:");
         
         //criar objeto
         Funcionario funcionario = new Funcionario(nome, cpf, celular);
         
         
         //guardar o obejto em uma lista
         listaFuncionarios.add(funcionario);
     }
     
     private static void listarFuncionarios(){
         String relatorio = "";
         
         //verificar se tem ou não elementos
         if(listaFuncionarios.size() == 0){
             JOptionPane.showMessageDialog(null, "Nenhum funcionário foi cadastrado");
             return;
         }
         
         //listar os funcionarios obtendo da lista (ArrayList)
         for(Funcionario funcionarioAtual : listaFuncionarios){
             relatorio += funcionarioAtual.getCodigo() + "\n" +
                          funcionarioAtual.getNome() + "\n" +
                          funcionarioAtual.getCpf() + "\n" +
                          funcionarioAtual.getCelular() + "\n";  
                    
             
         }
         
         JOptionPane.showMessageDialog(null, relatorio);
     }
     
     
     private static void pesquisarPorCodigo(){
         //verificar se tem ou não elementos
         if(listaFuncionarios.size() == 0){
             JOptionPane.showMessageDialog(null, "Nenhum funcionário foi cadastrado");
             return;
         }
         
         String codigoPesquisar = JOptionPane.showInputDialog("Informe o código: ");
         
         long codigo = Long.parseLong(codigoPesquisar);
         
         
         Funcionario funcionarioProcurado = null;
         
         for(int i = 0; i < listaFuncionarios.size(); i++){
             // procurar em todos os elementos e comparar se código existe
             
             //pega o funcionario atual
             Funcionario f = listaFuncionarios.get(i);
             
             if(codigo == f.getCodigo()){
                 //achei
                 funcionarioProcurado = f;
                 break;
             }
         }// fim do laço
         
         // se objeto funcionarioProcurado existir, ele esta na mao
            String dados = "";
         if(funcionarioProcurado != null){
            
                   dados += funcionarioProcurado.getCodigo() + "\n" +
                            funcionarioProcurado.getNome() + "\n" +
                            funcionarioProcurado.getCpf() + "\n" +
                            funcionarioProcurado.getCelular() + "\n";  
                    
          }
          // joga na tela visual
         JOptionPane.showMessageDialog(null, dados);
     }
     
     private static void editarFuncionario(){
           if(listaFuncionarios.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado");
            return;
        }//Fim do if
        
        //Variaveis para auxilio do médoto editarAluno
        Funcionario funcionarioEditado;
        String nomeFuncionario = JOptionPane.showInputDialog("Informe o nome do funcionario que "
                + "deseja editar");
        
        //Comparar, edita o aluno pesquisado e salva as alterações
        for(int i = 0; i < listaFuncionarios.size(); ++i){
            //Objeto para comparação
            Funcionario funcionario = listaFuncionarios.get(i);
            
            //Comparando e editando aluno
            if(nomeFuncionario.equalsIgnoreCase(funcionario.getNome())){
                //Igualar aluno com alunoEditado
                funcionarioEditado = funcionario;
                
                funcionarioEditado.setNome(JOptionPane.showInputDialog("Informe o nome do funcionario que  deseja editar: " 
                        + funcionario.getNome()));;
                funcionarioEditado.setNome(JOptionPane.showInputDialog("Informe o CPF: " 
                        + funcionario.getCpf()));;
                funcionarioEditado.setNome(JOptionPane.showInputDialog("Informe o celular: " 
                        + funcionario.getCelular()));;        
                //Monstra na tela as alterações
                JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso. \n\n" + funcionarioEditado);
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado.\nTente novamente");
                break;
            }//Fim do if
        }
     }
     
}// fim da classe
