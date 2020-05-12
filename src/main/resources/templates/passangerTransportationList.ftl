<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Passanger Transportation List</h3>
<div>
    <fieldset>
        <legend>Find transportation</legend>
        <form name="search" action="" method="POST">
            Transport:<@spring.formInput "searchForm.string" "" "text"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Transported
                <a href="/web/passangerTransportation/list/sorted/acs" type="button">↓</a>
                <a href="/web/passangerTransportation/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Transport</th>
            <th>Number of Passangers</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list passangerTransportations as passangerTransportation>
        <tr>
            <td>${passangerTransportation.id}</td>
            <td>${passangerTransportation.dateTransported}</td>
            <td>${(passangerTransportation.transport.getBrandAndTrackNumber())!"null"}</td>
            <td>${passangerTransportation.numberOfPassangers}</td>
            <td><a href="/web/passangerTransportation/edit/${passangerTransportation.id}"><button>Edit</button></a></td>
            <td><a href="/web/passangerTransportation/delete/${passangerTransportation.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/passangerTransportation/create"><button>Create</button></a>
</div>
</body>
</html>