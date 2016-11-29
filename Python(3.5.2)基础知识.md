
#使用的Python版本是3.5.2

##目录
 * [缩进和注释](#缩进和注释)
 * [输入输出](#输入输出)
 * [数据类型和变量](#数据类型和变量)
 * [list和tuple](#list和tuple)
 * [循环](#循环)
 * [dict和set](#dict和set)

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
  * 所以，最后打印变量b的结果自然是'ABC'了。
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
