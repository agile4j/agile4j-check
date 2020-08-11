package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.ShortRuler.eq
import com.agile4j.check.ruler.support.ShortRuler.gt
import com.agile4j.check.ruler.support.ShortRuler.gte
import com.agile4j.check.ruler.support.ShortRuler.lt
import com.agile4j.check.ruler.support.ShortRuler.lte
import com.agile4j.check.ruler.support.ShortRuler.notNull
import com.agile4j.check.ruler.support.ShortRuler.beNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class ShortRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val weight: Short? = 1


    @Test
    fun nullValTest() {
        var num: Short? = null
        num must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17000, desc=num必须为Null")
        num = 1
        num alias "num" must beNull
    }

    @Test
    fun notNullTest() {
        var num: Short? = 1
        num must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17006, desc=num不能为Null")
        num = null
        num alias "num" must notNull
    }

    @Test
    fun eqTest() {
        weight must eq(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17001, desc=weight必须等于17")
        weight alias "weight" must eq(17)
    }

    @Test
    fun gtTest() {
        weight must gt(0)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17002, desc=weight必须大于17")
        weight alias "weight" must gt(17)
    }

    @Test
    fun gteTest() {
        weight must gte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17003, desc=weight必须大于或等于17")
        weight alias "weight" must gte(17)
    }

    @Test
    fun ltTest() {
        weight must lt(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17004, desc=weight必须小于1")
        weight alias "weight" must lt(1)
    }

    @Test
    fun lteTest() {
        weight must lte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17005, desc=weight必须小于或等于0")
        weight alias "weight" must lte(0)
    }
}