<%-- 
    Document   : index
    Created on : Apr 2, 2016, 12:38:50 AM
    Author     : shahidur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css"/>
    </head>
    <body>
        <div style="background-color: #f8f8f8; border: 1px solid #2b542c; width: 50%; margin: auto; padding: 20px;">
            <h1>Report Generate</h1>
            <hr/>
           
                <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Or name</th>
                        <th>Or District</th>
                    </tr>
                    <tr>
                    <form action="employeeReport.jsp">
                        <td><input type="text" name="Emp_Id"/></td>
                        <td><input type="text" name="Emp_Name"/></td>
                        <td><input type="text" name="District"/></td>
                      </form>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <input type="submit" value="Query" class="btn btn-info"/></td> 
                        <td>
                            <form action="employeeReportall.jsp">
                                <input type="submit" value="All" class="btn btn-info"/>
                            </form>
                        </td>

                    </tr>
                </table>

            
        </div>
    </body>
</html>
