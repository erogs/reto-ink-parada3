package pe.eickgs.ikf.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Data
public class ClientOutputDto extends ClientInputDto {

    @JsonProperty("fechaMuerte")
    @ApiModelProperty(required = true, example = "2000-01-01", notes = "Fecha probable de muerte, basado en la esperanza de visa en el Peru")
    private LocalDate deathDate;
}
