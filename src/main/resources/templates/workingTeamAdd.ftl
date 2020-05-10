<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="workingTeam" action="" method="POST">
    Number:<@spring.formInput "workingTeamForm.number" "" "number"/>
    <br>
    Team leader:<@spring.formSingleSelect "workingTeamForm.teamLeader", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>