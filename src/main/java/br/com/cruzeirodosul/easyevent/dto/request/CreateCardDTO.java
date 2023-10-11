package br.com.cruzeirodosul.easyevent.dto.request;

import br.com.cruzeirodosul.easyevent.enumerated.CardBrand;
import br.com.cruzeirodosul.easyevent.enumerated.CardType;
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

    private String number;
    private String owner;
    private Integer pin;
    private LocalDate expirationDate;
    private CardType type;
    private CardBrand brand;
    private boolean defaultPayment;

}
