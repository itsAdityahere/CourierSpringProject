package philips.courier.cont;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import philips.courier.cont.CourierController;
import philips.courier.dto.ResponseDto;
import philips.courier.models.Courier;
import philips.courier.models.CourierRequest;
import philips.courier.models.CourierStatus;
import philips.courier.models.CourierStatusRequest;
import philips.courier.service.CourierService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourierController.class)
@AutoConfigureMockMvc
public class CourierControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private CourierService courierService;


        @Test
        public void testFetchAllConsignments() throws Exception {
                List<UUID> consignmentNoList = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());

                when(courierService.fetchAllConsignments())
                                .thenReturn(consignmentNoList);

                mockMvc.perform(get("/couriers/fetch-all"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0]").value(consignmentNoList.get(0).toString())) // Adjust the
                                                                                                        // array index
                                                                                                        // accordingly
                                .andExpect(jsonPath("$[1]").value(consignmentNoList.get(1).toString())); // Adjust the
                                                                                                         // array index
                                                                                                         // accordingly
        }

        @Test
        public void testFetchCourierDetails() throws Exception {
                UUID consignmentNo = UUID.randomUUID();
                Courier courier = new Courier();
                // Set up the expected courier object or mock

                courier.setConsignmentNumber(consignmentNo);
                courier.setUserName("John");
                courier.setPickupLocation("Address A");
                courier.setDeliveryLocation("Address B");
                courier.setCourierDate(LocalDate.now());
                courier.setStatus(CourierStatus.Created);
                courier.setMessage("Consignment details");

                when(courierService.fetchCourierDetails(any(UUID.class)))
                                .thenReturn(courier);

                mockMvc.perform(get("/couriers/fetch-details/{consignmentNo}", consignmentNo))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.consignmentNumber")
                                                .value(courier.getConsignmentNumber().toString()))
                                .andExpect(jsonPath("$.userName").value(courier.getUserName()))
                                .andExpect(jsonPath("$.pickupLocation").value(courier.getPickupLocation()))
                                .andExpect(jsonPath("$.deliveryLocation").value(courier.getDeliveryLocation()))
                                .andExpect(jsonPath("$.courierDate").value(courier.getCourierDate().toString()))
                                .andExpect(jsonPath("$.status").value(courier.getStatus().toString()))
                                .andExpect(jsonPath("$.message").value(courier.getMessage()));
        }

}
