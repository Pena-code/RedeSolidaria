package io.codeforall.bootcamp.redesolidaria.command;

import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;

import javax.validation.constraints.*;

/**
 * The {@link PrestadorSvc} data transfer object
 */
public class PrestadorSvcDto {

    private Integer id;

    @NotNull(message = "Nome is mandatory")
    @NotBlank(message = "Nome is mandatory")
    @Size(min = 3, max = 64)
    private String nome;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private int contacto;

    @NotNull(message = "NIF is mandatory")
    @Positive(message = "NIF must be a positive number")
    @Min(value = 100000000, message = "NIF must be at least 8 digits long")
    @Max(value = 999999999, message = "NIF must be at most 9 digits long")
    private int nif;

    @NotNull(message = "Concelho is mandatory")
    @NotBlank(message = "Concelho is mandatory")
    @Size(min = 3, max = 64)
    private String concelho;

    @NotNull(message = "Ativo is mandatory")
    private boolean ativo;

    private String docs;

    private String servico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
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
        return "PrestadorSvcForm{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", contacto='" + contacto + '\'' +
                ", nif='" + nif + '\'' +
                ", concelho='" + concelho + '\'' +
                ", ativo=" + ativo +
                ", docs=" + docs +
                "} " + super.toString();
    }
}
