package pe.eickgs.ikf.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Data
public class ClientInputDto implements Serializable {

    @NotNull
    @JsonProperty("nombre")
    @ApiModelProperty(required = true, example = "Erick", notes = "Nombre del cliente")
    private String firstName;

    @NotNull
    @JsonProperty("apellido")
    @ApiModelProperty(required = true, example = "Gonzales", notes = "Apellido del cliente")
    private String lastName;

    @NotNull
    @JsonProperty("edad")
    @ApiModelProperty(required = true, example = "32", notes = "Edad del cliente")
    private int age;

    @NotNull
    @JsonProperty("fechaNacimiento")
    @ApiModelProperty(required = true, example = "1986-04-21", notes = "Fecha de nacimiento del cliente")
    private LocalDate birthdate;
}
