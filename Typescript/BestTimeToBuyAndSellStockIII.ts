function maxProfit(prices: number[]): number {

    let firstBuy:number = -100000, secondBuy:number = -100000;
    let firstSell:number = 0, secondSell:number = 0;

    for(let i = 0; i < prices.length;i++){
        firstBuy = Math.max(firstBuy, -prices[i]);
        firstSell = Math.max(firstSell, firstBuy+prices[i]);
        secondBuy = Math.max(secondBuy, firstSell-prices[i]);
        secondSell = Math.max(secondSell, secondBuy+prices[i]);
    }

    return secondSell;
    
};
