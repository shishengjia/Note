#C语言基础知识

这些只是最基本的知识，当然例如变量子类的常识就不写了XD,进阶的还得自己阅读相关书籍，查阅资料。<br>

##目录
* [数据类型](#数据类型)
* [逻辑运算](#逻辑运算)
* [输入输出](#输入输出)
* [数组](#数组)
* [循环](#循环)
* [结束语句](#结束语句)
* [枚举](#枚举)
* [typedef](#typedef)
* [指针](#指针)

数据类型
-----------

* 整数
  * char / short / int / long / (long long)
* 浮点数
  * float / double / (long double)
* bool
  * (bool)
* 指针  
* 自定义类型

运算符两边出现不一样的类型时，会自动转换成较大的类型，如`double+int = double`

通过`sizeof`可以知道一个数据类型在内存中所占的字节
```c
//示例，int,long结果视具体环境决定，如32位和64位电脑上的结果是不一样的
printf("sizeof(char) = %ld\n",sizeof(char)); //1
printf("sizeof(int) = %ld\n",sizeof(int)); //4
printf("sizeof(double) = %ld\n",sizeof(double)); //8
```
**注意点:sizeof**是静态运算符，它的结果在编译时刻就决定了，在**sizeof**的括号里做运算是无效的。

逻辑运算
---------
 
| 运算符         | 描述           | 示例  |    结果                                                    |
| :-------------: |:-------------:| :-----:| :-------------:                                              |
| !             | 逻辑非         | !a    |  a是true，结果就是false，反之同理                             | 
| &&            | 逻辑且         |  a&&b |  a和b都是true，结果则是true，否则就是false                     |      
|      \|\|     | 逻辑或         |  a\|\|b |  a和b有一个是true，结果就是true，两个都是false，结果才为flase    | 

**优先级: ! > && > \|\|**

**短路: 逻辑运算自左向右进行，如果左边的结果已经能够决定结果了，就不会做右边的计算**

输入输出
--------
示例
```c
    char x;
    char buf[100];
    int y;
    double z;
    scanf("%c %s %d %lf",&x,buf,&y,&z);
    printf("%c %s %d %f",x,buf,y,z);
```
**注意**在`scanf`中`float`和`double`用`%f`和`%lf`区分，但在`printf`中，统一用`%f`进行输出，否则可能会出现问题

数组
----------------
####4.1一维数组<br>
```c
#define len 4

int main() {
    int arr[len];//声明一个数组
    for (int i = 0; i < len; i++)
        scanf("%d", &arr[i]);//赋值
    for (int i = 0; i < len; i++)
        printf("%d ", arr[i]);//遍历输出
    
    int arr_2[len] = {2,3};//数组初始化，未初始化的自动填充为0
    for (int i = 0; i < len; i++)
        printf("%d ", arr_2[i]);//遍历输出,2 3 0 0
    return 0;
}
```
####4.2二维数组<br>
```c
 int arr[2][3];
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 3; j++)
            scanf("%d", &arr[i][j]);//通过两重循环赋值
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 3; j++) {
            printf("%d ", arr[i][j]);//通过两重循环遍历输出
            if (j == 2)
                printf("\n");
        }

    int arr_2[3][3]={ //二维数组的初始化，同样空缺的元素补0
            {1,2},
            {4,5,6},
            {7,8,9}
    };
```
####4.3字符数组<br>
```c
#include<stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {

    char str[10]={'H','e','l','l','o','\0'};
    printf("the length is %d the content is %s",strlen(str),str);//the length is 5 the content is Hello

    printf("\n");

    char str_2[10]={'H','e','l','\0','l','o','\0'};//以'\0'作为字符串结束的标志
    printf("the length is %d the content is %s",strlen(str_2),str_2);//the length is 3 the content is Hel

    printf("\n");

    char str_3[] = "Hello World"; //遍历每一个字符
    for(int i=0;i<strlen(str_3);i++)
        printf("%c ",str_3[i]);  //H e l l o   W o r l d

    printf("\n");

    char  str_4[3][10]={  //二维字符数组
            {"China"},
            {"Japan"},
            {"American"}
    };
    for(int i = 0;i<3;i++)
        printf("%s ",str_4[i]); //China Japan American

    return 0;
}
```
循环
------------
* while
```c
int i,sum=0;
    i=1;
    while(  i<=100   )  //循环条件应该是什么呢？
    {
        sum=sum+i;
        i++;         //这里是不是应该改变循环变量的值
    }
    printf("100以内所有整数之和为：%d\n", sum);
```
* do-while(使用do-while结构语句时，while括号后必须有分号。)
```c
    int number=200;
    int year=2014;
    do{
      year++;     
      number = number * 1.2;                  
    }while(number<1000);     //这里好像缺点什么
    printf("到%d年招工规模突破1000人\n", year);
```
结束语句
-------------
* break 

    跳出当前循环
* continue

    结束本次循环开始执行下一次循环

枚举
------------
* 常规枚举
```c
    enum Color{RED,YELLO,BLACK};
```
    三种颜色的值分别0,1,2

* 枚举可以指定值：
```c
    enum Color{RED=1,YELLOW,BLACK=5};
```
    则YELLO的值依然是前面一个值+1，即2

* 套路：自动计数的枚举
```c
    enum Color{RED,YELLO,BLACK,NUMCOLORS};
```
    列出的值后面再加一个如NUMCOLORS，他就可以表示前面有多少个定义值，方便遍历

typedef
------------
C语言提供`typedef`来声明一个已有的数据类型的新名字。例如:
```c
    typedef int Length;
```
使得`Length`成为`int`类型的别名，这样`Length`就可以代替`int`出现在变量定义
和参数声明的地方

示例代码
```c
#include <stdio.h>

typedef struct mStudent
{
int ID;
char name[10];
char gender[10];
}student;//定义该结构体的别名为student

student* getStu(student*);
void printStu(student*);
void printStu(student);

int main()
{
//student代替 struct mStudent
student stu = {1,"David","male"};
printStu(&stu);
student *p = &stu;
printStu(p);

student stu_1;
student *q = &stu_1;
getStu(q);
printStu(q);
return 0;
}

student* getStu(student*p){
scanf("%d",&p->ID);
scanf("%s",&p->name);
scanf("%s",&p->gender);
return p;
}

void printStu(student*p){
printf("ID=%d,name=%s,gender=%s\n",p->ID,p->name,p->gender);
}

void printStu_2(student p){
printf("ID=%d,name=%s,gender=%s\n",p.ID,p.name,p.gender);
}
```

指针
------------
先来看一个最经典的例子
```c
#include <stdio.h>
void swap(int a,int b){
    int temp = a;
    a = b;
    b = temp;
}

int main(){
    int a = 2;
    int b = 3;
    swap(a,b);
    printf("a=%d b=%d",a,b); 
    return 0;
}
```
结果为`a=2 b=3`，并没有发生交换，这是因为在执行`swap`函数时，传入的仅仅是`a`和`b`的值，把他们赋给`swap`函数中的形参`a，b`，在`swap`中的`a，b`和`main`中`a，b`可以看做局部变量，相互不影响，所以`swap`中`a，b`虽然交换了值，但是`main中`的`a，b`并不受影响

做一下修改
```c
#include <stdio.h>
void swap(int *a,int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main(){
    int a = 2;
    int b = 3;
    swap(&a,&b);
    printf("a=%d b=%d",a,b);
    return 0;
}
```
这时a和b的值就交换过来了，a=3 b=2，因为通过"&"取地址符将a，b在内存中的地址传入到swap函数中，然后在swap函数中通过地址直接操作a，b所对应的值，这时a，b的值就能交换过来了

指针保存的是内存地址，其实就是保存地址的变量。数组名其实也是一个地址，所以可以通过指针变量保存该数组的地址，并通过指针来访问数组元素。例如：
```c
int main() {
    int arr[5] = {1, 2, 3, 4, 5};//声明一个数组
    int *p = arr;//将该数组的地址arr赋给指针变量p
    for (int i = 0; i < 5; i++) {
//      printf("%d ,"arr[i]);//常规方式
//      printf("%d ",*(arr+i));//数组名也是地址，所以也可以这样访问数组元素
//      printf("%d ",*(p+i));//当然，这跟通过数组名来访问数组元素是一个道理
        printf("%d ", p[i]);//这样也是可以的
    }
    return 0;
}
```
在上面`arr[i]，\*(p+i)`处，指针p的值是使终没有改变。所以变量指针`p`与数组名`arr`可以互换。

数组名和指针的区别在于数组名是常量指针，它的值是不能被修改的。看如下代码
```c
    int i,*pa,arr[]={3,4,5,6,7,3,7,4,4,6};
    pa =arr;
    for (i=0;i<=9;i++)
    {
      printf ( “%d”, *pa );
      pa++ ;　 //注意这里，指针值被修改
      //arr++是不被允许的，数组名是常量指针，不能被修改
    } 
```
但是当把pa定义为常量指针`(int *const pa)`,同样`pa++`也是不允许的。

当然`int *const pa`说明`pa`是常量指针，不能被修改，但是`*pa`是变量，是可以修改的。如果是这样`int const *pa`，这样的话表示`pa`是指针变量，是能够被
赋予新的地址的，但是`*pa`表示的值则是一个常量，不能被修改。





