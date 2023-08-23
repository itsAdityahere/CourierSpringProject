package philips.courier.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import philips.courier.models.Courier;
import philips.courier.models.CourierStatus;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class CourierRepositoryTest {
    @Autowired
    CourierRepository courierRepository;

    @Test
    public void testCreation() {

        CourierStatus courierStatus = CourierStatus.Created;
        Courier courier = new Courier(UUID.randomUUID(), "adi", "BLR", "JPR", LocalDate.of(2023, 8, 28),
                courierStatus,
                "consignment number successfully");

        courierRepository.save(courier);
        Courier fetchCourier = courierRepository.findById(courier.getConsignmentNumber()).orElse(null);

        assertThat(fetchCourier).isNotNull();
        assertThat(fetchCourier.getConsignmentNumber()).isEqualTo(courier.getConsignmentNumber());
        assertThat(fetchCourier.getUserName()).isEqualTo(courier.getUserName());
        assertThat(fetchCourier.getPickupLocation()).isEqualTo(courier.getPickupLocation());
        assertThat(fetchCourier.getDeliveryLocation()).isEqualTo(courier.getDeliveryLocation());
        assertThat(fetchCourier.getCourierDate()).isEqualTo(courier.getCourierDate());
        assertThat(fetchCourier.getStatus()).isEqualTo(courier.getStatus());
        assertThat(fetchCourier.getMessage()).isEqualTo(courier.getMessage());

    }

    @Test
    public void TestGetAllTest() {
        Courier firstCourier = new Courier(UUID.randomUUID(), "John", "BLR", "JPR",
                LocalDate.of(2023, 8, 28), CourierStatus.Delivered, "Consignment Numbers successfully retrieved");

        Courier secondCourier = new Courier(UUID.randomUUID(), "Eric", "DEL", "BOM",
                LocalDate.of(2021, 4, 11), CourierStatus.Delivered, "Consignment Numbers successfully retrieved");

        courierRepository.save(firstCourier);
        courierRepository.save(secondCourier);

        List<Courier> expectedCouriers = new ArrayList<Courier>();
        expectedCouriers.add(firstCourier);
        expectedCouriers.add(secondCourier);

        List<Courier> receivedCouriers = courierRepository.findAll();

        assertThat(expectedCouriers.size()).isEqualTo(receivedCouriers.size());

    }

}
