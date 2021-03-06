<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Ancillary Transport List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Mission</th>
            <th>Storage Object</th>
            <th>Track Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list ancillaryTransports as ancillaryTransport>
        <tr>
            <td>${ancillaryTransport.id}</td>
            <td>${(ancillaryTransport.brand)!"null"}</td>
            <td>${(ancillaryTransport.mission)!"null"}</td>
            <td>${(ancillaryTransport.storageObj.getNumber())!"null"}</td>
            <td>${(ancillaryTransport.trackNumber)!"null"}</td>

            <td><a href="edit/${ancillaryTransport.id}"><button>Edit</button></a></td>
            <td><a href="delete/${ancillaryTransport.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>