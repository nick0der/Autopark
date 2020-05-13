
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <script src="/js/script.js" type="text/javascript" ></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/datepicker.css" rel="stylesheet" />
</head>
<body>
<form name="addedTransport" action="" method="POST" id="form">
    Date added:<input id="datepicker" type="text" class="datepicker-class"/>
    <script src="/js/datepicker.js"></script>
    <@spring.formInput "addedTransportForm.dateAdded" "required" "text"/>
    <br>
    Transport brand:<@spring.formInput "addedTransportForm.brand" "required" "text"/>
    <br>
    Transport info:<@spring.formInput "addedTransportForm.info" "required" "text"/>
    <br>
    <input type="submit" value="Save" onclick="sendDateFromPicker()"/>
</form>
</body>
</html>