const getUSDtoIDR = (usd) => {
    return usd*16800;
}

const getJPYtoIDR = (jpy) => {
    return jpy*107;
}

module.exports = {
    getUSDtoIDR,
    getJPYtoIDR
}