package net.toregard.persistence;

import net.toregard.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by T530 on 12.04.2017.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
