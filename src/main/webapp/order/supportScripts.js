// show picture that user set and set size of it.
$(document).ready(() => {
    document.getElementById("in-order-img").onchange = function () {
        const imgTag = document.getElementById('in-order-img-show')
        imgTag.src = window.URL.createObjectURL(this.files[0]);
        imgTag.width = 250;
        imgTag.height = 250;
    };
});