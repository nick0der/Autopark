<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="bus" action="" method="POST">
    Brand:<@spring.formInput "busForm.brand" "" "text"/>
    <br>
    Seating capacity:<@spring.formInput "busForm.seatingCapacity" "" "number"/>
    <br>
    Service class:<@spring.formSingleSelect "busForm.serviceClass", types, ""/>
    <br>
    Route:<@spring.formSingleSelect "busForm.route", mavs1, ""/>
    <br>
    Storage object:<@spring.formSingleSelect "busForm.storageObj", mavs2, ""/>
    <br>
    Track number:<@spring.formInput "busForm.trackNumber" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>