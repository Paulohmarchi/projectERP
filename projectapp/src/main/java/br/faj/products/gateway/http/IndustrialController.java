package br.faj.products.gateway.http;

import br.faj.products.domain.Industrial;
import br.faj.products.domain.Product;
import br.faj.products.gateway.IndustrialGateway;
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
@RequestMapping("/v1/api/industrial")
@Api(value = "/v1/api/industrial", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndustrialController {

    private final IndustrialGateway gateway;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public IndustrialController(IndustrialGateway gateway) {
        this.gateway = gateway;
    }

    @ApiOperation(value = "cadastra")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastro ou Atualizacao efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Industrial> cadastrar(@RequestBody @Valid Industrial industrial){
        log.info("{}-{}",industrial, LocalDateTime.now());
        return ResponseEntity.ok(gateway.save(industrial));
    }

    @ApiOperation(value = "listar tudo")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Industrial>> listarTodos(){
        return ResponseEntity.ok(gateway.findAll());
    }

    @ApiOperation(value = "Busca Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Id efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "id")
    public ResponseEntity<Industrial> buscaId(@RequestParam("id") @NotEmpty String id){
        return ResponseEntity.ok(gateway.findById(id));
    }

    @ApiOperation(value = "Busca CNPJ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "cnpj")
    public ResponseEntity<Industrial> buscaCNPJ(@RequestParam("cnpj") @NotEmpty String cnpj){
        return ResponseEntity.ok(gateway.findByCnpj(cnpj));
    }

    @ApiOperation(value = "Busca Nome")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "name")
    public ResponseEntity<Industrial> buscaNome(@RequestParam("name") @NotEmpty String name){
        return ResponseEntity.ok(gateway.findByName(name));
    }

    @ApiOperation(value = "Busca Razao Social")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "socialReason")
    public ResponseEntity<Industrial> buscaRazaoSocial(@RequestParam("socialReason") @NotEmpty String socialReason){
        return ResponseEntity.ok(gateway.findBySocialReason(socialReason));
    }

    @ApiOperation(value = "Busca Telefone")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "telephone")
    public ResponseEntity<Industrial> buscTelefone(@RequestParam("telephone") @NotEmpty String telephone){
        return ResponseEntity.ok(gateway.findByTelephone(telephone));
    }

    @ApiOperation(value = "Busca Celular")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "cellephone")
    public ResponseEntity<Industrial> buscCelular(@RequestParam("cellephone") @NotEmpty String cellephone){
        return ResponseEntity.ok(gateway.findByCellphone(cellephone));
    }

    @ApiOperation(value = "Busca Enedreço")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "address1")
    public ResponseEntity<Industrial> buscEndereco1(@RequestParam("address1") @NotEmpty String address1){
        return ResponseEntity.ok(gateway.findByAddress1(address1));
    }

    @ApiOperation(value = "Busca Enedreço 2")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "address2")
    public ResponseEntity<Industrial> buscEndereco2(@RequestParam("address2") @NotEmpty String address2){
        return ResponseEntity.ok(gateway.findByAddress2(address2));
    }

    @ApiOperation(value = "Busca CEP")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "cep")
    public ResponseEntity<Industrial> buscCEP(@RequestParam("cep") @NotEmpty String cep){
        return ResponseEntity.ok(gateway.findByCep(cep));
    }

    @ApiOperation(value = "Busca Email")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Busca do Nome efetuada com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, path = "email")
    public ResponseEntity<Industrial> buscEmail(@RequestParam("email") @NotEmpty String email){
        return ResponseEntity.ok(gateway.findByEmail(email));
    }


}
