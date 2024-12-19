package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.command.ServicoDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import io.codeforall.bootcamp.redesolidaria.services.PrestadorSvcService;
import io.codeforall.bootcamp.redesolidaria.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link ServicoDto} to {@link Servico} type conversion
 */
@Component
public class ServicoDtoToServico implements Converter<ServicoDto, Servico> {

    private ServicoService servicoService;

    /**
     * Sets the customer service
     *
     * @param servicoService the customer service to set
     */
    @Autowired
    public void setServicoService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    /**
     * Converts the customer DTO into a customer model object
     *
     * @param servicoDto the customer DTO
     * @return the customer
     */
    @Override
    public Servico convert(ServicoDto servicoDto) {

        Servico servico = (servicoDto.getId() != null ? servicoService.get(servicoDto.getId()) : new Servico());

        servico.setTipoServico(servicoDto.getTipoServico());
        servico.setCertificado(servicoDto.hasCertificado());

        return servico;
    }
}
