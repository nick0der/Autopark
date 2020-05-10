<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="route" action="" method="POST">
    Start:<@spring.formInput "routeForm.start" "" "text"/>
    <br>
    Finish:<@spring.formInput "routeForm.finish" "" "text"/>
    <br>
    Distance:<@spring.formInput "routeForm.distance" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>