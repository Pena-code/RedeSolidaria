package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.EntidadeDto;
import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link Entidade} to {@link EntidadeDto} type conversion
 */
@Component
public class EntidadeToEntidadeDto extends AbstractConverter<Entidade, EntidadeDto> {

    /**
     * Converts the installer model object into a installer DTO
     *
     * @param entidade the entity
     * @return the installer DTO
     */
    @Override
    public EntidadeDto convert(Entidade entidade) {

        EntidadeDto entidadeDto = new EntidadeDto();
        entidadeDto.setId(entidade.getId());
        entidadeDto.setNome(entidade.getNome());
        entidadeDto.setEmail(entidade.getEmail());
        entidadeDto.setContacto(entidade.getContacto());
        entidadeDto.setNif(entidade.getNif());
        entidadeDto.setConcelho(entidade.getConcelho());
        entidadeDto.setMorada(entidade.getMorada());
        entidadeDto.setDocs(entidade.getDocs());


        return entidadeDto;
    }
}
