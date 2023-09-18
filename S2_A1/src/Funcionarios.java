public class Funcionarios {

    public Funcionarios(String nome, String departamento, double salario, String dataEntrada, String RG) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
        this.dataEntrada = dataEntrada;
        this.RG = RG;
    }

    private String nome;
    private String departamento;
    private double salario;
    private String dataEntrada;
    private String RG;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void recebeAumento(double novoSalario){
        setSalario(novoSalario);
    }

    public double ganhoAnual(){
        return getSalario() * 12;
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "nome='" + nome + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                ", dataEntrada='" + dataEntrada + '\'' +
                ", RG='" + RG + '\'' +
                '}';
    }
}
