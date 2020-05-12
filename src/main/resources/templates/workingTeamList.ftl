<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Working Team List</h3>
<div>
    <fieldset>
        <legend>Find working team</legend>
        <form name="search" action="" method="POST">
            №:<@spring.formInput "searchForm.string" "" "number"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>№
                <a href="/web/workingTeam/list/sorted/acs" type="button">↓</a>
                <a href="/web/workingTeam/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Team Leader</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list workingTeams as workingTeam>
        <tr>
            <td>${workingTeam.id}</td>
            <td>${workingTeam.number}</td>
            <td> ${(workingTeam.teamLeader.getFullName())!"null"}</td>
            <td><a href="/web/workingTeam/edit/${workingTeam.id}"><button>Edit</button></a></td>
            <td><a href="/web/workingTeam/delete/${workingTeam.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/workingTeam/create"><button>Create</button></a>
</div>
</body>
</html>