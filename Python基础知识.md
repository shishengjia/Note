
#使用的Python版本是3.5.2

##目录
 * [缩进和注释](#缩进和注释)
 * [输入输出](#输入输出)
 * [数据类型和变量](#数据类型和变量)
 * [list和tuple](#list和tuple)


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
如果字符串内部有很多换行，用`\n`写在一行里不好阅读，为了简化，Python允许用`'''...'''`的格式表示多行内容
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
