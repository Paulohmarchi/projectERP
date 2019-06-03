package br.faj.products.gateway.http;

import br.faj.products.domain.Feature;
import br.faj.products.domain.Product;
import br.faj.products.gateway.ProductGateway;
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
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
@Api(value = "/v1/api/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

    private final ProductGateway gateway;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public ProductController(ProductGateway gateway) {
        this.gateway = gateway;
    }

    @ApiOperation(value = "cadastra")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastro ou Atualizacao efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> cadastrar(@RequestBody @Valid Product product){
        log.info("{}-{}",product, LocalDateTime.now());
        return ResponseEntity.ok(gateway.save(product));
    }

    @ApiOperation(value = "listar tudo")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listarTodos(){
        return ResponseEntity.ok(gateway.findAll());
    }


    @ApiOperation(value = "Busca Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Id efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "id")
    public ResponseEntity<Product> buscaId(@RequestParam("id") @NotEmpty String id){
        return ResponseEntity.ok(gateway.findById(id));
    }

    @ApiOperation(value = "Busca Nome")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "name")
    public ResponseEntity<Product> buscaNome(@RequestParam("name") @NotEmpty String name){
        return ResponseEntity.ok(gateway.findByName(name));
    }

    @ApiOperation(value = "Busca Codigo de Barra")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Codigo de Barra efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "barcode")
    public ResponseEntity<Product> buscaCodigoBarra(@RequestParam("barcode") @NotEmpty String barcode){
        return ResponseEntity.ok(gateway.findByBarcode(barcode));
    }

    @ApiOperation(value = "Busca Preço")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Poreço efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "price")
    public ResponseEntity<Product> buscaPreco(@RequestParam("price") @NotEmpty Double price){
        return ResponseEntity.ok(gateway.findByPrice(price));
    }



}
