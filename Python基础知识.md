
##目录
 * [缩进和注释](#缩进和注释)
 * [输入输出](#输入输出)


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


