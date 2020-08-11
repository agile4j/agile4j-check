# agile4j-check
校验器

   * [特性总览](#特性总览)
   * [使用示例](#使用示例)



## 特性总览

![校验器特性.png](https://raw.githubusercontent.com/agile4j/agile4j-utils/master/src/test/resources/CheckUtilFeature.png)    

## 使用示例

使用alias、must中缀方法以类自然语言方式校验（自解释性强，推荐）
```kotlin
val idCard = "130802198108204219"
idCard alias "身份证号" must beIdCard
```

使用doCheck方法做校验
```kotlin
val idCard = "130802198108204219"
doCheck(idCard, "身份证号", beIdCard)
```

建议为校验对象设置别名，如果不需要别名，也可不传，别名默认值为空串""
```kotlin
val idCard: String? = null
// 不使用别名
idCard must beIdCard
// 使用别名
idCard alias "身份证号" must beIdCard
```

校验失败抛出异常：CheckException
```kotlin
try {
    val falseIdCard = "130802198108204210"
    falseIdCard alias "身份证号" must beIdCard
} catch (e: CheckException) {
    Assert.assertEquals(-11007L, e.code)
    Assert.assertEquals("身份证号必须符合身份证格式", e.desc)
    Assert.assertEquals("code=-11007, desc=身份证号必须符合身份证格式", e.message)
}
```

规则的“且”逻辑
```kotlin
var specialName = "张三"
// 以下三种写法效果相同
specialName alias "姓名" must be(lengthGte(2), lengthLte(10))
specialName alias "姓名" must (lengthGte(2) and lengthLte(10))
specialName alias "姓名" must be(Ruler.ofAll(lengthGte(2), lengthLte(10)))
```

规则的“或”逻辑
```kotlin
val beName = beEmpty.or(lengthGte(2) and lengthLte(10))
var specialName = "张三"
specialName alias "姓名" must beName
```

内置Ruler对null的特殊处理

除了beNull之外的其他内置Ruler，都会先进行notNull校验。若业务场景允许为null，可用或逻辑处理。
```kotlin
val idCard: String? = null
idCard alias "身份证号" must beNull.or(beIdCard)
```

自定义错误编号code和错误描述desc（支持在desc中对校验基准norm进行格式化）
```kotlin
val specialName = "乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫"
// 自定义code和desc(注意此处%d的用法)
specialName alias "姓名" must lengthLte(10, -2, "长度超过限制,允许的最大长度:%d")
// 只自定义desc,code使用默认值
specialName alias "姓名" must lengthLte(10, desc = "长度超过限制,允许的最大长度:%d")
```

为实体类不同操作封装个性化规则/自定义规则
```kotlin
data class Custom(var customId: String?, var name: String?, var age: Int?)

@Test
fun testEntity() {
    val customAddRuler = Ruler { custom: Custom? ->
        doCheck(custom, "商家", AnyRuler.notNull)
        custom?.customId alias "商家Id" must notEmpty
        custom?.name alias "商家姓名" must notEmpty
        custom?.age alias "商家年龄" must lte(60)
    }

    val custom = Custom("123", "张三", 80)
    custom must be(customAddRuler)
}
```

