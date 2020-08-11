package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.CharRuler.notNull
import com.agile4j.check.ruler.support.CharRuler.beNull
import com.agile4j.check.ruler.support.CharRuler.eq
import com.agile4j.check.ruler.support.CharRuler.gt
import com.agile4j.check.ruler.support.CharRuler.gte
import com.agile4j.check.ruler.support.CharRuler.lt
import com.agile4j.check.ruler.support.CharRuler.lte
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class CharRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val age: Char? = '1'

    @Test
    fun nullValTest() {
        var num: Char? = null
        num must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22000, desc=num必须为Null")
        num = age
        num alias "num" must beNull
    }

    @Test
    fun notNullTest() {
        var num: Char? = age
        num must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22006, desc=num不能为Null")
        num = null
        num alias "num" must notNull
    }

    @Test
    fun eqTest() {
        age must eq('1')

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22001, desc=age必须等于2")
        age alias "age" must eq('2')
    }

    @Test
    fun gtTest() {
        age must gt('0')

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22002, desc=age必须大于2")
        age alias "age" must gt('2')
    }

    @Test
    fun gteTest() {
        age must gte('1')

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22003, desc=age必须大于或等于2")
        age alias "age" must gte('2')
    }

    @Test
    fun ltTest() {
        age must lt('2')

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22004, desc=age必须小于1")
        age alias "age" must lt('1')
    }

    @Test
    fun lteTest() {
        age must lte('1')

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-22005, desc=age必须小于或等于0")
        age alias "age" must lte('0')
    }

}