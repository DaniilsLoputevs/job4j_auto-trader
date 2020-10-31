$(function () {
    $('#btn-order-save').click(() => {
        let formData = new FormData();
        const orderId = "" + 0; // stub
        // const orderId = getSelectedId(); // stub
        // const carId = "" + 0; // stub
        const seller = getCurrentUser();
        const isSold = "" + false; // stub


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
        formData.append("orderId", orderId);
        formData.append("orderImg", $('#in-order-img')[0].files);
        formData.append("orderDesc", $('#in-order-desc').val());
        formData.append("orderPrice", $('#in-order-price').val());

        // formData.append("carId", carId);
        formData.append("carBrand", $('#in-car-brand').val());
        formData.append("carModel", $('#in-car-model').val());
        formData.append("carYear", $('#in-car-year').val());
        formData.append("carDoorCount", $('#in-car-door-count').val());
        formData.append("carMileage", $('#in-car-mileage').val());
        formData.append("carEngine", $('#in-car-engine').val());
        formData.append("carBody",$('#in-car-body').val());
        formData.append("carTransmission",$('#in-car-transmission').val());
        formData.append("carFuelType",$('#in-car-fuel-type').val());

        formData.append("orderArea", $('#in-order-area').val());
        formData.append("orderSeller", seller);
        formData.append("orderSold", isSold);


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

function getCurrentUser() {
    let rsl = sessionStorage.getItem("user");
    return (rsl === null) ? "guest" : rsl;
}
function getSelectedId() {
    let rsl = sessionStorage.getItem("order-edit-selected-id");
    sessionStorage.setItem("order-edit-selected-id", null);
    return (rsl === null) ? 0 : rsl;
}
