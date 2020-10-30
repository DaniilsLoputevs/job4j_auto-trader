//     var file_data = this.files[0];
//     file_data.name = idaviz +'.pdf';
//     var form_data = new FormData();
//     form_data.append("file", file_data);
//     form_data.append('extraParam','value231');
//     console.log(file_data);
//     console.log('here');
//     var oReq = new XMLHttpRequest();
//     oReq.open("POST", "ajax_page.php", true);
//     oReq.onload = function (oEvent) {
//         if (oReq.status === 200) {
//             console.log('upload succes',oReq.responseText);
//         } else {
//             console.log("Error " + oReq.status + " occurred when trying to upload your file.<br \/>");
//         }
//     };
//
//     oReq.send(form_data);
// });


$(function () {
    $('#btn-order-save').click(() => {
        let formData = new FormData();
        const orderID = "stub";
        const carBrand = $('#in-car-brand').val();
        const carModel = $('#in-car-model').val();
        const carYear = $('#in-car-year').val();
        const carMileage = $('#in-car-mileage').val();
        const carDoorCount = $('#in-car-door-count').val();
        const carEngine = $('#in-car-engine').val();
        const carBody = $('#in-car-body').val();
        const carTransmission = $('#in-car-transmission').val();
        const carFuelType = $('#in-car-fuel-type').val();

        const orderDesc = $('#in-order-desc').val();
        const orderImg = $('#in-order-img')[0].files;
        const orderPrice = $('#in-order-price').val();
        const orderArea = $('#in-order-area').val();

        // const file = $('#input-file-test-upload')[0].files;
        const file = orderImg;

        alert("Script work!!!");
        // console.log("img", orderImg);

        formData.append("server_action", "ORDER_EDIT:SAVE_ORDER");
        formData.append("carBrand", $('#in-car-brand').val());
        formData.append("carModel", $('#in-car-model').val());
        formData.append("carYear", $('#in-car-year').val());
        formData.append("carMileage", $('#in-car-mileage').val());
        formData.append("carDoorCount", $('#in-car-door-count').val());
        formData.append("carEngine", $('#in-car-engine').val());
        formData.append("carBody",$('#in-car-body').val());
        formData.append("carTransmission",$('#in-car-transmission').val());
        formData.append("carFuelType",$('#in-car-fuel-type').val());

        formData.append("orderDesc", $('#in-order-desc').val());
        formData.append("orderImg", $('#in-order-img')[0].files);
        formData.append("orderPrice", $('#in-order-price').val());
        formData.append("orderArea", $('#in-order-area').val());


        // formData.append("img", file);
        // console.log("file", file);

        $.ajax({
            type: 'POST',
            url: BACK_END_MPF_URL,
            crossdomain: true,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',
            data: formData
        }).done((data) => {
            alert("request - yes,\r\n response - yes");
        }).fail((err) => {
            alert("Error!!! - See console");
            console.log(err);
        })

    });
});
