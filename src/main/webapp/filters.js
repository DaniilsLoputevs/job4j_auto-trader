/* BRANDS */


// btn-use-filters - active brands filters
$(function () {
    $('#btn-use-brands-filters').click(() => {
        let tag = document.getElementById("container-brands-filters");
        if (tag.style.display === "none") {
            tag.style.display = "block";
        } else {
            tag.style.display = "none";
        }
    });
});

// submit brands filters
$(function () {
    $('#btn-submit-brands-filters').click(() => {
        brandsFilterCore("none");
    });
});

// Reset brands filters
$(function () {
    $('#btn-reset-brands-filters').click(() => {
        brandsFilterCore("block");
    });
});


function brandsFilterCore(String) {
    const selectedBrandFilters = $('.mark-filter:checked');
    const brandsStrArr = tagsGetBrands(selectedBrandFilters);

    const supportInfoTags = $('.row').children('.support-hidden-order-info');

    for (let i = 0; i < supportInfoTags.length; i++) {
        let suppInfoEachOrder = supportInfoTags[i];
        let orderBrand = suppInfoEachOrder.id.split("&")[0];

        if (!brandsStrArr.includes(orderBrand)) {
            let orderTag = $(suppInfoEachOrder).parent(".row")[0];
            orderTag.style.display = String; // "block" || "none"
        }

    }
}

// extract brands info from tags
function tagsGetBrands(tags) {
    let brands = [];
    for (let i = 0; i < tags.length; i++) {
        brands.push(tags[i].value);
    }
    return brands;
}


/* IMG */


// img filter
$(function () {
    $('#btn-img-filter-hide').click(() => {
        console.log("accept filter IMG");
        imgFilterCore("none");

        $('#btn-img-filter-hide').hide();
        $('#btn-img-filter-show').show();
    });
});

// reset img filter
$(function () {
    $('#btn-img-filter-show').click(() => {
        console.log("reset filter IMG");
        imgFilterCore("block");

        $('#btn-img-filter-show').hide();
        $('#btn-img-filter-hide').show();
    });
});


function imgFilterCore(String) {
    const supportInfoTags = $('.row').children('.support-hidden-order-info');
    for (let i = 0; i < supportInfoTags.length; i++) {
        let eachSuppInfoOrder = supportInfoTags[i];
        let isImgNull = eachSuppInfoOrder.id.split("&")[1];

        if (isImgNull === "true") {
            let orderTag = $(eachSuppInfoOrder).parent(".row")[0];
            orderTag.style.display = String; // "block" || "none"
        }
    }
}


/* DATE */


// date filter
$(function () {
    $('#btn-date-filter-hide').click(() => {
        console.log("accept filter date");
        dateFilterCore("none");

        $('#btn-date-filter-hide').hide();
        $('#btn-date-filter-show').show();
    });
});

// reset date filter
$(function () {
    $('#btn-date-filter-show').click(() => {
        console.log("reset filter date");
        dateFilterCore("block");

        $('#btn-date-filter-show').hide();
        $('#btn-date-filter-hide').show();
    });
});

function dateFilterCore(String) {
    const supportInfoTags = $('.row').children('.support-hidden-order-info');
    for (let i = 0; i < supportInfoTags.length; i++) {
        let eachSuppInfoOrder = supportInfoTags[i];
        let orderCreatedDate = eachSuppInfoOrder.id.split("&")[2];

        // console.log("### NEW STAGE ###")
        // console.log("orderCreatedDate", orderCreatedDate)
        // console.log("isDateToday:: ", isDateToday(orderCreatedDate));

        if (isDateToday(orderCreatedDate)) {
            let orderTag = $(eachSuppInfoOrder).parent(".row")[0];
            orderTag.style.display = String; // "block" || "none"
        }
    }
}

// return: boolean
function isDateToday(dateString) {
    let todayDate = new Date();
    let orderDate = new Date(dateString);

    // console.log("todayDate", todayDate);
    // console.log("orderDate", orderDate);

    return todayDate.getDate() === orderDate.getDate()
        && todayDate.getMonth() === orderDate.getMonth()
        && todayDate.getFullYear() === orderDate.getFullYear();
}


