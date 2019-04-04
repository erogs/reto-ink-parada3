package pe.eickgs.ikf.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Data
public class KpiDto implements Serializable {

    @JsonProperty("promedioEdades")
    private double average;

    @JsonProperty("desviacionEstandar")
    private double desviationStd;
}
