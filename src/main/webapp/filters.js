// btn-use-filters - active filters
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
        filterCore("none");
    });
});

// Reset brands filters
$(function () {
    $('#btn-reset-brands-filters').click(() => {
        filterCore("block");
    });
});


function filterCore(String) {
    const selectedBrandFilters = $('.mark-filter:checked');
    const brandsStrArr = tagsGetBrands(selectedBrandFilters);

    const supportInfoTags = $('.row').children('.support-hidden-order-info');

    for (let i = 0; i < supportInfoTags.length; i++) {
        let suppInfoEachOrder = supportInfoTags[i];
        let orderBrand = suppInfoEachOrder.id;
        let orderTag = $(suppInfoEachOrder).parent(".row")[0];

        if (!brandsStrArr.includes(orderBrand)) {
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