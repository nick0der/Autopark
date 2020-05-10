<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="removedTransport" action="" method="POST">
    Date removed:<@spring.formInput "removedTransportForm.dateRemoved" "" "date"/>
    <br>
    Transport brand:<@spring.formInput "removedTransportForm.brand" "" "text"/>
    <br>
    Transport info:<@spring.formInput "removedTransportForm.info" "" "text"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>