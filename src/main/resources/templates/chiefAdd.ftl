<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="chief" action="" method="POST">
    First name:<@spring.formInput "chiefForm.firstName" "" "text"/>
    <br>
    Last name:<@spring.formInput "chiefForm.lastName" "" "text"/>
    <br>
    Patronymic:<@spring.formInput "chiefForm.patronymic" "" "text"/>
    <br>
    Salary:<@spring.formInput "chiefForm.salary" "" "number"/>
    <br>
    Experience:<@spring.formInput "chiefForm.experience" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>