package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.SHORT_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.SHORT_NULL_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.NumberUtil.isEq
import com.agile4j.utils.util.NumberUtil.isGt
import com.agile4j.utils.util.NumberUtil.isGte
import com.agile4j.utils.util.NumberUtil.isLt
import com.agile4j.utils.util.NumberUtil.isLte

/**
 * @author: liurenpeng
 * @date: Created in 18-7-13
 */
object ShortRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = SHORT_NULL_FAIL.code, desc: String = SHORT_NULL_FAIL.desc)
            = Ruler.ofBeNull<Short?>(code, desc)

    fun notNull(code: Long = SHORT_NOT_NULL_FAIL.code, desc: String = SHORT_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Short?>(code, desc)

    fun eq(norm: Short, code: Long = SHORT_EQ_FAIL.code, desc: String = SHORT_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Short, code: Long = SHORT_GT_FAIL.code, desc: String = SHORT_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Short, code: Long = SHORT_GTE_FAIL.code, desc: String = SHORT_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Short, code: Long = SHORT_LT_FAIL.code, desc: String = SHORT_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Short, code: Long = SHORT_LTE_FAIL.code, desc: String = SHORT_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}