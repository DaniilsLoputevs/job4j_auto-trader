// Authorization
$(function () {
    $('#btn-auth-submit').click(() => {
        const email = $('#auth-email').val();
        const password = $('#auth-password').val();

        if (email !== "" && password !== "") {

            $.ajax({
                type: 'GET',
                url: BACK_END_URL,
                crossdomain: true,
                dataType: 'text',
                data: {
                    server_action: "AUTH_USER",
                    email: email,
                    password: password,
                },
            }).done((data) => {
                let parseData = JSON.parse(data);

                if (parseData === "user Not Founded."
                    || parseData === "incorrect Password.") {
                    alert(parseData);
                } else {
                    document.getElementById("link-login").innerText = parseData;
                    sessionStorage.setItem("user", parseData);
                    alert("Authorization success!");
                }
            }).fail((err) => {
                alert("Error!!! - See console");
                console.log(err);
            })

        } else {
            alert("fill all fields!");
        }

    });
});

// Registration
$(function () {
    $('#btn-reg-submit').click(() => {
        const name = $('#reg-name').val();
        const password = $('#reg-password').val();
        const email = $('#reg-email').val();

        if (name !== "" && password !== "" && email !== "") {

            $.ajax({
                type: 'POST',
                url: BACK_END_URL,
                crossdomain: true,
                dataType: 'text',
                data: {
                    server_action: "REG_USER",
                    name: name,
                    password: password,
                    email: email,
                },
            }).done((data) => {
                refreshCurrentPage();
                alert("Register success!");
            }).fail((err) => {
                alert("Error!!! - See console");
                console.log(err);
            })

        } else {
            alert("fill all fields!");
        }

    });
});

// Identify user (Login(guest) || userName)
$(document).ready(() => {
    let loginHrefName = sessionStorage.getItem("user");
    if (loginHrefName === null) {
        loginHrefName = "Login";
    }
    document.getElementById("link-login").innerText = loginHrefName;
});