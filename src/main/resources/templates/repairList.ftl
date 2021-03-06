<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Repair List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Repaired</th>
            <th>Transport</th>
            <th>Working Team</th>
            <th>Cost</th>
            <th>Engines</th>
            <th>Transmissions</th>
            <th>Bridges</th>
            <th>Chassis</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list repairs as repair>
        <tr>
            <td>${repair.id}</td>
            <td>${repair.dateRepaired}</td>
            <td>${(repair.transport.getBrandAndTrackNumber())!"null"}</td>
            <td>${(repair.workingTeam.getNumber())!"null"}</td>
            <td>${repair.cost}</td>
            <td>${repair.engines}</td>
            <td>${repair.transmissions}</td>
            <td>${repair.bridges}</td>
            <td>${repair.chassis}</td>
            <td><a href="edit/${repair.id}"><button>Edit</button></a></td>
            <td><a href="delete/${repair.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>