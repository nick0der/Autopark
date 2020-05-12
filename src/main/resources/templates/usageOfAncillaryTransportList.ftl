<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Usage of Ancillary Transport List</h3>
<div>
    <fieldset>
        <legend>Find usage record</legend>
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
            <th>Date Used
                <a href="/web/usageOfAncillaryTransport/list/sorted/acs" type="button">↓</a>
                <a href="/web/usageOfAncillaryTransport/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Ancillary Transport</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list usageOfAncillaryTransports as usageOfAncillaryTransport>
            <tr>
                <td>${usageOfAncillaryTransport.id}</td>
                <td>${usageOfAncillaryTransport.dateUsed}</td>
                <td> ${(usageOfAncillaryTransport.ancillaryTransport.getBrandAndTrackNumber())!"null"}</td>
                <td><a href="/web/usageOfAncillaryTransport/edit/${usageOfAncillaryTransport.id}"><button>Edit</button></a></td>
                <td><a href="/web/usageOfAncillaryTransport/delete/${usageOfAncillaryTransport.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="/web/usageOfAncillaryTransport/create"><button>Create</button></a>
</div>
</body>
</html>