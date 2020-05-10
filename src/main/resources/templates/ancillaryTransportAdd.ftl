<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="ancillaryTransport" action="" method="POST">
    Brand:<@spring.formInput "ancillaryTransportForm.brand" "" "text"/>
    <br>
    Mission:<@spring.formInput "ancillaryTransportForm.mission" "" "text"/>
    <br>
    Storage object:<@spring.formSingleSelect "ancillaryTransportForm.storageObj", mavs, ""/>
    <br>
    Track number:<@spring.formInput "ancillaryTransportForm.trackNumber" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>