package philips.courier.models;
import java.util.UUID;

public class CourierStatusRequest {

    private UUID consignmentNumber;
    private CourierStatus status;
    private String message;
    public UUID getConsignmentNumber() {
        return consignmentNumber;
    }

    public void setConsignmentNumber(UUID consignmentNumber) {
        this.consignmentNumber = consignmentNumber;
    }

    public CourierStatus getStatus() {
        return status;
    }

    public void setStatus(CourierStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
