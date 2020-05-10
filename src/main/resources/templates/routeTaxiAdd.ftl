<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="routeTaxi" action="" method="POST">
    Brand:<@spring.formInput "routeTaxiForm.brand" "" "text"/>
    <br>
    Seating capacity:<@spring.formInput "routeTaxiForm.seatingCapacity" "" "text"/>
    <br>
    Number:<@spring.formInput "routeTaxiForm.number" "" "text"/>
    <br>
    Route:<@spring.formSingleSelect "routeTaxiForm.route", mavs1, ""/>
    <br>
    Storage object:<@spring.formSingleSelect "routeTaxiForm.storageObj", mavs2, ""/>
    <br>
    Track number:<@spring.formInput "routeTaxiForm.trackNumber" "" "text"/>
    <br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>