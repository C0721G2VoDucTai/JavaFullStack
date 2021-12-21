<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <!-- CSS only -->
    <style>
        * {
            padding: 0 0;
            margin: 0 0;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>Medical Declaration</h3>
    <form:form action="/showInfo" method="post" modelAttribute="medicalDeclaration" class="row g-3">
        <div class="col-12">
            <form:label path="name" class="form-label">Name</form:label>
            <form:input type="text" path="name" class="form-control" placeholder="Input name"/>
        </div>
        <div class="col-md-4">
            <form:label path="birthday" class="form-label">Birthday</form:label>
            <form:input type="text" path="birthday" class="form-control"/>
        </div>
        <div class="col-md-4">
            <form:label path="gender" class="form-label">Gender</form:label>
            <form:select path="gender">
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>
        <div class="col-md-4">
            <form:label path="national" class="form-label">National</form:label>
            <form:select path="national">
                <form:options items="${nationals}"></form:options>
            </form:select>
        </div>
        <div class="col-12">
            <form:label path="idCard" class="form-label">Id Card</form:label>
            <form:input type="text" path="idCard" class="form-control" placeholder="Input Id Card"/>
        </div>
        <div class="col-12">
            <label class="form-label">Travel Info</label>
            <table>
                <tr>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Flight</form:label>
                            <form:radiobutton path="travelInfo" value="Flight"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Ship</form:label>
                            <form:radiobutton path="travelInfo" value="Ship"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Car</form:label>
                            <form:radiobutton path="travelInfo" value="Car"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Other</form:label>
                            <form:radiobutton path="travelInfo" value="Other"/>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">
            <form:label path="idVehicle" class="form-label">Id vehicle</form:label>
            <form:input path="idVehicle" type="text" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="idSeat" class="form-label">Id seat</form:label>
            <form:input path="idSeat" type="text" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="startDay" class="form-label">Start day</form:label>
            <form:input path="startDay" type="date" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="endDay" class="form-label">End day</form:label>
            <form:input path="endDay" type="date" class="form-control"/>
        </div>
        <div class="col-12">
            <form:label path="localArrive" class="form-label">What city you came for 14 day</form:label>
            <form:textarea path="localArrive" class="form-control"/>
        </div>
        <div class="col-12">
            <label class="form-label">Address</label>
        </div>

        <div class="col-12">
            <table>
                <tr>
                    <td>
                        <div class="col-3">
                            <form:label path="city" class="form-label">City</form:label>
                            <form:select path="city">
                                <form:options items="${cities}"></form:options>
                            </form:select>

                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="district" class="form-label">District</form:label>
                            <form:select path="district">
                                <form:options items="${districts}"></form:options>
                            </form:select>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="ward" class="form-label">Ward</form:label>
                            <form:select path="ward">
                                <form:options items="${wards}"></form:options>
                            </form:select>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">
            <form:label path="phone" class="form-label">Phone</form:label>
            <form:input path="phone" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="email" class="form-label">Email</form:label>
            <form:input path="email" class="form-control"/>
        </div>
        <div class="col-12">
            <label path="localArrive" class="form-label">Have you had any symptoms within 14 days?</label>
            <table class="col-12" border="1">
                <tr>
                    <td><form:label path="fever" class="form-label">Fever</form:label></td>
                    <td><form:radiobuttons path="fever" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="cough" class="form-label">Cough</form:label></td>
                    <td><form:radiobuttons path="cough" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="nausea" class="form-label">Nausea</form:label></td>
                    <td><form:radiobuttons path="nausea" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="diarrhea" class="form-label">Diarrhea</form:label></td>
                    <td><form:radiobuttons path="diarrhea" items="${choices}"/></td>
                </tr>

            </table>
        </div>
        <div class="col-12">
            <label class="form-label">Have you had any symptoms within 14 days?</label>

            <table class="col-12" border="1">
                <tr>
                    <td><form:label path="history1" class="form-label">History1</form:label></td>
                    <td><form:radiobuttons path="history1" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="history1" class="form-label">History1</form:label></td>
                    <td><form:radiobuttons path="history2" items="${choices}"/></td>
                </tr>
            </table>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </form:form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>