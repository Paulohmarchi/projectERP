package br.faj.products.gateway.http;

import br.faj.products.domain.Feature;
import br.faj.products.gateway.FeatureGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/api/feature")
@Api(value = "/v1/api/feature", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FeatureController {


    private final FeatureGateway gateway;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public FeatureController(FeatureGateway gateway) {
        this.gateway = gateway;
    }

    @ApiOperation(value = "cadastra")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastro ou Atualizacao efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Feature> cadastrar(@RequestBody @Valid Feature feature){
        log.info("{}-{}",feature, LocalDateTime.now());
        return ResponseEntity.ok(gateway.save(feature));
    }

    @ApiOperation(value = "listar tudo")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Feature>> listarTodos(){
        return ResponseEntity.ok(gateway.findAll());
    }

    @ApiOperation(value = "Busca Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Id efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "id")
    public ResponseEntity<Feature> buscaId(@RequestParam("id") @NotEmpty String id){
        return ResponseEntity.ok(gateway.getById(id));
    }

    @ApiOperation(value = "Busca Valores")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca dos Valores efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "value")
    public ResponseEntity<Feature> buscarValue(@RequestParam("value") @NotEmpty String value){
        return ResponseEntity.ok(gateway.findByValue(value));
    }

    @ApiOperation(value = "Busca Caracteristicas")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca dos Valores efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "type")
    public ResponseEntity<Feature> buscarType(@RequestParam("type") @NotEmpty String type){
        return ResponseEntity.ok(gateway.findByType(type));
    }
}
