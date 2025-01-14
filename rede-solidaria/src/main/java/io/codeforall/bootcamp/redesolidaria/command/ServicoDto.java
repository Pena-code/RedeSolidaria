package io.codeforall.bootcamp.redesolidaria.command;

import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;

import javax.validation.constraints.*;

/**
 * The {@link Servico} data transfer object
 */
public class ServicoDto {

    private Integer id;

    @NotNull(message = "Nome is mandatory")
    @NotBlank(message = "Nome is mandatory")
    @Size(min = 3, max = 64)
    private String tipoServico;

    @NotNull(message = "Certificado is mandatory")
    private boolean certificado;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public boolean hasCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "InstaladorForm{" +
                "tipo de serviço='" + tipoServico + '\'' +
                ", certificado='" + certificado +
                "} " + super.toString();
    }
}
