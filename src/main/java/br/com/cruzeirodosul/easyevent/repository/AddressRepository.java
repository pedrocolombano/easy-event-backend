package br.com.cruzeirodosul.easyevent.repository;

import br.com.cruzeirodosul.easyevent.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
