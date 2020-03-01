# BankDefaulter_MapReduce

统计某银行信用卡违约用户数量

数据集见文件UCI_Credit_Card.csv
 
违约规则：AY_1～PAY_6：PAY_1为2005年9月的还款情况；PAY_2为2005年8月的还款情况；…；PAY_6为2005年4月的还款情况。BILL_AMT1～BILL_AMT6和PAY_AMT1～PAY_AMT6中数字标识的含义也是如此。

PAY_1～PAY_6的取值含义为：0 = 及时还；1 = 还款延迟一个月；2 = 还款延迟两个月；3 = 还款延迟三个月；…；9 = 还款延迟九个月及以上。

每月的支付金额PAY_AMT不能低于银行规定的当月最低还款额，否则就是违约。如果支付金额PAY_AMT大于上月账单金额BILL_AMT则视为及时还，剩余金额存入信用卡留做下次消费；如果支付金额小于上月账单金额但高于最低还款额则视为延迟还款。

要求:

  在Hadoop平台编程实现统计银行违约用户数量
  
实现:

  在IDEA中编写好业务代码,使用mvn将程序打成jar包,上传到hdoop平台之后运行
  
  其中1为违约用户数量, 共有6636位用户违约
