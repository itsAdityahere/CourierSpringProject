package philips.courier.service;

import philips.courier.dto.ResponseDto;
import philips.courier.models.Courier;
import philips.courier.models.CourierRequest;
import philips.courier.models.CourierStatusRequest;

import java.util.List;
import java.util.UUID;

// Interface representing the operations provided by the CourierService
public interface CourierService {

    ResponseDto createConsignment(CourierRequest request);

    ResponseDto updateConsignmentStatus(CourierStatusRequest request);

    ResponseDto deleteConsignment(UUID consignmentNo);

     // Method to fetch the list of all consignment numbers
    List<UUID> fetchAllConsignments();

     // Method to fetch details of a courier using its consignment number
    Courier fetchCourierDetails(UUID consignmentNo);
}
