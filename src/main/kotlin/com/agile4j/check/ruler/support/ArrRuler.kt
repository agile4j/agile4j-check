package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.ARR_LENGTH_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_LENGTH_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_LENGTH_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_LENGTH_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_LENGTH_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_DUP_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_NOT_EMPTY_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.ARR_NULL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.ArrayUtil.isLengthEq
import com.agile4j.utils.util.ArrayUtil.isLengthGt
import com.agile4j.utils.util.ArrayUtil.isLengthGte
import com.agile4j.utils.util.ArrayUtil.isLengthLt
import com.agile4j.utils.util.ArrayUtil.isLengthLte
import com.agile4j.utils.util.ArrayUtil.isNotContainsDup
import com.agile4j.utils.util.ArrayUtil.isNotContainsNull
import com.agile4j.utils.util.ArrayUtil.isNotEmpty

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object ArrRuler {

    val beNull = beNull()
    val notNull = notNull()
    val notEmpty = notEmpty()
    val notContainsNull = notContainsNull()
    val notContainsDup = notContainsDup()

    fun beNull(code: Long = ARR_NULL_FAIL.code, desc: String = ARR_NULL_FAIL.desc)
            = Ruler.ofBeNull<Array<*>?>(code, desc)

    fun notNull(code: Long = ARR_NOT_NULL_FAIL.code, desc: String = ARR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Array<*>?>(code, desc)

    fun notEmpty(code: Long = ARR_NOT_EMPTY_FAIL.code, desc: String = ARR_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun lengthEq(norm: Int, code: Long = ARR_LENGTH_EQ_FAIL.code, desc: String = ARR_LENGTH_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthEq)

    fun lengthGt(norm: Int, code: Long = ARR_LENGTH_GT_FAIL.code, desc: String = ARR_LENGTH_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGt)

    fun lengthGte(norm: Int, code: Long = ARR_LENGTH_GTE_FAIL.code, desc: String = ARR_LENGTH_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGte)

    fun lengthLt(norm: Int, code: Long = ARR_LENGTH_LT_FAIL.code, desc: String = ARR_LENGTH_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLt)

    fun lengthLte(norm: Int, code: Long = ARR_LENGTH_LTE_FAIL.code, desc: String = ARR_LENGTH_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLte)

    fun notContainsNull(code: Long = ARR_NOT_CONTAINS_NULL_FAIL.code, desc: String = ARR_NOT_CONTAINS_NULL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsNull)

    fun notContainsDup(code: Long = ARR_NOT_CONTAINS_DUP_FAIL.code, desc: String = ARR_NOT_CONTAINS_DUP_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsDup)
}


