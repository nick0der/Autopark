<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="kilometrage" action="" method="POST">
    Date recorded:<@spring.formInput "kilometrageForm.dateRecorded" "" "date"/>
    <br>
    Transport:<@spring.formSingleSelect "kilometrageForm.transport", mavs, ""/>
    <br>
    Kilometers:<@spring.formInput "kilometrageForm.kilometers" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>