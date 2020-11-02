$(function () {
    $('#btn-order-save').click(() => {
        let formData = new FormData();
        const orderId = "" + getSelectedId();

        formData.append("server_action", "ORDER_EDIT:SAVE_ORDER");
        formData.append("orderId", orderId);
        formData.append("orderImg", getCurrentImg());
        formData.append("orderDesc", $('#in-order-desc').val());
        formData.append("orderPrice", $('#in-order-price').val());

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
        formData.append("orderSeller", getCurrentUser());
        formData.append("orderSold", $('#in-order-is-sold').val());

        $.ajax({
            type: 'POST',
            url: BACK_END_MPF_URL,
            crossdomain: true,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',
            data: formData
        }).done((data) => {
            alert("Order save");
            sessionStorage.setItem("order-edit-selected-id", null);
            goToHtmlAuth("index");
        }).fail((err) => {
            alert("Error!!! - See console");
            console.log(err);
        })

    });
});

function getCurrentImg() {
    const imgTag = document.getElementById('in-order-img-show');
    const imgSrc = imgTag.getAttribute('src');
    if (imgSrc.startsWith("blob:http://")) {
        return $('#in-order-img')[0].files[0];
    } else {
        return null;
    }
}

function getSelectedId() {
    const rsl = sessionStorage.getItem("order-edit-selected-id");
    return (rsl === null || rsl === "null") ? 0 : rsl;
}
