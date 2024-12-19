package io.codeforall.bootcamp.redesolidaria.command;

import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * The {@link Ticket} data transfer object
 */
public class TicketDto {

    private Integer id;

    @NotNull(message = "Tipo trabalho is mandatory")
    @NotBlank(message = "Tipo trabalho is mandatory")
    @Size(min = 3, max = 64)
    private String tipoTrabalho;

    @NotNull(message = "Data pretendida is mandatory")
    @NotBlank(message = "Data pretendida is mandatory")
    private Date dataPretendida;

    @NotNull(message = "Data conclusao is mandatory")
    @NotBlank(message = "Data conclusao is mandatory")
    private Date dataConclusao;

    private int horas;

    private boolean aberto;

    private boolean emProgresso;

    private boolean concluido;

    private String entidade;

    private String prestadorSvc;

    private String servico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public Date getDataPretendida() {
        return dataPretendida;
    }

    public void setDataPretendida(Date dataPretendida) {
        this.dataPretendida = dataPretendida;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean isEmProgresso() {
        return emProgresso;
    }

    public void setEmProgresso(boolean emProgresso) {
        this.emProgresso = emProgresso;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getPrestadorSvc() {
        return prestadorSvc;
    }

    public void setPrestadorSvc(String prestadorSvc) {
        this.prestadorSvc = prestadorSvc;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "TicketForm{" +
                "id=" + id +
                ", tipoTrabalho='" + tipoTrabalho + '\'' +
                ", dataPretendida=" + dataPretendida +
                ", dataConclusao=" + dataConclusao +
                ", horas=" + horas +
                ", aberto=" + aberto +
                ", emProgresso=" + emProgresso +
                ", concluido=" + concluido +
                "} " + super.toString();
    }
}
