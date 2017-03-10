# 数据模型

## mongoDB字典
### 用户信息
```javascript
UserInfo
{
    id: "", // "U-" + uuid
    username: "", // 用户账号
    nickname: "", // 昵称
    email: "", // 邮箱，找回密码使用

    updateDate: "" // 更新时间
    createDate: "" // 创建时间
}
```

### 用户密码
```javascript
PasswordInfo
{
    id: "", // 对应用户的密码
    password: "" // sha512加密
}
```

### 游戏记录
每局游戏产生两个游戏记录
```javascript
GameRecord
{
    id: "",
    user: ${用户信息} // 玩家
    rival: ${用户信息} // 对方玩家

    totalDamage: 0 // 造成伤害
    totalTime: 0 // 耗时(ms)
    win: false // 是否胜利
    createDate: "" // 创建时间
}
```
