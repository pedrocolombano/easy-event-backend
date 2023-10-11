package br.com.cruzeirodosul.easyevent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1692641309430243146L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer number;

    @Column(length = 8, nullable = false)
    private String zipCode;

    @Column(length = 60)
    private String complement;

    @Column(length = 40, nullable = false)
    private String city;

    @Column(length = 40, nullable = false)
    private String state;

    @Column(length = 50, nullable = false)
    private String neighborhood;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
