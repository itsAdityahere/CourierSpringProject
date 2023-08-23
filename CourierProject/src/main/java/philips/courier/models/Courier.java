package philips.courier.models;

// import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Courier {
    @Id
    private UUID consignmentNumber;
    private String UserName;
    private String pickupLocation;
    private String deliveryLocation;
    private LocalDate courierDate;
    private CourierStatus status;
    private String Message;

    public Courier(UUID consignmentNumber, String userName, String pickupLocation, String deliveryLocation,
            LocalDate courierDate, CourierStatus status, String message) {
        this.consignmentNumber = consignmentNumber;
        this.UserName = userName;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.courierDate = courierDate;
        this.status = status;
        this.Message = message;
    }

    public Courier() {

    }

    public UUID getConsignmentNumber() {
        return consignmentNumber;
    }

    public void setConsignmentNumber(UUID consignmentNumber) {
        this.consignmentNumber = consignmentNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public LocalDate getCourierDate() {
        return courierDate;
    }

    public void setCourierDate(LocalDate courierDate) {
        this.courierDate = courierDate;
    }

    public CourierStatus getStatus() {
        return status;
    }

    public void setStatus(CourierStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}