<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Worker List</h3>
<div>
    <fieldset>
        <legend>Find worker</legend>
        <form name="search" action="" method="POST">
            Last name:<@spring.formInput "searchForm.string" "" "text"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Speciality</th>
            <th>Last Name
                <a href="/web/worker/list/sorted/acs" type="button">↓</a>
                <a href="/web/worker/list/sorted/desc" type="button">↑</a>
            </th>
            <th>First Name</th>
            <th>Patronymic</th>
            <th>Salary</th>
            <th>Experience (years)</th>
            <th>Working Team</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list workers as worker>
            <tr>
                <td>${worker.id}</td>
                <td>${worker.speciality}</td>
                <td>${worker.lastName}</td>
                <td>${worker.firstName}</td>
                <td>${worker.patronymic}</td>
                <td>${worker.salary}</td>
                <td>${worker.experience}</td>
                <td> ${(worker.workingTeam.getNumber())!"null"}</td>
                <td><a href="/web/worker/edit/${worker.id}"><button>Edit</button></a></td>
                <td><a href="/web/worker/delete/${worker.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="/web/worker/create"><button>Create</button></a>
</div>
</body>
</html>