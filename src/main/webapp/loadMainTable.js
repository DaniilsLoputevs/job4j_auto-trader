$(document).ready(() => {
    $.ajax({
        type: 'GET',
        url: BACK_END_URL,
        crossdomain: true,
        data: {
            server_action: "INDEX:GET_TABLE"
        }
    }).done((data) => {
        let finalHtml = "";

        /* show first: old added */
        // for (let i = 0; i < data.length; i++) {

        /* show first: fresh added */
        for (let i = data.length - 1; i >= 0; i--) {
            let order = data[i];

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
            let seller = order.seller.name;
            let isSold = (order.isSold) ? "Sold" : "Can buy";
            let created = order.created;

            let isSoldColor = (order.isSold) ? "#f00" : "#2bc25b";
            let isImgNull = (order.img.imgBase64 === "bnVsbA==");

            let editSignOrEmpty = (getCurrentUser() === seller)
                ? `<a id="edit-id-${id}" href="#" class="fas fa-edit"></a>` : "";

            finalHtml += ``
                + `<div class="row">`
                + `<img width="250" height="250" src="${imgBase64}" alt="IMG NOT FOUND">`
                + `<p style="font-size: 24px">`
                + `<a id="view-id-${id}" href="#" class="show-view-link">view full page</a><br>`
                + `${carBrand} ${carModel}, ${carYear} ${carDoorCount}<br>`
                + `<span style="font-size: 32px">${price}  </span>`
                + `${carEngine}, `
                + `${carBody} <br>`
                + `${carTransmission}, `
                + `${carFuelType} <br>`
                + `mileage: ${carMileage} <br>`
                + `${area}, `
                + `${seller}, `
                + `<span style="color: ${isSoldColor};">${isSold}</span> <br>`
                + `${created} `
                + `<span style="font-size: 16px">${desc}</span> <br>`
                + `${editSignOrEmpty} <br>`
                + `</p>`
                + `<div hidden class="support-hidden-order-info"
                    id="${carBrand}&${isImgNull}&${created}">support info</div>`
                + `</div>`
        }
        document.getElementById("order-list").innerHTML = finalHtml;

        setEditIconFunctionality();


    }).fail((err) => {
        alert("Error!!! - See console");
        console.log(err)
    })
});

/**
 * save order id and go to edit page,
 * then load order by id from back-end.
 *
 * * important that this script must be AFTER
 * load data into HTML else icon won't work cause:
 * selector didn't find tags, cause HTML doesn't contains it.
 */
function setEditIconFunctionality() {
    //  edit btn
    $(".fas").click(function () {
        // extract order id from tag id.
        const editId = this.id.split("-")[2];
        sessionStorage.setItem("order-edit-selected-id", editId);
        goToHtmlAuth("order/edit");
    });

    // open full view page
    $(".show-view-link").click(function () {
        // extract order id from tag id.
        const editId = this.id.split("-")[2];
        sessionStorage.setItem("order-view-selected-id", editId);
        goToHtmlAuth("order/view");
    });
}