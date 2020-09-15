package com.nakharin.pocdeeplink.shared.deeplink.command

import android.net.Uri

abstract class MatcherDeeplinkCommand (
    private val matcher: (deeplink: Uri) -> Matcher
) : DeeplinkCommand {
    override fun matches(uri: Uri): Boolean = matcher(uri).match()
}

class Matcher(var deeplink: Uri, private val preCondition:Boolean = true){

    private fun String?.process() = this?.removePrefix("/")?.removeSuffix("/")

    fun host(host: String? = null): Matcher {
        return Matcher(deeplink, deeplink.host == host && preCondition)
    }

    fun path(path: String? = null): Matcher {
        return Matcher(deeplink, deeplink.path.process() == path?.process() && preCondition)
    }

    fun hasPath(pathSegment: String): Matcher {
        return Matcher(deeplink, deeplink.pathSegments.contains(pathSegment) && preCondition)
    }

    fun firstPath(pathSegment: String): Matcher {
        return Matcher(deeplink, deeplink.pathSegments.firstOrNull() == pathSegment && preCondition)
    }

    fun lastPath(pathSegment: String): Matcher {
        return Matcher(deeplink, deeplink.lastPathSegment == pathSegment && preCondition)
    }

    fun hasQueryParam(paramName: String): Matcher {
        return Matcher(deeplink, deeplink.queryParameterNames.contains(paramName) && preCondition)
    }

    fun hasQueryParams(vararg paramNames: String): Matcher {
        return Matcher(deeplink, deeplink.queryParameterNames.containsAll(paramNames.toList()) && preCondition)
    }

    fun condition(cond: (deeplink: Uri) -> Boolean): Matcher {
        return Matcher(deeplink, cond(deeplink) && preCondition)
    }

    fun match(): Boolean {
        return preCondition
    }

}

// init by deeplink
fun Uri.matcher(): Matcher = Matcher(this)