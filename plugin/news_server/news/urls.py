# -*- coding: utf-8 -*-
# author：albert time:2020/6/18
from django.urls import path
from . import views

urlpatterns = [
    path('', views.show_news)
]