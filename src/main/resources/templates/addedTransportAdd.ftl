<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="addedTransport" action="" method="POST">
    Date added:<@spring.formInput "addedTransportForm.dateAdded" "" "date"/>
    <br>
    Transport brand:<@spring.formInput "addedTransportForm.brand" "" "text"/>
    <br>
    Transport info:<@spring.formInput "addedTransportForm.info" "" "text"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>