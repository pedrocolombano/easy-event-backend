package br.com.cruzeirodosul.easyevent.repository;

import br.com.cruzeirodosul.easyevent.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
