
package funcionario;

public class Funcionario {
    
    //atributos
    private long codigo;
    private String nome;
    private String cpf;
    private String celular;
    private static long contadorCodigo = 0;
    
    //construtor default
    public Funcionario(){
        contadorCodigo++;
        
        codigo = contadorCodigo;
    }
    public Funcionario(String nome, String cpf, String celular){
      
        contadorCodigo++;
        
        codigo = contadorCodigo;
        
        //construtor com argumentos
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
    
    
    public long getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
}
     public void setCpf(String cpf){
         this.cpf = cpf;
     }
     public String getCelular(){
         return celular;
     }
     public void setCelular(String celular){
         this.nome = celular;
     }
}