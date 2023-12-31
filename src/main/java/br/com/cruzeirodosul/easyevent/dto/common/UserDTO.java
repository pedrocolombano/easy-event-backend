package br.com.cruzeirodosul.easyevent.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 799038325252773529L;

    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private LocalDate birthDate;
    private String areaCode;
    private String phoneNumber;
    private AddressDTO billingAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
