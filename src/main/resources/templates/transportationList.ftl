<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Transportation List</h3>
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
                <a href="/web/transportation/list/sorted/acs" type="button">↓</a>
                <a href="/web/transportation/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Freight Transport</th>
            <th>Weight</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list transportations as transportation>
        <tr>
            <td>${transportation.id}</td>
            <td>${transportation.dateTransported}</td>
            <td> ${(transportation.freightTransport.getBrandAndTrackNumber())!"null"}</td>
            <td>${transportation.weight}</td>

            <td><a href="/web/transportation/edit/${transportation.id}"><button>Edit</button></a></td>
            <td><a href="/web/transportation/delete/${transportation.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/transportation/create"><button>Create</button></a>
</div>
</body>
</html>