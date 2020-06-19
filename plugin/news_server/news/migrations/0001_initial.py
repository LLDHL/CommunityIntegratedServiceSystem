# Generated by Django 3.0.5 on 2020-06-18 14:40

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='news',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('标题', models.CharField(max_length=200, unique=True)),
                ('图片', models.TextField()),
                ('内容', models.TextField(blank=True)),
                ('时间', models.DateField()),
            ],
            options={
                'verbose_name_plural': 'news',
                'db_table': 'news',
            },
        ),
    ]