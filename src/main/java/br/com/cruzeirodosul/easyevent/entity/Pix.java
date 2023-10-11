package br.com.cruzeirodosul.easyevent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@DiscriminatorValue("PIX")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pix extends Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = -3730241431170443713L;

    @Column(length = 11)
    private String document;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 60)
    private String email;

    @Column(length = 36)
    private UUID randomKey;

}
