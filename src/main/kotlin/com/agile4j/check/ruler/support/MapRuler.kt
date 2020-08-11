package com.agile4j.check.ruler.support

import com.agile4j.check.CheckResultCodeEnum.MAP_KEY_NOT_CONTAINS_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_NOT_EMPTY_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_NOT_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_NULL_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_SIZE_EQ_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_SIZE_GTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_SIZE_GT_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_SIZE_LTE_FAIL
import com.agile4j.check.CheckResultCodeEnum.MAP_SIZE_LT_FAIL
import com.agile4j.check.and
import com.agile4j.check.ruler.Ruler
import com.agile4j.utils.util.MapUtil.isKeyNotContainsNull
import com.agile4j.utils.util.MapUtil.isNotEmpty
import com.agile4j.utils.util.MapUtil.isSizeEq
import com.agile4j.utils.util.MapUtil.isSizeGt
import com.agile4j.utils.util.MapUtil.isSizeGte
import com.agile4j.utils.util.MapUtil.isSizeLt
import com.agile4j.utils.util.MapUtil.isSizeLte

object MapRuler {
    val beNull = beNull()
    val notNull = notNull()
    val notEmpty = notEmpty()
    val notContainsNullKey = notContainsNullKey()

    fun beNull(code: Long = MAP_NULL_FAIL.code, desc: String = MAP_NULL_FAIL.desc)
            = Ruler.ofBeNull<Map<*, *>?>(code, desc)

    fun notNull(code: Long = MAP_NOT_NULL_FAIL.code, desc: String = MAP_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Map<*, *>?>(code, desc)

    fun notEmpty(code: Long = MAP_NOT_EMPTY_FAIL.code, desc: String = MAP_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun sizeEq(norm: Int, code: Long = MAP_SIZE_EQ_FAIL.code, desc: String = MAP_SIZE_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeEq)

    fun sizeGt(norm: Int, code: Long = MAP_SIZE_GT_FAIL.code, desc: String = MAP_SIZE_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeGt)

    fun sizeGte(norm: Int, code: Long = MAP_SIZE_GTE_FAIL.code, desc: String = MAP_SIZE_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeGte)

    fun sizeLt(norm: Int, code: Long = MAP_SIZE_LT_FAIL.code, desc: String = MAP_SIZE_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeLt)

    fun sizeLte(norm: Int, code: Long = MAP_SIZE_LTE_FAIL.code, desc: String = MAP_SIZE_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isSizeLte)

    fun notContainsNullKey(code: Long = MAP_KEY_NOT_CONTAINS_NULL_FAIL.code, desc: String = MAP_KEY_NOT_CONTAINS_NULL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isKeyNotContainsNull)

}