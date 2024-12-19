package io.codeforall.bootcamp.redesolidaria.controller.rest;

import io.codeforall.bootcamp.redesolidaria.command.PrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.converters.PrestadorSvcDtoToPrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.converters.PrestadorSvcToPrestadorSvcDto;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.services.PrestadorSvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link PrestadorSvc} related CRUD operations
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/prestadorsvc")
public class RestPrestadorSvcController {

    private PrestadorSvcService prestadorSvcService;
    private PrestadorSvcDtoToPrestadorSvc prestadorSvcDtoToPrestadorSvc;
    private PrestadorSvcToPrestadorSvcDto prestadorSvcToPrestadorSvcDto;

    /**
     * Sets the customer service
     *
     * @param prestadorSvcService the prestadorSvc service to set
     */
    @Autowired
    public void setPrestadorSvcService(PrestadorSvcService prestadorSvcService) {
        this.prestadorSvcService = prestadorSvcService;
    }

    /**
     * Sets the converter for converting between customer DTO and customer model objects
     *
     * @param prestadorSvcDtoToPrestadorSvc the prestadorSvc DTO to prestadorSvc converter to set
     */
    @Autowired
    public void setPrestadorSvcDtoToPrestadorSvc(PrestadorSvcDtoToPrestadorSvc prestadorSvcDtoToPrestadorSvc) {
        this.prestadorSvcDtoToPrestadorSvc = prestadorSvcDtoToPrestadorSvc;
    }

    /**
     * Sets the converter for converting between prestadorSvc model objects and prestadorSvc DTO
     *
     * @param prestadorSvcToPrestadorSvcDto the prestadorSvc to prestadorSvc DTO converter to set
     */
    @Autowired
    public void setPrestadorSvcToPrestadorSvcDto(PrestadorSvcToPrestadorSvcDto prestadorSvcToPrestadorSvcDto) {
        this.prestadorSvcToPrestadorSvcDto = prestadorSvcToPrestadorSvcDto;
    }

    /**
     * Retrieves a representation of the list of prestadorSvc
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<PrestadorSvcDto>> listPrestadorSvc() {

        List<PrestadorSvcDto> prestadorSvcDtos = prestadorSvcService.list().stream()
                .map(prestadorSvc -> prestadorSvcToPrestadorSvcDto.convert(prestadorSvc))
                .collect(Collectors.toList());

        return new ResponseEntity<>(prestadorSvcDtos, HttpStatus.OK);
    }

    /**
    * Retrieves a representation of the given customer
    *
    * @param id the prestadorSvc id
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PrestadorSvcDto> showPrestadorSvc(@PathVariable Integer id) {

       PrestadorSvc prestadorSvc = prestadorSvcService.get(id);

        if (prestadorSvc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prestadorSvcToPrestadorSvcDto.convert(prestadorSvc), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/concelho/{concelho}")
    public ResponseEntity<List<PrestadorSvcDto>> showPrestadorSvcByConcelho(@PathVariable String concelho) throws CustomerNotFoundException {

        List<PrestadorSvcDto> prestadorSvcDtos = prestadorSvcService.listByConcelho(concelho).stream()
                .map(prestadorSvc -> prestadorSvcToPrestadorSvcDto.convert(prestadorSvc))
                .collect(Collectors.toList());

        return new ResponseEntity<>(prestadorSvcDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{servico_id}/{concelho}")
    public ResponseEntity<List<PrestadorSvcDto>> showByServicoAndConcelho(@PathVariable int servico_id, @PathVariable String concelho) throws CustomerNotFoundException {

        List<PrestadorSvcDto> prestadorSvcDtos = prestadorSvcService.listByServicoAndConcelho(servico_id, concelho).stream()
                .map(prestadorSvc -> prestadorSvcToPrestadorSvcDto.convert(prestadorSvc))
                .collect(Collectors.toList());

        return new ResponseEntity<>(prestadorSvcDtos, HttpStatus.OK);
    }
}
