function shortestPalindrome(s: string): string {
    
    for (let i = s.length - 1; i >= 0; i--) {
        if (isPalindrome(s, 0, i)) {
            let suffix: string = s.slice(i + 1);
            suffix = suffix.split('').reverse().join('');
            return suffix + s;
        }
    }
    return ''; 
}

function isPalindrome(s: string, leftIndex: number, rightIndex: number): boolean {
    while (leftIndex < rightIndex) {
        if (s[leftIndex] !== s[rightIndex]) {
            return false;
        }
        leftIndex++;
        rightIndex--;
    }
    return true;
}
