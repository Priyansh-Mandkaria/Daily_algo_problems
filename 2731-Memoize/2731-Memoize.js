// Last updated: 7/10/2025, 8:52:17 AM
/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    
    const cache = new Map(); // Cache to store results
    let callCount = 0; // Counter for how many times the function is actually called

    const memoizedFn = function(...args) {
        const key = JSON.stringify(args); // Use JSON.stringify to create a unique key for arguments
        if (!cache.has(key)) {
            callCount++; // Increment call count when the function is called
            cache.set(key, fn(...args)); // Store the result in the cache
        }
        return cache.get(key); // Return the cached result
    };

    return memoizedFn;
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */