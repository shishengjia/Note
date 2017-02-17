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
* [同时迭代多个可迭代对象](#同时迭代多个可迭代对象)
* [拆分含有多个分隔符的字符串](#拆分含有多个分隔符的字符串)
* [判断字符串a是否以b开头或结尾](#判断字符串a是否以b开头或结尾)
* [调整文本中文本格式](#调整文本中文本格式)
* [连接字符串](#连接字符串)
* [对字符串左右居中对齐](#对字符串左右居中对齐)
* [去掉字符串不需要的字符](#去掉字符串不需要的字符)
* [读写文本文件](#读写文本文件)
* [设置文件的缓冲区大小](#设置文件的缓冲区大小)
* [访问文件状态](#访问文件状态)
* [使用临时文件](#使用临时文件)
* [读写csv数据](#读写csv数据)
* [读写json数据](#读写json数据)
* [处理excel文件](#处理excel文件)


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
 
同时迭代多个可迭代对象
------------------------
 **1.并行迭代**
 ```python
 # 统计所有学生三门课的成绩综合
 # 每一次迭代zip函数返回一个元组,如果zip中每个可迭代对象长度不同，取最小长度为标准，多余的内容舍去
 Math = [randint(60, 100) for _ in xrange(6)]
Chinese = [randint(60, 100) for _ in xrange(6)]
Music = [randint(60, 100) for _ in xrange(6)]
total = []
for math,chinese,music in zip(Math, Chinese, Music):  #对元组进行拆包，依次对应三个成绩
    total.append(math + chinese + music)
print total
 ```
 
 **2.串行**
 ```python
 # 统计三个班分数不及格的学生人数
 # chain函数依次将可迭代对象串联起来
score_1 = [randint(0,100) for _ in xrange(49)]
score_2 = [randint(0,100) for _ in xrange(43)]
score_3 = [randint(0,100) for _ in xrange(35)]
count = 0
for x in chain(score_1, score_2, score_3):
    if x < 60:
        count += 1
print 'the number of unpassed student:%s' % count
 ```
 
拆分含有多个分隔符的字符串
-------------------------
 在只有一个分隔符的时候，`split`函数的效率是最高的
 **1.最简单的方式就是使用正则表达式**
 ```python
 import re
 
 s = 'abc,de/fg\thi;jk..lmn'
 print re.split('[,/\t.;]+', s)
 ```
 **2.用循环来依次分割（效率低，主要看下思路）**
 ```python
 def mySplit(s, ds):
    res = [s]
    for d in ds:  # 依次迭代所有分隔符
        # 这里map函数的返回值将是多维列表
        # 所以使用t来拓展每一次的处理结果
        t = []
        map(lambda x:t.extend(x.split(d)), res)
        res = t
    return [x for x in res if x]  # 防止字符串中有两个相同分隔符导致结果中有空字符的情况

s = 'abc,de/fg\thi;jk..lmn'
print mySplit(s, ',/\t.;')
 ```
 
判断字符串a是否以b开头或结尾
---------------------------
**使用`startswith()`和`endswith()`即可完成，这里以修改Linux下指定文件的权限为例**
```python
import os,stat

#  首先找到当前目录下所有以.cpp结尾的文件
file_cpp = [files for files in os.listdir('.') if files.endswith('.cpp')]
#  对每一个文件修改权限，添加用户可执行权限，os.stat(x).st_mode获得与权限相关的一个值，
#  再与用户可执行的掩码进行或运算，获得用户可执行权限，最后使用chmod进行权限的修改
#  S_IXUSR X代表可执行，USR代表用户
map(lambda x:os.chmod(x, os.stat(x).st_mode | stat.S_IXUSR), file_cpp )

```

调整文本中文本格式
------------------
```python
# 在正则表达式中使用()分别将年月日对应的部分括起来，使其成为捕获组，能够进行操作。（默认顺数从左到右，为1,2,3）
# ?P<>即为取别名 
re.sub('(?P<year>\d{4})-(?P<month>\d{2})-(?P<day>\d{2})', '\g<month>/\g<day>/\g<year>', open('data.log').read())
```


连接字符串
------------------
**1.直接使用`+`号**<br>
事实上调用的是str的__add__方法，但这种方法每一次都会产生一个临时变量，还要释放，开销比较大
```python
s = ['<123>', '<345>', '<1>', '<908>']
for x in s:
    strs += x
    print strs
"""
<123>
<123><345>
<123><345><1>
<123><345><1><908>
"""
```
**2.使用join方法**
`str.join(iterable) `,str是各个字符串之间的分隔符，参数是一个可迭代对象<br>
这里对参数进行字符串转换，防止错误，使用的是生成器表达式，相对列表解析开销小
```python
s = ['<123>', '<345>', '<1>', '<908>']
''.join((str(x) for x in s))
```

对字符串左右居中对齐
-------------------
**1.使用`str.ljust()`,`str.rjust()`,`str.center()`**<br>
```python
d = {
   'HearthStone' : 128,
   'OverWatch' : 198,
   'WOW' : 30
 }
 # 取的最长的键的长度
 width_max = max(map(len, d.keys()))
 
 for x in d:
   print x.ljust(width_max),':',d[x]
```

**2.使用`format`**<br>
`<`,`^`,`>`分别表示左，中，右对齐
```python
d = {
   'HearthStone' : 128,
   'OverWatch' : 198,
   'WOW' : 30
 }
 
 # 取的最长的键的长度
 width_max = max(map(len, d.keys()))
 
 for x in d:
   print format(x, '<%s' % width_max),':',d[x]

```


去掉字符串不需要的字符
---------------------
**1.`str.strip()`,`str.lstrip()`,`str.rstrip()`,参数为需要去掉字符(可以多个)**<br>
缺点是不能去掉中间的字符
```python
s = '----abc+++abc-----'

s.strip('-')
# 'abc+++abc'

s.lstrip('-')
# 'abc+++abc-----'

s.rstrip('-')
# '----abc+++abc'
```

**2.切片操作**<br>
这种方法比较局限，需要实现知道所去除字符的位置
```python
s2 = 'abc+def'

s2[:3] + s2[4:]
# 'abcdef'
```

**3.str.replace**<br>
缺点是一次只能去掉一种字符
```python
x = '--a---a---'

x.replace('-', '')
# 'aa'
```

**4.使用正则表达式**
```python
import re

s = '--+++abc+++---abc'

re.sub('[+-]', '', s4)
# 'abcabc'
```

**5.str.translate**
```python
import string

s = 'abc---xyz'
# 可以用来作字符射，传入映射表，string.maketrans('abcxyz', 'xyzabc')
s.translate(string.maketrans('abcxyz', 'xyzabc'))
# 'xyz---abc'

# 也可以用来删除字符,映射表为None，传入删除字符集
s = '---abc+++abc'
s.translate(None, '-+' )
# 'abcabc'
```

读写文本文件
---------------
在Python2中定义字节字符串,'abc',但是在Python3中，前面要加个b，b'abc'<br>
在Python2中定义unicode字符串,u'你好',但是在Python3中，前面不需要加u，'你好'<br>
**1.Python2下的文本读写**<br>
写入文件前对unicode编码，读入文件后对二进制字符解码
```python
f = open('test.txt', 'w')
s = u'你好'
f.write(s.encode('gbk'))  # 对unicode编码
f.close()

f = open('test.txt', 'r')
t = f.read()
print t.decode('gbk')  # 以相同格式解码
```

**2.Python3下的文本读写**<br>
open函数指定`t`的文本模式(默认为t,可以省略)，endcoding指定编码格式
```python
f = open('test.txt', 'wt', encoding='utf8')
f.write('你好')
f.close()

f = open('test.txt', 'rt', encoding='utf8')
s = f.read()
print(s)
```

设置文件的缓冲区大小
--------------------
文件的默认缓冲区大小为`4096`个字节(跟设备有关)，当写入的数据达到`4096`个字节，进行一次写操作，可以使用`tail -f filename`来监听文件的写入。<br>
文件缓冲可分为:
 * 全缓冲,`open`函数的`buffering`值为大于`1`的整数n，n即为缓冲区的大小
 * 行缓冲,`open`函数的`buffering`值为`1`,每遇到一个换行符'\n',进行一次写入
 * 无缓冲,`open`函数的`buffering`值为`0`,每一次输入都会被直接写入
 
```python
f = open('demo.txt', 'w', buffering = 2048)
f = open('demo.txt', 'w', buffering = 1)
f = open('demo.txt', 'w', buffering = 0)
```

访问文件状态
------------
**1.系统调用**<br>
os模块下的三个系统调用，`stat`,`fstat`,`lstat`。<br>
`fstat`需要传入一个打开的文件描述符，其余与`stat`类似。<br>
使用`lstat`不会跟随符号链接,获取的是符号链接文件的状态,其余则与`stat`类似
```python
import os
import stat
import time

state = os.stat('data.log')
# posix.stat_result(st_mode=33188, st_ino=311306, st_dev=64769L, st_nlink=1, st_uid=0, st_gid=0, st_size=22, st_atime=1487254706,
# st_mtime=1487254706, st_ctime=1487254706)

stat.S_ISDIR(state.st_mode)
# 不是文件夹 False

stat.S_ISREG(state.st_mode)
# 是普通文件 True

state.st_mode & stat.S_IWUSR # 跟用户写权限的掩码相与，值大于0即为拥有该权限，判断其他权限亦然

time.localtime(state.st_atime) # 获得最后访问时间
# time.struct_time(tm_year=2017, tm_mon=2, tm_mday=16, tm_hour=22, tm_min=18, tm_sec=26, tm_wday=3, tm_yday=47, tm_isdst=0)

state.st_size # 文件大小
```

**2.快捷函数**<br>
`os.path`下的一些函数,需要注意的是该方法无法获得用户的权限
```python
import os

os.path.isfile('data.log') # 判断是否是文件

time.localtime(os.path.getatime('data.log'))

os.path.getsize('data.log')

```

使用临时文件
--------------
临时文件不用命名，收集的数据将被临时存储到外部存储，且关闭后会自动删除<br>
**1.TemporaryFile**<br>
默认参数，`TemporaryFile(mode='w+b', bufsize=-1, suffix='', prefix='tmp', dir=None)`，`bufsize=-1` 表示采用默认缓存<br>
```python
f = TemporaryFile()
f.write('a' * 10000)
f.seek(0) # 文件指针指向文件头部
f.read(100) # 根据需要向内存中读入一部分内容
```

**2.NamedTemporaryFile**<br>
`NamedTemporaryFile(mode='w+b', bufsize=-1, suffix='', prefix='tmp', dir=None, delete=True)`,`delete`参数默认为`True`，即关闭后将自动删除文件，设置为`False`后将不被删除，其余则与`TemporaryFile`相同<br>
```python
f = NamedTemporaryFile()
print f.name # 通过f.name可以知道临时文件的目录及名字
# '/tmp/tmpHTdMVl'

```

读写csv数据
--------------
```python
from urllib import urlretrieve

# 下载数据后存储到pingan_origin.csv文件中
urlretrieve('http://table.finance.yahoo.com/table.csv?s=000001.sz', 'pingan_origin.csv')
```
写一个python脚本处理数据，获取2017年的相关数据
```python
import csv

with open('pingan_origin.csv', 'rb') as rf:
    reader = csv.reader(rf)
    with open('pingan_2017.csv', 'wb') as wf:
        writer = csv.writer(wf)
        header = reader.next()  
        writer.writerow(header)  # 先写入头部标识数据，Date,Open,High,Low,Close,Volume,Adj Close
        for row in reader:  #  从剩下的实际数据中筛选出2017年的数据并写入文件
            if row[0] >= '2017-01-01' and row[0] <= '2017-12-31':
                writer.writerow(row)
```

读写json数据
------------
```python
import json

l = [1, 2, {'name':'shishengjia', 'age':15}]  
json.dumps(l) # python对象转化为jason字符串
# '[1, 2, {"age": 15, "name": "shishengjia"}]'

d = {'a':None, 'c':'hello', 'b':3}
# separators参数指定分隔符逗号和分号，周围的空格省去，sort_keys参数设为True指定结果按键值大小排列
json.dumps(d, separators=[',', ':'], sort_keys=True)
# '{"a":null,"b":3,"c":"hello"}'

d_2 = '[1, 2, {"age": 15, "name": "shishengjia"}]'
json.loads(d)  # jason字符串转化为python对象
# [1, 2, {u'age': 15, u'name': u'shishengjia'}]

l = {'b':1, 'a':2}
# 使用dump函数将python对象转化为json字符串后写入文件，同理load函数则为从文件中读取相应python对象
with open('demo.json', 'wb') as f:
    json.dump(l, f)
    
with open('demo.json', 'rb') as f:
    s = json.load(f)
    print s # {u'a': 2, u'b': 1}

```

处理excel文件
---------------
```python
#coding:utf8
import xlrd, xlwt

rbook = xlrd.open_workbook('test.xlsx')
rsheet = rbook.sheet_by_index(0)  # 根据索引找到第一张工作表

nc = rsheet.ncols  # 工作表列数
rsheet.put_cell(0, nc, xlrd.XL_CELL_TEXT, u'Total', None) # 在第nc列添加'Total'表头

for row in xrange(1, rsheet.nrows):  # 从第二行开始遍历
    t = sum(rsheet.row_values(row, 1))  # 每一行第二列后面的数据相加得到总分
    rsheet.put_cell(row, nc, xlrd.XL_CELL_NUMBER, t, None) # 在第nc列添加总分数据


wbook = xlwt.Workbook()  
wsheet = wbook.add_sheet(rsheet.name)  # 新的文件里添加一张工作表
style = xlwt.easyxf('align: vertical center, horizontal center') # 设置样式，垂直居中，水平居中

# 将所有数据写入工作表
for r in xrange(rsheet.nrows):
    for c in xrange(rsheet.ncols):
        wsheet.write(r, c, rsheet.cell_value(r, c), style)

wbook.save('output.xls')  # 保存这个文件
```
