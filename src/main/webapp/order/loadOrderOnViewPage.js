
$(document).ready(() => {
    const selectedId = sessionStorage.getItem("order-view-selected-id");
    // alert("load page: id: " + selectedId);

    if (selectedId !== null) {
        $.ajax({
            type: 'GET',
            url: BACK_END_URL,
            crossdomain: true,
            data: {
                server_action: "ORDER_VIEW:GET_ORDER",
                orderId: selectedId
            }
        }).done((data) => {
            const order = JSON.parse(data);
            console.log("order", order);
            let finalHtml = "";

            let id = order.id;
            let imgBase64 = "data:image/png;base64," + order.img.imgBase64;
            let desc = order.desc;
            let price = order.price;

            let car = order.car;
            let carBrand = car.brand;
            let carModel = car.model;
            let carYear = car.year;
            let carDoorCount = "dr. " + car.doorCount;
            let carMileage = car.mileage;
            let carEngine = car.engine;
            let carBody = car.body;
            let carTransmission = car.transmission;
            let carFuelType = car.fuelType;

            let area = order.area;
            let sellerName = order.seller.name;
            let sellerEmail = order.seller.emial;
            let isSold = (order.isSold) ? "Sold" : "Can buy";

            let isSoldColor = (order.isSold) ? "#f00" : "#2bc25b";

            let editSignOrEmpty = (getCurrentUser() === sellerName)
                ? `<a id="edit-id-${id}" href="#" class="fas fa-edit"></a>` : "";

            finalHtml += ``
                + `<div class="row">`
                + `<img width="250" height="250" src="${imgBase64}" alt="IMG NOT FOUND">`
                + `<p style="font-size: 22px">`
                + `Price: <span style="font-size: 28px">${price}</span><br>`
                + `Mileage: ${carMileage} <br>`
                + `Area: ${area}<br>`
                + `Seller: ${sellerName}<br>`
                + `Email: ${sellerEmail}<br>`
                + `<span style="color: ${isSoldColor};">${isSold}</span><br>`
                + `<span style="font-size: 18px">${desc}</span> <br>`
                + `${editSignOrEmpty}`
                + `</p>`
                + `</div>`
                + `<div class="row">`
                + `<table class="table table-dark">`
                + `<tr>`
                + `<td><p style="font-size: 20px">Brand: ${carBrand}</p></td>`
                + `<td><p style="font-size: 20px">Model: ${carModel}</p></td>`
                + `<td><p style="font-size: 20px">Year: ${carYear}</p></td>`
                + `<td><p style="font-size: 20px">Door count:${carDoorCount}</p></td>`
                + `</tr>`
                + `<tr>`
                + `<td><p style="font-size: 20px">Engine: ${carEngine}</p></td>`
                + `<td><p style="font-size: 20px">Body: ${carBody}</p></td>`
                + `<td><p style="font-size: 20px">Transmission: ${carTransmission}</p></td>`
                + `<td><p style="font-size: 20px">Fuel type: ${carFuelType}</p></td>`
                + `</tr>`
                + `</table>`
                + `</div>`

            document.getElementById("order-place").innerHTML = finalHtml;

            //  set functionality for edit btn
            $(".fas").click(function () {
                // extract order id from tag id.
                const editId = this.id.split("-")[2];
                sessionStorage.setItem("order-edit-selected-id", editId);
                goToHtmlAuth("order/edit");
            });
        });

    }
});