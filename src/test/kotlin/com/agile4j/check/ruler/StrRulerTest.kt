package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.be
import com.agile4j.check.must
import com.agile4j.check.ruler.support.StrRuler.beAllLetter
import com.agile4j.check.ruler.support.StrRuler.beDigit
import com.agile4j.check.ruler.support.StrRuler.beEmail
import com.agile4j.check.ruler.support.StrRuler.beEmpty
import com.agile4j.check.ruler.support.StrRuler.beNull
import com.agile4j.check.ruler.support.StrRuler.bePhone
import com.agile4j.check.ruler.support.StrRuler.beStandardDate
import com.agile4j.check.ruler.support.StrRuler.beStandardDatetime
import com.agile4j.check.ruler.support.StrRuler.beUrl
import com.agile4j.check.ruler.support.StrRuler.eq
import com.agile4j.check.ruler.support.StrRuler.lengthEq
import com.agile4j.check.ruler.support.StrRuler.lengthGt
import com.agile4j.check.ruler.support.StrRuler.lengthGte
import com.agile4j.check.ruler.support.StrRuler.lengthLt
import com.agile4j.check.ruler.support.StrRuler.lengthLte
import com.agile4j.check.ruler.support.StrRuler.notEmpty
import com.agile4j.check.ruler.support.StrRuler.notNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class StrRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val str: String = "one"

    @Test
    fun nullValTest() {
        var temp: String? = null
        temp must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11017, desc=temp必须为Null")
        temp = str
        temp alias "temp" must beNull
    }

    @Test
    fun notNullTest() {
        var temp: String? = str
        temp must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11013, desc=temp不能为Null")
        temp = null
        temp alias "temp" must notNull
    }

    @Test
    fun beEmptyTest() {
        var temp: String? = ""
        temp must beEmpty

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11016, desc=temp必须为空")
        temp = str
        temp alias "temp" must beEmpty
    }

    @Test
    fun beNotEmptyTest() {
        var temp: String? = str
        temp must notEmpty

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11000, desc=temp不能为空")
        temp = ""
        temp alias "temp" must notEmpty
    }

    @Test
    fun beEmailTest() {
        var email: String? = "liurenpeng@163.com"
        email must beEmail

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11008, desc=email必须符合邮箱格式")
        email = str
        email alias "email" must beEmail
    }

    @Test
    fun bePhoneTest() {
        var phone: String? = "13200000000"
        phone must bePhone

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11009, desc=phone必须符合手机号格式")
        phone = str
        phone alias "phone" must bePhone
    }

    @Test
    fun beStandardDateTest() {
        var dateStr: String? = "2018-09-01"
        dateStr must beStandardDate

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11010, desc=dateStr必须符合yyyy-MM-dd格式")
        dateStr = str
        dateStr alias "dateStr" must beStandardDate
    }

    @Test
    fun beStandardDatetimeTest() {
        var datetimeStr: String? = "2018-09-01 00:00:00"
        datetimeStr must beStandardDatetime

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11011, desc=datetimeStr必须符合yyyy-MM-dd HH:mm:ss格式")
        datetimeStr = str
        datetimeStr alias "datetimeStr" must beStandardDatetime
    }

    @Test
    fun beUrlTest() {
        var urlStr: String? = "https://www.baidu.com"
        urlStr must beUrl

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11014, desc=urlStr必须符合URL规则")
        urlStr = str
        urlStr alias "urlStr" must beUrl
    }

    @Test
    fun beAllLetterTest() {
        var temp: String? = str
        temp must beAllLetter

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11015, desc=temp必须符合全字母规则")
        temp = "1"
        temp alias "temp" must beAllLetter
    }

    @Test
    fun beDigitTest() {
        var temp: String? = "1"
        temp must beDigit

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11012, desc=temp必须符合数字格式")
        temp = str
        temp alias "temp" must beDigit
    }

    @Test
    fun eqTest() {
        var temp: String? = str
        temp must be(eq(str))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11006, desc=temp的值必须是one")
        temp = "1"
        temp alias "temp" must be(eq(str))
    }

    @Test
    fun lengthEqTest() {
        str must be(lengthEq(3))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11001, desc=str的长度必须等于2")
        str alias "str" must be(lengthEq(2))
    }

    @Test
    fun lengthGtTest() {
        str must be(lengthGt(2))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11002, desc=str的长度必须大于3")
        str alias "str" must be(lengthGt(3))
    }

    @Test
    fun lengthGteTest() {
        str must be(lengthGte(3))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11003, desc=str的长度必须大于或等于4")
        str alias "str" must be(lengthGte(4))
    }

    @Test
    fun lengthLtTest() {
        str must be(lengthLt(4))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11004, desc=str的长度必须小于3")
        str alias "str" must be(lengthLt(3))
    }

    @Test
    fun lengthLteTest() {
        str must be(lengthLte(3))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-11005, desc=str的长度必须小于或等于2")
        str alias "str" must be(lengthLte(2))
    }

}