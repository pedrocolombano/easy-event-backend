package br.com.cruzeirodosul.easyevent.dto.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(max = 100)
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    @Size(min = 8, max = 8)
    private String zipCode;

    @Size(max = 60)
    private String complement;

    @NotBlank
    @Size(max = 40)
    private String city;

    @NotBlank
    @Size(max = 40)
    private String state;

    @NotBlank
    @Size(max = 50)
    private String neighborhood;

}
