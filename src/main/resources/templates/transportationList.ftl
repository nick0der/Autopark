<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Transportation List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Transported</th>
            <th>Weight</th>
            <th>Freight Transport</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list transportations as transportation>
        <tr>
            <td>${transportation.id}</td>
            <td>${transportation.dateTransported}</td>
            <td>${transportation.weight}</td>
            <td> ${(transportation.freightTransport.getBrandAndTrackNumber())!"null"}</td>
            <td><a href="edit/${transportation.id}"><button>Edit</button></a></td>
            <td><a href="delete/${transportation.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>