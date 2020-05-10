<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="transportation" action="" method="POST">
    Date transported:<@spring.formInput "transportationForm.dateTransported" "" "date"/>
    <br>
    Transport:<@spring.formSingleSelect "transportationForm.freightTransport", mavs, ""/>
    <br>
    Weight:<@spring.formInput "transportationForm.weight" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>