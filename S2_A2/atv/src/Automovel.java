public class Automovel {
    private String prop;
    private String h_entrada;
    private String h_saida;
    private String valor;

    public Automovel(String prop, String h_entrada, String h_saida, String valor) {
        this.prop = prop;
        this.h_entrada = h_entrada;
        this.h_saida = h_saida;
        this.valor = valor;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getH_entrada() {
        return h_entrada;
    }

    public void setH_entrada(String h_entrada) {
        this.h_entrada = h_entrada;
    }

    public String getH_saida() {
        return h_saida;
    }

    public void setH_saida(String h_saida) {
        this.h_saida = h_saida;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Automovel{" +
                "prop='" + prop + '\'' +
                ", h_entrada='" + h_entrada + '\'' +
                ", h_saida='" + h_saida + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
