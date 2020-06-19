# -*- coding: utf-8 -*-
# author：albert time:2020/6/18

import urllib.request
from bs4 import BeautifulSoup
import re
import time
import pymysql as py


def sql(list):
    connect = py.connect(host='127.0.0.1', user='root', password='123456', database='news_server', charset='utf8')
    cursor = connect.cursor()
    for ii in list:
        print(ii)
        Title = ii['Title']
        Img = ii['Img']
        Url = ii['Url']
        Text = ii['Text']
        Date = ii['Date']
        sql = "insert into news(标题,图片,链接,内容,时间) values(%s, %s, %s, %s, %s);"
        try:
            cursor.execute(sql, (Title, Img, Url, Text, Date))
            connect.commit()
        except:
            print("已存在")
    # cursor.commit()
    # print(cursor.fetchall())
    cursor.close()
    connect.close()

url = 'http://news.cctv.com/'
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.103 Safari/537.36'}
response = urllib.request.urlopen(url)
# print(response.read().decode('utf-8'))

soup = BeautifulSoup(response, 'html.parser')
# print(soup)
list = []
for ahtml in soup.find_all('div', class_='silde'):
    dict = {}
    # print(ahtml)
    title = ahtml.find('h3').get_text().replace('\n', '')
    url = ahtml.find('a').get('href')
    # print(url)
    text = ahtml.find('p').get_text().replace('\n', '')
    img = ahtml.find('img', class_='lazy')
    rr = re.compile('p.*jpg')
    img = rr.findall(str(img))[0]
    dict['Title'] = title
    dict['Url'] = url
    dict['Text'] = text
    dict['Img'] = img
    dict['Date'] = time.strftime('%Y-%m-%d', time.localtime(time.time()))
    list.append(dict)
    print(dict)
print(list)
sql(list)

#
# data = '<img class="lazy" data-echo="//p4.img.cctvpic.com/photoAlbum/page/performance/img/2020/6/18/1592449843219_445.jpg" src="//p2.img.cctvpic.com/photoAlbum/templet/common/DEPA1561603549108607/18886_diandi.png" width="100%"/>'
# rr = re.compile('p.*jpg')
# print(rr.findall(data)[0])

