package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link PrestadorSvc} to {@link PrestadorSvcDto} type conversion
 */
@Component
public class PrestadorSvcToPrestadorSvcDto extends AbstractConverter<PrestadorSvc, PrestadorSvcDto> {

    /**
     * Converts the installer model object into a installer DTO
     *
     * @param prestadorSvc the installer
     * @return the installer DTO
     */
    @Override
    public PrestadorSvcDto convert(PrestadorSvc prestadorSvc) {

        PrestadorSvcDto prestadorSvcDto = new PrestadorSvcDto();
        prestadorSvcDto.setId(prestadorSvc.getId());
        prestadorSvcDto.setNome(prestadorSvc.getNome());
        prestadorSvcDto.setEmail(prestadorSvc.getEmail());
        prestadorSvcDto.setContacto(prestadorSvc.getContacto());
        prestadorSvcDto.setNif(prestadorSvc.getNif());
        prestadorSvcDto.setConcelho(prestadorSvc.getConcelho());
        prestadorSvcDto.setAtivo(prestadorSvc.isAtivo());
        prestadorSvcDto.setDocs(prestadorSvc.getDocs());
        prestadorSvcDto.setServico(prestadorSvc.getServico().getTipoServico());

        return prestadorSvcDto;
    }
}
