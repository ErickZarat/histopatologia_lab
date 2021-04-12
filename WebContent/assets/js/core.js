
function setCurrentDate() {
    var currentDate = new Date();
    $('#currentDate').html(currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + currentDate.getFullYear());
}

$(document).ready(function(){
    setCurrentDate();
});

window.coreTableConfig = {
    searching: false,
    paging: true,
    pagingType: 'simple',
    info: false,
    bFilter: false,
    bLengthChange: false,
    iDisplayLength: 5,
    oLanguage: {
        oPaginate: {
            sPrevious: "Anterior", // This is the link to the previous page
            sNext: "Siguiente", // This is the link to the next page
        }
    }
}