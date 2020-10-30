$(document).ready(() => {
    $.ajax({
        type: 'GET',
        crossdomain: true,
        url: getBackEndUrl(),
        data: {
            server_action: "INDEX:GET_TABLE"
        }
    }).done((data) => {
        // console.log(data);

        let finalHtml = "";
        for (let i = 0; i < data.length; i++) {
            let order = data[i];
            let id = order.id;
            let name = order.name;
            let imgId = "https://56.img.avito.st/640x480/9236873956.jpg";

            let price = order.price;
            let seller = order.seller;
            let isSold = (order.isSold) ? "Sold" : "Can buy";


            let car = order.car;
            let carName = car.name;
            let carBrand = car.brand;
            let carBody = car.body;
            let carDoorCount = "dr. " + car.doorCount;
            let carFuelType = car.fuelType;
            let carTransmission = car.transmission;

            let carYear = "2010";
            let carEngine = "carEngine";
            let area = "area";

            // let img = getImgById(imgId);
            let imgBase64 = "data:image/png;base64," + order.imgBase64;
            let color = (isSold) ? "#2bc25b" : "#f00";
            isSold = `<span style="color: ${color};">${isSold}</span>`;

            // console.log("id", id);
            // console.log("name", name);
            // console.log("price", price);
            // console.log("seller", seller);
            // console.log("isSold", isSold);
            console.log("imgBase64", imgBase64);


            // console.log("car", car);
            // console.log("carName", carName);
            // console.log("carBrand", carBrand);
            // console.log("carBody", carBody);
            // console.log("carDoorCount", carDoorCount);
            // console.log("carFuelType", carFuelType);
            // console.log("carTransmission", carTransmission);

            finalHtml += `
                <div id="${id}" class="row">
                <img width="250" height="250" src="${imgBase64}" alt="IMG STUB">
                <p>
                ${carBrand} ${carName}, ${carYear} ${carDoorCount}<br>
                <span style="font-size: 24px">${price}</span>
                ${carEngine},
                ${carBody} <br>
                ${carTransmission}, 
                ${carFuelType} <br>
                ${area},  
                ${seller}, 
                ${isSold}
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


function getImgById(id) {
    let rsl = "IMG NOT FOUND";
    $.ajax({
        type: 'GET',
        crossdomain: true,
        url: getBackEndUrl(),
        dataType: 'text',
        data: {
            server_action: "OTHER:GET_IMG_ALBUM_BY_ID",
            img_list_id: id
        },
    }).done((data) => {
        let parseData = JSON.parse(data);

        rsl = parseData.imgList[0];
    }).fail((err) => {
        alert("Error!!! - getImgById() : " +
            "full stackTrace see in console");
        console.log(err);
    });
    return rsl;
}