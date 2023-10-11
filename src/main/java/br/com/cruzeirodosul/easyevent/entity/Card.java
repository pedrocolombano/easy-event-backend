package br.com.cruzeirodosul.easyevent.entity;

import br.com.cruzeirodosul.easyevent.enumerated.CardBrand;
import br.com.cruzeirodosul.easyevent.enumerated.CardType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@DiscriminatorValue("CARD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Card extends Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = -308943465161953626L;

    @Column(length = 16)
    private String number;

    @Column(length = 40)
    private String owner;

    @Column(precision = 3)
    private Integer pin;

    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private CardType type;

    @Enumerated(EnumType.STRING)
    private CardBrand brand;

}
