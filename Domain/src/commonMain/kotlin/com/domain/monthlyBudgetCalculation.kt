package com.domain


fun monthlyBudgetCalculation(data: Int): String{

    val food=(data*0.4)//40% on food
    val transport=(data*0.2)//transport fee of 20%
    val sub=(data*0.15)//digital subcription of 15%
    val academics=(data*0.1)//10% for academics supplies
    val total="[$food][$transport][$sub][$academics]"
    return total
}