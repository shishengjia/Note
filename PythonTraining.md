#PythonTraining
---------------


##目录
* [在列表字典集合中根据条件筛选数据](#在列表字典集合中根据条件筛选数据)
* [为元组中的每个元素命名](#为元组中的每个元素命名)
* [统计序列中元素出现的频度](#统计序列中元素出现的频度)
* [对字典进行排序](#对字典进行排序)
* [找到多个字典中的公共建](#找到多个字典中的公共建)
* [有序的字典](#有序的字典)
* [历史记录功能](#历史记录功能)
* [实现可迭代对象和迭代器对象来优化数据的加载](#实现可迭代对象和迭代器对象来优化数据的加载)
* [使用生成器函数实现可迭代对象](#使用生成器函数实现可迭代对象)
* [进行反向迭代及实现反向迭代](#进行反向迭代及实现反向迭代)
* [对迭代器作切片操作](#对迭代器作切片操作)


在列表字典集合中根据条件筛选数据
---------------------------------

**1.列表**
```python
data = [randint(-5, 5) for x in xrange(10)] # 生成范围在（-5,5）之间的10个数

data_2 = filter(lambda x: x >= 0, data) # 用filter函数筛选数据

data_3 = [x for x in data if x >= 0] # 用列表解析筛选数据，效率相对filter函数更高
print data
print data_2
print data_3
```

**2.字典**
```python
dict = {x: randint(60, 100) for x in xrange(1, 11)} # 生成10个值在60-100之间的数据

dict_2 = {k: v for k, v in dict.iteritems() if v >= 80} # 用字典解析筛选数据

print dict
print dict_2
```

**3.集合（类似列表）**
```python
s = {randint(-5, 5) for x in xrange(10)}

s_2 = {x for x in s if x % 3 == 0}

print s_2
```

为元组中的每个元素命名
-------------------------

**1.使用相关变量标示序号位置**
```python
NAME, AGE, SEX = xrange(3)  # 分别将0, 1, 2 分配给三个变量
student = ('shishengjia', 18, 'male')
print student[NAME], student[AGE], student[SEX]
```

**2.使用`namedtuple`(注意其开销要稍大于普通`tuple`，即上一种方法)**
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

**1.随机序列，找到出现次数最多的3个元素**
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

**2.统计文章中出现次数最多的10个单词**
```python
from collections import Counter
import re

txt = open('test.txt').read()
c = Counter(re.split('\W+', txt)).most_common(10)  # re.split('\W+', txt)以非字母作为分割将文章拆散成单词组成的列表
print c
```

对字典进行排序
-------------------------
**1.先用`zip`函数将字典转化成元组列表，再进行排序、**
```python
from random import randint

d = {x: randint(60, 100) for x in 'abcxyz'}
z = zip(d.values(), d.keys()) 
print sorted(z, reverse=True)
```

**2.利用`sorted`函数的`key`参数**
```python
from random import randint

d = {x: randint(60, 100) for x in 'abcxyz'}
print sorted(d.items(), key=lambda x: x[1], reverse=True) # 取出item里的第二个值也就是value作为比较依据
```


找到多个字典中的公共建
-------------------------
```python
from random import randint, sample

# 用randin和sample函数生成三个（3-6个人分别进球1-4个球）字典
s1 = {x: randint(1, 4) for x in sample('abcdefg', randint(3, 6))}
s2 = {x: randint(1, 4) for x in sample('abcdefg', randint(3, 6))}
s3 = {x: randint(1, 4) for x in sample('abcdefg', randint(3, 6))}

#先用map函数将3个字典分别转化成建的集合，再用reduce函数依次将3个集合作与运算，即得到每轮都进球的人 
print list(reduce(lambda a, b: a & b, map(dict.viewkeys, [s1, s2, s3])))
```

有序的字典
------------
使用orderedDict来记录选手答题的结果
```python
from random import randint
from time import time
from collections import OrderedDict

players = list('abcd') # 选手姓名列表
start = time() # 开始的时间
result = OrderedDict() # 使用OrderedDict来构建有序的dict
for i in xrange(4):
    raw_input() # 阻塞，通过输入来解除
    end = time() # 结束的时间
    player = players.pop(randint(0, 3 - i)) # 随机产生一个选手，并将对应的名字从list里pop
    print i + 1, player, end - start
    result[player] = (i + 1, end - start) # 将选手作为建，排名和时间组成值进行存储
print '--------------'
for k, v in result.iteritems():
    print k, v
```

历史记录功能
---------------
猜数字游戏，记录用户之前所输入的5个数字,使用deque双端队列来记录数据
```python
from random import randint
from collections import deque
import pickle

number = randint(0, 100) # 随机生成一个数字

def guess(k):
    if k == number:
        print 'Right!'
        return True
    elif k < number:
        print '%s is less than the number' % k
    else:
        print '%s is large than the number' % k
    return False
    
# 利用pickle函数加载历史记录对象，如果没有则新建一个对象并存储
try:
    history = pickle.load(open('history'))  
except Exception:
    history = deque([], 5)  # 建立一个空的长度为5的队列
    pickle.dump(history, open('history', 'w'))
    
while True:
    line = raw_input('Plaese input a number\n')  # 用户输入
    if line.isdigit(): 
        k = int(line)
        history.append(k)  # 添加到历史记录中
        if guess(k):
            pickle.dump(history, open('history', 'w')) #  保存历史记录
            break
    elif line == 'history':  #  用户输入history，则打印记录
        print list(history)
    pickle.dump(history, open('history', 'w'))  #  异常退出也保存历史记录
```

实现可迭代对象和迭代器对象来优化数据的加载
--------------------------------
```python
# -*- encoding: utf-8 -*-
from collections import Iterable, Iterator
import requests
_author_ = 'shishengjia'
_date_ = '30/01/2017 16:17'

"""
采用这种方法，天气的信息将会逐一返回，而不是获取所有数据后再一起返回，提高了效率
"""


class WeatherIterator(Iterator):
    """
    天气迭代器
    """
    def __init__(self, cities):
        self.cities = cities
        self.index = 0

    def get_weather(self, city):
        """
        获取城市天气
        :param city:
        """
        r = requests.get(u'http://wthrcdn.etouch.cn/weather_mini?city=' + city)
        data = r.json()['data']['forecast'][0]
        return '%s: %s , %s' % (city, data['low'], data['high'])

    def next(self):
        """
        重写next方法，返回一个城市的天气信息
        """
        if self.index == len(self.cities):
            raise StopIteration
        city = self.cities[self.index]
        self.index += 1
        return self.get_weather(city)


class WeatherIterable(Iterable):
    def __init__(self, cities):
        self.cities = cities
    def __iter__(self):
        """
        重写__iter__方法，返回一个城市天气的迭代器
        """
        return WeatherIterator(cities)


cities = [u'北京', u'武汉', u'上海', u'宁波']
# for循环中，将会调用WeatherIterable的__iter__方法构造迭代器，再调用迭代器的next方法返回值传给x
for x in WeatherIterable(cities):
    print x

```

使用生成器函数实现可迭代对象
-----------------------------
```python
# 实现一个可迭代对象的类，迭代出给定范围内所有素数

class PrimeNumber:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def is_prime_number(self, k):
        """
        判断是否是素数
        """
        if k < 2:
            return False
        else:
            for i in xrange(2, k):
                if k % i == 0:
                    return False
            return True

    def __iter__(self):
        """
        重写__iter__方法，使其为生成器
        """
        for i in xrange(self.start, self.end + 1):
            if self.is_prime_number(i):
                yield i

for x in PrimeNumber(1, 100):
    print x
```
进行反向迭代及实现反向迭代
------------------------
**1.进行反向迭代**
```python
# 这种方法虽然将列表反向迭代了，但缺点是是改变了原始列表
l = [1,2,3,4,5]
l.reverse()
```

```python
# 使用切片操作，缺点是会生成一个等大的列表，消耗空间
l = [1,2,3,4,5]
l[::-1]
```

```python
# 使用reversed()函数，生成一个反向迭代器，与iter()函数生成的迭代器刚好相反
l = [1,2,3,4,5]
for x in reversed(l):
    print x
```

**2.实现反向迭代**
 实际上，`reversed()`函数调用了对象的`__reversed__`，而`iter()`函数调用了对象的`__iter__`，所以，可以自定义一个能够正向迭代和反向迭代的类
 ```python
class FloatRange:
    def __init__(self, start, end, step=0.1):  # 间隔默认为0.1
        self.start = start
        self.end = end
        self.step = step

    def __iter__(self):  # 正向迭代
        x = self.start
        while x <= self.end:  # 使用生成器完成迭代的功能
            yield x
            x += self.step

    def __reversed__(self):  # 反向迭代
        x = self.end
        while x >= self.start:
            yield x
            x -= self.step

for x in FloatRange(1.0, 4.0, 0.2):  # __iter__函数会自动调用，不用显示调用该函数
    print x

for x in reversed(FloatRange(1.0, 4.0, 0.2)):
    print x
 ```
 
 
 对迭代器作切片操作
 --------------------
 例子，取出文本文件中指定行数的内容
 ```python
 # 使用readlines方法噶能够实现该要求，但是缺点也很明显，他会一次性读取文件的所有内容，当文件很大的时候是不可取的
 f = open('test.txt')
line = f.readlines()
print line[0:3]
# 需要注意的是当执行完上述操作后，文件的指针已经移动，下次操作时需要将指针置为文件起始位置
 f.seek(0)
 ```
 
 ```python
 # 使用islice
f = open('test.txt')
for line in islice(f, 4, 8): # 需要读到末尾的话就讲8改为None
    print line
print '-----------------'
f = open('test.txt')  # 需要注意的是在经过切片后，f对象是有损耗的，即上面前8行的内容将会消失，再次操作需要重新申请一个f对象
for line in f:
    print line
 ```
