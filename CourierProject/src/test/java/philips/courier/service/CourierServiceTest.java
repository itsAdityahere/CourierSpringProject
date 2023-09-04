package philips.courier.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import philips.courier.dto.ResponseDto;
import philips.courier.models.Courier;
import philips.courier.models.CourierRequest;
import philips.courier.models.CourierStatus;
import philips.courier.models.CourierStatusRequest;
import philips.courier.repo.CourierRepository;
import philips.courier.service.serviceImpl.CourierServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourierServiceImplTest {

    @InjectMocks
    private CourierServiceImpl courierService;

    @Mock
    private CourierRepository courierRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateConsignment() {
        CourierRequest request = new CourierRequest();
        request.setUsername("John");
        request.setFromAddress("Address A");
        request.setToAddress("Address B");
        request.setDate(LocalDate.now());

        when(courierRepository.save(any(Courier.class))).thenReturn(new Courier());
        ResponseDto responseDto = courierService.createConsignment(request);
        assertThat(responseDto).isNotNull();  
    }

    @Test
    void testUpdateConsignmentStatus() {
        UUID consignmentNumber = UUID.randomUUID();
        CourierStatusRequest request = new CourierStatusRequest();
        request.setConsignmentNumber(consignmentNumber);
        request.setStatus(CourierStatus.Delivered);
        request.setMessage("Delivered successfully");

        when(courierRepository.findById(any(UUID.class))).thenReturn(Optional.of(new Courier()));

        ResponseDto responseDto = courierService.updateConsignmentStatus(request);

        assertThat(responseDto).isNotNull();
        
    }

    @Test
    void testDeleteConsignment() {
        UUID consignmentNumber = UUID.randomUUID();

        when(courierRepository.getById(any(UUID.class))).thenReturn(new Courier());

        ResponseDto responseDto = courierService.deleteConsignment(consignmentNumber);

        assertThat(responseDto).isNotNull();
       
    }

    @Test
    void testFetchAllConsignments() {
        // Create and configure mock data
        List<Courier> courierList = List.of(new Courier(), new Courier());
        when(courierRepository.findAll()).thenReturn(courierList);

        List<UUID> consignmentNoList = courierService.fetchAllConsignments();
        assertThat(consignmentNoList).hasSize(courierList.size());
       
    }

    @Test
    void testFetchCourierDetails() {
        UUID consignmentNumber = UUID.randomUUID();
        Courier expectedCourier = new Courier();
        // Configuring mock data
        when(courierRepository.findById(any(UUID.class))).thenReturn(Optional.of(expectedCourier));

        Courier fetchedCourier = courierService.fetchCourierDetails(consignmentNumber);
        assertThat(fetchedCourier).isEqualTo(expectedCourier);
    }
}
