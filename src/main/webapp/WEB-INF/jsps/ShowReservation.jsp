<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h2>Flight Details</h2>
 
 Flight Number: ${flight.flightNumber }
 <br>
 Operating Airlines: ${flight.operatingAirlines }
 
 <br>
Departure City: ${flight.departureCity }<br>
Arrival City:${flight.arrivalCity }<br>
Departure Date:${flight.dateOfDeparture }<br>

<h2>Enter Passenger Detail</h2>
<form action="confirmReservation" method="post">
   <pre>
      First Name <input type="text" name="firstName" />
      Last Name  <input type="text" name="lastName" />
      Middle Name<input type="text" name="middleName" />
          email  <input type="email" name="email" /> 
           Phone <input type="number" name="phone" />
                 <input type="hidden" name="flightId" value="${flight.id }"/>
      
      <h2>Enter The Payment details</h2>
      
      Name On The Card<input type="text" name="NameOnCard"/>
          Card Number <input type="text" name="cardNumber"/>
                 Cvv  <input type="text" name="cvv"/>
          Expiry Date <input type="text" name="expiryDate"/>  
                 
            
             <input type="submit"  value="complete Reservation"/>
   </pre>


</form>

 <br>
</body>
</html>