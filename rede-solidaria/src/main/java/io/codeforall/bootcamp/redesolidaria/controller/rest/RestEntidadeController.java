package io.codeforall.bootcamp.redesolidaria.controller.rest;

import io.codeforall.bootcamp.redesolidaria.command.EntidadeDto;
import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.command.ServicoDto;
import io.codeforall.bootcamp.redesolidaria.converters.EntidadeDtoToEntidade;
import io.codeforall.bootcamp.redesolidaria.converters.EntidadeToEntidadeDto;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoDtoToServico;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoToServicoDto;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import io.codeforall.bootcamp.redesolidaria.services.EntidadeService;
import io.codeforall.bootcamp.redesolidaria.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link Entidade} related CRUD operations
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/entidade")
public class RestEntidadeController {

    private EntidadeService entidadeService;
    private EntidadeDtoToEntidade entidadeDtoToEntidade;
    private EntidadeToEntidadeDto entidadeToEntidadeDto;

    /**
     * Sets the entidade service
     *
     * @param entidadeService the entidade service to set
     */
    @Autowired
    public void setEntidadeService(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    /**
     * Sets the converter for converting between entidde DTO and entidade model objects
     *
     * @param entidadeDtoToEntidade the entidade DTO to entidade converter to set
     */
    @Autowired
    public void setEntidadeDtoToEntidade(EntidadeDtoToEntidade entidadeDtoToEntidade) {
        this.entidadeDtoToEntidade = entidadeDtoToEntidade;
    }

    /**
     * Sets the converter for converting between customer model objects and customer DTO
     *
     * @param entidadeToEntidadeDto the customer to customer DTO converter to set
     */
    @Autowired
    public void setEntidadeToEntidadeDto(EntidadeToEntidadeDto entidadeToEntidadeDto) {
        this.entidadeToEntidadeDto = entidadeToEntidadeDto;
    }

    /**
     * Retrieves a representation of the list of customers
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<EntidadeDto>> listEntidades() {

        List<EntidadeDto> entidadeDtos = entidadeService.list().stream()
                .map(entidade -> entidadeToEntidadeDto.convert(entidade))
                .collect(Collectors.toList());

        return new ResponseEntity<>(entidadeDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<EntidadeDto> showEntidade(@PathVariable Integer id) {

        Entidade entidade = entidadeService.get(id);

        if (entidade == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(entidadeToEntidadeDto.convert(entidade), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/concelho/{concelho}")
    public ResponseEntity<List<EntidadeDto>> showEntidadeByConcelho(@PathVariable String concelho) throws CustomerNotFoundException {

        List<EntidadeDto> entidadeDtos = entidadeService.listByConcelho(concelho).stream()
                .map(entidade -> entidadeToEntidadeDto.convert(entidade))
                .collect(Collectors.toList());

        return new ResponseEntity<>(entidadeDtos, HttpStatus.OK);
    }
}
