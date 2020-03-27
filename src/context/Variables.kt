package context

import kotlin.Exception

interface Variables {
    fun createVar(name:String)
    fun getValue(name: String): Any?
    fun setValue(name: String, value: Any)
    fun contains(name: String): Boolean
    fun isInitialized(name: String): Boolean

}

class VariableRedefinitionException: Exception("Variable is already defined")

class VariableNotFoundException: Exception("Variable doesn't exist")

class VariablesImpl: Variables {

    private val variablesMap = HashMap<String, Any?>()

    override fun createVar(name: String) {
        if (contains(name)) throw VariableRedefinitionException()

        variablesMap[name] = null
    }

    override fun setValue(name: String, value: Any) {
        if(!contains(name)) throw VariableNotFoundException()


        variablesMap[name] = value
    }

    override fun getValue(name: String): Any? =
        when (contains(name)) {
            false -> null
            true -> variablesMap[name]
        }

    override fun contains(name: String): Boolean = variablesMap.contains(name)

    override fun isInitialized(name: String): Boolean = variablesMap[name] !=null
}