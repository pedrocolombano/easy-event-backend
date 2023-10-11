package br.com.cruzeirodosul.easyevent.repository;

import br.com.cruzeirodosul.easyevent.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
