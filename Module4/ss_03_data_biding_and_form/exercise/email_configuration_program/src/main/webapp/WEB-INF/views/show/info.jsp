<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>SETTINGS</h4>
<table border="1" width="400px">
    <tr>
        <th>Languages:</th>
        <th>Page size:</th>
        <th>Spams filter:</th>
        <th>Signature:</th>
    </tr>
    <tr>
        <td> ${configEmail.language} </td>
        <td> ${configEmail.pageSize} </td>
        <td> ${configEmail.spamsFilter} </td>
        <td> ${configEmail.signature} </td>
    </tr>
</table>