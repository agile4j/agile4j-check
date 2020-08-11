package com.agile4j.check.ruler

import com.agile4j.check.CheckException
import com.agile4j.check.alias
import com.agile4j.check.must
import com.agile4j.check.ruler.support.CollRuler.notContainsDup
import com.agile4j.check.ruler.support.CollRuler.notContainsNull
import com.agile4j.check.ruler.support.CollRuler.notEmpty
import com.agile4j.check.ruler.support.CollRuler.notNull
import com.agile4j.check.ruler.support.CollRuler.beNull
import com.agile4j.check.ruler.support.CollRuler.sizeEq
import com.agile4j.check.ruler.support.CollRuler.sizeGt
import com.agile4j.check.ruler.support.CollRuler.sizeGte
import com.agile4j.check.ruler.support.CollRuler.sizeLt
import com.agile4j.check.ruler.support.CollRuler.sizeLte
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class CollRulerTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val signers: List<String> = listOf("a", "b")

    @Test
    fun nullValTest() {
        var list: Collection<*>? = null
        list must beNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14009, desc=list必须为Null")
        list = signers
        list alias "list" must beNull
    }

    @Test
    fun notNullTest() {
        var list: Collection<*>? = signers
        list must notNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14008, desc=list不能为Null")
        list = null
        list alias "list" must notNull
    }

    @Test
    fun notEmptyTest() {
        var list: Collection<*>? = signers
        list must notEmpty

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14000, desc=list不能为空")
        list = emptyList<String>()
        list alias "list" must notEmpty
    }

    @Test
    fun notContainsNullTest() {
        var list: Collection<*>? = signers
        list must notContainsNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14006, desc=list中不能有空值")
        list = listOf("a", null)
        list alias "list" must notContainsNull
    }

    @Test
    fun notContainsDupTest() {
        var list: Collection<*>? = signers
        list must notContainsDup

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14007, desc=list中不能有重复值")
        list = listOf("a", "a")
        list alias "list" must notContainsDup
    }

    @Test
    fun sizeEqTest() {
        signers must sizeEq(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14001, desc=signers的长度必须等于1")
        signers alias "signers" must sizeEq(1)
    }

    @Test
    fun sizeGtTest() {
        signers must sizeGt(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14002, desc=signers的长度必须大于2")
        signers alias "signers" must sizeGt(2)
    }

    @Test
    fun sizeGteTest() {
        signers must sizeGte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14003, desc=signers的长度必须大于或等于3")
        signers alias "signers" must sizeGte(3)
    }

    @Test
    fun sizeLtTest() {
        signers must sizeLt(3)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14004, desc=signers的长度必须小于2")
        signers alias "signers" must sizeLt(2)
    }

    @Test
    fun sizeLteTest() {
        signers must sizeLte(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-14005, desc=signers的长度必须小于或等于1")
        signers alias "signers" must sizeLte(1)
    }
}