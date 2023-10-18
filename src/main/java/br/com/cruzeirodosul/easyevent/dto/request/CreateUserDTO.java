package br.com.cruzeirodosul.easyevent.dto.request;

import br.com.cruzeirodosul.easyevent.dto.common.AddressDTO;
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
public class CreateUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 799038325252773529L;

    @NotBlank
    @Size(min = 2, max = 40)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 40)
    private String lastName;

    @NotBlank
    @Size(min = 11, max = 11)
    private String document;

    @NotBlank
    @Size(max = 60)
    private String email;

    @NotBlank
    @Size(min = 7, max = 20)
    private String password;

    @NotNull
    private LocalDate birthDate;

    @NotBlank
    @Size(min = 2, max = 2)
    private String areaCode;

    @NotBlank
    @Size(min = 9, max = 9)
    private String phoneNumber;

    private AddressDTO billingAddress;
    private CreateCardDTO paymentCard;

}
