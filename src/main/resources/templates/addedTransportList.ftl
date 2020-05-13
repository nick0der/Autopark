<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/table.css" />
    <script src="/js/sortingTable.js"></script>
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
            <th>
                <div class="sort-block">
                Date Added
                    <div onclick="sortTableAZ(1)" id="down">↓</div>
                    <div onclick="sortTableZA(1)" id="up">↑</div>
                </div>
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
</body>
</html>