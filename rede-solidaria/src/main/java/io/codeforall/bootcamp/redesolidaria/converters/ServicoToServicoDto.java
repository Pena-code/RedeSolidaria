package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.command.ServicoDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link Servico} to {@link ServicoDto} type conversion
 */
@Component
public class ServicoToServicoDto extends AbstractConverter<Servico, ServicoDto> {

    /**
     * Converts the installer model object into a installer DTO
     *
     * @param servico the installer
     * @return the installer DTO
     */
    @Override
    public ServicoDto convert(Servico servico) {

        ServicoDto servicoDto = new ServicoDto();
        servicoDto.setId(servico.getId());
        servicoDto.setTipoServico(servico.getTipoServico());
        servicoDto.setCertificado(servico.hasCertificado());

        return servicoDto;
    }
}
