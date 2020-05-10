<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Route Taxi List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Seating Capacity</th>
            <th>№</th>
            <th>Route</th>
            <th>Storage Object</th>
            <th>Track Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list routeTaxis as routeTaxi>
        <tr>
            <td>${routeTaxi.id}</td>
            <td>${routeTaxi.brand}</td>
            <td>${routeTaxi.seatingCapacity}</td>
            <td>${routeTaxi.number}</td>
            <td> ${(routeTaxi.route.getFullTitle())!"null"}</td>
            <td> ${(routeTaxi.storageObj.getNumber())!"null"}</td>
            <td> ${(routeTaxi.trackNumber)!"null"}</td>
            <td><a href="edit/${routeTaxi.id}"><button>Edit</button></a></td>
            <td><a href="delete/${routeTaxi.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>