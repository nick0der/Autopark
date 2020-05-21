<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="icon" type="image/png" href="/table_responsive_v1/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/css/util.css">
    <link rel="stylesheet" type="text/css" href="/table_responsive_v1/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/table.css">
    <link rel="stylesheet" type="text/css" href="/css/search.css">
    <link rel="stylesheet" type="text/css" href="/css/menubar.css">
    <script src="/table_responsive_v1/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/menubar.js" type="text/javascript"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="/table_responsive_v1/vendor/bootstrap/js/popper.js"></script>
    <script src="/table_responsive_v1/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/table_responsive_v1/vendor/select2/select2.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/sortingTable.js"></script>
    <script src="/js/search.js"></script>
    <script src="/js/edt-dlt.js"></script>
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
            <label for="btn-1" class="show">Transport</label>
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
            <label for="btn-2" class="show">Person</label>
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
            <label for="btn-3" class="show">Report</label>
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
            <label for="btn-4" class="show">Other</label>
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
<div class="second-header">
    <div class="form-group has-search" id="search-block" style="left: 285px;">
        <span class="fa fa-search form-control-feedback"></span>
        <input class="form-control" type="text" placeholder="Search.." aria-label="Search" id="searchForm" onkeyup="search()">
    </div>
    <div class="add-button">
        <a href="/web/storageObj/create"><p>Add a new record</p></a>
    </div>
    <div class="title-class"><a href="/web/storageObj/list">Storage Object</a></div>
</div>
<div>
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100">
                    <table id="myTable">
                        <thead>
                        <tr class="table100-head">
                            <th class="column-l" style="width: 170px">
                                <div class="with-sort">
                                    <div class="sort-text">Number</div>
                                    <div class="sort-block">
                                        <div><img onclick="sortTableZA(0)" id="up0" src="/img/sortarrows/arrowupoff.png"></div>
                                        <div><img onclick="sortTableAZ(0)" id="down0" src="/img/sortarrows/arrowdownoff.png"></div>
                                    </div>
                                </div>
                            </th>
                            <th style="width: 170px">
                                <div class="with-sort">
                                    <div class="sort-text">Type</div>
                                    <div class="sort-block">
                                        <div><img onclick="sortTableZA(1)" id="up1" src="/img/sortarrows/arrowupoff.png"></div>
                                        <div><img onclick="sortTableAZ(1)" id="down1" src="/img/sortarrows/arrowdownoff.png"></div>
                                    </div>
                                </div>
                            </th>
                            <th style="width: 170px">
                                <div class="with-sort">
                                    <div class="sort-text">Area</div>
                                    <div class="sort-block">
                                        <div><img onclick="sortTableZA(2)" id="up2" src="/img/sortarrows/arrowupoff.png"></div>
                                        <div><img onclick="sortTableAZ(2)" id="down2" src="/img/sortarrows/arrowdownoff.png"></div>
                                    </div>
                                </div>
                            </th>
                            <th style="width: 290px">
                                <div class="with-sort">
                                    <div class="sort-text">Capacity</div>
                                    <div class="sort-block">
                                        <div><img onclick="sortTableZA(3)" id="up3" src="/img/sortarrows/arrowupoff.png"></div>
                                        <div><img onclick="sortTableAZ(3)" id="down3" src="/img/sortarrows/arrowdownoff.png"></div>
                                    </div>
                                </div>
                            </th>
                            <th style="width: 290px">
                                <div class="with-sort">
                                    <div class="sort-text">Chief</div>
                                    <div class="sort-block">
                                        <div><img onclick="sortTableZA(4)" id="up4" src="/img/sortarrows/arrowupoff.png"></div>
                                        <div><img onclick="sortTableAZ(4)" id="down4" src="/img/sortarrows/arrowdownoff.png"></div>
                                    </div>
                                </div>
                            </th>
                            <th style="text-align: center; width: 70px">Edit</th>
                            <th style="text-align: center; width: 70px" class="column-r">Delete</th>
                        </tr>
                        </thead>
                        <#list storageObjs as storageObj>
                            <tr>
                                <td class="column-l" style="width: 170px">${(storageObj.number)!"null"}</td>
                                <td style="width: 170px">${(storageObj.type)!"null"}</td>
                                <td style="width: 170px">${(storageObj.area)!"null"} m²</td>
                                <td style="width: 290px">${(storageObj.capacity)!"null"}</td>
                                <td style="width: 290px">${(storageObj.chief.getFullName())!"null"}</td>
                                <td style="text-align: center; width: 70px"><a href="/web/storageObj/edit/${storageObj.id}"><img class="edt-img" src="/img/edt-dlt/edit.png"></a></td>
                                <td style="text-align: center; width: 70px" class="column-r"><a onclick="return confirm('Are you sure want to delete? Its impossible to recover the data!')" href="/web/storageObj/delete/${storageObj.id}"><img class="dlt-img" src="/img/edt-dlt/delete.png"></a></td>
                            </tr>
                        </#list>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>