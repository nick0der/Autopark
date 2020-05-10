<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="passangerTransportation" action="" method="POST">
    Date transported:<@spring.formInput "passangerTransportationForm.dateTransported" "" "date"/>
    <br>
    Transport:<@spring.formSingleSelect "passangerTransportationForm.transport", mavs, ""/>
    <br>
    Number of passangers:<@spring.formInput "passangerTransportationForm.numberOfPassangers" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>