function record(url, value, pageSize) {
    const pageNo = value.split("/")[0].trim();
    location.href = url + "pageNo=" + pageNo + "&pageSize=" + pageSize;
}
