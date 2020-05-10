<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="teamLeader" action="" method="POST">
    First name:<@spring.formInput "teamLeaderForm.firstName" "" "text"/>
    <br>
    Last name:<@spring.formInput "teamLeaderForm.lastName" "" "text"/>
    <br>
    Patronymic:<@spring.formInput "teamLeaderForm.patronymic" "" "text"/>
    <br>
    Salary:<@spring.formInput "teamLeaderForm.salary" "" "number"/>
    <br>
    Experience:<@spring.formInput "teamLeaderForm.experience" "" "number"/>
    <br>
    Master:<@spring.formSingleSelect "teamLeaderForm.master", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>