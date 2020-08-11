package com.agile4j.check.ruler

import com.agile4j.check.CheckException

/**
 * 规则类
 * @author: liurenpeng
 * @date: Created in 18-7-11
 */

class Ruler<T>(val check: (T) -> Unit) {

    /**
     * 或操作
     */
    fun or(vararg rulers: Ruler<T>): Ruler<T> {
        return Ruler { checkTarget: T ->
            try {
                this.check(checkTarget)
            } catch (e: CheckException) {
                rulers.forEach { it.check(checkTarget) }
            }

        }
    }

    companion object {
        /**
         * noneNorm-Ruler
         */
        fun <T> of(failCode: Long, failDesc: String, primaryVerifier: (T) -> Boolean): Ruler<T> {
            return Ruler { checkTarget: T ->
                if (!primaryVerifier(checkTarget)) {
                    throw CheckException(failCode, failDesc)
                }
            }
        }

        /**
         * oneNorm-Ruler
         */
        fun <T, N> of(norm: N, failCode: Long, failDesc: String, primaryVerifier: (T, N) -> Boolean): Ruler<T> {
            return Ruler { checkTarget: T ->
                if (!primaryVerifier(checkTarget, norm)) {
                    throw CheckException(failCode, String.format(failDesc, norm))
                }
            }
        }

        /**
         * beNotNull-Ruler
         */
        fun <T> ofNotNull(failCode: Long, failDesc: String): Ruler<T> = Ruler { checkTarget: T ->
            if (null == checkTarget) {
                throw CheckException(failCode, failDesc)
            }
        }

        /**
         * beNullVal-Ruler
         */
        fun <T> ofBeNull(failCode: Long, failDesc: String): Ruler<T> = Ruler { checkTarget: T ->
            if (null != checkTarget) {
                throw CheckException(failCode, failDesc)
            }
        }

        /**
         * Ruler整合
         */
        @SafeVarargs
        fun <T> ofAll(vararg rulers: Ruler<T>): Ruler<T> {
            return ofAll(rulers.toList())
        }

        /**
         * Ruler整合
         */
        @SafeVarargs
        fun <T> ofAll(rulers: Collection<Ruler<T>>): Ruler<T> {
            return Ruler { checkTarget: T -> rulers.forEach { it.check(checkTarget) } }
        }

    }

}

