# Generated by Django 3.0.5 on 2020-06-18 15:04

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('news', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='news',
            name='图片',
            field=models.ImageField(upload_to='img/'),
        ),
    ]