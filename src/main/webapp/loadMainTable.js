$(document).ready(() => {
    $.ajax({
        type: 'GET',
        url: BACK_END_URL,
        crossdomain: true,
        data: {
            server_action: "INDEX:GET_TABLE"
        }
    }).done((data) => {
        // console.log(data);

        let finalHtml = "";
        for (let i = 0; i < data.length; i++) {
            let order = data[i];

            let id = order.id;
            let imgBase64 = "data:image/png;base64," + order.imgBase64;
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
            let seller = order.seller;
            let isSold = (order.isSold) ? "Sold" : "Can buy";

            let isSoldColor = (order.isSold) ? "#f00" : "#2bc25b";

            finalHtml += `
                <div id="order-id=${id}" class="row">
                <img width="250" height="250" src="${imgBase64}" alt="IMG NOT FOUND">
                <p style="font-size: 24px">
                ${carBrand} ${carModel}, ${carYear} ${carDoorCount}<br>
                <span style="font-size: 32px">${price}</span>
                ${carEngine},
                ${carBody} <br>
                ${carTransmission}, 
                ${carFuelType} <br>
                mileage: ${carMileage} <br>
                ${area},  
                ${seller}, 
               <span style="color: ${isSoldColor};">${isSold}</span> <br>
               <span style="font-size: 16px">${desc}</span>
                </p>
                </div>
                `;
        }

        let tag = document.getElementById("order-list");
        tag.innerHTML = finalHtml;
    }).fail((err) => {
        alert("Error!!! - See console");
        console.log(err)
    })
});