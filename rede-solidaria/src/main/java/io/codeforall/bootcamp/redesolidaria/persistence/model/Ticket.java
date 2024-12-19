package io.codeforall.bootcamp.redesolidaria.persistence.model;

import io.codeforall.bootcamp.redesolidaria.persistence.model.account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name = "ticket")
public class Ticket extends AbstractModel {

    private String tipoTrabalho;
    private Date dataPretendida;
    private Date dataConclusao;
    private int horas;
    private boolean aberto;
    private boolean emProgresso;
    private boolean concluido;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Entidade entidade;

    @ManyToOne
    private PrestadorSvc prestadorsvc;

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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public PrestadorSvc getPrestadorSvc() {
        return prestadorsvc;
    }

    public void setPrestadorSvc(PrestadorSvc prestadorSvc) {
        this.prestadorsvc = prestadorSvc;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "Ticket{" +
                "tipoTrabalho='" + tipoTrabalho + '\'' +
                ", dataPretendida=" + dataPretendida +
                ", dataConclusao=" + dataConclusao +
                ", horas=" + horas +
                ", aberto=" + aberto +
                ", emProgresso=" + emProgresso +
                ", concluido=" + concluido +
                ", entidade=" + entidade +
                ", prestadorSvc=" + prestadorsvc +
                ", servico=" + servico +
                "} " + super.toString();
    }


}



