
##目录
* [优先返回空集合而非null](#优先返回空集合而非null)
* [判断奇数](#判断奇数)
* [单引号与双引号的区别](#单引号与双引号的区别)
* [JSON编码](#JSON编码)
* [JSON解析](#JSON解析)
* [进程和线程的区别](#进程和线程的区别)
* [重载和重写的区别](#重载和重写的区别)
* [JAVA访问权限](#JAVA访问权限)
* [interface和抽象类](#interface和抽象类)
* [Object的一些方法](#Object的一些方法)
* [类加载机制](#类加载机制)
* [类加载主要步骤](#类加载主要步骤)
* [双亲委派模型](#双亲委派模型)
* [JSP与Servlet的关系](#JSP与Servlet的关系)
* [Servlet生命周期](#Servlet生命周期)
* [GET请求和POST请求](#GET请求和POST请求)
* [找出未打卡的员工](#找出未打卡的员工)
* [Servlet生命周期](#Servlet生命周期)
优先返回空集合而非null
----------------------
如果程序要返回一个不包含任何值的集合，确保返回的是空集合而不是null。这能节省大量的”if else”检查。
```java
public class getLocationName {
    return (null==cityName ? "": cityName);
}
```

判断奇数
--------------------
考虑到负奇数的情况，它除以2的结果就不会是1。因此，返回值是false，而这样是不对的。
```java
public boolean oddOrNot(int num) {
    return num % 2 == 1;
}
```
修改成一下代码就没问题了，并且还是经过优化的，因为逻辑运算要比算术运算更高效，计算的结果也会更快。
```java
public boolean oddOrNot(int num) {
    return (num & 1) != 0;
}
```
`num & 1` 将`num`化成二进制，然后进行同位比较。 例如3 `11 & 01 = 01` / 8`100 * 001 = 000`

单引号与双引号的区别
----------------------
用了双引号的时候，字符会被当作字符串处理，而如果是单引号的话，字符值会被转换成ASCII值。[ASCII表](http://baike.baidu.com/link?url=PHRqWw36UAHR6NFYijWifqsxwzotNHTe9W-39ny1CScolHuhOExdnDwGatnP5_3VVrsJtJ4cTMMGYDDaUcXDS2rQHVtBosEn9elVXxV0o4nwZxZ84DReVexkNAVxN3IxnJ4JwX6JrMYkWkltHU-mpq)

```java
public class test {
	public static void main(String args[]){
		System.out.println("H"+"a");//Ha
		System.out.println('H'+'a');//169
	}
}
```
JSON编码
---------------------
下面是编码成JSON串的一个简单的例子。
```java
public class JsonEncodeDemo {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("Novel Name", "Godaan");
        obj.put("Author", "Munshi Premchand");

        JSONArray novelDetails = new JSONArray();
        novelDetails.add("Language: Hindi");
        novelDetails.add("Year of Publication: 1936");
        novelDetails.add("Publisher: Lokmanya Press");

        obj.put("Novel Details", novelDetails);

        System.out.print(obj);
    }
}
```
**输出：**
```java
{"Novel Name":"Godaan",
 "Novel Details":
 ["Language: Hindi",
  "Year of Publication: 1936",
  "Publisher: Lokmanya Press"
 ],
 "Author":"Munshi Premchand"}
```
JSON解析
----------------
```java
public class JsonParseTest {

    private static final String filePath = "//home//user//Documents//jsonDemoFile.json";

    public static void main(String[] args) {

        try {
            // read the json file
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);

            // get a number from the JSON object
            Long id =  (Long) jsonObject.get("id");
            System.out.println("The id is: " + id);           

            // get a String from the JSON object
            String   type = (String) jsonObject.get("type");
            System.out.println("The type is: " + type);

            // get a String from the JSON object
            String   name = (String) jsonObject.get("name");
            System.out.println("The name is: " + name);

            // get a number from the JSON object
            Double ppu =  (Double) jsonObject.get("ppu");
            System.out.println("The PPU is: " + ppu);

            // get an array from the JSON object
            System.out.println("Batters:");
            JSONArray batterArray= (JSONArray) jsonObject.get("batters");
            Iterator i = batterArray.iterator();
            // take each value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("ID "+ innerObj.get("id") + 
                        " type " + innerObj.get("type"));
            }

            // get an array from the JSON object
            System.out.println("Topping:");
            JSONArray toppingArray= (JSONArray) jsonObject.get("topping");
            Iterator j = toppingArray.iterator();
            // take each value from the json array separately
            while (j.hasNext()) {
                JSONObject innerObj = (JSONObject) j.next();
                System.out.println("ID "+ innerObj.get("id") + 
                        " type " + innerObj.get("type"));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}
```

```java
//jsonDemoFile.json
{
    "id": 0001,
    "type": "donut",
    "name": "Cake",
    "ppu": 0.55,
    "batters":
        [
            { "id": 1001, "type": "Regular" },
            { "id": 1002, "type": "Chocolate" },
            { "id": 1003, "type": "Blueberry" },
            { "id": 1004, "type": "Devil's Food" }
        ],
    "topping":
        [
            { "id": 5001, "type": "None" },
            { "id": 5002, "type": "Glazed" },
            { "id": 5005, "type": "Sugar" },
            { "id": 5007, "type": "Powdered Sugar" },
            { "id": 5006, "type": "Chocolate with Sprinkles" },
            { "id": 5003, "type": "Chocolate" },
            { "id": 5004, "type": "Maple" }
        ]
}
```

```java
//结果
The id is: 1
The type is: donut
The name is: Cake
The PPU is: 0.55
Batters:
ID 1001 type Regular
ID 1002 type Chocolate
ID 1003 type Blueberry
ID 1004 type Devil's Food
Topping:
ID 5001 type None
ID 5002 type Glazed
ID 5005 type Sugar
ID 5007 type Powdered Sugar
ID 5006 type Chocolate with Sprinkles
ID 5003 type Chocolate
ID 5004 type Maple
```
进程和线程的区别
---------------
  * 一个程序至少一个进程，一个进程最少一个线程
  * 进程间相互独立，同一个进程的各线程共享内存，某个进程内的线程在其他进程中不可见
  * 操作系统中，一般把进程作为分配资源的基本单位，把线程作为独立运行和独立调度的基本单位
  
重载和重写的区别
--------------
  重载: Overloading,方法名称相同，参数的类型或个数不同，对权限没有要求，发生在一个类中。
  重写: Overriding,方法名称、参数的类型，返回值类型全部相同，被重写的方法不能拥有比父类更加严格的权限，发生在继承中。
  
JAVA访问权限
--------------
  * private，可以修饰数据成员，构造方法，方法成员，不能修饰类（此处指外部类，不考虑内部类）。被private修饰的成员，只能在定义它们的类中使用，在其他	       类中不能调用。
  * default，类，数据成员，构造方法，方法成员，都能够使用默认权限，即不写任何关键字。默认权限即同包权限，同包权限的元素只能在定义它们的类中，以及同		    包的类中被调用。
  * protected，修饰数据成员，构造方法，方法成员，不能修饰类（此处指外部类，不考虑内部类）。被protected修饰的成员，能在定义它们的类中，同包的类中被调用。如果有不同包的类想调用它们，那么这个类必须是定义它们的类的子类。
  * public，　public可以修饰类，数据成员，构造方法，方法成员。被public修饰的成员，可以在任何一个类中被调用，不管同包或不同包，是权限最大的一个修饰符。
  
interface和抽象类
------------------
抽象类更相当于 is-a （是不是） 的关系 。接口是 has-a （有没有）的关系

比如抽象类 Bird 和 Plane 表示鸟、飞机，可以继承它们实现更具体的鸟（老鹰、麻雀等），更具体的飞机（直升机、战斗机）。

用 Fly 表示接口，一组抽象的飞行行为，不能设计为类，因此它只是一个行为特性，并不是对一类事物的抽象描述。此时可以将 飞行 设计为一个接口Fly，包含方法fly( )，然后Airplane和Bird分别根据自己的需要实现Fly这个接口。

Object的一些方法
---------------
  * `public` 方法：`getClass`、`equals`、`hashCode`、`toString`、`wait`、`notify`
  * `protected` 方法：`clone`、`finalize`
  * `private` 方法：`registerNatives`，该方法作用是将不同平台C/C++实现的方法映射到Java中的`native`方法
  
类加载机制
------------
  * 启动类加载器( Bootstrap ClassLoader)
    启动类加载器无法被 java 程序员直接引用, 这个类加载器负责把存放在`<JAVA_HOME>\lib`目录中的, 或者被-Xbootclasspath参数指定路径中的, 并且是被虚 拟机识别的类库加载到虚拟机内存中.
  * 扩展类加载器(Extension ClassLoader)
    负责加载在`<JAVA_HOME>\lib\ext`目录中的, 或者被`java.ext.dirs`系统变量所指定的路径中的所有类库。
  * 应用程序类加载器( Application ClassLoader )
    这个类加载器是ClassLoader 中的`getSystemClassLoader()`方法的返回值, 一般称其为系统类加载器, 它负责加载用户类路径( ClassPath )上所指定的类库
    
  **从 java 虚拟机的角度而降, 只存在两种不同的类加载器**
   * 一个是启动类加载器( Bootstrap ClassLoader ), 这个类加载使用 C++ 语言实现, 是虚拟机自身的一部分;
   * 另一种是其他所有的类加载器, 他们由 java 语言实现, 独立于虚拟机之外, 并且全部继承自java.lang.ClassLoader

  
类加载主要步骤
--------------
   * 加载 把 class 文件的二进制字节流加载到 jvm 里面
   * 验证 确保 class 文件的字节流包含的信息符合当前 jvm 的要求 有文件格式验证, 元数据验证, 字节码验证, 符号引用验证等
   * 准备 正式为类变量分配内存并设置类变量初始值的阶段, 初始化为各数据类型的零值
   * 解析 把常量值内的符号引用替换为直接引用的过程
   * 初始化 执行类构造器`<clinit>()`方法
   * 使用根据相应的业务逻辑代码使用该类
   * 卸载 类从方法区移除
   
双亲委派模型
-------------
除了顶层的启动类加载器之外, 其余的类加载器都应当有自己的父类加载器, 父子关系这儿一般都是以组合来实现。

工作过程: 如果一个类加载器收到了类加载的请求, 它首先不会自己去尝试加载这个类, 而是把这个请求委派给父类加载器去完成, 最终所有的加载请求都会传送到顶层的启动类加载器中, 只有当父类加载器反馈自己无法完成这个请求时候, 才由子加载器来加载。

例如类`Object`，它放在`rt.jar`中，无论哪一个类加载器要加载这个类，最终都是委派给启动类加载器进行加载，因此`Object`类在程序的各种类加载器环境中都是同一个类。

对于任何一个类, 都需要由加载它的类加载器和这个类本身一同确定其在 java 虚拟机中的唯一性。

`ClassLoader.loadClass()`的代码如下，先检查是否已经被加载过，如果没有则`parent.loadClass()`调用父加载器的`loadClass()`方法，如果父加载器为空则默认使用启动类加载器作为父加载器。如果父类加载器加载失败，抛出`ClassNotFoundException`，再调用自己的`findClass()`方法进行加载。

另外，如果我们自己实现类加载器，一般是Override复写`findClass`方法，而不是`loadClass`方法。
```java
protected Class<?> loadClass(String name, boolean resolve)
throws ClassNotFoundException {
    synchronized (getClassLoadingLock(name)) {
        // First, check if the class has already been loaded
        Class c = findLoadedClass(name);
        if (c == null) {
            long t0 = System.nanoTime();
            try {
                if (parent != null) {
                    c = parent.loadClass(name, false);
                } else {
                    c = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e) {
                // ClassNotFoundException thrown if class not found
                // from the non-null parent class loader
            }
            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                c = findClass(name); //可以Override该方法
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }
}
```

JSP与Servlet的关系
--------------------
   * `Tomcat`等`Web`容器最终会把`JSP`转化为`Servlet`
   * Jsp更擅长表现于页面显示, Servlet更擅长于逻辑控制
   * Servlet是利用`System.out.println()`来输出 html 代码，由于包括大量的HTML标签、大量的静态文本及格式等，导致`Servlet`的开发效率低下
   * JSP通过在标准的HTML页面中嵌入Java代码，其静态的部分无须Java程序控制，Java 代码只控制那些动态生成的信息
   * 最终`JSP`被容器解释为`ervlet`，其中`Html`代码也是用`System.out.println()`等拼接输出的
   * `JSP`第一次访问的时候，要转化为`java`文件，然后编译为`class`文件，所以第一次访问`JSP`速度会比较慢，后面会快很多
   
Servlet生命周期
----------------
主要是java.servlet.Servlet接口中的init() 、service() 、和destroy() 3个方法。<br>
   * 初始化阶段，`web`容器通过调用`init()`方法来初始化`Servlet`实例，在`Servlet`的整个生命周期类，`init()`方法只被调用一次
   * 客户请求到来时，容器会开始一个新线程，并调用`servlet`的`service()`方法，`service()`方法根据请求的`http`方法来调用`doget()`或`dopost()`
   * 终止阶段调用`destroy()`方法，销毁一些资源
   
GET请求和POST请求
-------------------
   * GET用于信息获取，是安全的和幂等的，GET一般是对后台数据库的信息进行查询
   * POST表示可能修改变服务器上的资源的请求，一般是对后台数据库进行增、删、改的操作
   * GET请求的参数会跟在URL后进行传递，请求的数据会附在URL之后，以?分割URL和传输数据，参数之间以&相连，一般浏览器对 URL 的长度会有限制
   * POST请求，提交的数据则放置在是HTTP包的包体中，用类似Key-Value的格式发送一些数据，相对来说，GET请求会把请求的参数暴露在 URL 中，安全性比POST差一些

找出未打卡的员工
----------------
题目：输入两行数据，第一行为全部员工的 id，第二行为某一天打卡的员工 id，已知只有一个员工没有打卡，求出未打卡员工的 id。（员工 id 不重复，每行输入的 id 未排序）<br>
输入：<br>
1001 1003 1002 1005 1004<br>
1002 1003 1001 1004<br>
输出：<br>
1005<br>

分析：可以用两个 List，第一个 List 保存所有员工的 id，第二个 List 保存打卡员工的 id，从第一个List 中把第二个 List 的数据都删除，最终剩下的就是未打卡员工的 id。

更好的方法：异或，两行数据中未打卡员工的 id 出现了一次，其余员工的 id 都出现了2次，两个相同的数异或为0。<br>
```java
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	while (scan.hasNext()) {
		String[] ids = scan.nextLine().split(" ");
		String[] marks = scan.nextLine().split(" ");
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result ^= Integer.parseInt(ids[i]);
		}
		for (int i = 0; i < marks.length; i++) {
			result ^= Integer.parseInt(marks[i]);
		}
		System.out.println(result);
	}
}
```
关于[异或运算](http://baike.baidu.com/link?url=h53q63LfgUhej7MsOfMg1mJQyS55Ayzo1rfpogFgMi5D0U6-E4wOn2ugjOjsNIqdAd302nNKUJsbiJIe4G5k2-4qUCmtkE8ZuRQafKX9XGl5PBM6okdDaln8Y4sp0XnWu8J0KHrbmVAyrurjYc4mETuVf8slVhj_ooXknbqopjYnGmzlLlJhO4O4EfGIuokA):同一变量与另一变量和其异或值异或等于另一个数，如`(a^b)^a=b`。另外，异或运算满足交换律，任何数异或0都等于其本身。<br>
上述代码中，第一个循环中的`result`:`1001^=1003^=1002^=1005^=1004`<br>
到了第二层循环时,其过程为:<br>

  * `1001^=1003^=1002^=1005^=1004` ^= `1002` = `1001^=1003^=1005^=1004`
  * `1001^=1003^=1005^=1004` ^= `1003` = `1001^=1005^=1004`
  * `1001^=1005^=1004` ^= `1001` = `1005^=1004`
  * `1005^=1004` ^= `1004` = `1005`







   


