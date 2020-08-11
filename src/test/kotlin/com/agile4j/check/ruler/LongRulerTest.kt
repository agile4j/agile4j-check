package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.LongRuler.eq
import com.agile4j.check.ruler.support.LongRuler.gt
import com.agile4j.check.ruler.support.LongRuler.gte
import com.agile4j.check.ruler.support.LongRuler.lt
import com.agile4j.check.ruler.support.LongRuler.lte
import com.agile4j.check.ruler.support.LongRuler.notNull
import com.agile4j.check.ruler.support.LongRuler.beNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class LongRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val weight: Long? = 1


    @Test
    fun nullValTest() {
        var num: Long? = null
        num must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19000, desc=num必须为Null")
        num = 1
        num alias "num" must beNull
    }

    @Test
    fun notNullTest() {
        var num: Long? = 1
        num must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19006, desc=num不能为Null")
        num = null
        num alias "num" must notNull
    }

    @Test
    fun eqTest() {
        weight must eq(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19001, desc=weight必须等于19")
        weight alias "weight" must eq(19)
    }

    @Test
    fun gtTest() {
        weight must gt(0)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19002, desc=weight必须大于19")
        weight alias "weight" must gt(19)
    }

    @Test
    fun gteTest() {
        weight must gte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19003, desc=weight必须大于或等于19")
        weight alias "weight" must gte(19)
    }

    @Test
    fun ltTest() {
        weight must lt(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19004, desc=weight必须小于1")
        weight alias "weight" must lt(1)
    }

    @Test
    fun lteTest() {
        weight must lte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-19005, desc=weight必须小于或等于0")
        weight alias "weight" must lte(0)
    }
}