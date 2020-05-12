<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Freight Transport List</h3>
<div>
    <fieldset>
        <legend>Find freight transport</legend>
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
            <th>Brand
                <a href="/web/freightTransport/list/sorted/acs" type="button">↓</a>
                <a href="/web/freightTransport/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Load Capacity</th>
            <th>Type</th>
            <th>Storage Object</th>
            <th>Track Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list freightTransports as freightTransport>
        <tr>
            <td>${freightTransport.id}</td>
            <td>${freightTransport.brand}</td>
            <td>${freightTransport.loadCapacity}</td>
            <td>${freightTransport.type}</td>
            <td>${(freightTransport.storageObj.getNumber())!"null"}</td>
            <td>${(freightTransport.trackNumber)!"null"}</td>
            <td><a href="/web/freightTransport/edit/${freightTransport.id}"><button>Edit</button></a></td>
            <td><a href="/web/freightTransport/delete/${freightTransport.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/freightTransport/create"><button>Create</button></a>
</div>
</body>
</html>