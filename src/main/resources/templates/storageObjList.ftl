<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Storage Object List</h3>
<div>
    <fieldset>
        <legend>Find storage object</legend>
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
                <a href="/web/storageObj/list/sorted/acs" type="button">↓</a>
                <a href="/web/storageObj/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Type</th>
            <th>Area</th>

            <th>Capacity</th>
            <th>Chief</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list storageObjs as storageObj>
        <tr>
            <td>${storageObj.id}</td>
            <td>${storageObj.number}</td>
            <td>${storageObj.type}</td>
            <td>${storageObj.area}</td>
            <td>${storageObj.capacity}</td>
            <td> ${(storageObj.chief.getFullName())!"null"}</td>
            <td><a href="/web/storageObj/edit/${storageObj.id}"><button>Edit</button></a></td>
            <td><a href="/web/storageObj/delete/${storageObj.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/storageObj/create"><button>Create</button></a>
</div>
</body>
</html>