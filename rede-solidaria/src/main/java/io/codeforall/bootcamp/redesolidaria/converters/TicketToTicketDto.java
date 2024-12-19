package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.EntidadeDto;
import io.codeforall.bootcamp.redesolidaria.command.TicketDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link Ticket} to {@link TicketDto} type conversion
 */
@Component
public class TicketToTicketDto extends AbstractConverter<Ticket, TicketDto> {

    /**
     * Converts the installer model object into a installer DTO
     *
     * @param ticket the entity
     * @return the installer DTO
     */
    @Override
    public TicketDto convert(Ticket ticket) {

        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setTipoTrabalho(ticket.getTipoTrabalho());
        ticketDto.setDataPretendida(ticket.getDataPretendida());
        ticketDto.setDataConclusao(ticket.getDataConclusao());
        ticketDto.setAberto(ticket.isAberto());
        ticketDto.setEmProgresso(ticket.isEmProgresso());
        ticketDto.setConcluido(ticket.isConcluido());
        ticketDto.setEntidade(ticket.getEntidade().getNome());
        ticketDto.setPrestadorSvc(ticket.getPrestadorSvc().getNome());
        ticketDto.setServico(ticket.getServico().getTipoServico());

        return ticketDto;
    }
}
