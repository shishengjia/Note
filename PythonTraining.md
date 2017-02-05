#PythonTraining
---------------


##目录
* [在列表字典集合中根据条件筛选数据](#在列表字典集合中根据条件筛选数据)
* [为元组中的每个元素命名](#为元组中的每个元素命名)
* [统计序列中元素出现的频度](#统计序列中元素出现的频度)




在列表字典集合中根据条件筛选数据
---------------------------------

1.列表
-----
```python
data = [randint(-5, 5) for x in xrange(10)] # 生成范围在（-5,5）之间的10个数

data_2 = filter(lambda x: x >= 0, data) # 用filter函数筛选数据

data_3 = [x for x in data if x >= 0] # 用列表解析筛选数据，效率相对filter函数更高
print data
print data_2
print data_3
```

2.字典
-----
```python
dict = {x: randint(60, 100) for x in xrange(1, 11)} # 生成10个值在60-100之间的数据

dict_2 = {k: v for k, v in dict.iteritems() if v >= 80} # 用字典解析筛选数据

print dict
print dict_2
```

3.集合（类似列表）
-----
```python
s = {randint(-5, 5) for x in xrange(10)}

s_2 = {x for x in s if x % 3 == 0}

print s_2
```

为元组中的每个元素命名
-------------------------

1.使用相关变量标示序号位置
--------------------------
```python
NAME, AGE, SEX = xrange(3)  # 分别将0, 1, 2 分配给三个变量
student = ('shishengjia', 18, 'male')
print student[NAME], student[AGE], student[SEX]
```

2.使用namedtuple(注意其开销要稍大于普通tuple，即上一种方法)
--------------------------
```python
from collections import namedtuple

Student = namedtuple('Student', ['name', 'age', 'gender'])  # 创建实例,参数为类型名字以及各个字段名字

s = Student('shishengjia', 18, 'male')  # 创建实例
s_2 = Student(name='shishengjia', age=22, gender='male')  # 也可以这样创建

print s.name, s.age, s.gender # 访问就跟访问类的属性一样
print s_2.name, s_2.age, s_2.gender
```

namedtuple就是tuple的一个子类，在使用tuple的地方都可以使用namedtuple
```python
print isinstance(s, tuple) # True
```


统计序列中元素出现的频度
-------------------------

1.随机序列，找到出现次数最多的3个元素
---------------
```python
# 普通方法
from random import randint

data = [randint(0, 10) for _ in xrange(20)] 
data_2 = dict.fromkeys(data, 0) # 将随机生成的序列的值作为key，value设为0生成一个dict
for x in data:   # 统计每个元素出现的次数
    data_2[x] += 1
data_3 = sorted(data_2.iteritems(), key=lambda t: t[1], reverse=True)[:3] # 对dict根据value进行排序并取前3名
print data_3
```

```python
# 使用Counter
from random import randint
from collections import Counter

data = [randint(0, 10) for _ in xrange(20)] 
print Counter(data).most_common(3) 
```

2.统计文章中出现次数最多的10个单词
---------------
```python
from collections import Counter
import re

txt = open('test.txt').read()
c = Counter(re.split('\W+', txt)).most_common(10)  # re.split('\W+', txt)以非字母作为分割将文章拆散成单词组成的列表
print c
```
