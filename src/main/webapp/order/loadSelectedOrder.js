/**
 * load selected Order by Id from back-end.
 * check selected-order-id:
 * if selectedId === null ->> user place new Order
 * else ->> load data from back and set into inputs on DOM
 */
$(document).ready(() => {
    let selectedId = sessionStorage.getItem("order-edit-selected-id");

    if (selectedId !== null && selectedId !== "noneId") {

        $.ajax({
            type: 'GET',
            url: BACK_END_URL,
            crossdomain: true,
            data: {
                server_action: "ORDER_EDIT:GET_ORDER",
                orderId: selectedId
            }
        }).done((data) => {
            const parseData = JSON.parse(data);
            // console.log("parseData", parseData);

            $("#in-car-brand").val(parseData.car.brand);
            $("#in-car-model").val(parseData.car.model);
            $("#in-car-year").val(parseData.car.year);
            $("#in-car-mileage").val(parseData.car.mileage);
            $("#in-car-door-count").val(parseData.car.doorCount);

            $("#in-car-engine").val(parseData.car.engine);
            $("#in-car-body").val(parseData.car.body);
            $("#in-car-transmission").val(parseData.car.transmission);
            $("#in-car-fuel-type").val(parseData.car.fuelType);

            $("#in-order-desc").val(parseData.description);
            $("#in-order-price").val(parseData.price);
            $("#in-order-area").val(parseData.area);
            $("#in-order-is-sold").val(parseData.isSold);

            document.getElementById('in-order-img-show')
                .setAttribute(
                    'src',
                    "data:image/png;base64," + parseData.img.imgBase64
                );
        });

    }

});
