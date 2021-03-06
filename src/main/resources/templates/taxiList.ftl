<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Taxi List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Seating Capacity</th>
            <th>Body Type</th>
            <th>Storage Object</th>
            <th>Track Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list taxis as taxi>
        <tr>
            <td>${taxi.id}</td>
            <td>${taxi.brand}</td>
            <td>${taxi.seatingCapacity}</td>
            <td>${taxi.bodyType}</td>
            <td>${(taxi.storageObj.getNumber())!"null"}</td>
            <td>${(taxi.trackNumber)!"null"}</td>
            <td><a href="edit/${taxi.id}"><button>Edit</button></a></td>
            <td><a href="delete/${taxi.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>