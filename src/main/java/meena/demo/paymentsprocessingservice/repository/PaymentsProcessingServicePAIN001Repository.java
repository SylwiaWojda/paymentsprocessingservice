package meena.demo.paymentsprocessingservice.repository;

import meena.demo.paymentsprocessingservice.model.pain001.PAIN001Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsProcessingServicePAIN001Repository extends MongoRepository<PAIN001Document , String >{

}
