<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                background-color: whitesmoke;
            }

            td {
                border: 2px solid grey;
                text-align: middle;
                padding: 6px;

            }

            th {
                border: 2px solid grey;
                text-align: middle;
                padding: 6px;
                background-color: whitesmoke;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">ProjectManagementSystem</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home</a></li>
                     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Companies<span class="caret"></span></a>
                         <ul class="dropdown-menu">
                             <li><a href="/companies/all">Find all companies</a></li>
                             <li><a href="/companies/form">Find company</a></li>
                             <li><a href="/companies/add">Add company</a></li>
                             <li><a href="/companies/update/form">Update company</a></li>
                             <li><a href="/companies/delete/form">Delete company</a></li>
                         </ul>
                     </li>
                     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customers<span class="caret"></span></a>
                         <ul class="dropdown-menu">
                             <li><a href="/customers/all">Find all customers</a></li>
                             <li><a href="/customers/form">Find customer</a></li>
                             <li><a href="/customers/add">Add customer</a></li>
                             <li><a href="/customers/update/form">Update customer</a></li>
                             <li><a href="/customers/delete/form">Delete customer</a></li>
                         </ul>
                     </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Developers<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/developers/all">Find all developers</a></li>
                            <li><a href="/developers/form">Find developer</a></li>
                            <li><a href="/developers/add">Add developer</a></li>
                            <li><a href="/developers/update/form">Update developer</a></li>
                            <li><a href="/developers/delete/form">Delete developer</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Projects<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/projects/all">Find all projects</a></li>
                            <li><a href="/projects/form">Find project</a></li>
                            <li><a href="/projects/add">Add project</a></li>
                            <li><a href="/projects/update/form">Update project</a></li>
                            <li><a href="/projects/delete/form">Delete project</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Skills<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/skills/all">Find all skills</a></li>
                            <li><a href="/skills/form">Find skill</a></li>
                            <li><a href="/skills/add">Add skill</a></li>
                            <li><a href="/skills/update/form">Update skill</a></li>
                            <li><a href="/skills/delete/form">Delete skill</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>