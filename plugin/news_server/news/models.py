from django.db import models

# Create your models here.

class news(models.Model):
    标题 = models.CharField(max_length=250, unique=True)
    图片 = models.TextField()
    链接 = models.CharField(max_length=200)
    内容 = models.TextField(blank=True)
    时间 = models.DateField()

    #数据表

    class Meta:
        verbose_name_plural = "news"
        db_table = "news"

    def __str__(self):
        return self.标题