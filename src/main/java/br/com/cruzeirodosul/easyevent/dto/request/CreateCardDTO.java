package br.com.cruzeirodosul.easyevent.dto.request;

import br.com.cruzeirodosul.easyevent.enumerated.CardBrand;
import br.com.cruzeirodosul.easyevent.enumerated.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCardDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6320581494666436639L;

    @NotBlank
    @Size(min = 16, max = 16)
    private String number;

    @NotBlank
    @Size(min = 2, max = 45)
    private String owner;

    @NotBlank
    @Size(min = 3, max = 3)
    private String pin;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private CardType cardType;

    @NotNull
    private CardBrand brand;

}
