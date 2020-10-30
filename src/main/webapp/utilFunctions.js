function getContextPath() {
    return location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function refreshCurrentPage() {
    window.location.href = getContextPath();
}

function getBackEndUrl() {
    return getContextPath() + '/back-end';
}
function getBackEndMPFUrl() {
    return getContextPath() + '/back-end-mpf';
}

// function substringFrom(String, start, charsSkipFromEnd) {
//     return String.substring(start, String.length - charsSkipFromEnd);
// }