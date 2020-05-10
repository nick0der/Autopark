<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="taxi" action="" method="POST">
    Brand:<@spring.formInput "taxiForm.brand" "" "text"/>
    <br>
    Seating capacity:<@spring.formInput "taxiForm.seatingCapacity" "" "number"/>
    <br>
    Type:<@spring.formSingleSelect "taxiForm.bodyType", types, ""/>
    <br>
    Storage object:<@spring.formSingleSelect "taxiForm.storageObj", mavs, ""/>
    <br>
    Track number:<@spring.formInput "taxiForm.trackNumber" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>