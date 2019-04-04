package pe.eickgs.ikf.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.eickgs.ikf.model.client.ClientInputDto;
import pe.eickgs.ikf.model.client.ClientOutputDto;
import pe.eickgs.ikf.model.client.KpiDto;
import pe.eickgs.ikf.utils.Maths;
import pe.eickgs.ikf.repositories.ClientRepository;
import pe.eickgs.ikf.utils.Dates;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Service
public class ClientService {

    @Value("${parameter.life-expectancy}")
    private double lifeExpectancy;

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(ClientInputDto clientInputDto) {
        ClientOutputDto dto = new ClientOutputDto();
        BeanUtils.copyProperties(clientInputDto, dto);
        dto.setDeathDate(Dates.add(clientInputDto.getBirthdate(), lifeExpectancy));
        clientRepository.save(dto);
    }

    public KpiDto getKpi() {
        KpiDto dto = new KpiDto();
        List<Integer> ages = clientRepository.getAll().stream().map(ClientInputDto::getAge).collect(Collectors.toList());
        dto.setAverage(Maths.average(ages));
        dto.setDesviationStd(Maths.deviationStd(ages));
        return dto;
    }

    public Collection<ClientOutputDto> getAll() {
        return clientRepository.getAll();
    }
}
