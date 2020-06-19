from django.shortcuts import render

# Create your views here.

from django.http import JsonResponse
from django.core import serializers
import json
from .models import news

def show_news(request):
    if request.method == "POST":
        Date = str(request.POST['Date'])
        # Date = '2020-06-18'
        内容 = news.objects.filte(时间=Date)  #从数据库获取数据QuerySet类型
        内容 = json.loads(serializers.serialize("json", 内容))  #QuerySet类型转json
        data = {'status': 1, 'data': 内容}
        return JsonResponse(data)
    else:
        return JsonResponse({'status': 0, 'data': 'bad request'})
