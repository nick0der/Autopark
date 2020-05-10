<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="freightTransport" action="" method="POST">
    Brand:<@spring.formInput "freightTransportForm.brand" "" "text"/>
    <br>
    Load capacity:<@spring.formInput "freightTransportForm.loadCapacity" "" "number"/>
    <br>
    Type:<@spring.formSingleSelect "freightTransportForm.type", types, ""/>
    <br>
    Storage object:<@spring.formSingleSelect "freightTransportForm.storageObj", mavs, ""/>
    <br>
    Track number:<@spring.formInput "freightTransportForm.trackNumber" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>