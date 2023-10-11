package br.com.cruzeirodosul.easyevent.repository;

import br.com.cruzeirodosul.easyevent.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long> {
}
