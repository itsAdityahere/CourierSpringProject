package philips.courier.service.serviceImpl;

import philips.courier.repo.CourierRepository;
import philips.courier.service.CourierService;
import philips.courier.dto.ResponseDto;
import philips.courier.models.Courier;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import philips.courier.models.CourierRequest;
import philips.courier.models.CourierStatus;
import philips.courier.models.CourierStatusRequest;

import java.util.List;
import java.util.ArrayList;

import java.util.UUID;

// Declare the class as a Service component
@Service
public class CourierServiceImpl implements CourierService {

    // Injecting the CourierRepository using Spring's dependency injection
    @Autowired
    private CourierRepository courierRepository;

    // Method to create a new consignment
    @Override
    public ResponseDto createConsignment(CourierRequest request) {
        // Creating a new Courier obj with the given details
        Courier courier = new Courier(UUID.randomUUID(), request.getUsername(),
                request.getFromAddress(), request.getToAddress(), request.getDate(),
                CourierStatus.Created, "Consignment Number successfully created");
       
        // Saving the courier object to the repository
        courierRepository.save(courier);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setConsignmentNo(courier.getConsignmentNumber());
        responseDto.setCourierStatus(courier.getStatus());
        responseDto.setMessage("Consignment Number successfully created");
        return responseDto;
    }

    // Method to update the status of a consignment
    @Override
    public ResponseDto updateConsignmentStatus(CourierStatusRequest request) {
       // Finding the courier by its consignment number
        Courier courier = courierRepository.findById(request.getConsignmentNumber()).get();
        ResponseDto responseDto = new ResponseDto();
        if (courier != null) {
            // Updating the status and message of the courier
            courier.setStatus(request.getStatus());
            courier.setMessage(request.getMessage());
            courierRepository.save(courier);
            responseDto.setConsignmentNo(courier.getConsignmentNumber());
            responseDto.setCourierStatus(courier.getStatus());
            responseDto.setMessage("Consignment Number successfully updated");
            return responseDto;
        } else {
            throw new RuntimeException("Invalid Consignment number");
        }
    }

    // Method to delete a consignment by its consignment number
    @Override
    public ResponseDto deleteConsignment(UUID consignmentNo) {
        // Geting the courier by its consignment number
        Courier courier = courierRepository.getById(consignmentNo);
        // Deleting the courier from the repository
        courierRepository.deleteById(consignmentNo);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setConsignmentNo(courier.getConsignmentNumber());
        responseDto.setCourierStatus(CourierStatus.Cancelled);
        responseDto.setMessage("Consignment Number successfully deleted");
        return responseDto;
    }


    // Method to fetch a list of all consignment numbers
    @Override
    public List<UUID> fetchAllConsignments() {
    // Fetching all consignments from the repository
        List<Courier> consignments = courierRepository.findAll();
        List<UUID> consignmentNoList = new ArrayList<>();

    // Extracting consignment numbers from each courier and adding them to the list
        for (Courier consignment : consignments) {
            consignmentNoList.add(consignment.getConsignmentNumber());
        }
        return consignmentNoList;
    }

    // Method to fetch details of a courier using its consignment number
    @Override
    public Courier fetchCourierDetails(UUID consignmentNo) {
        return courierRepository.findById(consignmentNo).orElse(null);
    }
}
