<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Team Leader List</h3>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Patronymic</th>
            <th>Salary</th>
            <th>Experience (years)</th>
            <th>Master</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list teamLeaders as teamLeader>
            <tr>
                <td>${teamLeader.id}</td>
                <td>${teamLeader.firstName}</td>
                <td>${teamLeader.lastName}</td>
                <td>${teamLeader.patronymic}</td>
                <td>${teamLeader.salary}</td>
                <td>${teamLeader.experience}</td>
                <td>${(teamLeader.master.getFullName())!"null"}</td>
                <td><a href="edit/${teamLeader.id}"><button>Edit</button></a></td>
                <td><a href="delete/${teamLeader.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>
</body>
</html>