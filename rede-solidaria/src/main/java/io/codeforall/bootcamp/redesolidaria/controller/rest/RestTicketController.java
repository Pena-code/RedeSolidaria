package io.codeforall.bootcamp.redesolidaria.controller.rest;

import io.codeforall.bootcamp.redesolidaria.command.*;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoDtoToServico;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoToServicoDto;
import io.codeforall.bootcamp.redesolidaria.converters.TicketDtoToTicket;
import io.codeforall.bootcamp.redesolidaria.converters.TicketToTicketDto;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Customer;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import io.codeforall.bootcamp.redesolidaria.services.ServicoService;
import io.codeforall.bootcamp.redesolidaria.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link Ticket} related CRUD operations
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class RestTicketController {

    private TicketService ticketService;
    private TicketDtoToTicket ticketDtoToTicket;
    private TicketToTicketDto ticketToTicketDto;

    /**
     * Sets the customer service
     *
     * @param ticketService the ticket service to set
     */
    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Sets the converter for converting between customer DTO and customer model objects
     *
     * @param ticketDtoToTicket the customer DTO to customer converter to set
     */
    @Autowired
    public void setTicketDtoToTicket(TicketDtoToTicket ticketDtoToTicket) {
        this.ticketDtoToTicket = ticketDtoToTicket;
    }

    /**
     * Sets the converter for converting between customer model objects and customer DTO
     *
     * @param ticketToTicketDto the ticket to ticket DTO converter to set
     */
    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }

    /**
     * Retrieves a representation of the list of customers
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<TicketDto>> listTickets() {

        List<TicketDto> ticketDtos = ticketService.list().stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/one/{id}")
    public ResponseEntity<TicketDto> showTicket(@PathVariable Integer id) {

        Ticket ticket = ticketService.get(id);

        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ticketToTicketDto.convert(ticket), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/prestadorsvc/{id}")
    public ResponseEntity<List<TicketDto>> showTicketsByPrestadorSvc(@PathVariable Integer id) throws CustomerNotFoundException {

        List<TicketDto> ticketDtos = ticketService.listByPrestadorSvc(id).stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/entidade/{id}")
    public ResponseEntity<List<TicketDto>> showTicketsByEntidade(@PathVariable Integer id) throws CustomerNotFoundException {

        List<TicketDto> ticketDtos = ticketService.listByEntidade(id).stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{estado}")
    public ResponseEntity<List<TicketDto>> showTicketsByEntidade(@PathVariable String estado) throws CustomerNotFoundException {

        List<TicketDto> ticketDtos = ticketService.listByEstado(estado).stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{estado}/{servico_id}")
    public ResponseEntity<List<TicketDto>> showTicketsByEstadoAndServico(@PathVariable String estado, @PathVariable Integer servico_id) throws CustomerNotFoundException {

        List<TicketDto> ticketDtos = ticketService.listByEstadoAndServicoId(estado, servico_id).stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{estado}/{servico_id}/{concelho}")
    public ResponseEntity<List<TicketDto>> showTicketsByEstadoAndServicoAndConcelho(@PathVariable String estado, @PathVariable Integer servico_id, @PathVariable String concelho) throws CustomerNotFoundException {

        List<TicketDto> ticketDtos = ticketService.listByEstadoAndServicoIdAndConcelho(estado, servico_id, concelho).stream()
                .map(ticket -> ticketToTicketDto.convert(ticket))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }
}
