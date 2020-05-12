
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body onload="load()">

<form name="addedTransport" action="" method="POST" id="form">
    Date added:<input id="datepicker" type="text" class="datepicker-class"/>
    <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap',
            format: 'yyyy-mm-dd'
        });
    </script>
        Date added2:<@spring.formInput "addedTransportForm.dateAdded" ""/>
    <br>
    Transport brand:<@spring.formInput "addedTransportForm.brand" "required" "text"/>
    <br>
    Transport info:<@spring.formInput "addedTransportForm.info" "required" "text"/>
    <br>
    <input type="submit" value="Save" onclick="myFunction()"/>
</form>
<script>
    function myFunction() {
        document.forms['form'].elements["dateAdded"].value = document.forms['form'].elements["datepicker"].value;
    }
</script>
<script>
    function load() {
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateAdded"].value;
        document.forms['form'].elements["dateAdded"].type = "hidden";
    }
</script>
<style>
    .input-group{
            max-width: 220px;
        }
</style>

</body>
</html>