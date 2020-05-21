function search() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchForm");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    var indexes = [];
    for (let i = 0; i < document.getElementById('myTable').rows[0].cells.length - 2; i++) {
        for (j = 0; j < tr.length; j++) {
            td = tr[j].getElementsByTagName("td")[i];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    indexes.push(j);
                }
            }
        }
    }
    var switcher = true;
    for (i = 1; i < tr.length; i++) {

        if (indexes.includes(i)) {
            tr[i].style.display = "";
            tr[i].style.backgroundColor = switcher ? '#ffffff': '#f5f5f5';
            switcher = !switcher;
        } else {
            tr[i].style.display = "none";
        }
    }
}
