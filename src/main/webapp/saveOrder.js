$(function () {
//     var file_data = this.files[0];
//     file_data.name = idaviz +'.pdf';
//     var form_data = new FormData();
//     form_data.append("file", file_data);
//     form_data.append('extraParam','value231');
//     console.log(file_data);
//     console.log('here');
//     var oReq = new XMLHttpRequest();
//     oReq.open("POST", "ajax_page.php", true);
//     oReq.onload = function (oEvent) {
//         if (oReq.status === 200) {
//             console.log('upload succes',oReq.responseText);
//         } else {
//             console.log("Error " + oReq.status + " occurred when trying to upload your file.<br \/>");
//         }
//     };
//
//     oReq.send(form_data);
// });



    $('#btn-test').click(() => {
        let formData = new FormData();
        const file = $('#input-file-test-upload')[0].files;

        formData.append( "server_action","OTHER:SAVE_IMG_ALBUM");
        formData.append("img", file);

        console.log("file", file);

            $.ajax({
                type: 'POST',
                url: BACK_END_MPF_URL,
                crossdomain: true,
                contentType: false,
                processData: false,
                enctype: 'multipart/form-data',
                data: formData
            }).done((data) => {
                alert("request - yes,\r\n response - yes");
            }).fail((err) => {
                alert("Error!!! - See console");
                console.log(err);
            })

    });
});