package pe.eickgs.ikf.repositories;

import org.springframework.stereotype.Repository;
import pe.eickgs.ikf.model.client.ClientOutputDto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Repository
public class ClientRepository {

    private final Set<ClientOutputDto> clientsInMemory = new HashSet<>();

    public void save(ClientOutputDto clientOutputDto) {
        clientsInMemory.add(clientOutputDto);
    }

    public Collection<ClientOutputDto> getAll() {
        return clientsInMemory;
    }
}
