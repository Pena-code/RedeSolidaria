package io.codeforall.bootcamp.redesolidaria.controller.rest;

import io.codeforall.bootcamp.redesolidaria.command.ServicoDto;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoDtoToServico;
import io.codeforall.bootcamp.redesolidaria.converters.ServicoToServicoDto;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import io.codeforall.bootcamp.redesolidaria.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller responsible for {@link Servico} related CRUD operations
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/servico")
public class RestServicoController {

    private ServicoService servicoService;
    private ServicoDtoToServico servicoDtoToServico;
    private ServicoToServicoDto servicoToServicoDto;

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
     * Sets the converter for converting between customer DTO and customer model objects
     *
     * @param servicoDtoToServico the customer DTO to customer converter to set
     */
    @Autowired
    public void setServicoDtoToServico(ServicoDtoToServico servicoDtoToServico) {
        this.servicoDtoToServico = servicoDtoToServico;
    }

    /**
     * Sets the converter for converting between customer model objects and customer DTO
     *
     * @param servicoToServicoDto the customer to customer DTO converter to set
     */
    @Autowired
    public void setServicoToServicoDto(ServicoToServicoDto servicoToServicoDto) {
        this.servicoToServicoDto = servicoToServicoDto;
    }

    /**
     * Retrieves a representation of the list of customers
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<ServicoDto>> listServicos() {

        List<ServicoDto> servicoDtos = servicoService.list().stream()
                .map(servico -> servicoToServicoDto.convert(servico))
                .collect(Collectors.toList());

        return new ResponseEntity<>(servicoDtos, HttpStatus.OK);
    }

//    /**
//     * Retrieves a representation of the list of customers
//     *
//     * @return the response entity
//     */
//    @RequestMapping(method = RequestMethod.GET, path = {"/name"})
//    public ResponseEntity<List<CustomerDto>> listCustomersName() throws CustomerNotFoundException {
//
//        List<CustomerDto> customerDtos = customerService.listByName("Rui").stream()
//                .map(customer -> customerToCustomerDto.convert(customer))
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
//    }
//
//    /**
//     * Retrieves a representation of the given customer
//     *
//     * @param id the customer id
//     * @return the response entity
//     */
//    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
//    public ResponseEntity<CustomerDto> showCustomer(@PathVariable Integer id) {
//
//        Customer customer = customerService.get(id);
//
//        if (customer == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(customerToCustomerDto.convert(customer), HttpStatus.OK);
//    }
//
//    /**
//     * Adds a customer
//     *
//     * @param customerDto          the customer DTO
//     * @param bindingResult        the binding result object
//     * @param uriComponentsBuilder the uri components builder
//     * @return the response entity
//     */
//    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
//    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
//
//        if (bindingResult.hasErrors() || customerDto.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));
//
//        // get help from the framework building the path for the newly created resource
//        UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedCustomer.getId()).build();
//
//        // set headers with the created path
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriComponents.toUri());
//
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }
//
//    /**
//     * Edits a customer
//     *
//     * @param customerDto   the customer DTO
//     * @param bindingResult the binding result
//     * @param id            the customer id
//     * @return the response entity
//     */
//    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
//    public ResponseEntity<CustomerDto> editCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, @PathVariable Integer id) {
//
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        if (customerDto.getId() != null && !customerDto.getId().equals(id)) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        if (customerService.get(id) == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        customerDto.setId(id);
//
//        customerService.save(customerDtoToCustomer.convert(customerDto));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    /**
//     * Deletes a customer
//     *
//     * @param id the customer id
//     * @return the response entity
//     */
//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Integer id) {
//
//        try {
//
//            customerService.delete(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        } catch (AssociationExistsException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        } catch (CustomerNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
