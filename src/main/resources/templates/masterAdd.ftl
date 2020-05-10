<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="master" action="" method="POST">
    First name:<@spring.formInput "masterForm.firstName" "" "text"/>
    <br>
    Last name:<@spring.formInput "masterForm.lastName" "" "text"/>
    <br>
    Patronymic:<@spring.formInput "masterForm.patronymic" "" "text"/>
    <br>
    Salary:<@spring.formInput "masterForm.salary" "" "number"/>
    <br>
    Experience:<@spring.formInput "masterForm.experience" "" "number"/>
    <br>
    Chief:<@spring.formSingleSelect "masterForm.chief", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>