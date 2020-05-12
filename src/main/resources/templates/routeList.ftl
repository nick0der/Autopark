<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Route List</h3>
<div>
    <fieldset>
        <legend>Find route</legend>
        <form name="search" action="" method="POST">
            Route:<@spring.formInput "searchForm.string" "" "text"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Start
                <a href="/web/route/list/sorted/start/acs" type="button">↓</a>
                <a href="/web/route/list/sorted/start/desc" type="button">↑</a>
            </th>
            <th>Finish
                <a href="/web/route/list/sorted/finish/acs" type="button">↓</a>
                <a href="/web/route/list/sorted/finish/desc" type="button">↑</a>
            </th>
            <th>Distance</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list routes as route>
        <tr>
            <td>${route.id}</td>
            <td>${route.start}</td>
            <td>${route.finish}</td>
            <td>${route.distance}</td>
            <td><a href="/web/route/edit/${route.id}"><button>Edit</button></a></td>
            <td><a href="/web/route/delete/${route.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/route/create"><button>Create</button></a>
</div>
</body>
</html>