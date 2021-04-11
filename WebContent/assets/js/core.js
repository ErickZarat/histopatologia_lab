
function setCurrentDate() {
    var currentDate = new Date();
    $('#currentDate').val(currentDate.getDate() + "/" + currentDate.getMonth() + 1 + "/" + currentDate.getFullYear());
}

$(document).ready(function(){
    setCurrentDate();
});