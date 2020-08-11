package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.DateRuler.beNull
import com.agile4j.check.ruler.support.DateRuler.notNull
import com.agile4j.utils.util.DateUtil.getDateByDateStr
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.util.*

class DateRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val birthDay: Date? = getDateByDateStr("2018-09-02")

    @Test
    fun nullValTest() {
        var time: Date? = null
        time must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12006, desc=time必须为Null")
        time = birthDay
        time alias "time" must beNull
    }

    @Test
    fun notNullTest() {
        var time: Date? = birthDay
        time must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12005, desc=time不能为Null")
        time = null
        time alias "time" must notNull
    }

    /*@Test
    fun eqTest() {
        birthDay must eq(getDateByDateStr("2018-09-02"))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12000, desc=birthDay必须是星期一 九月 03 00:00:00 CST 2018")
        birthDay alias "birthDay" must eq(getDateByDateStr("2018-09-03"))
    }

    @Test
    fun afterTest() {
        birthDay must after(getDateByDateStr("2018-09-01"))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12001, desc=birthDay必须晚于星期日 九月 02 00:00:00 CST 2018")
        birthDay alias "birthDay" must after(getDateByDateStr("2018-09-02"))
    }

    @Test
    fun afterOrEqTest() {
        birthDay must afterOrEq(getDateByDateStr("2018-09-02"))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12002, desc=birthDay必须晚于或等于星期一 九月 03 00:00:00 CST 2018")
        birthDay alias "birthDay" must afterOrEq(getDateByDateStr("2018-09-03"))
    }

    @Test
    fun beforeTest() {
        birthDay must before(getDateByDateStr("2018-09-03"))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12003, desc=birthDay必须早于星期日 九月 02 00:00:00 CST 2018")
        birthDay alias "birthDay" must before(getDateByDateStr("2018-09-02"))
    }

    @Test
    fun beforeOrEqTest() {
        birthDay must beforeOrEq(getDateByDateStr("2018-09-02"))

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-12004, desc=birthDay必须早于或等于星期六 九月 01 00:00:00 CST 2018")
        birthDay alias "birthDay" must beforeOrEq(getDateByDateStr("2018-09-01"))
    }*/
}