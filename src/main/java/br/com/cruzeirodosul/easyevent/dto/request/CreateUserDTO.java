package br.com.cruzeirodosul.easyevent.dto.request;

import br.com.cruzeirodosul.easyevent.dto.common.AddressDTO;
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

    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String areaCode;
    private String phoneNumber;
    private AddressDTO billingAddress;

}
