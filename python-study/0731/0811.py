# coding=utf-8
from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")

driver.maximize_window()

# driver.find_element_by_id("kw").send_keys("三十二亿")
# driver.find_element_by_id("su").click()
#
# time.sleep(3)
# driver.find_element_by_id("kw").clear()
# driver.find_element_by_id("kw").send_keys("三十而已")
# driver.find_element_by_id("su").click()
driver.find_element_by_id("kw").send_keys("乃万")
driver.find_element_by_id("su").click()
#智能等待
driver.implicitly_wait(10)
driver.find_element_by_link_text("乃万_百度百科").click()

#打印title
title = driver.title
print(title)

url = driver.current_url
print(url)


#浏览器的缩小
driver.minimize_window()
time.sleep(6)
#设置浏览器的宽和高
driver.set_window_size(400,800)
time.sleep(6)
#浏览器的滚动条拖到最底端
js="var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
#text输入元素的文本信息
time.sleep(3)
driver.quit()
