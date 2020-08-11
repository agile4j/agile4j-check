package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.ArrRuler.notContainsDup
import com.agile4j.check.ruler.support.ArrRuler.notContainsNull
import com.agile4j.check.ruler.support.ArrRuler.notEmpty
import com.agile4j.check.ruler.support.ArrRuler.notNull
import com.agile4j.check.ruler.support.ArrRuler.beNull
import com.agile4j.check.ruler.support.ArrRuler.lengthEq
import com.agile4j.check.ruler.support.ArrRuler.lengthGt
import com.agile4j.check.ruler.support.ArrRuler.lengthGte
import com.agile4j.check.ruler.support.ArrRuler.lengthLt
import com.agile4j.check.ruler.support.ArrRuler.lengthLte
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class ArrRulerTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val signers: Array<String> = arrayOf("a", "b")

    @Test
    fun nullValTest() {
        var array: Array<*>? = null
        array must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13009, desc=array必须为Null")
        array = signers
        array alias "array" must beNull
    }

    @Test
    fun notNullTest() {
        var array: Array<*>? = signers
        array must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13008, desc=array不能为Null")
        array = null
        array alias "array" must notNull
    }

    @Test
    fun notEmptyTest() {
        var array: Array<*>? = signers
        array must notEmpty

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13000, desc=array不能为空")
        array = emptyArray<String>()
        array alias "array" must notEmpty
    }

    @Test
    fun notContainsNullTest() {
        var array: Array<*>? = signers
        array must notContainsNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13006, desc=array中不能有空值")
        array = arrayOf("a", null)
        array alias "array" must notContainsNull
    }

    @Test
    fun notContainsDupTest() {
        var array: Array<*>? = signers
        array must notContainsDup

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13007, desc=array中不能有重复值")
        array = arrayOf("a", "a")
        array alias "array" must notContainsDup
    }

    @Test
    fun lengthEqTest() {
        signers must lengthEq(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13001, desc=signers的长度必须等于1")
        signers alias "signers" must lengthEq(1)
    }

    @Test
    fun lengthGtTest() {
        signers must lengthGt(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13002, desc=signers的长度必须大于2")
        signers alias "signers" must lengthGt(2)
    }

    @Test
    fun lengthGteTest() {
        signers must lengthGte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13003, desc=signers的长度必须大于或等于3")
        signers alias "signers" must lengthGte(3)
    }

    @Test
    fun lengthLtTest() {
        signers must lengthLt(3)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13004, desc=signers的长度必须小于2")
        signers alias "signers" must lengthLt(2)
    }

    @Test
    fun lengthLteTest() {
        signers must lengthLte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-13005, desc=signers的长度必须小于或等于1")
        signers alias "signers" must lengthLte(1)
    }
}