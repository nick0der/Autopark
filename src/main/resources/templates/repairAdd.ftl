<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="repair" action="" method="POST">
    Date repaired:<@spring.formInput "repairForm.dateRepaired" "" "date"/>
    <br>
    Transport:<@spring.formSingleSelect "repairForm.transport", mavs1, ""/>
    <br>
    Working team:<@spring.formSingleSelect "repairForm.workingTeam", mavs2, ""/>
    <br>
    Cost:<@spring.formInput "repairForm.cost" "" "number"/>
    <br>
    Engines:<@spring.formInput "repairForm.engines" "" "number"/>
    <br>
    Transmissions:<@spring.formInput "repairForm.transmissions" "" "number"/>
    <br>
    Bridges:<@spring.formInput "repairForm.bridges" "" "number"/>
    <br>
    Chassis:<@spring.formInput "repairForm.chassis" "" "number"/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>