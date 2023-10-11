package br.com.cruzeirodosul.easyevent.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5357059576112257920L;

    private Long id;
    private String street;
    private String number;
    private String zipCode;
    private String complement;
    private String city;
    private String state;
    private String neighborhood;

}
