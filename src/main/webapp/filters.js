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
        let orderBrand = suppInfoEachOrder.id.split("-")[0];

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

// img filter
$(function () {
    $('#btn-img-filter-hide').click(() => {
        console.log("filter");
        imgFilterCore("none");

        $('#btn-img-filter-hide').hide();
        $('#btn-img-filter-show').show();
    });
});

// reset img filter
$(function () {
    $('#btn-img-filter-show').click(() => {
        console.log("reset");
        imgFilterCore("block");

        $('#btn-img-filter-show').hide();
        $('#btn-img-filter-hide').show();
    });
});


function imgFilterCore(String) {
    const supportInfoTags = $('.row').children('.support-hidden-order-info');
    for (let i = 0; i < supportInfoTags.length; i++) {
        let eachSuppInfoOrder = supportInfoTags[i];
        let isImgNull = eachSuppInfoOrder.id.split("-")[1];

        if (isImgNull === "true") {
            let orderTag = $(eachSuppInfoOrder).parent(".row")[0];
            orderTag.style.display = String; // "block" || "none"
        }
    }

}
