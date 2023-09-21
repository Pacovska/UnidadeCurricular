package engtelecom.poo;

import java.util.ArrayList;

public class UnidadeCurricular {
    // Atributos.
    private String nome;
    private String codigo;
    private String sigla;
    private Integer creditos;
    private String ementa;
    private ArrayList<String> objetivos;
    private ArrayList<String> conteudo;

    // Construtores.
    public UnidadeCurricular() {
        this.nome     = "xxx";
        this.codigo   = "xxx000000";
        this.sigla    = "xxx";
        this.creditos = 0;
        this.ementa   = "xxx";
        this.objetivos = new ArrayList<>();
        this.conteudo = new ArrayList<>();
    }
    public UnidadeCurricular(String nome, String codigo){
        this(nome, codigo, "xxx", 0, "xxx");
    }

    public UnidadeCurricular(String nome, String codigo, String sigla){
        this(nome, codigo, sigla, 0, "xxx");
    }

    public UnidadeCurricular(String nome, String codigo, String sigla, Integer creditos){
        this(nome, codigo, sigla, creditos, "xxx");
    }

    public UnidadeCurricular(String nome, String codigo, String sigla, Integer creditos, Integer semanas){
        this(nome, codigo, sigla, creditos, "xxx");
    }

    public UnidadeCurricular(String nome, String codigo, String sigla, Integer creditos, String ementa) {
        this();
        setNome(nome);
        setCodigo(codigo);
        setSigla(sigla);
        setCreditos(creditos);
        setEmenta(ementa);
    }

    //Getter e setter.
    public Integer getCargaHoraria() { return this.creditos *  Curso.SEMANAS; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("UnidadeCurricular:");

        sb.append('\n').append("nome = ").append(nome).append('\n');
        sb.append(", codigo = ").append(codigo).append('\n');
        sb.append(", sigla = ").append(sigla).append('\n');
        sb.append(", creditos = ").append(creditos).append("\n");
        sb.append(", ementa = ").append(ementa).append('\n');
        sb.append(", Carga Horaria = ").append(getCargaHoraria()).append("\n");
        sb.append(", [ objetivos = ");
        for(var o: objetivos) sb.append(o).append(',');
        sb.append(']').append('\n');
        sb.append(", [ conteudo = ");
        for(var c: conteudo) sb.append(c).append(',');
        sb.append(']').append('\n');

        return sb.toString();
    }

    public ArrayList<String> getObjetivos() {
        return objetivos;
    }

    public void adicionarObjetivo(String stringObjetivo) {
        this.objetivos.add(stringObjetivo);
    }

    public void removeObjetivo(int pos){
        this.objetivos.remove(pos);
    }

    public ArrayList<String> getConteudo() {
        return conteudo;
    }

    public void adicionarConteudo(String stringConteudo) {
        this.conteudo.add(stringConteudo);
    }

    public void removeConteudo(int pos){
        this.conteudo.remove(pos);
    }
}
