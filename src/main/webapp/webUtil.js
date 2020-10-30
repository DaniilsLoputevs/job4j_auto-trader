/**
 * go straight to other HTML page.
 * @param String - name of HTML file with packages name.
 */
function goToHtml(String) {
    window.location.href = getContextPath() + "/" + String + ".html";
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

/* other util method */

// function substringFrom(String, start, charsSkipFromEnd) {
//     return String.substring(start, String.length - charsSkipFromEnd);
// }