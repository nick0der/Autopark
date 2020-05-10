<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Kilometrage List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Recorded</th>
            <th>Transport</th>
            <th>Kilometers</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list kilometrages as kilometrage>
        <tr>
            <td>${kilometrage.id}</td>
            <td>${kilometrage.dateRecorded}</td>
            <td>${(kilometrage.transport.getBrandAndTrackNumber())!"null"}</td>
            <td>${kilometrage.kilometers}</td>
            <td><a href="edit/${kilometrage.id}"><button>Edit</button></a></td>
            <td><a href="delete/${kilometrage.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>