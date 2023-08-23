package philips.courier.repo;

import org.springframework.data.jpa.repository.JpaRepository;


// import org.springframework.stereotype.Repository;
import philips.courier.models.Courier;

import java.util.UUID;

// @Repository
public interface CourierRepository extends JpaRepository<Courier, UUID> {
}


// try{}
// catch(Exception e){
//     response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//     response.setMessage("Failed to perform operation due to internal service breakdown");

// }