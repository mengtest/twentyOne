# 数据模型

## 用户
~~~javascript
UserInfo:
{
    id: "", // "U-" + uuid
	nickname: '', // 昵称
}
~~~

## 用户密码
~~~javascript
UserInfo:
{
	privinceCode: 100, // 省份、直辖市代码
	privinceName: "北京市", // 省份、直辖市名称
	cityCode: 10001, // 省份下面的市县、直辖市下面的区代码
	cityName: "海淀区", // 省份下面的市县、直辖市下面的区代码
}
~~~
