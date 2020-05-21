window.onload = function(){

    var list1 = document.getElementsByClassName("edt-img");

    for (var i = 0; i < list1.length; i++) {
                list1[i].addEventListener("mouseover", function( event ) {
                    event.target.setAttribute("src", "/img/edt-dlt/edithover.png");
                });
        list1[i].addEventListener("mouseout", function( event ) {
            event.target.setAttribute("src", "/img/edt-dlt/edit.png");
        });
    }

    var list2 = document.getElementsByClassName("dlt-img");
    for (var i = 0; i < list2.length; i++) {
        list2[i].setAttribute("src", "/img/edt-dlt/delete.png");
        list2[i].addEventListener("mouseover", function( event ) {
            event.target.setAttribute("src", "/img/edt-dlt/deletehover.png");
        });
        list2[i].addEventListener("mouseout", function( event ) {
            event.target.setAttribute("src", "/img/edt-dlt/delete.png");
        });
    }
}

window.addEventListener( "pageshow", function ( event ) {
    var historyTraversal = event.persisted ||
        ( typeof window.performance != "undefined" &&
            window.performance.navigation.type === 2 );
    if ( historyTraversal ) {
        // Handle page restore.
        window.location.reload();
    }
});