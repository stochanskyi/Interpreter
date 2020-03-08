package context

interface Variables {
    fun createVar(name:String, value: Int = 0): Boolean
    fun getValue(name: String): Int?
    fun setValue(name: String, value: Int): Boolean
    fun contains(name: String): Boolean

}


class VariablesImpl: Variables {

    private val variablesMap = HashMap<String, Int>()

    override fun createVar(name: String, value: Int): Boolean {

        if (contains(name)) {
            return false
        }

        variablesMap[name] = value
        return true
    }

    override fun setValue(name: String, value: Int): Boolean {
        if(!contains(name)) {
            return false
        }

        variablesMap[name] = value
        return true
    }

    override fun getValue(name: String): Int? =
        when (contains(name)) {
            false -> null
            true -> variablesMap[name]
        }

    override fun contains(name: String): Boolean = variablesMap.contains(name)

}