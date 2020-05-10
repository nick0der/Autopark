<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="driver" action="" method="POST">
    First name:<@spring.formInput "driverForm.firstName" "" "text"/>
    <br>
    Last name:<@spring.formInput "driverForm.lastName" "" "text"/>
    <br>
    Patronymic:<@spring.formInput "driverForm.patronymic" "" "text"/>
    <br>
    Salary:<@spring.formInput "driverForm.salary" "" "number"/>
    <br>
    Experience:<@spring.formInput "driverForm.experience" "" "number"/>
    <br>
    Transport:<@spring.formSingleSelect "driverForm.transport", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>