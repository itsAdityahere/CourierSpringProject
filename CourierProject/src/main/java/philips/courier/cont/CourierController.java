package philips.courier.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import philips.courier.dto.ResponseDto;
import philips.courier.models.Courier;
import philips.courier.models.CourierRequest;
import philips.courier.models.CourierStatusRequest;
import philips.courier.service.CourierService;

import java.util.*;

@RestController
@RequestMapping("/couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;
    // Endpoint to create a new consignment
    @PostMapping("/create")
    public ResponseDto createConsignment(@RequestBody CourierRequest courierRequest) {

        return courierService.createConsignment(courierRequest);
    }

    // Endpoint to update the status of a consignment
    @PutMapping("/update-status")
    public ResponseDto updateConsignmentStatus(@RequestBody CourierStatusRequest request) {

        return courierService.updateConsignmentStatus(request);
    }


    // Endpoint to delete a consignment by consignment number
    @DeleteMapping("/delete/{consignmentNo}")
    public ResponseDto deleteConsignment(@PathVariable UUID consignmentNo) {

        return courierService.deleteConsignment(consignmentNo);
    }


    // Endpoint to fetch a list of all consignment numbers
    @GetMapping("/fetch-all")
    public List<UUID> fetchAllConsignments() {
        return courierService.fetchAllConsignments();
    }

    // Endpoint to fetch details of a specific consignment by consignment number
    @GetMapping("/fetch-details/{consignmentNo}")
    public Courier fetchCourierDetails(@PathVariable UUID consignmentNo) {
        return courierService.fetchCourierDetails(consignmentNo);
    }

}
