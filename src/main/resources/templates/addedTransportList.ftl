<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Added Transport List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Added</th>
            <th>Brand</th>
            <th>Info</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list addedTransports as addedTransport>
        <tr>
            <td>${addedTransport.id}</td>
            <td>${(addedTransport.dateAdded)!"null"}</td>
            <td>${addedTransport.brand}</td>
            <td>${(addedTransport.info)!"null"}</td>
            <td><a href="edit/${addedTransport.id}"><button>Edit</button></a></td>
            <td><a href="delete/${addedTransport.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>