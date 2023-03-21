package meena.demo.paymentsprocessingservice.repository;

import meena.demo.paymentsprocessingservice.model.pacs008.PACS008Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsProcessingServicePACS008Repository extends MongoRepository<PACS008Document , String> {
}
