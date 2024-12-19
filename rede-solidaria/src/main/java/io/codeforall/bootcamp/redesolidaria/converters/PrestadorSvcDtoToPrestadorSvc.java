package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import io.codeforall.bootcamp.redesolidaria.services.PrestadorSvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link PrestadorSvcDto} to {@link PrestadorSvc} type conversion
 */
@Component
public class PrestadorSvcDtoToPrestadorSvc implements Converter<PrestadorSvcDto, PrestadorSvc> {

    private PrestadorSvcService prestadorSvcService;

    /**
     * Sets the customer service
     *
     * @param prestadorSvcService the customer service to set
     */
    @Autowired
    public void setPrestadorSvcService(PrestadorSvcService prestadorSvcService) {
        this.prestadorSvcService = prestadorSvcService;
    }

    /**
     * Converts the customer DTO into a customer model object
     *
     * @param prestadorSvcDto the customer DTO
     * @return the customer
     */
    @Override
    public PrestadorSvc convert(PrestadorSvcDto prestadorSvcDto) {

        PrestadorSvc prestadorSvc = (prestadorSvcDto.getId() != null ? prestadorSvcService.get(prestadorSvcDto.getId()) : new PrestadorSvc());

        prestadorSvc.setNome(prestadorSvcDto.getNome());
        prestadorSvc.setEmail(prestadorSvcDto.getEmail());
        prestadorSvc.setContacto(prestadorSvcDto.getContacto());
        prestadorSvc.setNif(prestadorSvcDto.getNif());
        prestadorSvc.setConcelho(prestadorSvcDto.getConcelho());
        prestadorSvc.setAtivo(prestadorSvcDto.isAtivo());
        prestadorSvc.setDocs(prestadorSvcDto.getDocs());

        return prestadorSvc;
    }
}
