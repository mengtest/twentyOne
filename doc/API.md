# API接口文档

## 基础信息格式

1. 日期格式：yyyyMMdd HH:mm:ss，示例：20160301 12:30:21
2. 接口返回的数据格式
  - 单条数据:
    ```javascript
    {
      code: 0, // 状态码，0为正常
      data: ${SOME DATA} // 返回对象json序列化数据
    }
    ```
  - 状态码:
    ```javascript
    {
      code: 0, // 状态码，0为正常
      msg: "" // 错误码不为0时的错误信息
    }
    ```

## 用户模块
### 用户登录
输入账号即可登陆游戏，数据库没有账号记录则生成记录

```javascript
POST /twentyOne/api/users/signin

// 根据登录账号登录或者email登录，客户端选择填写username或者email字段内容
Param:
{
	username: '', // 登录账号
}

Response: ${单条数据} -> ${用户信息}
```

### 用户登出

```javascript
GET /twentyOne/api/users/signout

Response: ${状态码}
```
