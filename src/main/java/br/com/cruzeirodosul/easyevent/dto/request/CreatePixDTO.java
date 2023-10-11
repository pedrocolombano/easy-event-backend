package br.com.cruzeirodosul.easyevent.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePixDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4085396593002219794L;

    private String document;
    private String phoneNumber;
    private String email;
    private UUID randomKey;
    private boolean defaultPayment;

}
