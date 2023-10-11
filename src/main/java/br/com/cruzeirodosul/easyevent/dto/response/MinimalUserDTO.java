package br.com.cruzeirodosul.easyevent.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MinimalUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1738481893150994916L;

    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private LocalDate birthDate;
    private String areaCode;
    private String phoneNumber;

}
