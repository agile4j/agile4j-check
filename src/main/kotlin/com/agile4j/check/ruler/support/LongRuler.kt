package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.LONG_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_LT_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.LONG_NULL_FAIL
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
object LongRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = LONG_NULL_FAIL.code, desc: String = LONG_NULL_FAIL.desc)
            = Ruler.ofBeNull<Long?>(code, desc)

    fun notNull(code: Long = LONG_NOT_NULL_FAIL.code, desc: String = LONG_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Long?>(code, desc)

    fun eq(norm: Long, code: Long = LONG_EQ_FAIL.code, desc: String = LONG_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Long, code: Long = LONG_GT_FAIL.code, desc: String = LONG_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Long, code: Long = LONG_GTE_FAIL.code, desc: String = LONG_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Long, code: Long = LONG_LT_FAIL.code, desc: String = LONG_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Long, code: Long = LONG_LTE_FAIL.code, desc: String = LONG_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}