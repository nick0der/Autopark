<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Driver List</h3>
<div>
    <fieldset>
        <legend>Find driver</legend>
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
            <th>First Name</th>
            <th>Last Name
                <a href="/web/driver/list/sorted/acs" type="button">↓</a>
                <a href="/web/driver/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Patronymic</th>
            <th>Transport</th>
            <th>Salary</th>
            <th>Experience (years)</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list drivers as driver>
            <tr>
                <td>${driver.id}</td>
                <td>${driver.firstName}</td>
                <td>${driver.lastName}</td>
                <td>${driver.patronymic}</td>
                <td>${(driver.transport.getBrandAndTrackNumber())!"null"}</td>
                <td>${driver.salary}</td>
                <td>${driver.experience}</td>
                <td><a href="/web/driver/edit/${driver.id}"><button>Edit</button></a></td>
                <td><a href="/web/driver/delete/${driver.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="/web/driver/create"><button>Create</button></a>
</div>
</body>
</html>