package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.EntidadeDto;
import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.services.EntidadeService;
import io.codeforall.bootcamp.redesolidaria.services.PrestadorSvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link EntidadeDto} to {@link Entidade} type conversion
 */
@Component
public class EntidadeDtoToEntidade implements Converter<EntidadeDto, Entidade> {

    private EntidadeService entidadeService;

    /**
     * Sets the customer service
     *
     * @param entidadeService the customer service to set
     */
    @Autowired
    public void setEntidadeService(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    /**
     * Converts the customer DTO into a customer model object
     *
     * @param entidadeDto the entidade DTO
     * @return the customer
     */
    @Override
    public Entidade convert(EntidadeDto entidadeDto) {

        Entidade entidade = (entidadeDto.getId() != null ? entidadeService.get(entidadeDto.getId()) : new Entidade());

        entidade.setNome(entidadeDto.getNome());
        entidade.setMorada(entidadeDto.getMorada());
        entidade.setEmail(entidadeDto.getEmail());
        entidade.setContacto(entidadeDto.getContacto());
        entidade.setConcelho(entidadeDto.getConcelho());
        entidade.setNif(entidadeDto.getNif());
        entidade.setDocs(entidadeDto.getDocs());

        return entidade;
    }
}
