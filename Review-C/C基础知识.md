#C语言基础知识

这些只是最基本的知识，当然例如变量子类的常识就不写了XD,进阶的还得自己阅读相关书籍，查阅资料。<br>

##1.数据类型(括号里的是C99之后的数据类型)
* 整数
  * char / short / int / long / (long long)
* 浮点数
  * float / double / (long double)
* bool
  * (bool)
* 指针  
* 自定义类型

运算符两边出现不一样的类型时，会自动转换成较大的类型，如double+int = double

通过**sizeof**可以知道一个数据类型在内存中所占的字节
```c
//示例，int,long结果视具体环境决定，如32位和64位电脑上的结果是不一样的
printf("sizeof(char) = %ld\n",sizeof(char)); //1
printf("sizeof(int) = %ld\n",sizeof(int)); //4
printf("sizeof(double) = %ld\n",sizeof(double)); //8
```
**注意点:sizeof**是静态运算符，它的结果在编译时刻就决定了，在**sizeof**的括号里做运算是无效的。

##2.逻辑运算
 
| 运算符         | 描述           | 示例  |    结果                                                    |
| :-------------: |:-------------:| :-----:| :-------------:                                              |
| !             | 逻辑非         | !a    |  a是true，结果就是false，反之同理                             | 
| &&            | 逻辑且         |  a&&b |  a和b都是true，结果则是true，否则就是false                     |      
|      \|\|     | 逻辑或         |  a\|\|b |  a和b有一个是true，结果就是true，两个都是false，结果才为flase    | 

**优先级: ! > && > \|\|**

**短路: 逻辑运算自左向右进行，如果左边的结果已经能够决定结果了，就不会做右边的计算**

##3.输入&输出
示例
```c
    char x;
    char buf[100];
    int y;
    double z;
    scanf("%c %s %d %lf",&x,buf,&y,&z);
    printf("%c %s %d %f",x,buf,y,z);
```
**注意**在scanf中float和double用**%f**和**%lf**区分，但在printf中，统一用**%f**进行输出，否则可能会出现问题

##4.数组
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
##4.函数
