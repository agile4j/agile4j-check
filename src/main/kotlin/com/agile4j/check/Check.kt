package com.agile4j.check

import com.agile4j.check.ruler.Ruler

/**
 * @author: liurenpeng
 * @date: Created in 18-7-11
 */

fun <T> doCheck(target: T, vararg rulers: Ruler<T>) {
    doCheck(target, "", Ruler.ofAll(rulers.toList()))
}

fun <T> doCheck(target: T, description: String, vararg rulers: Ruler<T>) {
    try {
        rulers.forEach { it.check(target) }
    } catch (e: CheckException) {
        throw CheckException(e.code, description + e.desc, e)
    }
}

infix fun <T> Pair<T, String>.must(rulers: Collection<Ruler<T>>) {
    doCheck(this.first, this.second, Ruler.ofAll(rulers))
}

infix fun <T> Pair<T, String>.must(ruler: Ruler<T>) {
    doCheck(this.first, this.second, ruler)
}

infix fun <T> T.must(rulers: Collection<Ruler<T>>) {
    doCheck(this, Ruler.ofAll(rulers))
}

infix fun <T> T.must(ruler: Ruler<T>) {
    doCheck(this, ruler)
}

infix fun <T> T.alias(alias: String) = Pair(this, alias)

fun <T> be(vararg rulers: Ruler<T>) = Ruler.ofAll(rulers.toList())

infix fun <T> Ruler<T>.and(ruler: Ruler<T>) = Ruler.ofAll(this, ruler)

