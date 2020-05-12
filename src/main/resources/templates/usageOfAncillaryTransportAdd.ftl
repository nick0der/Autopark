<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="usageOfAncillaryTransport" action="" method="POST">
    Date used:<@spring.formInput "usageOfAncillaryTransportForm.dateUsed" "required" "date"/>
    <br>
    Transport:<@spring.formSingleSelect "usageOfAncillaryTransportForm.ancillaryTransport", mavs, ""/>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>