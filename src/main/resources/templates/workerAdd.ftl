<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="worker" action="" method="POST">
    Speciality:<@spring.formSingleSelect "workerForm.speciality", types, ""/>
    <br>
    First name:<@spring.formInput "workerForm.firstName" "" "text"/>
    <br>
    Last name:<@spring.formInput "workerForm.lastName" "" "text"/>
    <br>
    Patronymic:<@spring.formInput "workerForm.patronymic" "" "text"/>
    <br>
    Salary:<@spring.formInput "workerForm.salary" "" "number"/>
    <br>
    Experience:<@spring.formInput "workerForm.experience" "" "number"/>
    <br>
    Working team:<@spring.formSingleSelect "workerForm.workingTeam", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>