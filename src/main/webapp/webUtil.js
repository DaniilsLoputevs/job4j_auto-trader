/**
 * go straight(without any data load) to other HTML page.
 * check auth, - if not show alert about "Unauthorized user".
 *
 * @param String - name of HTML file with packages name.
 */
function goToHtmlAuth(String) {
    if (checkAuth() >= 0) {
    window.location.href = getContextPath() + "/" + String + ".html";
    } else {
        alert("You need to be authorized user, to use this option.");
    }
}

/**
 * Use this URL for send your usual requests.
 * @type {string}
 */
const BACK_END_URL = getContextPath() + '/back-end'

/**
 * MPF - Multi-part-Form.
 * Use this URL for send your MPF requests.
 * @type {string}
 */
const BACK_END_MPF_URL = getContextPath() + '/back-end-mpf'


function getContextPath() {
    return location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function refreshCurrentPage() {
    window.location.href = getContextPath();
}

/**
 * meaning of return int:
 * -1 : Unauthorized user
 * 0 : root
 * 1 : Authorised user
 *
 * @returns {number}
 */
function checkAuth() {
    let rsl;
    let loginHrefName = sessionStorage.getItem("user");
    if (loginHrefName === null) {
        rsl = -1;
    } else if (loginHrefName === "root") {
        rsl = 0;
    } else { // any other Authorised user.
        rsl = 1;
    }
    return rsl;
}

function getCurrentUser() {
    let rsl = sessionStorage.getItem("user");
    return (rsl === null) ? "guest" : rsl;
}

/* other util method */

// function substringFrom(String, start, charsSkipFromEnd) {
//     return String.substring(start, String.length - charsSkipFromEnd);
// }


/* manual script activation: for try js code */

// <button type="button" id="manual-script-run">Script test</button>

// $(function () {
//     $('#manual-script-run').click(() => {
//         // write script here
//     })
// });