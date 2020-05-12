<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Removed Transport List</h3>
<div>
    <fieldset>
        <legend>Find removed transport</legend>
        <form name="search" action="" method="POST">
            Brand:<@spring.formInput "searchForm.string" "" "text"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Date Removed
                <a href="/web/removedTransport/list/sorted/acs" type="button">↓</a>
                <a href="/web/removedTransport/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Brand</th>
            <th>Info</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list removedTransports as removedTransport>
            <tr>
                <td>${removedTransport.id}</td>
                <td>${(removedTransport.dateRemoved)!"null"}</td>
                <td>${removedTransport.brand}</td>
                <td>${(removedTransport.info)!"null"}</td>
                <td><a href="/web/removedTransport/edit/${removedTransport.id}"><button>Edit</button></a></td>
                <td><a href="/web/removedTransport/delete/${removedTransport.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="/web/removedTransport/create"><button>Create</button></a>
</div>
</body>
</html>