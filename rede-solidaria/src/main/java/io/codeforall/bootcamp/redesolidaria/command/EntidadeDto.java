package io.codeforall.bootcamp.redesolidaria.command;

import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;

import javax.validation.constraints.*;

/**
 * The {@link Entidade} data transfer object
 */
public class EntidadeDto {

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

    @NotNull(message = "Morada is mandatory")
    @NotBlank(message = "Morada is mandatory")
    @Size(min = 3, max = 64)
    private String morada;

    @NotNull(message = "Concelho is mandatory")
    @NotBlank(message = "Concelho is mandatory")
    @Size(min = 3, max = 64)
    private String concelho;

    private String docs;

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

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "EntidadeForm{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", contacto='" + contacto + '\'' +
                ", nif='" + nif + '\'' +
                ", morada='" + morada + '\'' +
                ", concelho='" + concelho + '\'' +
                ", docs=" + docs +
                "} " + super.toString();
    }
}
