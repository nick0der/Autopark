<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="storageObj" action="" method="POST">
    Type:<@spring.formSingleSelect "storageObjForm.type", types, ""/>
    <br>
    Area:<@spring.formInput "storageObjForm.area" "" "number"/>
    <br>
    Number:<@spring.formInput "storageObjForm.number" "" "number"/>
    <br>
    Capacity:<@spring.formInput "storageObjForm.capacity" "" "number"/>
    <br>
    Chief:<@spring.formSingleSelect "storageObjForm.chief", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>