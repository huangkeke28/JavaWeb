#如何批量执行测试方法
#(1) addtest
#可以把某一个脚本中的测试方法添加到测试套件
#(2) makesuit
#可以把一个类中所有的测试方法添加到测试套件中(测试方法指的是以test_开头)
#(3) testLoader
#可以把一个类中所有的测试方法添加到测试套件中(测试方法指的是以test_开头)
#(4) discover
#把一个文件夹,以某种命名规则的文件中所有的测试方法都添加到测试套件(测试方法指的是以test_开头)

#测试方法执行的顺序 0~9 A~Z a~z

#忽略测试用例的执行
#skipping

#断言是干什么的
#判断某一个结果和预期的结果是否一致

#HTML TestReport
#1需要先解决的问题
#(1)创建一个存放测试报告的文件夹 (2)命名问题:让每一个测试报告名称不一致
from selenium import webdriver

#错误截图

#数据驱动
#(1)安装ddt