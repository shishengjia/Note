
#使用的Python版本是3.5.2,内容参考[廖雪峰大神的Python教程](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000)
##目录
 * [缩进和注释](#缩进和注释)
 * [输入输出](#输入输出)
 * [数据类型和变量](#数据类型和变量)
 * [list和tuple](#list和tuple)
 * [循环](#循环)
 * [dict和set](#dict和set)
 * [函数](#函数)
 * [高级特性](#高级特性)
    * [切片](#切片)
    * [迭代](#迭代)
    * [列表生成式](#列表生成式)
    * [生成器](#生成器)
    * [迭代器](#迭代器)
 * [函数式编程](#函数式编程)
    * [高阶函数](#高阶函数)
    * [map和reduce](#map和reduce)
    * [filter函数](#filter函数)
    * [sorted函数](#sorted函数)
    * [返回函数](#返回函数)
    * [匿名函数](#匿名函数)
    * [装饰器](#装饰器)
    * [偏函数](#偏函数)
 * [面向对象编程](#面向对象编程)
  
  
缩进和注释
----------
按照约定俗成的管理，编写Python代码时应该始终坚持使用**4个空格**的缩进。<br>
代码或注释中需要中文时，需要在开头声明`#coding=utf-8`<br>
单行注释:以`#`开头<br>



输入输出
------------
用`print()`在括号中加上字符串，就可以向屏幕上输出指定的文字
```python
print('hello, world')
```
`print()`函数也可以接受多个字符串，用逗号“,”隔开,打印时依次打印每个字符串，遇到逗号“,”会输出一个空格
```python
print('The quick brown fox', 'jumps over', 'the lazy dog')
#The quick brown fox jumps over the lazy dog
```
打印整数
```python
print('100 + 200 =', 100 + 200)
#100 + 200 = 300
print(10/2) #两个整数相除，结果是浮点数 5.0
print(2**3) #2的3次方 8
print(10 // 3) # 取整 3
print(10 % 3) # 取余 1
```
`input()`可以让用户输入字符串，并存放到一个变量里，另外里面添加字符串则会变为提示信息显示出来
```python
name = input('Please enter your name:\n')
print('ok your name is',name)
```

数据类型和变量
-------------
**整数**<br>
Python可以处理任意大小的整数，当然包括负整数，直接打印，没有什么像C一样的格式要求。<br>
**浮点数**<br>
也称为小数。整数和浮点数在计算机内部存储的方式是不同的，整数运算永远是精确的（除法也是精确的！），而浮点数运算则可能会有四舍五入的误差。<br>
**字符串**<br>
以`''`或`""`括起来的文本。<br>
如果`'`本身也是一个字符，那就可以用`""`括起来。
```python
print("I'm shishengjia")
#I'm shishengjia
```
如果字符串内部既包含`'`又包含`"`,可以用转义字符`\`来标识
```python
print("I\'m \"shishengjia\" ")
#I'm "shishengjia" 
```
如果字符串里面有很多字符都需要转义，就需要加很多`\`，为了简化，Python还允许用`r''`表示`''`内部的字符串默认不转义`\`
```python
print('\\\t\\')
#\	\
print(r'\\\t\\')
#\\\t\\
```
如果字符串内部有很多换行，用`\n`写在一行里不好阅读，为了简化，Python允许用`'''...'''`的格式表示多行内容。
```python
print ('''line1
line2
line3''')
#line1
#line2
#line3
```
**布尔值**<br>
```python
print(True)
#True
print(not True)
#False
print(True and False)
#False
print(True or False)
#True
```
**空值**<br>
空值是Python里一个特殊的值，用`None`表示。`None`不能理解为0，因为0是有意义的，而`None`是一个特殊的空值。
```python
print(None)
#None
```
**变量**<br>
在Python中，等号`=`是赋值语句，可以把任意数据类型赋值给变量，同一个变量可以反复赋值，而且可以是不同类型的变量
```python
a = 123 # a是整数
print (a)
a = 'ABC' # a变为字符串
print (a)
```
这种变量本身类型不固定的语言称之为动态语言，与之对应的是静态语言。静态语言在定义变量时必须指定变量类型，如果赋值的时候类型不匹配，就会报错。例如Java是静态语言。
```python
a = 'ABC'
b = a
a = 'XYZ'
print(a,b)
#XYZ ABC
```
  * 执行a = 'ABC'，解释器创建了字符串'ABC'和变量a，并把a指向'ABC'：
  * 执行b = a，解释器创建了变量b，并把b指向a指向的字符串'ABC'：
  * 执行a = 'XYZ'，解释器创建了字符串'XYZ'，并把a的指向改为'XYZ'，但b并没有更改：
  * 所以，最后打印变量b的结果自然是'ABC'了。<br>
  
**常量**<br>
在Python中，通常用全部大写的变量名表示常量.
```python
PI = 3.1415926
```
但事实上`PI`仍然是一个变量，Python没有任何机制保证`PI`不会被改变，所以，用全部大写的变量名表示常量只是一个习惯上的用法，如果你一定要改变变量PI的值，也没人能拦住你。<br>
**字符串和编码**<br>
[点此](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/001431664106267f12e9bef7ee14cf6a8776a479bdec9b9000)<br>
**格式化输出**<br>
采用的格式化方式和C语言是一致的，用`%`实现.
  * %d	整数
  * %f	浮点数
  * %s	字符串
  * %x	十六进制整数
```python
print('Name:%s Age:%d' % ('shishengjia',22))
#Name:shishengjia Age:22
```

list和tuple
--------------
**list**
```python
#coding=utf-8
Games = ['LOL','CS:G0','Overwatch']
print(Games) #打印数组
print('The length of Games is %d' % (len(Games))) #计算数组长度
print(Games[1]) #获取数组元素
print(Games[-1]) #倒序获取数组元素
Games.append('HearthStone') #追加元素到末尾
Games.insert(1,'WOW') #把元素插入到指定的位置
Games.pop() #删除list末尾的元素
Games.pop(0) #删除指定位置的元素
Games[0]='LOL2'#替换指定元素
```
list里面的元素的数据类型也可以不同
```python
Games = ['LOL',123,'Overwatch']
```
list元素也可以是另一个list
```python
Games = ['LOL',[123,456],'Overwatch']
print(Games[1][1]) #访问456元素
#另一种写法
number = [123,456]
Games = ['LOL',number,'Overwatch']
print(Games[1][1]) #访问456元素
print(number[1]) #访问456元素
```
实际上，Games可以看作是一个二维数组<br>
空的list
```python
L = []
```
**tuple**<br>
另一种有序列表:元组。tuple和list非常类似，但是tuple一旦初始化就不能修改，没有append()，insert()这样的方法。其他获取元素的方法和list是一样的，比如classmates[0]，classmates[-1]，但不能赋值成另外的元素。
```python
classmates = ('Michael', 'Bob', 'Tracy') #注意tuple用的是圆括号
print(classmates)
```
tuple不可变，所以代码更安全。如果可能，能用tuple代替list就尽量用tuple<br>
定义一个元素的tuple
```python
t = (1) #这种情况下，()既可以表示tuple，又可以表示数学公式中的小括号，这就产生了歧义，Python默认为小括号
#1
print(t)
t2 = (1,) #所以正确的写法是在后面加一个`,`号
print(t2)
#(1,)
```
“可变的”tuple
```python
t = (1,2,[3,4])
print(t)
# (1, 2, [3, 4])
t[2][0] = 'change'
print(t)
# (1, 2, ['change', 4])
```
表面上看，tuple的元素确实变了，但其实变的不是tuple的元素，而是list的元素。tuple一开始指向的list并没有改成别的list，所以，tuple所谓的“不变”是说，tuple的每个元素，**指向**永远不变。即指向'a'，就不能改成指向'b'，指向一个list，就不能改成指向其他对象，但指向的这个list本身是可变的！

条件判断
---------
根据Python的缩进规则，如果if语句判断是True，就把缩进的print语句执行了，否则，什么也不做。
```python
grade = input('Please enter your grade:\n')
grade_int = int(grade)
if grade_int > 60:  #不要忘了冒号结尾
    print('pass')
elif grade_int == 60:
    print('wait')
else:
    print('failed')
```

循环
----------
**for in 循环**<br>
实质上就是把每个Games的元素带入games，然后再由`print()`语句
```pythion
Games = ['LOL','WOW','OverWatch']
for games in Games:
    print(games)
```
Python提供一个`range()`函数，可以生成一个整数序列，再通过`list()`函数可以转换为`list`
```python
print(range(10))
# range(0, 10)
print(list(range(10)))
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

```python
sum = 0
for x in range(101): 
    sum += x
print(sum)
```
**whiel循环**<br>
```python
#计算100以内所有奇数之和
sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print(sum)
```
**break**<br>
`break`语句可以提前退出循环
```python
for x in range(10):
    if(x>5):
        break
    print(x)
```
**continue**<br>
`continue`可以提前结束本轮循环，并直接开始下一轮循环
```python
#打印偶数
for x in range(10):
    if x%2 !=0:
        continue
    print(x)
```
dict和set
-----------
**dict**<br>
dict全称dictionary，在其他语言中也称为map，使用键-值（key-value）存储，具有极快的查找速度，一个key只能对应一个value。<br>
dict内部存放的顺序和key放入的顺序是没有关系的<br>
```python
GamesInfo = {'OverWatch':198,'GTA5':198} #注意是大括号
print(GamesInfo['OverWatch'])
# 198
GamesInfo['OverWatch'] = 328 #修改key对应的value
print(GamesInfo['OverWatch'])
# 328
print(GamesInfo['Over']) #key不存在就会报错
# dict提供的get方法判断key是否存在
print(GamesInfo.get('OverWatch',-1)) #key存在，就返回对应value
print(GamesInfo.get('Over',-1)) #key不存在,就返回指定的-1
```
要删除一个key，用pop(key)方法，对应的value也会从dict中删除
```python
GamesInfo = {'OverWatch':198,'GTA5':198}
print(GamesInfo)
# {'GTA5': 198, 'OverWatch': 198}
GamesInfo.pop('GTA5')
print(GamesInfo)
# {'OverWatch': 198}
```
另外，在Python中，字符串、整数等都是不可变的，因此，可以放心地作为key。而list是可变的，就不能作为key：
这是因为dict根据key来计算value的存储位置，如果每次计算相同的key得出的结果不同，那dict内部就完全混乱了。这个通过key计算位置的算法称为哈希算法（Hash）。<br>
**set**<br>
set和dict类似，也是一组key的集合，但不存储value。由于key不能重复，所以，在set中，没有重复的key。
```python
s = set([1,2,3]) # 要创建一个set，需要提供一个list作为输入集合
print(s) # {1, 2, 3}
s.add(4) # 添加一个元素
print(s) # {1, 2, 3, 4}
s.add(4) # 重复添加会被过滤
print(s) # {1, 2, 3, 4}
s.remove(1) # 移除一个元素
print(s) # {2, 3, 4}
```
set可以看成数学意义上的无序和无重复元素的集合，因此，两个set可以做数学意义上的交集、并集等操作
```python
s1 = set([1,2,3])
s2 = set([2,3,4])
print(s1 & s2) # 交集 {2, 3}
print(s1 | s2) # 并集 {1, 2, 3, 4}
```

set和dict的唯一区别仅在于没有存储对应的value，但是，set的原理和dict一样，所以，同样不可以放入可变对象，因为无法判断两个可变对象是否相等，也就无法保证set内部“不会有重复元素”。试试把list放入set，看看是否会报错。
```python
s = set([1,2,3]) # 这里的list只是作为输入集合
s.add(4) # 不报错
s.add([5,6]) # 报错 不能放入一个list，注意跟上面的区别
```
```python
s1 = set((1,2,3)) # 不报错
s2 = set((1,[2,3])) # 报错 因为(1,[2,3])是一个"可变"的tuple,具体原因在tuple部分
```
总结:<br>
 * tuple可作为插入到dict，作为key指定value
 * list不可插入到dict
 * tuple可插入到set，作为key
 * list不可插入到set
 * 含list的tuple不可插入到set
 * 含list的tuple不可插入到dict


str是不变对象，而list是可变对象
对于可变对象，比如list，对list进行操作，list内部的内容是会变化的，比如
```python
a = ['c', 'b', 'a']
a.sort()
print(a)
# ['a', 'b', 'c']
```
对于不可变对象，比如str
```python
a = 'abc'
b = a.replace('a', 'A')
print(a) # abc
print(b) # Abc
```
当我们调用`a.replace('a', 'A')`时，实际上调用方法`replace`是作用在字符串对象`'abc'`上的，而这个方法虽然名字叫`replace`，但却没有改变字符串`'abc'`的内容。相反，`replace`方法创建了一个新字符串`'Abc'`并返回，如果我们用变量b指向该新字符串，就容易理解了，变量a仍指向原有的字符串`'abc'`，但变量b却指向新字符串`'Abc'了`<br>
对于不变对象来说，调用对象自身的任意方法，也不会改变该对象自身的内容。相反，这些方法会创建新的对象并返回，这样，就保证了不可变对象本身永远是不可变的。

函数
-----------
**内置函数**<br>
Pyhton提供一些常用的内置函数：
```python
print(abs(-5)) # 绝对值abs
print(sum(x**2 for x in range(1,3))) # 求和sum，sum里可以是一个抽象的表达式
a = abs # 函数名其实就是指向一个函数对象的引用，可以把函数名赋给一个变量，相当于给这个函数起了一个“别名”
print(a(-5)) # 5
```
[更多内置函数](https://docs.python.org/3/library/functions.html#abs)<br>
**定义函数**<br>
在Python中，定义一个函数要使用`def`语句，依次写出函数名、括号、括号中的参数和冒号`:`，然后，在缩进块中编写函数体，函数的返回值用return语句返回。
```python
#定义一个计算长方形面积的函数
def area_rectangle(hight,width):
    return hight * width
print(area_rectangle(3,4))
#定义一个空函数
def nop():
    pass
```
pass语句什么都不做，pass可以用来作为占位符，比如现在还没想好怎么写函数的代码，就可以先放一个pass，让代码能运行起来。<br>
```python
# 返回多个参数
def area(hight,width, radius):
    return hight * width,3.14*radius*radius
print(area(3,4,3)) # (12, 28.259999999999998)
area_1,area_2 = area(3,4,3)
print(area_1,area_2) # 12 28.259999999999998
```
返回值其实是一个tuple！但是，在语法上，返回一个tuple可以省略括号，**而多个变量可以同时接收一个tuple，按位置赋给对应的值**，所以，Python的函数返回多值其实就是返回一个tuple，但写起来更方便。<br>
小结:
 * 定义函数时，需要确定函数名和参数个数。
 * 如果有必要，可以先对参数的数据类型做检查。
 * 函数体内部可以用return随时返回函数结果。
 * 函数执行完毕也没有return语句时，自动return None。
 * 函数可以同时返回多个值，但其实就是一个tuple。<br>

**函数的参数**<br>
位置参数
```python
def power(x):   # 参数x就是一个位置参数
    return x * x
```
默认参数
```python
def power(x,n=2): # n 默认为2
    return x**n
print(power(2)) # n这里为默认值2，4，相当于调用power(2,2)
print(power(2,3)) # 8
```
```python
def enroll(name,city='Zhejiang',age=0): 
    print(name,city,age)
enroll('shi')
enroll('shi','Beijing',22) # 有多个默认参数时，调用的时候，可以按顺序提供默认参数
enroll('shi',age = 22) # 不按顺序提供部分默认参数时，需要将参数名写上
```
默认参数的陷阱
```python
def add_end(L=[]):
    L.append('END')
    print(L)
def add_end(L=[]):
    L.append('END')
    print(L)
add_end([1,2,3]) # 正常使用，没有问题 [1, 2, 3, 'END']
add_end()        # 使用默认参数，第一次调用也没问题 ['END']
add_end()        # 但是第二次调用时 ['END', 'END']
```
原因，Python函数在定义的时候，默认参数`L`的值就被计算出来了，即`[]`，因为默认参数`L`也是一个变量，它指向对象`[]`，每次调用该函数，如果改变了`L`的内容，则下次调用时，**默认参数的内容就变了**，不再是函数定义时的`[]`了。<br>
改进,可以用None这个不变对象来实现
```python
def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    print(L)
```
所以说，str、None这样的不变对象，一旦创建，对象内部的数据就不能修改，这样就减少了由于修改数据导致的错误。此外，由于对象不变，多任务环境下同时读取对象不需要加锁，同时读一点问题都没有。我们在编写程序时，如果可以设计一个不变对象，那就尽量设计成不变对象。<br>
**可变参数**<br>
在参数前面加一个*号。在函数内部，参数numbers接收到的是一个tuple
```python
def cal(*numbers):
    sum = 0
    for x in numbers:
        sum += x*x
    print(sum)
cal(1,2)
cal(1,2,3)
# 如果已经有一个list或者tuple,只需在前面加个 * 即可
nums = [1,2,3]
nums2 = (1,2,3)
cal(*nums)
cal(*nums2)
```
**关键字参数**<br>
可变参数允许传入0个或任意个**参数**，这些可变参数在函数调用时自动组装为一个`tuple`。而关键字参数允许传入0个或任意个**含参数名的参数**，这些关键字参数在函数内部自动组装为一个`dict`。<br>
```python
def register(name,age,**others):
    print('Names:',name,' Age:',age, ' Other:',others)
register('shi',22) # Names: shi  Age: 22  Other Information: {}
register('shi',22,address = 'Beijing',gender = 'Male') # Names: shi  Age: 22  Other: {'gender': 'Male', 'address': 'Beijing'}
# 当然，也可以先组装出一个dict，传入时在前面加2个*即可
other = {'address':'Beijing','gender':'Male'}
register('shi',22,**other) # Names: shi  Age: 22  Other: {'gender': 'Male', 'address': 'Beijing'}
```
当然，在`register`函数里对`others`的改变不会影响到函数外的`other`，`others`获得的只是`other`的一份拷贝。<br>
**命名关键字参数**<br>
检查是否有city和job参数
```python
def person(name, age, **kw):
    if 'city' in kw:
        # 有city参数
        pass
    if 'job' in kw:
        # 有job参数
        pass
    print('name:', name, 'age:', age, 'other:', kw)
```
但是调用者仍可以传入不受限制的关键字参数.<br>
要限制关键字参数的名字，就可以用命名关键字参数，例如，只接收city和job作为关键字参数。命名关键字参数必须传入参数名,当然，如果有默认值的话也不需要传入参数
```python
def person(name, *, city, job):
    print(name, city, job)
person('shi',city = 'beijing',job = 'student') # shi beijing student
```
**参数组合**<br>
在Python中定义函数，可以用必选参数、默认参数、可变参数、关键字参数和命名关键字参数，这5种参数都可以组合使用。但是请注意，参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数和关键字参数
```python
def f1(a, b, c=0, *args, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'args =', args, 'kw =', kw)

def f2(a, b, c=0, *, d, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'd =', d, 'kw =', kw)
```
在函数调用的时候，Python解释器自动按照参数位置和参数名把对应的参数传进去。
```python
>>> f1(1, 2)
a = 1 b = 2 c = 0 args = () kw = {}
>>> f1(1, 2, c=3)
a = 1 b = 2 c = 3 args = () kw = {}
>>> f1(1, 2, 3, 'a', 'b')
a = 1 b = 2 c = 3 args = ('a', 'b') kw = {}
>>> f1(1, 2, 3, 'a', 'b', x=99)
a = 1 b = 2 c = 3 args = ('a', 'b') kw = {'x': 99}
>>> f2(1, 2, d=99, ext=None)
a = 1 b = 2 c = 0 d = 99 kw = {'ext': None}
```
注意参数会逐个匹配
```python
def f(a,b,*c):
    print(a,b,c)
f(*(1,2)) # 1 2 ()
f(*(1,2,3)) # 1 2 (3,)
```

**递归函数**<br>
递归函数的优点是定义简单，逻辑清晰。<br>
使用递归函数需要注意防止栈溢出。在计算机中，函数调用是通过栈（stack）这种数据结构实现的，每当进入一个函数调用，栈就会加一层栈帧，每当函数返回，栈就会减一层栈帧。由于栈的大小不是无限的，所以，递归调用的次数过多，会导致栈溢出。如fact(1000)
```python
def fact(n):
    if n == 1:
        return 1
    else:
        return n*fact(n-1)
print(fact(5))
print(fact(1000)) # 递归调用次数过多，发生栈溢出
# 看一下fact(5)的递归过程，注意栈的特性，先进后出
===> fact(5)
===> 5 * fact(4)
===> 5 * (4 * fact(3))
===> 5 * (4 * (3 * fact(2)))
===> 5 * (4 * (3 * (2 * fact(1))))
===> 5 * (4 * (3 * (2 * 1)))
===> 5 * (4 * (3 * 2))
===> 5 * (4 * 6)
===> 5 * 24
===> 120
```
解决递归调用栈溢出的方法是通过尾递归优化，事实上尾递归和循环的效果是一样的，把循环看成是一种特殊的尾递归函数也是可以的。<br>
尾递归是指，在函数返回的时候，调用自身本身，并且，return语句不能包含表达式。这样，编译器或者解释器就可以把尾递归做优化，使递归本身无论调用多少次，都只占用一个栈帧，不会出现栈溢出的情况。<br>
上面的fact(n)函数由于return n * fact(n - 1)引入了乘法表达式，所以就不是尾递归了。下面改成尾递归
```python
def fact(n):
    return fact_iter(n, 1)

def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)
# 看一下递归过程fact_iter(5,1)
===> fact_iter(5, 1)
===> fact_iter(4, 5)
===> fact_iter(3, 20)
===> fact_iter(2, 60)
===> fact_iter(1, 120)
===> 120
```
`return fact_iter(num - 1, num * product)`仅返回递归函数本身，`num - 1`和`num * product`在函数调用前就会被计算，不影响函数调用。<br>
但是，大多数编程语言没有针对尾递归做优化，Python解释器也没有做优化，所以，即使把上面的fact(n)函数改成尾递归方式，也会导致栈溢出。<br>
**总结**<br>
Python的函数具有非常灵活的参数形态，既可以实现简单的调用，又可以传入非常复杂的参数。<br>
默认参数一定要用不可变对象，如果是可变对象，程序运行时会有逻辑错误！<br>
要注意定义可变参数和关键字参数的语法：<br>
*args是可变参数，args接收的是一个tuple；<br>
**kw是关键字参数，kw接收的是一个dict。<br>
以及调用函数时如何传入可变参数和关键字参数的语法：<br>
可变参数既可以直接传入：`func(1, 2, 3)`，又可以先组装`list`或`tuple`，再通过`*args`传入：`func(*(1, 2, 3))`；<br>
关键字参数既可以直接传入：`func(a=1, b=2)`，又可以先组装`dict`，再通过`**kw`传入：`func(**{'a': 1, 'b': 2})`。<br>
使用`*args`和`**kw`是Python的习惯写法，当然也可以用其他参数名，但最好使用习惯用法。<br>
命名的关键字参数是为了限制调用者可以传入的参数名，同时可以提供默认值。<br>
定义命名的关键字参数在没有可变参数的情况下不要忘了写分隔符`*`，否则定义的将是位置参数。<br>

高级特性
--------------
切片
--------------
对于一个list，list[参数m:参数n:参数k]<br>

    * 参数m表示开始索引从m开始（包括索引m），默认是0
    * 参数n表示切片直到索引n为止（不包括索引n），默认是list长度
    * 参数k表示每k个元素取一个，默认是1
```python
L = list(range(11))
print(L[0:5]) # [0, 1, 2, 3, 4]
print(L[::2]) # [0, 2, 4, 6, 8, 10]
print(L[1:3]) # [1, 2]
print(L[-2:]) # [9, 10] ,从倒数第二个元素开始直到末尾
print(L[-2:-1]) # [9] ，从倒数第二个元素开始到倒数第一个元素（不包括）
print(L[:]) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```
对于字符串和tuple，切片的操作相同。<br>

迭代
--------------
Python的for循环抽象程度要高于Java的for循环，因为Python的for循环不仅可以用在list或tuple上，还可以作用在其他**可迭代对象上**。
list这种数据类型虽然有下标，但很多其他数据类型是没有下标的，但是，只要是可迭代对象，无论有无下标，都可以迭代，比如dict就可以迭代
```python
# dict的存储不是按照list的方式顺序排列，迭代出的结果顺序是乱的
d = {'a':1,'b':2,'c':3}
for key in d:    # 只迭代key
    print(key)
for values in d.values(): # 只迭代values
    print(values)
for key,value in d.items(): # 同时迭代key和对应的value
    print(key,'-',value)
```
字符串也是可迭代对象，因此，也可以作用于for循环
```python
str = 'hello python'
for c in str:
    print(c)
```
判断是否可以迭代，通过`collections`模块的`Iterable`类型判断
```python
from collections import Iterable
print(isinstance('abc', Iterable)) #True
print(isinstance(123, Iterable)) #False
print(isinstance({'a':1,'b':2}, Iterable)) #True
```
如果要对list实现类似Java那样的下标循环,Python内置的`enumerate`函数可以把一个list变成索引-元素对，这样就可以在for循环中同时迭代索引和元素本身：
```python
str = 'abc'
for i,value in enumerate(str):
    print(i,value)
# 0 a
# 1 b
# 2 c
```
列表生成式
------------
写列表生成式时，把要生成的元素比如`x * x`放到前面，后面跟`for`循环
```python
print([x*x for x in range(1,11)]) # [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
print([x*x for x in range(1,11) if x%2 ==0]) # 还可以加判断语句，[4, 16, 36, 64, 100]
print([m + n for m in 'ABC' for n in 'XYZ']) # 两层for循环 ['AX', 'AY', 'AZ', 'BX', 'BY', 'BZ', 'CX', 'CY', 'CZ']
```
列表生成式也可以使用两个变量来生成list
```python
d = {'a':1,'b':2,'c':3}
print([k+'-'+str(v) for k,v in d.items()]) # 注意这里的v是int类型，要转换成字符串类型
```
练习
```python
L1 = ['Hello', 'World', 18, 'Apple', None]
print([s.lower() for s in L1 if isinstance(s,str)]) #把list不是字符串类型的排除掉，其余的都转为小写
```
生成器
--------
要创建一个generator，有很多种方法。第一种方法很简单，只要把一个列表生成式的[]改成()，就创建了一个generator
```python
g = (x * x for x in range(10)) #generator也是可迭代对象：
for n in g:
    print(n)
```
定义generator的另一种方法。如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator。<br>
函数是顺序执行，遇到return语句或者最后一行函数语句就返回。而变成generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行。
```python
# 杨辉三角
def triangles():
    L = [1]
    while True:
        yield L
        temp = L[:]
        temp.insert(0,0)
        for i in range(len(L)):
            L[i] = temp[i] + temp[i+1]
        L.append(1)
n = 0
for t in triangles():
    print(t)
    n = n + 1
    if n == 10:
        break
```

迭代器
--------
可以直接作用于for循环的数据类型有以下几种：<br>
一类是集合数据类型，如list、tuple、dict、set、str等；<br>
一类是generator，包括生成器和带yield的generator function。<br>
这些可以直接作用于for循环的对象统称为**可迭代对象**：Iterable。<br>
可以使用isinstance()判断一个对象是否是Iterable对象：<br>
```python
>>> from collections import Iterable
>>> isinstance([], Iterable)
True
>>> isinstance({}, Iterable)
True
>>> isinstance('abc', Iterable)
True
>>> isinstance((x for x in range(10)), Iterable)
True
>>> isinstance(100, Iterable)
False
```
生成器不但可以作用于for循环，还可以被next()函数不断调用并返回下一个值，直到最后抛出StopIteration错误表示无法继续返回下一个值了。<br>
可以被next()函数调用并不断返回下一个值的对象称为迭代器：Iterator。<br>
可以使用isinstance()判断一个对象是否是Iterator对象
```python
>>> from collections import Iterator
>>> isinstance((x for x in range(10)), Iterator)
True
>>> isinstance([], Iterator)
False
>>> isinstance({}, Iterator)
False
>>> isinstance('abc', Iterator)
False
```
生成器都是Iterator对象，但list、dict、str虽然是Iterable，却不是Iterator。<br>
把list、dict、str等Iterable变成Iterator可以使用iter()函数：
```python
>>> isinstance(iter([]), Iterator)
True
>>> isinstance(iter('abc'), Iterator)
True
```
Python的Iterator对象表示的是一个数据流，Iterator对象可以被next()函数调用并不断返回下一个数据，直到没有数据时抛出StopIteration错误。可以把这个数据流看做是一个有序序列，但我们却不能提前知道序列的长度，只能不断通过next()函数实现按需计算下一个数据，所以Iterator的计算是惰性的，只有在需要返回下一个数据时它才会计算。<br>
小结<br>
 * 凡是可作用于for循环的对象都是Iterable类型；
 * 凡是可作用于next()函数的对象都是Iterator类型，它们表示一个惰性计算的序列；
 * 集合数据类型如list、dict、str等是Iterable但不是Iterator，不过可以通过iter()函数获得一个Iterator对象。<br>
 
函数式编程
-----------
 函数式编程就是一种抽象程度很高的编程范式，**纯粹的函数式编程语言编写的函数没有变量**，任意一个函数，只要输入是确定的，输出就是确定的，这种纯函数我们称之为没有副作用。允许使用变量的程序设计语言，由于函数内部的变量状态不确定，同样的输入，可能得到不同的输出，因此，这种函数是有副作用的。<br>
 函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数。<br>
 Python对函数式编程提供部分支持。由于Python允许使用变量，因此，Python不是纯函数式编程语言。<br>
高阶函数
----------------------------------
```python
f = abs 
print(f(-10))
```
变量可以指向函数。<br>
函数名其实就是指向函数的变量<br>
对于`abs()`这个函数，完全可以把函数名`abs`看成变量，它指向一个可以计算绝对值的函数<br>
所以，变量可以指向函数，函数的参数能接收变量，那么一个函数就可以接收另一个函数作为参数，这种函数就称之为高阶函数。
```python
def cal(a,b,f):
    return f(a)+f(b)
print(cal(-3,-2,abs)) # 将指向函数的变量abs传入
```
map和reduce
--------------
**map()**
`map(`)函数接收两个参数，一个是`函数`，一个是`Iterable`，`map`将传入的函数依次作用到序列的每个元素，并把结果作为新的`Iterator`返回。
```python
def f(x):
    return x*x
r = map(f,list(range(1,10)))
print(list(r)) # [1, 4, 9, 16, 25, 36, 49, 64, 81]
print(list(map(str, [1, 2, 3]))) # ['1', '2', '3']
```
`map()`传入的第一个参数是`f`，即函数对象本身。由于结果`r`是一个`Iterator`，`Iterator`是惰性序列，因此通过`list()`函数让它把整个序列都计算出来并返回一个`list`。<br>
**reduce()**<br>
`reduce`把一个函数作用在一个序列`[x1, x2, x3, ...]`上，这个函数必须接收两个参数，`reduce`把结果继续和序列的下一个元素做累积计算
```python
from functools import reduce
def f(x,y):
    return x*10+y
print(reduce(f,[1,2,3])) # 123
```
结合map和reduce
```python
from functools import reduce
def f_1(x,y):
    return x*10+y

def f_2(s):
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
print(reduce(f_1,map(f_2,['3','2','3']))) # 323
```
f_2返回s在dict中的索引值，即字符转数字，当然直接int()就可以，这里只是用map实现这个功能，仅用几行代码。<br>

filter函数
-----------------
和map()类似，filter()也接收一个函数和一个序列。和map()不同的是，filter()把传入的函数依次作用于每个元素，然后根据返回值是True还是False决定保留还是丢弃该元素。
```python
# 保留奇数
def is_odd(n):
    return n % 2 == 1
print(list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15])))
```
```python
def palindrome(n):
    return str(n)==str(n)[::-1]  # 判断是否是回文数，仅用一行代码！！！
print(list(filter(palindrome,[12321,123,1441,454,1])))
```

sorted函数
------------
排序
```python
>>> sorted([36, 5, -12, 9, -21])
[-21, -12, 5, 9, 36]
```
接收一个key函数来实现自定义的排序，例如按绝对值大小排序
```python
>>> sorted([36, 5, -12, 9, -21], key=abs) # key指定的函数将作用于list的每一个元素上，并根据key函数返回的结果进行排序
[5, 9, -12, -21, 36]
```
默认情况下，对字符串排序，是按照ASCII的大小比较的，由于'Z' < 'a'，结果，大写字母Z会排在小写字母a的前面。
```python
>>> sorted(['bob', 'about', 'Zoo', 'Credit'])
['Credit', 'Zoo', 'about', 'bob']
>>> sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower) # 传入key函数，忽略大小写
['about', 'bob', 'Credit', 'Zoo']
>>> sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True)
['Zoo', 'Credit', 'bob', 'about']  # 实现方向，传入第三个参数reverse=True
```
```python
# 成绩从大到小排列
L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]
def by_name(t):
   return t[1]
print(sorted(L,key=by_name,reverse=True)) # [('Adam', 92), ('Lisa', 88), ('Bob', 75), ('Bart', 66)]
```

返回函数
----------
[看大神的讲解](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/001431835236741e42daf5af6514f1a8917b8aaadff31bf000#0)

匿名函数
---------
在Python中，对匿名函数提供了有限支持。以map()函数为例
```python
>>> list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9]))
[1, 4, 9, 16, 25, 36, 49, 64, 81]
```
关键字lambda表示匿名函数，冒号前面的x表示函数参数<br>
匿名函数有个限制，就是只能有一个表达式，不用写return，返回值就是该表达式的结果<br>
因为函数没有名字，不必担心函数名冲突。此外，匿名函数也是一个函数对象，也可以把匿名函数赋值给一个变量，再利用变量来调用该函数：
```python
>>> f = lambda x: x * x
>>> f
<function <lambda> at 0x101c6ef28>
>>> f(5)
25
```
同样，也可以把匿名函数作为返回值返回，比如：
```python
def build(x, y):
    return lambda: x * x + y * y
```

装饰器
--------
要增强一个函数的功能，比如，在函数调用前后自动打印日志，但又不希望修改该函数的定义，这种在代码运行期间动态增加功能的方式，称之为“装饰器”（Decorator）.<br>
本质上，decorator就是一个返回函数的高阶函数,定义一个能打印日志的decorator<br>
```python
def log(func):
    @functools.wraps(func) #把原始函数的__name__等属性复制到wrapper()函数中
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper
```
借助Python的@语法，把decorator置于函数的定义处：
```python
@lognw
def now():
    print('2016-12-20')
    
now()
#call now():
#2016-12-20
```
事实上,把`@log`放到`now()`函数的定义处，相当于执行了语句,`now`函数变量其实已经传到了`func`参数里
```python
now = log(now)
```
自定义log的文本
```python
def log(text):
    def decorator(func):
        @functools.wraps(func) #把原始函数的__name__等属性复制到wrapper()函数中
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator

@log('execute')
def now():
    print('2016-12-20')
```
相当于执行了`now = log('execute')(now)`，首先执行log('execute')，返回的是decorator函数，再调用返回的函数，参数是now函数，返回值最终是wrapper函数。<br>

综合例子
```python
from functools import wraps

def log(str_or_func):
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kw):
            fname = func.__name__
            print('%s call %s():' % (text, fname))
            func(*args, **kw)
            print('end call %s():' % fname)
        return wrapper
    if type(str_or_func) == str:
        text = str_or_func
        return decorator
    else:
        text = 'begin'
        return decorator(str_or_func)  #这里其实str_or_func接收了函数变量，这个过程将str_or_func接收的函数变量传到func参数里
@log
def f():
    print('abc')
f()
@log('execute')
def g():
    print('xyz')
g()
```

偏函数
---------
functools.partial帮助我们创建一个偏函数，直接使用下面的代码创建一个新的函数
```python
#将二进制字符串转换为整数
>>> import functools
>>> int2 = functools.partial(int, base=2)
>>> int2('1000000')
64
>>> int2('1010101')
85
```
`functools.partial`的作用就是，把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单。<br>
所以也可以在函数调用时传入其他值
```python
>>> int2('1000000', base=10)
1000000
```

面向对象编程
------------
**类和实例**<br>
```python
class Student(object):

    def __init__(self,name,score):
        self.name = name
        self.score = score

    def print(self):
        print('Name: %s ,Score: %s' % (self.name,self.score))

stu_1 = Student('shishengjia',80)
stu_1.print()
```
object表示要继承的类，没有合适的继承类，就用object<br>
和普通的函数相比，在类中定义的函数只有一点不同，就是第一个参数永远是实例变量self，并且，调用时，不用传递该参数。

**访问限制**<br>
```python
class Student(object):

    def __init__(self,name,score):
        self.__name = name
        self.__score = score

    def print(self):
        print('Name: %s ,Score: %s' % (self.__name,self.__score))

    def setName(self,name):
        self.__name = name

    def getName(self):
        return self.__name

stu_1 = Student('shishengjia',80)
stu_1.setName("ssj")
print(stu_1.getName())
```
实例的变量名如果以`__`开头，就变成了一个私有变量<br>
在Python中，变量名类似__xxx__的，也就是以双下划线开头，并且以双下划线结尾的，是特殊变量，特殊变量是可以直接访问的，不是private变量，所以，不能用`__name__`、`__score__`这样的变量名。<br>
不能直接访问`__name`是因为Python解释器对外把`__name`变量改成了`_Student__name`，所以，仍然可以通过`_Student__name`来访问`__name`变量,但是强烈建议不要这么干，因为不同版本的Python解释器可能会把`__name`改成不同的变量名.


**继承和多态**<br>
```python

class Animal(object):

    def run(self):
        print('Animal is running')

    def run_2(self,animal):
        animal.run()

class Dog(Animal):

    def run(self):
       print('Dog is running')

class Cat(Animal):

    def run(self):
       print('Cat is running')
       
class Human(object):

    def run(self):
       print('Human is running')

animal = Animal()
dog = Dog()
cat = Cat();
animal.run()
dog.run()
cat.run()
animal.run_2(cat)
animal.run_2(Human())
```
子类的`run()`覆盖了父类的`run()`，在代码运行的时候，总是会调用子类的`run()`<br>
多态的好处就是，当我们需要传入`Dog、Cat、Tortoise……`时，我们只需要接收`Animal`类型就可以了，因为`Dog、Cat、Tortoise……`都是`Animal`类型，然后，按照`Animal`类型进行操作即可。由于`Animal`类型有`run()`方法，因此，传入的任意类型，只要是`Animal`类或者子类，就会自动调用实际类型的`run()`方法，这就是多态的意思：
对于静态语言（例如Java）来说，如果需要传入Animal类型，则传入的对象必须是Animal类型或者它的子类，否则，将无法调用run()方法。<br>
对于Python这样的动态语言来说，**则不一定需要传入Animal类型。我们只需要保证传入的对象有一个run()方法就可以了**<br>

**获取对象信息**<br>

**使用type**<br>
```python
import types

def run():
    pass

print(type(123) == int)
print(type('123') == str)
print(type(run) == types.FunctionType) #判断是否为函数
print(type(abs) == types.BuiltinFunctionType) #判断是否为内置函数
print(type(lambda x: x) == types.LambdaType) #判断是否为lambda表达式
```

**使用isinstance()**<br>
object -> Animal -> Dog -> Husky
```python
a = Animal()
d = Dog()
h = Husky()

isinstance(h, Husky) #true
isinstance(h, Dog) #true
isinstance(d, Husky) #false
```

**使用dir()**<br>
如果要获得一个对象的所有属性和方法，可以使用dir()函数，它返回一个包含字符串的list，比如，获得一个str对象的所有属性和方法<br>
```python
print(dir('abc'))
```
类似`__xxx__`的属性和方法在Python中都是有特殊用途的，比如`__len__`方法返回长度。在Python中，如果你调用`len()`函数试图获取一个对象的长度，实际上，在`len()`函数内部，它自动去调用该对象的`__len__()`方法，所以，下面的代码是等价的：
```python
>>> len('ABC')
3
>>> 'ABC'.__len__()
3
```
[剩余的一些杂碎知识](http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/001431866385235335917b66049448ab14a499afd5b24db000)

**实例属性和类属性**<br>
由于Python是动态语言，根据类创建的实例可以任意绑定属性。给实例绑定属性的方法是通过实例变量，或者通过self变量
```python
class Student(object):
    def __init__(self, name):
        self.name = name

s = Student('Bob')
s.score = 90
```
直接在class中定义属性，这种属性是类属性，归Student类所有
```python
class Student(object):
    name = 'Student'
```

```python
>>> class Student(object):
...     name = 'Student'
...
>>> s = Student() # 创建实例s
>>> print(s.name) # 打印name属性，因为实例并没有name属性，所以会继续查找class的name属性
Student
>>> print(Student.name) # 打印类的name属性
Student
>>> s.name = 'Michael' # 给实例绑定name属性
>>> print(s.name) # 由于实例属性优先级比类属性高，因此，它会屏蔽掉类的name属性
Michael
>>> print(Student.name) # 但是类属性并未消失，用Student.name仍然可以访问
Student
>>> del s.name # 如果删除实例的name属性
>>> print(s.name) # 再次调用s.name，由于实例的name属性没有找到，类的name属性就显示出来了
Student
```

面向对象高级编程
------------------
正常情况下，当我们定义了一个class，创建了一个class的实例后，我们可以给该实例绑定任何属性和方法，这就是动态语言的灵活性<br>
但是，给一个实例绑定的方法，对另一个实例是不起作用的,为了给所有实例都绑定方法，可以给class绑定方法

```python
def set_Age(self,age):
    self.age = age

from types import MethodType
class Student(object):
    def __init__(self,name):
        self.name = name

stu_1 = Student('a')
stu_2 = Student('b')

Student.set_Age = MethodType(set_Age,Student) #给class绑定方法

stu_1.set_Age(20)

stu_2.set_Age(40)
print(stu_1.age,'  ',stu_2.age,'   ',Student.age) # 40 40 40
```
但是要注意，给class绑定方法后，**方法内的属性是类属性，并不是实例属性**，所以当依次调用`stu_1`和`stu_2`的`set_Age`，修改的都是Student的类属性，即age，所以，最后的修改将会覆盖之前的修改，从输出也可以看出来，三者的age值是一样的，因为age是一个类属性。因此，动态绑定一个方法后，比如上面的代码，不能随便调用set_Age方法，因为调用此方法更改的是类属性age的值，不是实例a自身的age属性值。<br>
下面是在构造类时就把属性添加进去，就不回出现上面的问题。
```python
class Student(object):
    def __init__(self, ages):
        self.ages = ages

    def set_Age(self, ages):

        self.ages = ages

stu_1 = Student(20)
stu_2 = Student(30)

stu_1.set_Age(10)

stu_2.set_Age(40)
print(stu_1.ages, '  ', stu_2.ages) # 10 40
```
**使用__slots__限制实例属性**<br>
```python
class Student(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

stu = Student()
stu.age = 20;
stu.name = 'shi'
stu.gender = 'male' # 不允许，会报错，因为gender没有绑定到__slots__中
```
需要注意的是，`__slots__`定义的属性仅对当前类实例起作用，**对继承的子类是不起作用的**,除非在子类中也定义`__slots__`，这样，子类实例允许定义的属性就是**自身的`__slots__`加上父类的`__slots__`**。<br>

**使用@property**<br>
