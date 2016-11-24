1.优先返回空集合而非null
----------------------
如果程序要返回一个不包含任何值的集合，确保返回的是空集合而不是null。这能节省大量的”if else”检查。
```java
public class getLocationName {
    return (null==cityName ? "": cityName);
}
```

2.判断奇数
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

3.单引号与双引号的区别
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
4.1JSON编码
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
4.2JSON解析
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



