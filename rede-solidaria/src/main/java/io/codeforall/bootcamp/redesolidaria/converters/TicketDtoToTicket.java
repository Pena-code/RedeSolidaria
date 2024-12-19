package io.codeforall.bootcamp.redesolidaria.converters;

import io.codeforall.bootcamp.redesolidaria.command.EntidadeDto;
import io.codeforall.bootcamp.redesolidaria.command.TicketDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import io.codeforall.bootcamp.redesolidaria.services.EntidadeService;
import io.codeforall.bootcamp.redesolidaria.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link TicketDto} to {@link Ticket} type conversion
 */
@Component
public class TicketDtoToTicket implements Converter<TicketDto, Ticket> {

    private TicketService ticketService;

    /**
     * Sets the customer service
     *
     * @param ticketService the customer service to set
     */
    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Converts the customer DTO into a customer model object
     *
     * @param ticketDto the entidade DTO
     * @return the customer
     */
    @Override
    public Ticket convert(TicketDto ticketDto) {

        Ticket ticket = (ticketDto.getId() != null ? ticketService.get(ticketDto.getId()) : new Ticket());

        ticket.setTipoTrabalho(ticketDto.getTipoTrabalho());
        ticket.setDataPretendida(ticketDto.getDataPretendida());
        ticket.setDataConclusao(ticketDto.getDataConclusao());
        ticket.setHoras(ticketDto.getHoras());
        ticket.setAberto(ticketDto.isAberto());
        ticket.setEmProgresso(ticketDto.isEmProgresso());
        ticket.setConcluido(ticketDto.isConcluido());

        return ticket;
    }
}
