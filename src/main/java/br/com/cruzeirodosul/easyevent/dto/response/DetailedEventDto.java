package br.com.cruzeirodosul.easyevent.dto.response;

import br.com.cruzeirodosul.easyevent.dto.common.AddressDTO;
import br.com.cruzeirodosul.easyevent.enumerated.EventStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link br.com.cruzeirodosul.easyevent.entity.Event}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedEventDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2213428599009092336L;

    private Long eventId;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventStatus status;
    private AddressDTO address;
    private MinimalUserDTO user;

}