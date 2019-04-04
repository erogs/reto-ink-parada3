package pe.eickgs.ikf.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pe.eickgs.ikf.model.client.ClientInputDto;
import pe.eickgs.ikf.model.client.ClientOutputDto;
import pe.eickgs.ikf.model.client.KpiDto;
import pe.eickgs.ikf.services.ClientService;
import pe.eickgs.ikf.validator.ClientValidator;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@RestController
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @InitBinder("clientInputDto")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new ClientValidator());
    }

    @PostMapping("creacliente")
    @ApiOperation(value = "Crea un nuevo cliente",
            notes = "Almacena un nuevo cliente en la base de datos, agregandole la fecha probable de su muerte (basado " +
                    "en la esperanza de vida que hay en el Peru)")
    public ResponseEntity<Void> createClient(@Valid @RequestBody ClientInputDto clientInputDto) {
        clientService.saveClient(clientInputDto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("kpideclientes")
    @ApiOperation(value = "KPI de clientes",
            notes = "Obtiene los KPI del registro de clientes: Promedio y la desviacion estandar")
    public ResponseEntity<KpiDto> kpiClients() {
        return ResponseEntity.ok(clientService.getKpi());
    }

    @GetMapping("listclientes")
    @ApiOperation(value = "Listado de clientes",
            notes = "Lista el registro de todos los clientes del sistema")
    public ResponseEntity<Collection<ClientOutputDto>> clientList() {
        return ResponseEntity.ok(clientService.getAll());
    }
}


