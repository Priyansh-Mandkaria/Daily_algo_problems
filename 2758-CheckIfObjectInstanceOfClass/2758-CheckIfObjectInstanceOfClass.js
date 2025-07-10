// Last updated: 7/10/2025, 8:52:14 AM
/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj == null || classFunction == null) return false;
    if (typeof classFunction !== 'function') return false;
    let proto = Object.getPrototypeOf(obj);
    while (proto !== null) {
        if (proto === classFunction.prototype) return true;
        proto = Object.getPrototypeOf(proto);
    }  
    return false; 
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */