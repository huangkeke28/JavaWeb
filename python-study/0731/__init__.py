# coding = utf-8
from selenium import webdriver
import time


driver = webdriver.Firefox()

driver.get("http://www.baidu.com/")
 
driver.maximize_window()


#class定位
# driver.find_element_by_class_name("s_ipt").send_keys("月月")
# driver.find_element_by_id("su").click()

#link定位
# driver.find_element_by_link_text("高考加油").click()
# driver.find_element_by_partial_link_text("高考").click()
#tag name定位
# driver.find_element_by_tag_name("input").send_keys("三十而已")
# driver.find_element_by_id("su").click()
#xpath定位

time.sleep(3)
driver.quit()