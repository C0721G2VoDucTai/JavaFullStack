<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>You have successfully registered </h1>
<h3>Name: ${medicalDeclaration.name}</h3>
<h3>Birth day: ${medicalDeclaration.birthday}</h3>
<h3>Gender: ${medicalDeclaration.gender}</h3>
<h3>National: ${medicalDeclaration.national}</h3>
<h3>Id Card: ${medicalDeclaration.idCard}</h3>
<h3>Travel Info: ${medicalDeclaration.travelInfo}</h3>
<h3>Id vehicle: ${medicalDeclaration.idVehicle}</h3>
<h3>Id seat: ${medicalDeclaration.idSeat}</h3>
<h3>Start day: ${medicalDeclaration.startDay}</h3>
<h3>end Day: ${medicalDeclaration.endDay}</h3>
<h3>What city you came for 14 day: ${medicalDeclaration.localArrive}</h3>
<h3>Address:</h3>
<h3>City: ${medicalDeclaration.city}</h3>
<h3>District: ${medicalDeclaration.district}</h3>
<h3>Ward: ${medicalDeclaration.ward}</h3>
<h3>Phone: ${medicalDeclaration.phone}</h3>
<h3>Email: ${medicalDeclaration.email}</h3>
<h3>Fever: ${medicalDeclaration.fever}</h3>
<h3>Cough: ${medicalDeclaration.cough}</h3>
<h3>Nausea: ${medicalDeclaration.nausea}</h3>
<h3>Diarrhea: ${medicalDeclaration.diarrhea}</h3>
<h3>History1: ${medicalDeclaration.history1}</h3>
<h3>History2: ${medicalDeclaration.history2}</h3>
</body>
</html>