<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courier Delivery System</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Include your custom styles.css here if needed -->
    <link rel="stylesheet" type="text/css" href="../../css/styles.css">
    <style>
        /* Add custom styles here */
        .navbar {
            background-color: #343a40;
        }
        
        .navbar-brand {
            color: white;
        }
        
        .nav-link {
            color: white;
        }
        
        .nav-link:hover {
            color: #ffc107;
        }
        
        .container {
            margin-top: 50px;
        }
        
        .action-buttons {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
            margin-top: 20px;
        }
        
        .action-button {
            width: 100%;
            text-align: center;
            padding: 15px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            background-color: #df87be;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease;
        }
        
        .action-button:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>
  
    <div class="container">
        <h1 class="text-center my-5">Courier Delivery System</h1>
        <div class="action-buttons">
            <!-- Add Package Button -->
            <div class="action-button">
                <a class="btn btn-primary" href="Create">Add Package</a>
            </div>
            
            <!-- Update Package Button -->
            <div class="action-button">
                <a class="btn btn-warning" href="Update">Update Package</a>
            </div>
            
            <!-- Delete Package Button -->
            <div class="action-button">
                <a class="btn btn-danger" href="Delete">Delete Package</a>
            </div>
            
            <!-- View Details Button -->
            <div class="action-button">
                <a class="btn btn-info" href="View">View Details</a>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
