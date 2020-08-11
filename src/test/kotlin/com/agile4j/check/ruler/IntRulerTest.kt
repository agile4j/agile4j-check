package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.IntRuler.eq
import com.agile4j.check.ruler.support.IntRuler.gt
import com.agile4j.check.ruler.support.IntRuler.gte
import com.agile4j.check.ruler.support.IntRuler.lt
import com.agile4j.check.ruler.support.IntRuler.lte
import com.agile4j.check.ruler.support.IntRuler.notNull
import com.agile4j.check.ruler.support.IntRuler.beNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class IntRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val weight: Int? = 1


    @Test
    fun nullValTest() {
        var num: Int? = null
        num must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18000, desc=num必须为Null")
        num = 1
        num alias "num" must beNull
    }

    @Test
    fun notNullTest() {
        var num: Int? = 1
        num must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18006, desc=num不能为Null")
        num = null
        num alias "num" must notNull
    }

    @Test
    fun eqTest() {
        weight must eq(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18001, desc=weight必须等于18")
        weight alias "weight" must eq(18)
    }

    @Test
    fun gtTest() {
        weight must gt(0)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18002, desc=weight必须大于18")
        weight alias "weight" must gt(18)
    }

    @Test
    fun gteTest() {
        weight must gte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18003, desc=weight必须大于或等于18")
        weight alias "weight" must gte(18)
    }

    @Test
    fun ltTest() {
        weight must lt(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18004, desc=weight必须小于1")
        weight alias "weight" must lt(1)
    }

    @Test
    fun lteTest() {
        weight must lte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-18005, desc=weight必须小于或等于0")
        weight alias "weight" must lte(0)
    }
}