function minPatches(nums: number[], n: number): number {
    let miss = 1, added = 0, i = 0;
    
    while (miss <= n) {
        if (i < nums.length && nums[i] <= miss) {
            miss += nums[i++];
        } else {
            miss += miss;
            added++;
        }
    }
    
    return added;
}
