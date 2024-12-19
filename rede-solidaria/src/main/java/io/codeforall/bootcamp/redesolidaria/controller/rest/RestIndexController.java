package io.codeforall.bootcamp.redesolidaria.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller responsible for retrieving the API description
 */
@RestController
@RequestMapping("/api")
public class RestIndexController {

    /**
     * Retrieves the API name and version
     *
     * @return the response
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    @ResponseBody
    protected String showVersion() {

        StringBuilder sb = new StringBuilder();

        sb.append("PRESTADOR DE SERVIÇOS");
        sb.append("\n\n/prestadorsvc ------------------------------------> LISTA TODOS OS PRESTADORES DE SERVIÇO");
        sb.append("\n/prestadorsvc/{id} -------------------------------> LISTA O PRESTADOR DE SERVIÇO POR ID");
        sb.append("\n/prestadorsvc/concelho/{concelho} ----------------> LISTA TODOS OS PRESTADORES DE SERVIÇO POR CONCELHO");
        sb.append("\n/prestadorsvc/{servico_id}/{concelho} ----------------> LISTA TODOS OS PRESTADORES DE SERVIÇO POR SERVIÇO E CONCELHO");
        sb.append("\n\n\nENTIDADE");
        sb.append("\n\n/entidade ----------------------------------------> LISTA TODAS AS ENTIDADES");
        sb.append("\n/entidade/{id} -----------------------------------> LISTA A ENTIDADE POR ID");
        sb.append("\n/entidade/concelho/{concelho} --------------------> LISTA TODAS AS ENTIDADES POR CONCELHO");
        sb.append("\n\n\nSERVIÇOS");
        sb.append("\n\n/servicos ----------------------------------------> LISTA TODOS OS SERVIÇOS");
        sb.append("\n\n\nTICKETS");
        sb.append("\n\n/ticket ------------------------------------------> LISTA TODOS OS TICKETS");
        sb.append("\n/one/{id} ----------------------------------------> LISTA O TICKET COM O ID FORNECIDO");
        sb.append("\n/prestadorsvc/{id} -------------------------------> LISTA TODOS OS TICKETS ATRIBUIDOS AO PRESTADOR DE SERVIÇOS COM O ID FORNECIDO");
        sb.append("\n/entidade/{id} -----------------------------------> LISTA TODOS OS TICKETS ATRIBUIDOS À ENTIDADE COM O ID FORNECIDO");
        sb.append("\n/{estado} ----------------------------------------> LISTA TODOS OS TICKETS COM O ESTADO FORNECIDO (aberto, emprogresso, concluido)");
        sb.append("\n/{estado}/{servico} ---------------------------> LISTA TODOS OS TICKETS COM O ESTADO E TIPO DE SERVIÇO FORNECIDOS (aberto, emprogresso, concluido, todos)");

        return sb.toString();

    }

    private static class ApiVersion {

        private String name;
        private String version;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
