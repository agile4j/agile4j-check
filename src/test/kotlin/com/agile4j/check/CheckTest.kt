package com.agile4j.check

import com.agile4j.check.ruler.Ruler
import com.agile4j.check.ruler.support.AnyRuler
import com.agile4j.check.ruler.support.IntRuler.lte
import com.agile4j.check.ruler.support.StrRuler.beEmpty
import com.agile4j.check.ruler.support.StrRuler.beIdCard
import com.agile4j.check.ruler.support.StrRuler.beNull
import com.agile4j.check.ruler.support.StrRuler.lengthGte
import com.agile4j.check.ruler.support.StrRuler.lengthLte
import com.agile4j.check.ruler.support.StrRuler.notEmpty
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class CheckTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    /**
     * 使用alias、must中缀方法以类自然语言方式校验(自解释性强,推荐)
     */
    @Test
    fun mustTest() {
        val trueIdCard = "130802198108204219"
        trueIdCard alias "身份证号" must beIdCard
        //(trueIdCard.alias("身份证号")).must(beIdCard)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11007, desc=身份证号必须符合身份证格式")
        val falseIdCard = "130802198108204210"
        falseIdCard alias "身份证号" must beIdCard
    }

    /**
     * 使用doCheck方法做校验
     */
    @Test
    fun doCheckTest() {
        val trueIdCard = "130802198108204219"
        doCheck(trueIdCard, "身份证号", beIdCard)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11007, desc=身份证号必须符合身份证格式")
        val falseIdCard = "130802198108204210"
        doCheck(falseIdCard, "身份证号", beIdCard)
    }

    /**
     * 建议为校验对象设置别名,如果不需要别名,也可不传,别名默认值为空串""
     */
    @Test
    fun aliasTest() {
        var idCard: String? = "130802198108204219"
        // 不使用别名
        idCard must beIdCard

        idCard = null
        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11013, desc=身份证号不能为Null")
        // 使用别名
        idCard alias "身份证号" must beIdCard
    }

    /**
     * 校验失败抛出异常：CheckException
     */
    @Test
    fun exceptionTest() {
        try {
            val falseIdCard = "130802198108204210"
            falseIdCard alias "身份证号" must beIdCard
        } catch (e: CheckException) {
            Assert.assertEquals(-11007L, e.code)
            Assert.assertEquals("身份证号必须符合身份证格式", e.desc)
            Assert.assertEquals("code=-11007, desc=身份证号必须符合身份证格式", e.message)
        }
    }

    /**
     * 规则的“且”逻辑
     */
    @Test
    fun andTest() {
        var specialName = "张三"
        // 以下三种写法效果相同
        specialName alias "姓名" must be(lengthGte(2), lengthLte(10))
        specialName alias "姓名" must (lengthGte(2) and lengthLte(10))
        specialName alias "姓名" must be(Ruler.ofAll(lengthGte(2), lengthLte(10)))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11005, desc=姓名的长度必须小于或等于10")
        specialName = "乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫"
        specialName alias "姓名" must (lengthGte(2) and lengthLte(10))
    }

    /**
     * 规则的“或”逻辑
     */
    @Test
    fun orTest() {
        val beName = beEmpty.or(lengthGte(2) and lengthLte(10))

        var specialName = ""
        specialName alias "姓名" must beName

        specialName = "张三"
        specialName alias "姓名" must beName

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11005, desc=姓名的长度必须小于或等于10")
        specialName = "乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫"
        specialName alias "姓名" must beName
    }

    /**
     * 内置Ruler对null的特殊处理：除了beNull之外的其他内置Ruler,都会先进行notNull校验,若业务场景允许为null,可用或逻辑处理
     */
    @Test
    fun nullTest() {
        val idCard: String? = null
        idCard alias "身份证号" must beNull.or(beIdCard)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11013, desc=身份证号不能为Null")
        idCard alias "身份证号" must beIdCard
    }

    /**
     * 自定义错误编号code和错误描述desc(支持在desc中对校验基准norm进行格式化)
     */
    @Test
    fun userDefinedFailCodeAndDescTest() {
        val specialName = "乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫"

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-2, desc=姓名长度超过限制,允许的最大长度:10")
        // 自定义code和desc(注意此处%d的用法)
        specialName alias "姓名" must lengthLte(10, -2, "长度超过限制,允许的最大长度:%d")

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11005, desc=姓名长度超过限制,允许的最大长度:10")
        // 只自定义desc,code使用默认值
        specialName alias "姓名" must lengthLte(10, desc = "长度超过限制,允许的最大长度:%d")
    }

    data class Custom(var customId: String?, var name: String?, var age: Int?)

    /**
     * 为实体类不同操作封装个性化规则/自定义规则
     */
    @Test
    fun testEntity() {
        val customAddRuler = Ruler { custom: Custom? ->
            doCheck(custom, "商家", AnyRuler.notNull)
            custom?.customId alias "商家Id" must notEmpty
            custom?.name alias "商家姓名" must notEmpty
            custom?.age alias "商家年龄" must lte(60)
        }

        val custom = Custom("123", "张三", 80)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18005, desc=商家年龄必须小于或等于60")
        custom must be(customAddRuler)
    }
}
