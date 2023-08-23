package philips.courier.dto;

import java.util.UUID;
import philips.courier.models.CourierStatus;

public class ResponseDto {

    private UUID consignmentNo;
    private CourierStatus courierStatus;
    private String message;

    //Getters and setters for retrieving and setting up response
    public UUID getConsignmentNo() {
        return consignmentNo;
    }

    public void setConsignmentNo(UUID consignmentNo) {
        this.consignmentNo = consignmentNo;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
