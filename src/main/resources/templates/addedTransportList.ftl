<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Added Transport List</h3>
<div>
    <fieldset>
        <legend>Find added transport</legend>
        <form name="search" action="" method="POST">
            Brand:<@spring.formInput "searchForm.string" "" "text"/>
            <br>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div>
    <table id="myTable">
        <tr>
            <th>ID</th>
            <th>Date Added
                <a href="/web/addedTransport/list/sorted/acs" type="button">↓</a>
                <a href="/web/addedTransport/list/sorted/desc" type="button">↑</a>
            </th>
            <th>Brand</th>
            <th>Info</th>
            <th style="text-align: center">Edit</th>
            <th style="text-align: center">Delete</th>
        </tr>
        <#list addedTransports as addedTransport>
        <tr>
            <td>${addedTransport.id}</td>
            <td>${(addedTransport.dateAdded)!"null"}</td>
            <td>${addedTransport.brand}</td>
            <td>${(addedTransport.info)!"null"}</td>
            <td style="text-align: center"><a href="/web/addedTransport/edit/${addedTransport.id}"><button>Edit</button></a></td>
            <td style="text-align: center"><a href="/web/addedTransport/delete/${addedTransport.id}"><button>Delete</button></a></td>
        </tr>
        </#list>
    </table>
    <a href="/web/addedTransport/create"><button>Create</button></a>
</div>
<style>
    #myTable {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #myTable td, #myTable th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #myTable tr:nth-child(even){background-color: #f2f2f2;}

    #myTable tr:hover {background-color: #ddd;}

    #myTable th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #2a72de;
        color: white;
    }
</style>
</body>
</html>