package br.com.cruzeirodosul.easyevent.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6706814810942302488L;

    @NotBlank
    @Size(min = 3, max = 150)
    private String title;

    @NotBlank
    @Size(min = 3, max = 250)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startDate;

    @NotNull
    @Future
    private LocalDateTime endDate;

}
