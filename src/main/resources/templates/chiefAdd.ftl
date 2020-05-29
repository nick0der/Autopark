
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <script src="/js/script.js" type="text/javascript" ></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/inputPage.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/menubar.css" rel="stylesheet" />
    <link href="/css/inputs.css" rel="stylesheet" />

</head>
<body>
<nav>
    <div class="logo">AutoPark</div>
    <label for="btn" class="icon">
        <span class="fa fa-bars"></span>
    </label>
    <input type="checkbox" id="btn">
    <ul>
        <li>
            <a href="/">Home</a>
        </li>
        <li>
            <a href="">Transport</a>
            <input type="checkbox" id="btn-1">
            <ul id="first-list">
                <li><a href="/web/ancillaryTransport/list">Ancillary transport</a></li>
                <li><a href="/web/bus/list">Bus</a></li>
                <li><a href="/web/freightTransport/list">Freight transport</a></li>
                <li><a href="/web/routeTaxi/list">Route taxi</a></li>
                <li><a href="/web/taxi/list">Taxi</a></li>
            </ul>
        </li>
        <li>
            <a href="">Person</a>
            <input type="checkbox" id="btn-2">
            <ul id="second-list">
                <li><a href="/web/chief/list">Chief</a></li>
                <li><a href="/web/driver/list">Driver</a></li>
                <li><a href="/web/master/list">Master</a></li>
                <li><a href="/web/teamLeader/list">Team leader</a></li>
                <li><a href="/web/worker/list">Worker</a></li>
            </ul>
        </li>
        <li>
            <a href="">Report</a>
            <input type="checkbox" id="btn-3">
            <ul id="third-list">
                <li><a href="/web/addedTransport/list">Added transport</a></li>
                <li><a href="/web/removedTransport/list">Removed transport</a></li>
                <li><a href="/web/kilometrage/list">Kilometrage</a></li>
                <li><a href="/web/passangerTransportation/list">Passanger transportation</a></li>
                <li><a href="/web/transportation/list">Freight transportation</a></li>
                <li><a href="/web/repair/list">Repair</a></li>
                <li><a href="/web/usageOfAncillaryTransport/list">Usage of anc. transport</a></li>
            </ul>
        </li>
        <li>
            <a href="">Other</a>
            <input type="checkbox" id="btn-4">
            <ul id="fourth-list">
                <li><a href="/web/route/list">Route</a></li>
                <li><a href="/web/storageObj/list">Storage object</a></li>
                <li><a href="/web/workingTeam/list">Brigade</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div class="wrapper">
    <div class="form-input" style="height: 455px">
        <div class="input-header">
            <a href="/web/chief/list"><img src="/img/arrowback.png" width="35px" style="margin-top: 9px"></a>
            <div>Chief</div>
        </div>
        <form name="chief" action="" method="POST" id="form" autocomplete="off">
            <div class="form-row">
                <div>First name:</div><@spring.formInput "chiefForm.firstName" "required pattern='^[A-Z]{1}[a-z]{2,32}' title='example: Name'" "text"/>
                <br>
            </div>
            <div class="form-row">
                <div>Last name:</div><@spring.formInput "chiefForm.lastName" "required pattern='^[A-Z]{1}[a-z]{2,32}' title='example: Surname'" "text"/>
                <br>
            </div>
            <div class="form-row">
                <div>Patronymic:</div><@spring.formInput "chiefForm.patronymic" "required pattern='^[A-Z]{1}[a-z]{2,32}' title='example: Patronymic'" "text"/>
                <br>
            </div>
            <div class="form-row">
                <div>Salary:</div><@spring.formInput "chiefForm.salary" "required min='0' max='10000000'" "number"/>
                <br>
            </div>
            <div class="form-row">
                <div>Experience:</div><@spring.formInput "chiefForm.experience" "required min='0' max='100'" "number"/>
                <br>
            </div>
            <br>
            <input class="save-btn" type="submit" value="Save"/>
        </form>
    </div>
</div>
</body>
</html>