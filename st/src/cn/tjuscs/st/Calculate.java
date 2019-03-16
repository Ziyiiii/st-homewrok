package cn.tjuscs.st;

public class Calculate {
	boolean canGiven = false ;
	//canGiven 代表是否能拿出给定数字的钱数 如果返回true 则代表能  false则代表不能 
	int[] ownMoney = {50,20,5,5,1,1,1};
	//将所拥有的钱数以数组形式存储在ownMoney中。
	public boolean given ( int money) {
		if ( money > 83 ) {
		//简单过滤超过手中最大额度理所当然返回false 
			// 可以通过遍历数组求得最大额度 这里显而易见为83 
			canGiven = false ;
		}else {
			for ( int i = 0 ; i < ownMoney.length ; i ++ ) {
				//从金额大的面值开始比较逐次相减。
				if ( money >= ownMoney[i]) {
					money -= ownMoney[i];
				}
				//成功减到0 证明能拿出，结束循环
				if ( money == 0 ) {
					break ;
				}
			}
		}
		if (money == 0) {
			canGiven = true ;
		}
		return canGiven;
	}

}
