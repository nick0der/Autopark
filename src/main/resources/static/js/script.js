window.onload = function(){

    if (document.forms['form'].elements["dateAdded"]) {
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateAdded"].value;
    } else if (document.forms['form'].elements["dateRecorded"]){
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateRecorded"].value;
    } else if (document.forms['form'].elements["dateTransported"]){
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateTransported"].value;
    } else if (document.forms['form'].elements["dateRemoved"]){
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateRemoved"].value;
    } else if (document.forms['form'].elements["dateRepaired"]){
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateRepaired"].value;
    } else if (document.forms['form'].elements["dateUsed"]){
        document.forms['form'].elements["datepicker"].value = document.forms['form'].elements["dateUsed"].value;
    }

}

function sendDateFromPicker() {
    if (document.forms['form'].elements["dateAdded"]) {
        document.forms['form'].elements["dateAdded"].value = document.forms['form'].elements["datepicker"].value;
    } else if (document.forms['form'].elements["dateRecorded"]){
        document.forms['form'].elements["dateRecorded"].value = document.forms['form'].elements["datepicker"].value;
    } else if (document.forms['form'].elements["dateTransported"]){
        document.forms['form'].elements["dateTransported"].value = document.forms['form'].elements["datepicker"].value;
    } else if (document.forms['form'].elements["dateRemoved"]){
        document.forms['form'].elements["dateRemoved"].value = document.forms['form'].elements["datepicker"].value;
    } else if (document.forms['form'].elements["dateRepaired"]){
        document.forms['form'].elements["dateRepaired"].value = document.forms['form'].elements["datepicker"].value;
    } else if (document.forms['form'].elements["dateUsed"]){
        document.forms['form'].elements["dateUsed"].value = document.forms['form'].elements["datepicker"].value;
    }
}
