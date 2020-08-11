package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.FloatRuler.eq
import com.agile4j.check.ruler.support.FloatRuler.gt
import com.agile4j.check.ruler.support.FloatRuler.gte
import com.agile4j.check.ruler.support.FloatRuler.lt
import com.agile4j.check.ruler.support.FloatRuler.lte
import com.agile4j.check.ruler.support.FloatRuler.notNull
import com.agile4j.check.ruler.support.FloatRuler.beNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class FloatRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val weight: Float? = 1.0F


    @Test
    fun nullValTest() {
        var num: Float? = null
        num must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20000, desc=num必须为Null")
        num = 1.0F
        num alias "num" must beNull
    }

    @Test
    fun notNullTest() {
        var num: Float? = 1.0F
        num must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20006, desc=num不能为Null")
        num = null
        num alias "num" must notNull
    }

    @Test
    fun eqTest() {
        weight must eq(1.0F)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20001, desc=weight必须等于20")
        weight alias "weight" must eq(20.0F)
    }

    @Test
    fun gtTest() {
        weight must gt(0.0F)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20002, desc=weight必须大于20")
        weight alias "weight" must gt(20.0F)
    }

    @Test
    fun gteTest() {
        weight must gte(1.0F)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20003, desc=weight必须大于或等于20")
        weight alias "weight" must gte(20.0F)
    }

    @Test
    fun ltTest() {
        weight must lt(2.0F)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20004, desc=weight必须小于1")
        weight alias "weight" must lt(1.0F)
    }

    @Test
    fun lteTest() {
        weight must lte(1.0F)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-20005, desc=weight必须小于或等于0")
        weight alias "weight" must lte(0.0F)
    }
}