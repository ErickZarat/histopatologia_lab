
function setCurrentDate() {
    var currentDate = new Date();
    $('#currentDate').html(currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + currentDate.getFullYear());
}

$(document).ready(function(){
    setCurrentDate();
});

window.coreTableConfig = {
    // searching: false,
    paging: true,
    // pagingType: 'simple',
    info: false,
 	autoWidth : true,
    // bFilter: false,
    bLengthChange: false,
    iDisplayLength: 10,
columnDefs: [{ 'width': '5%', 'targets': [0,1]  },
    {'width': '90%','targets': [2, 3] },
    { "className": 'dt-center', 'targets': '_all'  },  ],
    oLanguage: {
        oPaginate: {
            sPrevious: "Anterior", // This is the link to the previous page
            sNext: "Siguiente", // This is the link to the next page
        }
    }

}

toastr.options = {
    "closeButton": true,
    "debug": false,
    "newestOnTop": true,
    "progressBar": true,
    "positionClass": "toast-bottom-right",
    "preventDuplicates": true,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}