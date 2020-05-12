<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Chief List</h3>
<div>
    <fieldset>
        <legend>Find chief</legend>
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
            <th>Last Name
                <a href="/web/chief/list/sorted/acs" type="button">↓</a>
                <a href="/web/chief/list/sorted/desc" type="button">↑</a>
            </th>
            <th>First Name</th>
            <th>Patronymic</th>
            <th>Salary</th>
            <th>Experience (years)</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list chiefs as chief>
        <tr>
            <td>${chief.id}</td>
            <td>${chief.lastName}</td>
            <td>${chief.firstName}</td>
            <td>${chief.patronymic}</td>
            <td>${chief.salary}</td>
            <td>${chief.experience}</td>
            <td><a href="/web/chief/edit/${chief.id}"><button>Edit</button></a></td>
            <td><a href="/web/chief/delete/${chief.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/chief/create"><button>Create</button></a>
</div>
</body>
</html>