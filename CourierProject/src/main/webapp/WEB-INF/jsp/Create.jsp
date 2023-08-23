<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courier Delivery System</title>
    <link rel="stylesheet" type="text/css" href="../../css/Create.css">
</head>
<body>
    <div class="container">
        <h1>Add Package</h1>
        
        <form action="/couriers/create" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="pickupLocation">Pickup Address</label>
                <input type="text" class="form-control" id="pickupLocation" name="pickupLocation" required>
            </div>
            <div class="form-group">
                <label for="deliveryLocation">Delivery Address</label>
                <input type="text" class="form-control" id="deliveryLocation" name="deliveryLocation" required>
            </div>
            <div class="form-group">
                <label for="courierDate">Date (DD-MON-YYYY)</label>
                <input type="text" class="form-control" id="courierDate" name="courierDate" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
