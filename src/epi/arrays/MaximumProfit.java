package epi.arrays;

import java.util.List;

import meta.Problem;

public class MaximumProfit {
	
	@Problem(code = "6.6", name = "Buy and cell a stock once")
	public static double computeMaximumProfit(List<Double> prices) {
		Double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
		for(Double price : prices) {
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(price, minPrice);
		}
		
		return maxProfit;
	}

}
