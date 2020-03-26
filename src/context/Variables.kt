package context

import kotlin.Exception

interface Variables {
    fun createVar(name:String): Boolean
    fun getValue(name: String): Any?
    fun setValue(name: String, value: Any): Boolean
    fun contains(name: String): Boolean
    fun isInitialized(name: String): Boolean

}

class VariableRedefinitionException: Exception("Variable is already defined")

class VariablesImpl: Variables {

    private val variablesMap = HashMap<String, Any?>()

    override fun createVar(name: String): Boolean {
        if (contains(name)) throw VariableRedefinitionException()

        variablesMap[name] = null
        return true
    }

    override fun setValue(name: String, value: Any): Boolean {
        if(!contains(name)) {
            return false
        }

        variablesMap[name] = value
        return true
    }

    override fun getValue(name: String): Any? =
        when (contains(name)) {
            false -> null
            true -> variablesMap[name]
        }

    override fun contains(name: String): Boolean = variablesMap.contains(name)

    override fun isInitialized(name: String): Boolean = variablesMap[name] !=null
}