function sortTableAZ(colIndex) {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("myTable");

    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[colIndex];
            y = rows[i + 1].getElementsByTagName("TD")[colIndex];
            var condition = !(/^\d+$/.test(x.innerHTML) && /^\d+$/.test(y.innerHTML)) ? x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() :
                parseInt(x.innerHTML) > parseInt(y.innerHTML);
            if (x.innerHTML.includes('$') || y.innerHTML.includes('$') ||
                x.innerHTML.includes('years') || y.innerHTML.includes('years') ||
                x.innerHTML.includes('km') || y.innerHTML.includes('km') ||
                x.innerHTML.includes('kg') || y.innerHTML.includes('kg') ||
                x.innerHTML.includes('№') || y.innerHTML.includes('№') ||
                x.innerHTML.includes('m²') || y.innerHTML.includes('m²'))  {
                    condition =  parseInt(x.innerHTML.replace(/\D/g, "")) > parseInt(y.innerHTML.replace(/\D/g, ""));
                }

            if (condition) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
    document.getElementById("down" + colIndex).src="/img/sortarrows/arrowdownon.png";
    document.getElementById("up" + colIndex).src="/img/sortarrows/arrowupoff.png";

    for (var i = 0; i < 10; i++) {
        if (i === colIndex) continue;
        var elementToChange1 = document.getElementById("up" + i);
        var elementToChange2 = document.getElementById("down" + i);
        if ((elementToChange1 !== null) && (elementToChange2 !== null)){
            elementToChange1.src="/img/sortarrows/arrowupoff.png";
            elementToChange2.src="/img/sortarrows/arrowdownoff.png";
        }
    }

    var table = document.getElementById("myTable");
    var tr = table.getElementsByTagName("tr");
    var switcher = true;
    for (var i = 1; i < tr.length; i++) {
        if (tr[i].style.display !== 'none') {
            tr[i].style.backgroundColor = switcher ? '#ffffff': '#f5f5f5';
            switcher = !switcher;
        }
    }
}

function sortTableZA(colIndex) {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("myTable");
    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[colIndex];
            y = rows[i + 1].getElementsByTagName("TD")[colIndex];
            let condition = !(/^\d+$/.test(x.innerHTML) && /^\d+$/.test(y.innerHTML)) ? x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() :
                parseInt(x.innerHTML.replace(/\D/g, "")) < parseInt(y.innerHTML.replace(/\D/g, ""));
            if (x.innerHTML.includes('$') || y.innerHTML.includes('$') ||
                x.innerHTML.includes('years') || y.innerHTML.includes('years') ||
                x.innerHTML.includes('km') || y.innerHTML.includes('km') ||
                x.innerHTML.includes('kg') || y.innerHTML.includes('kg') ||
                x.innerHTML.includes('№') || y.innerHTML.includes('№') ||
                x.innerHTML.includes('m²') || y.innerHTML.includes('m²'))  {
                condition =  parseInt(x.innerHTML.replace(/\D/g, "")) < parseInt(y.innerHTML.replace(/\D/g, ""));
            }
            if (condition) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
    document.getElementById("down" + colIndex).src="/img/sortarrows/arrowdownoff.png";
    document.getElementById("up" + colIndex).src="/img/sortarrows/arrowupon.png";

    for (var i = 0; i < 10; i++) {
        if (i === colIndex) continue;
        var elementToChange1 = document.getElementById("up" + i);
        var elementToChange2 = document.getElementById("down" + i);
        if ((elementToChange1 !== null) && (elementToChange2 !== null)){
            elementToChange1.src="/img/sortarrows/arrowupoff.png";
            elementToChange2.src="/img/sortarrows/arrowdownoff.png";
        }
    }

    var table = document.getElementById("myTable");
    var tr = table.getElementsByTagName("tr");
    var switcher = true;
    for (var i = 1; i < tr.length; i++) {
        if (tr[i].style.display !== 'none') {
            tr[i].style.backgroundColor = switcher ? '#ffffff': '#f5f5f5';
            switcher = !switcher;
        }
    }
}